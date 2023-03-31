import lombok.Data;

@Data
public class House {

    private static final House Gryffondor = new House("Gryffondor", "la description de gryfondor", Specificity.RESISTANT_TO_DAMAGE );
    private static final House HufflePuff = new House("huffle puff", "description", Specificity.STRONG_POTION);
    private static final House RavenClaw = new House("ravenClaw", "description", Specificity.ACCURATE);
    private static final House syltherin = new House("Syltherin", "description", Specificity.POWERFUL_SPELL);

    public static final House[] listHouse = {Gryffondor , HufflePuff , RavenClaw, syltherin};

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