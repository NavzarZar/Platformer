package game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Map {
    private final ArrayList<Integer> mapList = new ArrayList<>();

    static final int levelHeight = 500;

    private final int mapElementWidth = 75;
    private final int mapElementHeight = 50;

    public Map() {
        int[] heights = new int[]{1, 1, 1, 2, 1, 3, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2};
        for (int height : heights) {
            mapList.add(height);
        }
    }

    public ArrayList<Integer> getMapList() {
        return new ArrayList<>(mapList);
    }

    public int getMapElementWidth() {
        return mapElementWidth;
    }

    public int getMapElementHeight() {
        return mapElementHeight;
    }
}