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


    public Character(int hp){
        this.hp = hp;
    }

    public void attack(Character character, int damage) {
        character.setHp(character.getHp()-damage);
    }

    public int defend(){
        return (int) (this.hpMax * 0.05);
    }



}
