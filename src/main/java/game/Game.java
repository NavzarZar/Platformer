package game;

import inputs.MouseInputs;

import javax.swing.*;
import java.time.chrono.JapaneseEra;

public class Game implements Runnable {
    private final GamePanel gamePanel;


    private void startGameLoop(){
        Thread gameThread = new Thread(this);
        gameThread.start();
    }
    public void run()
    {
        int SET_FPS = 120;
        double timePerFrame = 1000000000.0/ SET_FPS;
        boolean gameOver = false;
        long lastFrame = System.nanoTime();
        long now;
        JLabel coordinateLabel1 = new JLabel();
        JLabel coordinateLabel2 = new JLabel();
        JLabel coordinateLabel3 = new JLabel();
        JLabel coordinateLabel4 = new JLabel();

        coordinateLabel1.setSize(400, 50);
        coordinateLabel2.setSize(400, 100);
        coordinateLabel3.setSize(400, 150);
        coordinateLabel4.setSize(400, 200);

        coordinateLabel1.setLocation(10, 0);
        coordinateLabel2.setLocation(10, 5);
        coordinateLabel3.setLocation(10, 15);
        coordinateLabel4.setLocation(10, 20);

        while(!gameOver)
        {
            now = System.nanoTime();
            if(now - lastFrame >= timePerFrame)
            {
                coordinateLabel1.setText("Up-left Corner: " + "X: " + gamePanel.getPlayerX() + " Y: " + gamePanel.getPlayerY());
                gamePanel.add(coordinateLabel1);

                coordinateLabel2.setText("Up-right Corner: " + "X: " + (gamePanel.getPlayerX() + gamePanel.getPlayerWidth()) + " Y: " + gamePanel.getPlayerY());
                gamePanel.add(coordinateLabel2);

                coordinateLabel3.setText("Down-Left Corner: " + "X: " + gamePanel.getPlayerX() + " Y: " + (gamePanel.getPlayerY() + gamePanel.getPlayerHeight()));
                gamePanel.add(coordinateLabel3);

                coordinateLabel4.setText("Down-Right Corner: " + "X: " + (gamePanel.getPlayerX() + gamePanel.getPlayerWidth()) + " Y: " + (gamePanel.getPlayerY() + gamePanel.getPlayerHeight()));
                gamePanel.add(coordinateLabel4);

                gamePanel.repaint();
                lastFrame = now;
            }
        }
    }

    public Game()
    {
        gamePanel = new GamePanel();
        GameWindow gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
    }
}
