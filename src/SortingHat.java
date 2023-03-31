import java.util.Random;

public class SortingHat {

    public static House choixMaison(){
        Random rnd = new Random();
        int val = rnd.nextInt(House.listHouse.length);
        return House.listHouse[val];
    }
}