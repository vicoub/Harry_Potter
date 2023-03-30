import java.util.List;

public abstract class AbstractEnemy extends Character{

    public static String name;
    public int level;

    public int pWin;
    public AbstractEnemy(int level,String name, int hpMax, int hp, int dp, int pWin) {
        super(level, hpMax, hp, dp);
        this.level = level;
        this.name = name;
        this.dp = dp;
        this.setHpMax(hpMax);
        this.hp = hp;
        this.pWin = pWin;
    }

    public String getName() {
        return name;
    }

    public int getDp(){
        return this.dp;
    }

    public void enemyAttack(Wizard wizard, Enemy enemy) {
        System.out.println(getName() + " attack " + wizard.getName() );

        ;
        if (Math.random() * 100 + 1 <= pWin){
            wizard.setHp(wizard.getHp() - getDp());
            System.out.println(getName() + " t'as inflige " + getDp() + " degats" );
        }else{
            System.out.println(getName() + "a rate sa cible. Tu as toujours " + wizard.getHp());
        }
    }



}
