
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Wizard extends Character{

    private  Wand wand;



    private int gold;

    private double precision;



    private String name;

    public int hp;

    private int dp;

    private  String sex;

    private House house;

    private  Pet pet;

    private int level;

    private List<Spell> knownSpells = new ArrayList<>();


    private  List<Potion> listePotions = new ArrayList<Potion>();



    public Wizard(int level, int dp, int hp, double precision ) {
        super(level, dp, hp, hp);
        this.setHpMax(hp);
        this.hp = hp;
        this.hpMax = hp;
        this.level = level;
        this.dp = dp;
        this.precision = precision;
        this.gold = 0;
    }



    public void usePotion(Potion potion) {
        int hpgain = potion.gethpGain(this);
        hp += hpgain;
        System.out.println("La potion te gueri de "+ hpgain + ". Tu as maintenant " + hp);
    }

    public House getHouse() {
        return this.house;
    }

    public void addSpell(Spell spell){
        this.knownSpells.add(spell);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
       this.name = name;}
    public boolean alive(){
        if(this.hp <= 0){
            return false;}
        else{
            return true;
        }
    }

}