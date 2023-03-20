import lombok.Data;

@Data
public class Character {

    private int hp;

    public Character(int hp){
        this.hp = hp;
    }


    public void attack(Character character) {
        character.setHp(character.getHp() - 10);
    }
}
