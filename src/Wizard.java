import java.util.List;

public class Wizard extends Character{

    private final Wand wand;

    private final Potion potion;

    private int hp;

    private int hpMax;

    private int dp;

    private double precision;



    private final String name;

    private final String sex;

    private final House house;

    private final Pet pet;

    private int level;

    private List<Spell> knownSpells;

    public enum Pet {
        OWL, CAT, TOAD, DRAGON, SNAKE
    }

    private List<Potion> potions;



    public Wizard(String name, String sex , Pet pet, House house, int hp,
                  Wand wand,int level,int dp, double precision,int hpMax,Potion potion ) {
        super(hp);
        this.name = name;
        this.sex = sex;
        this.pet = pet;
        this.house = house;
        this.wand  = wand;
        this.level = level;
        this.dp = dp;
        this.precision = precision;
        this.potion = potion;
    }

    public void upgradeStats(boolean upgradeHp, int rising) {
        if (upgradeHp) {
            this.hp += rising;
        } else {
            this.dp += rising;

        }
    }

    public void usePotion(Potion potion) {
        int hpgain = potion.gethpGain(this);
        this.hp = Math.min(this.hp + hpgain, this.hpMax);
    }

    public House getHouse() {
        return this.house;
    }
}