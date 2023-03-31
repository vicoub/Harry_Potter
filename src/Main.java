
import lombok.Data;

@Data
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

    }
    public void year1(){
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
        System.out.printf("Félicitation, ta baguette est longue de " +wizard.getWand().getSize()+ " cm et a un core de " + wizard.getWand().getCore());
        System.out.println("\n À présent, tu vas découvrir ta maison grâce au chapeau magique.");
        System.out.println("Tape sur entrer pour connaitre le verdict du chapeau.");
        scanner.nextLine();
        House tempHouse = SortingHat.choixMaison();
        System.out.println(" Bravo tu as été sélectionné à " + tempHouse.getName());
        wizard.setHouse(tempHouse);
        System.out.println("En ce début d'année vous allez pouvoir choisir également un animal de compagnie qui sera à tes côté durant toute ton aventure.");
        int i = 0;
        for (Pet pet : Pet.values()) {
            System.out.println("(" + i +") "+ pet.name());
            i += 1;
        }

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
        wizard.addSpell(new Spell("wingardium Leviosa" , "normal" ,
                "un sort qui fait léviter un objet",80,8));

        //NIVEAU1

        System.out.println("Vous êtes au niveau 1,à present que vous êtes bien équipé rendez-vous dans les toilettes de l'école pour affronter votre premier boss, attention des ennemis peuvent être sur votre chemin.");

        Enemy spider = new Enemy(6 ,"araignée",40, 40,  5, 50);
        myobj.nextLine();

        System.out.println("Une araignée est apparue! Utilisez votre sort pour la détruire.");

        Game.battle(spider);

        System.out.println("tu sais maintenant comment combattre avec ton nouveau sort, appuie sur entrer pour continuer ta route vers les toilettes de l'école.");
        myobj.nextLine();

        Boss troll = new Boss(1,"troll",40, 5,50,40);
        Game.battle(troll);

        System.out.println(" bravo , c'était pas si simple...Vous validez le niveau 1 !");
        myobj.nextLine();

        System.out.println("Félicitation vous avez également appris un nouveau sort : ");
        myobj.nextLine();


        //NIVEAU 2

       /* public static void main(String[] args) {
            Main main = new Main();
            main.year2();
        main.year2();



        */
            System.out.println("félicitation tu es maintenant à ta deuxième année en tant que sorcier!");
            System.out.println("tu es maintenant niveau 2");
            myobj.nextLine();
            System.out.println("À présent dirige toi vers la chambre des secrets attention de nombreux ennemies peuvent être sur ta route... ");
            myobj.nextLine();


            System.out.println("une araigné apparait!");
            Game.battle(spider);

            System.out.println("continu ta route vers la grotte du basilic pour le vaincre");
            myobj.nextLine();


            Boss basilic = new Boss(2, "basilic", 60, 10, 60, 60);

            System.out.println(" Le basilic est là! suit les instructions pour pouvoir le battre.");

           /* if (Wizard.getHouse().equals("Gryffindor")) { // If the player is from Gryffindor
                GryffindorSword sword = new GryffindorSword(); // Create a Gryffindor sword
                Wizard.use(sword, basilic); // The player uses the sword to slay the basilisk
            } else { // If the player is not from Gryffindor
                BasilicFang fang = basilic.extractFang(); // The player extracts a fang from the basilisk
                TomRiddleDiary diary = new TomRiddleDiary(); // Create Tom Riddle's diary
                Wizard.use(fang, diary); // The player uses the fang to destroy the diary
            }*/
            Game.battle(basilic);

            System.out.println("Bravo ce combat n'était pas si simple...le basilic est mort! tu peux rentrer à poudlard maintenant.");

        //NIVEAU 3

        System.out.println("félicitation tu es maintenant à ta troisième année en tant que sorcier!");
        System.out.println("tu es maintenant niveau 3");
        myobj.nextLine();
        System.out.println("Les détraqueurs rode autour de poudlard rejoint...Tu apprends expecto patronum pour les chasser! ");
        myobj.nextLine();

        Boss detraqueur = new Boss(3,"detraqueur",80,20,70,80);
        System.out.println("une détraqueur apparait! Utilise ton nouveau sort pour le vaincre");
        Game.battle(detraqueur);

        System.out.println("continue à faire le tour du chateau pour les chasser et protéger les autres sorciers");
        myobj.nextLine();


        System.out.println("Une détraqueur apparait! Utilise ton nouveau sort pour le vaincre");
        Game.battle(detraqueur);

        System.out.println("Bravo vous avez chassez la majorité des détraqueur et vous passez au niveau 4 vous êtes de plus en plus fort!");



                //niveau 4

                System.out.println("Dans ce niveau 4 vous allez devoir participer au tournoi des grand sorcier!");
                System.out.println("Bienvenue au Tournoi des Trois Sorciers !");
                System.out.println("Malheureusement, vous avez remporté le tournoi... et le droit de mourir.");
                System.out.println("Vous vous retrouvez dans un cimetière, où se trouvent également Voldemort et Peter Pettigrew.");
                System.out.println("Votre seule chance de fuite est de vous rapprocher du Portoloin et de l'attirer à vous en utilisant le sortilège Accio !");
                System.out.println("Ne vous inquiétez pas, vous reverrez Voldemort.");

                boolean echappe = false;
                int distanceDuPortoloin = 10; // initialisation de la distance au Portoloin

                while (!echappe) {
                    System.out.println("Vous êtes à " + distanceDuPortoloin + " pieds du Portoloin.");
                    System.out.print("Entrez Accio ! pour appeler le Portoloin : ");



                    Scanner choice = new Scanner(System.in); //regarde ce que le mec rentre et si ça correspond à accio
                    String selectedChoice = choice.nextLine(); //ça le fait s'enfuire

                    if (selectedChoice == "Accio") { // si le sortilège est utilisé
                        if (distanceDuPortoloin <= 0) { // si le sorcier est assez proche du Portoloin
                            System.out.println("Vous avez réussi à vous échapper en utilisant le Portoloin !");
                            echappe = true;
                        } else {
                            distanceDuPortoloin -= 5; // avancer de 5 pieds vers le Portoloin
                            System.out.println("Vous vous rapprochez du Portoloin...");
                        }
                    } else {
                        System.out.println("Vous devez utiliser le sortilège Accio ! pour appeler le Portoloin.");
                    }
                }

                //niveau 5


                // Introduction de l'histoire
                System.out.println("C'est l'heure du BUSE, le moment tant redouté pour les étudiants de Poudlard. Dolores Ombrage veille sur le grain et surveille chaque élève avec une attention particulière.");
                System.out.println("Votre objectif est de distraire Dolores Ombrage le temps que les feux d'artifice soient prêts à être utilisés.");

                // Proposer à l'utilisateur trois options pour distraire Dolores Ombrage
                System.out.println("Voici trois options pour distraire Dolores Ombrage :");
                System.out.println("1. Chanter une chanson de Noël en juillet");
                System.out.println("2. Faire un tour de magie");
                System.out.println("3. Créer une invasion de rats");
                System.out.println("Entrez le numéro de votre choix :");
                int choix = scanner.nextInt();

                // Vérifier si le choix de l'utilisateur est correct pour distraire Dolores Ombrage
                if (choix == 3) {
                    System.out.println("Bravo ! Votre choix a réussi à distraire Dolores Ombrage !");
                    System.out.println("Les feux d'artifice peuvent maintenant être lancés en toute sécurité.");
                    System.out.println("Vous avez appris un nouveau sortilège: Sectumsempra. ");
                } else {
                    System.out.println("Dolores Ombrage n'a pas été dupe de votre choix. Vous êtes renvoyé de Poudlard pour avoir perturbé l'ordre.");
                }

                // Fermer l'objet Scanner
                scanner.close();
            }

            //NIVEAU 6



    public class AttackPoudlard {

        public static void main(String[] args) {

            // Création d'un objet Scanner pour lire l'entrée utilisateur
            Scanner scanner = new Scanner(System.in);

            // Introduction de l'histoire
            System.out.println("Les Mangemorts attaquent Poudlard ! Les élèves et les professeurs se préparent à la bataille.");
            System.out.println("Êtes-vous prêts à vous défendre ?");
            System.out.println("Si oui, vous devez les attaquer de face avec le sortilège Sectumsempra.");
            System.out.println("Si vous êtes de Serpentard, vous pouvez décider de rejoindre les rangs des Mangemorts.");

            // Proposer à l'utilisateur de se défendre ou de rejoindre les Mangemorts
            System.out.println("Que voulez-vous faire ?");
            System.out.println("1. Se défendre contre les Mangemorts");
            System.out.println("2. Rejoindre les rangs des Mangemorts");
            System.out.println("Entrez le numéro de votre choix :");
            int choice = scanner.nextInt();

            // combats contre mangemorts
            if (choice == 1) {
                System.out.println("Vous êtes prêt à vous battre contre les Mangemorts !");

                Boss Mangemort = new Boss(6 ,"mangeMort",140,30,80,140 );
                Game.battle(Mangemort);


                System.out.println("Vous brandissez votre baguette magique et lancez le sortilège Sectumsempra.");
                System.out.println("Les Mangemorts ripostent avec leurs sorts les plus puissants, mais vous vous défendez vaillamment.");
                System.out.println("Finalement, après une bataille épique, les Mangemorts sont vaincus et la paix est rétablie à Poudlard.");
                System.out.println("Vous passez glorieusement en 7ème année!");
            }

            // rejoindre les rangs des Mangemorts
            else if (choice == 2) {
                System.out.println("Vous avez choisi de rejoindre les rangs des Mangemorts...");
                System.out.println("Vous vous dirigez vers eux en brandissant votre baguette magique.");
                System.out.println("Les Mangemorts vous accueillent à bras ouverts et vous donnent des instructions pour la bataille.");
                System.out.println("Vous lancez le sortilège Sectumsempra sur vos anciens camarades de Poudlard, sans aucune pitié.");
                System.out.println("Finalement, après une bataille épique, les Mangemorts sont victorieux et prennent le contrôle de Poudlard.");
            }

            // Si l'utilisateur n'a pas choisi une option valide
            else {
                System.out.println("Vous n'avez pas choisi une option valide. La bataille continue sans vous !");
            }

            // Fermer l'objet Scanner
            scanner.close();
        }

        //NIVEAU 7

        import java.util.Scanner;

        public class AttaqueVoldemort {

            public static void main(String[] args) {

                // Création d'un objet Scanner pour lire l'entrée utilisateur
                Scanner scanner = new Scanner(System.in);

                // Introduction de l'histoire
                System.out.println("félicitation vous êtes maintenant à votre dernière année de sorcier." );
                System.out.println("Vous ëtes à présent l'un des sorcier les plus puissant au monde, et êtes sur le point de faire le combat qui pourra changer votre vie ou bien vous l'enlever...");
                System.out.println("Vous êtes face à Voldemort et Bellatrix Lestrange.");
                System.out.println("Faites attention, ils peuvent vous tuer d’un coup avec Avada Kedavra si vous n’êtes pas prêts.");

                Boss Voldemort = new Boss ( 7, "voldemort",140,35,80,140);
                Boss Bellatrix = new Boss(7 ,"Bellatrix",100,30,70,100 );

                // Tant que les personnages de l'utilisateur et des ennemis sont en vie, continuer le combat
                while (Wizard.alive() && (Voldemort.alive() || Bellatrix.alive())) {

                    // Afficher les statistiques des personnages avant chaque tour
                    System.out.println("----- Tour " + Game.getTour() + " -----");
                    System.out.println(Wizard);
                    System.out.println(Voldemort);
                    System.out.println(Bellatrix);

                    System.out.println("Vous commencez par affronter Bellatrix. Vous pouvez exceptionnelement utiliser les sorts interdits! ");
                    Game.battle(Bellatrix);

                    System.out.println("Le meilleur pour la fin ! préparez-vous à faire face à votre combat ultime contre Voldemort.");
                    Game.battle(Voldemort);
                }


                }

                // Afficher le résultat final du combat
                System.out.println("----- Fin du combat -----");
                if (!Wizard.alive()) {
                    System.out.println("Vous êtes mort. Les ennemis ont gagné.");
                } else if (Voldemort.alive() && !Bellatrix.alive()) {
                    System.out.println("Félicitations ! Vous avez vaincu Voldemort et Bellatrix Lestrange.");
                } else {
                    System.out.println("Vous avez fui le combat. Les ennemis ont gagné.");


                System.out.println("Vous avez vaincu les sorciers les plus maléfique du monde!");
                System.out.println("Rendez-vous à poudlard pour recevoir votre diplome ainsi que revoir tous vos amis et vos professeurs.");


                }


            }

        }


    }


}















