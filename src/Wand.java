public class Wand {

    public enum Core {
        PHOENIX_FEATHER,
        DRAGON_HEARTSTRING
    }

    private final int size;

    private final String name;
    private final Core core;


    public Wand(Core core, int size, String name)
    {this.core = core;
    this.size = size;
    this.name = name;
    }

}
