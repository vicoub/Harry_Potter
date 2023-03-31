import java.util.List;

public class Enemy extends AbstractEnemy{
    public static String name;
    public int level;
    private List<Spell> knownSpell;


    public static Enemy Mangemort = new Enemy(6 ,"mangeMort",140, 140,  50, 70);

    public Enemy(int level,String name, int hpMax,int hp, int dp, int pWin) {
        super(level, name, hpMax, hp, dp, pWin);
        this.level = level;
        this.name = name;
        this.setHpMax(hpMax);
        this.hp = hpMax;
        this.pWin = pWin;
    }




}



