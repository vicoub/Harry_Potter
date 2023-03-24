public class Spell {

    private String nom;
    private String type;

    private String description;

    private double pWin;

    public Spell(String nom, String type, String description, double pWin) {
        this.nom = nom;
        this.description = description;
        this.type = type;
        this.pWin = pWin;
    }
}