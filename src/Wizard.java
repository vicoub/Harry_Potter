import java.util.List;

public class Wizard extends Character{

    private final String name;

    private final String sex;

    private final House house;

    private final Pet pet;

    private List<Spell> knownSpells;

    public enum Pet {
        OWL, CAT, TOAD, DRAGON, SNAKE
    }

    private List<Potion> potions;

    private final String wand;

    public Wizard(String name, String sex , Pet pet, House house, int hp, String wand) {
        super(hp);
        this.name = name;
        this.sex = sex;
        this.pet = pet;
        this.house = house;
        this.wand  = wand;
    }

}
