package game;

import java.util.ArrayList;

public class Map {
    public static final ArrayList<Integer> mapList = new ArrayList<>();
    public static final ArrayList<Integer> spikePositionList = new ArrayList<>();
    public static final ArrayList<Integer> holePositionList = new ArrayList<>();
    public static final int levelHeight = 500;
    public static final int mapElementWidth = 80;
    public static final int mapElementHeight = 60;

    public static final int spikeHeight = 50;

    public static int mapOffset = 0;

    static {
        int[] heights = new int[]{1, 1, 1, 2, 2, 1, 1, 2, 2, 3, 3, 3, 4, 4, 3, 2, 4, 4, 4, 2, 1, 2, 4, 3,
                3, 3, 3, 1, 1, 2, 1, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 11};

        int[] spikes = new int[]{5, 6, 14, 15, 19, 20, 21, 23, 27, 28};

        int[] holes = new int[]{2, 10, 11, 24, 25, 30};
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
