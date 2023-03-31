import java.util.Scanner;


public class Game {
    static Wizard wizard = new Wizard(1, 10,60,100);
    static Scanner scanner = new Scanner(System.in);

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

    public static void battle(AbstractEnemy enemy){
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
                if(dmg < 0){
                    //add some damage if player defends well
                    dmg -= dmgTook/2;
                    dmgTook = 0;
                }
                if(dmg < 0)
                    //set damage to 0 if it is negative
                    dmg = 0;
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
                    printHeading("You defeated " + enemy.getName() + "!");
                    //add xp
                    wizard.setXp(wizard.getXp() + enemy.getXp());
                    System.out.println("You gained " + enemy.getXp() + " xp!");
                    boolean addRest = (Math.random()*5 + 1 <= 2.25);
                    int goldEarned = (int)(Math.random()*enemy.xp);
                    if (addRest){
                        //add rest
                        System.out.println("You found a rest spot!");
                        wizard.setHp(wizard.getMaxHp());
                    }
                    if(goldEarned > 0) {
                        //add gold
                        wizard.setGold(wizard.getGold() + goldEarned);
                        System.out.println("You found " + goldEarned + " gold from " + enemy.getName() + "!");
                    }
                    promptEnterKey();
                    break;
                }
            }else if(input == 2) {
                //use potion
                clearConsole();
                if (wizard.getPotions().size() > 0 && wizard.getHp() < wizard.getMaxHp()) {
                    //use potion
                    wizard.getPotions().remove(0);
                    wizard.setHp(wizard.getHp() + 10);
                    if (wizard.getHp() > wizard.getMaxHp()) {
                        printHeading("Do you want to use a potion? (" + wizard.getPotions() + " left)");
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
    }

    public static int readInt(String prompt, int userChoices) {
        int input;
        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Please enter integer!");
            }

        } while (input < 1 || input > userChoices);
        return input;

    }

    public static void textDelay(String text) {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            delay(5);
        }
        System.out.println("");
    }


    private static void promptEnterKey() {System.out.println("Appuyez sur Entrée pour continuer...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    private static void printHeading(String s) { printSeperator(1);
        System.out.println(title);
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
        printHeading("vous êtes mort");
        System.out.println("vous êtes mort ");
        printSeperator(1);
        System.out.println("Tu gagnes " + wizard.xp + " xp. Essaye de faire mieux la prochaine fois. ");
        
        promptEnterKey();
        //exit the game
        boolean isRunning = false;
    }
}
