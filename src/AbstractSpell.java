public abstract class AbstractSpell {

    public int damage;
    public String description;
    public int accuracy;
    public String name;
    public String type;


    public AbstractSpell(String name, String type, String description, int accuracy, int damage) {
        this.name = name;
        this.damage = damage;
        this.accuracy = accuracy;
        this.description = description ;
        this.type = type;
    }

}
