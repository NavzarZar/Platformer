package game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Map {
    public static final ArrayList<Integer> mapList = new ArrayList<>();

    public static final int levelHeight = 500;

    public static final int mapElementWidth = 75;
    public static final int mapElementHeight = 75;

    public static int mapOffset = 5;

    static {
        int[] heights = new int[]{1, 1, 2, 1, 3, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        for (int height : heights) {
            mapList.add(height);
        }
    }
}