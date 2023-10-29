package levels;

import java.util.ArrayList;

/**
 * The `LevelThree` class represents the properties of the third game level, which extends the `Level` abstract class.
 */
public class LevelThree extends Level {
    // ArrayLists to define the map, spike positions, and hole positions for this level
    public static final ArrayList<Integer> mapList = new ArrayList<>();
    public static final ArrayList<Integer> spikePositionList = new ArrayList<>();
    public static final ArrayList<Integer> holePositionList = new ArrayList<>();

    static {
        // Heights of map elements in this level
        int[] heights = new int[]{1, 1, 1, 2, 2, 1, 1, 2, 2, 3, 3, 3, 4, 4, 3, 2, 4, 4,
                4, 2, 1, 2, 4, 3, 3, 3, 3, 1, 1, 2, 1, 2, 2, 2, 1, 1,
                1, 1, 2, 2, 3, 3, 2, 2, 3, 1, 1, 2, 3, 4, 5, 5, 5, 5};

        // Positions of spikes in this level
        int[] spikes = new int[]{5, 6, 14, 15, 19, 20, 21, 23, 27, 28, 42, 43, 45};

        // Positions of holes in this level
        int[] holes = new int[]{2, 10, 11, 24, 25, 30, 32, 39, 40, 46, 47};

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
