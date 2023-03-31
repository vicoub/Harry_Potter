import lombok.Data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
@Data
public class Wand {

    public enum Core {
        PHOENIX_FEATHER,
        DRAGON_HEARTSTRING
    }

    private final int size;

    private final String name;
    private final Core core;


    public Wand(Core core, int size, String name) {
        this.core = core;
        this.size = size;
        this.name = name;
    }

    public static Wand choixWand(){
        Random rand = new Random();
        int valTaille = rand.nextInt(15 , 35);
        List<Core> values = Collections.unmodifiableList(Arrays.asList(Core.values()));
        Core leCore = values.get(rand.nextInt(values.size()));
        return new Wand(leCore , valTaille , "pas de nom");
    }
}
