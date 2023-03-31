public class Boss extends AbstractEnemy{



    public static Boss troll = new Boss(1,"le troll",40, 5,50,40);
    public static Boss basilic = new Boss(2,"basilic",60,10, 60,60);

    public static Boss detraqueur = new Boss(3,"detraqueur",80,20,70,80);

    public static Boss peterPettigrow = new Boss(4,"peterPettigrow",90,20,70,90);

    public static Boss Voldemort = new Boss ( 7, "voldemort",140,30,80,100);

    public static Boss DoloresOmbrage = new Boss ( 5, "doloresOmbrage",120,30,80,120);

    public static Boss Mangemort = new Boss(6 ,"mangeMort",140,30,80,140 );

    public static Boss Bellatrix = new Boss(7 ,"Bellatrix",100,30,70,100 );


    public Boss (int level,String name,int hp,int dp, int pWin, int hpMax) {
        super(level, name, hpMax, hp, dp, pWin);
        this.hp = hpMax;
        this.level = level;
        this.name = name;
        this.dp = dp;
        this.setHpMax(hpMax);
        this.pWin = pWin;
    }


    public boolean alive() {
        return hp > 0;
    }







}
