package levels;

import java.util.ArrayList;

/**
 * The `LevelTwo` class represents the properties of the second game level, which extends the `Level` abstract class.
 */
public class LevelTwo extends Level {
    // ArrayLists to define the map, spike positions, and hole positions for this level
    public static final ArrayList<Integer> mapList = new ArrayList<>();
    public static final ArrayList<Integer> spikePositionList = new ArrayList<>();
    public static final ArrayList<Integer> holePositionList = new ArrayList<>();

    static {
        // Heights of map elements in this level
        int[] heights = new int[]{1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 5, 4, 3, 3, 5, 4, 4, 4,
                4, 3, 2, 2, 3, 3, 2, 1, 2, 2, 3, 3, 2, 3, 3, 2, 2, 2,
                2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2, 3, 3, 4, 5, 5, 5};

        // Positions of spikes in this level
        int[] spikes = new int[]{11, 12, 13, 23, 24, 30, 43, 45, 49};

        // Positions of holes in this level
        int[] holes = new int[]{4, 6, 8, 20, 21, 26, 38, 39, 40};

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
