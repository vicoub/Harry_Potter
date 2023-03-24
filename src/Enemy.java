import java.util.List;

public class Enemy extends AbstractEnemy {

    private final int level;
    private String name;
    private int hp;
    private int hpMax;
    private List<Spell> knownSpell;


    public Enemy(int level, String name, int hp, int hpMax) {
        super(hp);
        this.level = level;
        this.name = name;
        this.hpMax = hpMax;
    }

    public void attackWizard(Wizard wizard) {
        int damage = 10; // Calculer les dégâts en fonction du sort utilisé
        if (wizard.getHouse().getSpecificity() == House.Specificity.RESISTANT_TO_DAMAGE) {
            damage *= 0.8; // Réduire les dégâts de 20% pour les sorciers de Gryffindor
        }
        this.attack(wizard, damage);
    }

}
