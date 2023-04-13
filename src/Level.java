import lombok.Data;

import java.util.ArrayList;


@Data
public class Level {
    private boolean completed;
    private int levelNumber;
    private ArrayList<AbstractEnemy> enemiesList;
    private String[] battleTexts;

    public Level(int levelNumber, String[] battleTexts, ArrayList<AbstractEnemy> enemiesList) {
        completed = false;
        this.enemiesList = enemiesList;
        this.levelNumber = levelNumber;
        this.battleTexts = battleTexts;
    }
}
