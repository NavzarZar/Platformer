package game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Map extends JPanel {
    private Graphics graphics;
    private ArrayList<Integer> mapList = new ArrayList<>();

    private int mapElementWidth = 50;
    private int mapElementHeight = 100;

    public Map()
    {
        mapList.add(1);
        mapList.add(3);
        mapList.add(1);
        mapList.add(3);
        mapList.add(1);
        mapList.add(3);
    }

    public int getMapElementWidth() {
        return mapElementWidth;
    }

    public ArrayList<Integer> getMapList() {
        return new ArrayList<>(mapList);
    }

    public int getMapElementHeight() {
        return mapElementHeight;
    }
}