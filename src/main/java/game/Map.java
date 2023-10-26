package game;

import java.util.ArrayList;

public class Map {
    public static final ArrayList<Integer> mapList = new ArrayList<>();
    public static final ArrayList<Integer> spikePositionList = new ArrayList<>();

    public static final ArrayList<Integer> holePositionList = new ArrayList<>();
    public static final int levelHeight = 500;

    public static final int mapElementWidth = 80;
    public static final int mapElementHeight = 75;

    public static final int spikeHeight = 50;

    public static int mapOffset = 0;

    static {
        int[] heights = new int[]{1, 1, 2, 1, 3, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        int[] spikes = new int[] {4, 5, 6, 24, 25, 29};

        int[] holes = new int[] {2, 3, 24, 26, 27};
        for (int spike : spikes) {
            spikePositionList.add(spike);
        }
        for (int height : heights) {
            mapList.add(height);
        }
        for(int hole : holes) {
            holePositionList.add(hole);
        }
    }
}