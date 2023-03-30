public class Spell {

    private String nom;
    private String type;

    private String description;

    private double pWin;

    public Spell(String nom, String type, String description, double pWin) {
        this.nom = nom;
        this.description = description;
        this.type = type;
        this.pWin = pWin;
        this.dp = dp;
    }

    public static void castSpell() {
    }

    public String getName() {
        return nom;
    }
    public int getDp(){
        return dp;
    }

    //Enemy specific attack and defence calculations
    public void useSpell(Wizard wizard, Enemy enemy) {
        System.out.println(wizard.getName() + " utilise " + getName() + " sur " + enemy.getName());

        ;
        if (Math.random() * 100 + 1 <= pWin){
            enemy.setMaxHp(enemy.getMaxHp() - getDp());
            System.out.println("Tu as infligé: " + getDp());
        }else{
            System.out.println("Ton sors rate sa cible. Ton ennemi a toujours" + enemy.getMaxHp());
        }
    }
}
