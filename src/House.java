public class House {

    private final String name;
    private final String description;

    private final Specificity specificity;

    public House(String name, String description, Specificity specificity) {
        this.name = name;
        this.description = description;
        this.specificity = specificity;
    }

    public enum Specificity {

        STRONG_POTION, POWERFUL_SPELL, RESISTANT_TO_DAMAGE, ACCURATE
    }

    public Specificity getSpecificity() {
        return this.specificity;
    }
}