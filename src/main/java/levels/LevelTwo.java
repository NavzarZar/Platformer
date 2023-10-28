package levels;

import java.util.ArrayList;

public class LevelTwo {
    public static final ArrayList<Integer> mapList = new ArrayList<>();
    public static final ArrayList<Integer> spikePositionList = new ArrayList<>();
    public static final ArrayList<Integer> holePositionList = new ArrayList<>();
    public static final int levelHeight = 500;
    public static final int mapElementWidth = 80;
    public static final int mapElementHeight = 60;

    public static final int spikeHeight = 50;

    public static int mapOffset = 0;
    //38
    static {
        int[] heights = new int[]{1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 5, 4, 3, 3, 5, 4, 4, 4, 4, 3, 2, 2, 3, 3, 2, 1, 2, 2, 3, 3,
                2, 3, 3, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2, 3, 3, 4, 5, 5, 6, 20};

        int[] spikes = new int[]{11, 12, 13, 23, 24, 25, 30, 43, 44, 49};

        int[] holes = new int[]{4, 6, 8, 20, 21, 26, 38, 39, 40};
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