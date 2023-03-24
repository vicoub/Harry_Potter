import lombok.Data;

@Data
public class Character {

    private int hp;

    public Character(int hp){
        this.hp = hp;
    }

    public void attack(Character character, int damage) {
        character.setHp(character.getHp()-damage);
    }


}
