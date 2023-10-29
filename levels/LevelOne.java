package levels;

import java.util.ArrayList;

/**
 * The `LevelOne` class represents the properties of the first game level, which extends the `Level` abstract class.
 */
public class LevelOne extends Level {
    // ArrayLists to define the map, spike positions, and hole positions for this level
    public static final ArrayList<Integer> mapList = new ArrayList<>();
    public static final ArrayList<Integer> spikePositionList = new ArrayList<>();
    public static final ArrayList<Integer> holePositionList = new ArrayList<>();

    static {
        // Heights of map elements in this level
        int[] heights = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 4, 4, 4,
                4, 3, 1, 1, 1, 1, 1, 1, 2, 3, 3, 4, 4, 3, 3, 4, 4, 4,
                3, 3, 2, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2};

        // Positions of spikes in this level
        int[] spikes = new int[]{5, 8, 20, 21, 31, 32, 48, 49};

        // Positions of holes in this level
        int[] holes = new int[]{10, 11, 23, 24, 40, 41};

        // Populate the spike positions ArrayList
        for (int spike : spikes) {
            spikePositionList.add(spike);
        }

        // Populate the map heights ArrayList
        for (int height : heights) {
            mapList.add(height);
        }

        // Populate the hole positions ArrayList
        for (int hole : holes) {
            holePositionList.add(hole);
        }
    }
}
