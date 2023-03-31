import lombok.Data;

@Data
public abstract class Character {
    public int hpMax;
    public int dp;
    public int hp;
    public int maxHp;
    public int xp;
    public int accuracy;
    public int level;

    public Character(int level,  int dp, int hp, int hpMax) {
        this.level = level;
        this.setHpMax(hpMax);
        this.dp = dp;
        this.hp = hp;
    }


    public void upgradeStats(boolean upgradeHp, int rising) {
        if (upgradeHp) {
            this.hp += rising;
        } else {
            this.dp += rising;

        }
    }

    public int attack(){
        return this.dp;
    }

    public int defend(){
        return (int) (this.hpMax * 0.05);
    }



}
