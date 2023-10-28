package levels;

import java.util.ArrayList;

public class LevelThree {
    public static final ArrayList<Integer> mapList = new ArrayList<>();
    public static final ArrayList<Integer> spikePositionList = new ArrayList<>();
    public static final ArrayList<Integer> holePositionList = new ArrayList<>();
    public static final int levelHeight = 500;
    public static final int mapElementWidth = 80;
    public static final int mapElementHeight = 60;

    public static final int spikeHeight = 50;

    public static int mapOffset = 0;

    static {
        int[] heights = new int[]{1, 1, 1, 2, 2, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 2, 1, 2, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 20};

        int[] spikes = new int[]{};

        int[] holes = new int[]{};
        for (int spike : spikes) {
            spikePositionList.add(spike);
        }
        for (int height : heights) {
            mapList.add(height);
        }
        for (int hole : holes) {
            holePositionList.add(hole);
        }
    }
}
