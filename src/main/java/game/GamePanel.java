package game;
import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.Graphics;

public class GamePanel extends JPanel{
    //Coordinates where rectangle is drawn at
    private int xDelta = 100, yDelta = 100;
    Map map;
    //    private int frames = 0;
    //    private long lastChecked = 0;

    public GamePanel() {
        MouseInputs mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        map = new Map();
    }

    public void changeX(int value){
        this.xDelta += value;
    }

    public void changeY(int value){
        this.yDelta += value;

    }
    public void drawRect(int x, int y)
    {
        this.xDelta = x;
        this.yDelta = y;
    }

    @Override
    public void paintComponent(Graphics g){

        //Keeping the drawing sheet clean
        super.paintComponent(g);

        // Draw map
        for(int i = 0; i < map.getMapList().size(); i++) {
            for (int j = 0; j < map.getMapList().get(i); j++) {
                g.fillRect(i * map.getMapElementWidth(), j * map.getMapElementHeight() , map.getMapElementWidth(), map.getMapElementHeight());
            }
        }

        //Draw functions
        g.fillRect(xDelta,yDelta,50, 50);

//        Display framerate
//        frames++;
//        if(System.currentTimeMillis() - lastChecked >= 1000) {
//            lastChecked = System.currentTimeMillis();
//            System.out.println("FPS: " + frames);
//            frames = 0;
//        }
    }

    public void displayMap() {

    }
}