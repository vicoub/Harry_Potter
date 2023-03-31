import java.util.List;

public class Spell extends AbstractSpell{

    private String nom;
    private String type;

    private String description;

    private int pWin;

    private int dp;



    public static final Spell wingardiumLeviosa = new Spell ("Wingardium leviosa", "normal",
            " un sort qui permet de deplacer des objets",80,10);

    public static final Spell expectroPatronum = new Spell ("expectro patronum", "normal",
            " un sort qui chasse les détraqueurs",90,30);

    public static final Spell accio = new Spell ("accio","normal",
            "sort qui permet permet de faire venir un objet jusqu'au sorcier lançant le sort.", 80,
            10);

    public static final Spell sectumSempra = new Spell("sectumSempra","normal",
            "créé par Severus Rogue, il est utilisé pour trancher de l'intérieur des objets ou des êtres vivants…", 70,
            20);

    public static Spell avadaKadavra = new Spell ( "avada Kadavra","interdit",
            " ce sortilège inflige la mort instantanée de la personne visée.",100,
            200);



    public Spell(String name, String type, String description, int pWin, int dp) {
        super(name, type, description, pWin, dp);
        this.name = name;
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
