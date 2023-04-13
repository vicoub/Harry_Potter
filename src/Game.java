import java.util.ArrayList;
import java.util.Scanner;


public class Game {
    public static Wizard wizard = new Wizard(1, 10,60,80);
    static Scanner scanner = new Scanner(System.in);

    private ArrayList<Level> levels;
    private boolean gameOver;

    public Game(){
        this.gameOver = false;
        String[] test = new String[]{"test"};
        ArrayList<AbstractEnemy> test2 = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            this.levels.add(new Level(i+1, test, test2));
        }
    }

    //method to get user input from console
    public static int readInt(String prompt, int userChoices) {
        int input;
        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Faite un choix:");
            }

        } while (input < 1 || input > userChoices);
        return input;

    }

    public void start() {
        this.introduction();
        for (Level level : this.levels) {
            for (int i = 0; i < level.getEnemiesList().size(); i++) {
                printHeading(level.getBattleTexts()[i]);
                if (!this.battle(level.getEnemiesList().get(0))) {
                    this.gameOver = true;
                    break;
                }
            }
            if (this.gameOver) {
                break;
            }
        }
    }

    public void introduction() {
        Scanner myobj = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue dans le monde magique de Harry Potter, où vous vivrez une aventure épique, en découvrant des lieux emblématiques, en apprenant des sorts et en affrontant des ennemis puissants dans des duels magiques. Préparez-vous à plonger dans l'univers de la magie et à vivre des aventures incroyables dans ce jeu Harry Potter passionnant.");
        System.out.println("Quel est ton nom ?:");
        String str = myobj.nextLine();
        wizard.setName(str);
        System.out.println("Tu vas recevoir ta baguette maintenant que tu es un sorcier !");
        System.out.println("Appuie sur entrée pour continuer.");
        scanner.nextLine();
        wizard.setWand(Wand.choixWand());
        System.out.printf("Félicitation, ta baguette est longue de " + wizard.getWand().getSize() + " cm et a un core de " + wizard.getWand().getCore());
        System.out.println("\n À présent, tu vas découvrir ta maison grâce au chapeau magique.");
        System.out.println("Tape sur entrer pour connaitre le verdict du chapeau.");
        scanner.nextLine();
        House tempHouse = SortingHat.choixMaison();
        System.out.println(" Bravo tu as été sélectionné à " + tempHouse.getName());
        wizard.setHouse(tempHouse);
        System.out.println("En ce début d'année vous allez pouvoir choisir également un animal de compagnie qui sera à tes côté durant toute ton aventure.");
        int i = 0;
        for (Pet pet : Pet.values()) {
            System.out.println("(" + i + ") " + pet.name());
            i += 1;
        }

        System.out.println("Pour commencer voici une potion, elle te permettra de gagner de la vie. Attention tu peux uniquement l'utiliser si tu perds des points de vie.");
        wizard.getListePotions().add(Potion.strongPotion);


        System.out.println("veuillez entrez le numéro pour l'animal que vous souhaitez choisir");

        int val;
        while (true) {
            if (myobj.hasNextInt()) {
                val = myobj.nextInt();
                if (val >= 0 && val < Pet.values().length) {
                    break;
                }
            } else {
                myobj.next();
            }
            System.out.println("Veuillez entrer un numéro valide s'il vous plaît :");
        }

        wizard.setPet(Pet.values()[val]);

        System.out.println("Vous avez choisi un " + wizard.getPet().name());
        myobj.nextLine();
        System.out.println("Voici ton premier sort! wingardium Leviosa. un sort qui fait léviter un objet, tu en auras besoin prochainement... ");
        wizard.addSpell(new Spell("wingardium Leviosa", "normal",
                "un sort qui fait léviter un objet", 80, 8));
    }

    public static boolean battle(AbstractEnemy enemy){
        boolean battleWon = false ;
        //start battle
        while(true){
            clearConsole();
            printHeading(enemy.getName() + " HP: " + enemy.getHp() + "/" + enemy.getMaxHp());
            printHeading(wizard.getName() + " HP: " + wizard.getHp() + "/" + wizard.getMaxHp());
            System.out.println("Choose an action: ");
            printSeperator(1);
            System.out.println("(1) Attack \n(2) Potions \n(3) Run");
            int input = readInt("->", 3);
            //react according to the input
            if (input == 1){
                Spell.castSpell();
                System.out.println();
                //Fight
                //calculating the damage and damage reduction
                int dmg = wizard.attack() - enemy.defend();
                int dmgTook = enemy.attack() - wizard.defend();
                //check if the damage is negative
                if(dmg < 0) {
                    //set damage to 0 if it is negative
                    dmg = 0;
                }
                //deal dmg to both parties
                wizard.setHp(wizard.getHp() - dmgTook);
                enemy.setHp(enemy.getHp() - dmg);
                //print the info of this battle round
                clearConsole();
                //printHeading("You used " + AbstractSpell.spells[AbstractSpell.input-1] + "!"
                //        + "\n You attacked " + enemy.getName() + " for " + dmg + " damage!");
                printHeading(enemy.getName() + " attacked you for " + dmgTook + " damage!");
                promptEnterKey();
                //check if battle is over
                if(wizard.getHp() <= 0){
                    //player lost
                    wizardDied();
                    break;
                }else if(enemy.getHp() <= 0){
                    //player won
                    clearConsole();
                    printHeading("Vous avez vaincu " + enemy.getName() + "!");
                    //add xp
                    wizard.setXp(wizard.getXp() + enemy.getXp());
                    System.out.println("Tu gagnes " + enemy.getXp() + " xp!");
                    boolean addRest = (Math.random()*5 + 1 <= 2.25);
                    int goldEarned = (int)(Math.random()*enemy.xp);
                    if (addRest){
                        //add rest
                        System.out.println("Reposez-vous !");
                        wizard.setHp(wizard.getMaxHp());
                    }
                    if(goldEarned > 0) {
                        //add gold
                        wizard.setGold(wizard.getGold() + goldEarned);
                        System.out.println("You found " + goldEarned + " gold from " + enemy.getName() + "!");
                    }
                    promptEnterKey();
                    battleWon = true;
                    break;
                }
            }else if(input == 2) {
                //use potion
                clearConsole();
                if (wizard.getListePotions().size() > 0 && wizard.getHp() < wizard.getMaxHp()) {
                    //use potion
                    wizard.getListePotions().remove(0);
                    wizard.setHp(wizard.getHp() + 10);
                    if (wizard.getHp() > wizard.getMaxHp()) {
                        printHeading("Do you want to use a potion? (" + wizard.getListePotions().size() + " left)");
                        System.out.println("(1) Yes \n(2) No");
                        input = readInt("->", 2);
                        if (input == 1) {
                            if (wizard.getHouse().getSpecificity() != House.Specificity.STRONG_POTION) {
                                wizard.setHp(wizard.getHp() + 50);
                            } else {
                                wizard.setHp(wizard.getHp() + 100);
                            }

                            printHeading("You used a potion back to " + wizard.getMaxHp() + " hp");
                            promptEnterKey();
                        } else {
                            //no potions
                            printHeading("You don't have any potions or you are full hp!");
                            promptEnterKey();
                        }
                    }
                }
            }
            else if(input == 3){
                clearConsole();
                //Chance of escape = 50%
                if(Math.random()*10 + 1 <= 5){
                    printHeading("Tu as échapé à" + enemy.getName() + "!");
                    promptEnterKey();
                    battleWon = true;
                    break;
                }else{
                    printHeading("Tu ne peux pas t'enfuir de " + enemy.getName() + "!");
                    int dmgTook = enemy.attack();
                    System.out.println("Tu prends" + dmgTook + " dégats!");
                    promptEnterKey();
                    if(wizard.getHp() <= 0) {
                        //player lost
                        wizardDied();
                        break;
                    }
                }
            }
        }
        return battleWon;
    }


    public static void textDelay(String text) {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            delay(5);
        }
        System.out.println("");
    }

    private static void delay(int i) {
    }


    private static void promptEnterKey() {System.out.println("Appuyez sur Entrée pour continuer...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    private static void printHeading(String s) {
        printSeperator(1);
        System.out.println(s);
        printSeperator(1);

    }

    public static void printSeperator(int n) {
        for (int i = 0; i < n; i++)
            System.out.println("__________________________________________________________");
        System.out.println();

    }

    public static void clearConsole() {
        for (int i=0;i <= 50;i++)
            System.out.println();
    }

    public static void removeElement(Object[] arr, int removedIdx) {
        System.arraycopy(arr, removedIdx + 1, arr, removedIdx, arr.length - 1 - removedIdx);
    }

    public static void wizardDied(){
        //print the death screen
        clearConsole();
        printHeading("Vous êtes mort !");
        printSeperator(1);
        System.out.println("Tu gagnes " + wizard.xp + " xp. Essaye de faire mieux la prochaine fois. ");
        
        promptEnterKey();
        //exit the game
    }
}
