import java.util.ArrayList;
import java.util.List;

public class Potion {
    private final String name;
    private int gainHp;

    public static final Potion strongPotion = new Potion("Strong Potion" , 40);

    public Potion(String name, int gainHp) {
        this.name = name;
        this.gainHp = gainHp;
    }

    public int gethpGain(Wizard wizard) {
        int hpGain = this.gainHp;
        if (wizard.getHouse().getSpecificity() == House.Specificity.STRONG_POTION) {
            hpGain *= 1.2; // Augmenter les points de vie gagnés de 20% pour les membres de Hufflepuff
        }
        return hpGain;
    }

    public static void main(String[] args) {
        List<Potion> potions = new ArrayList<>();
        Potion potion1 = new Potion("Heal", 40);
        potions.add(potion1);
    }
}
