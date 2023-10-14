package main;

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

        while(!gameOver)
        {
            now = System.nanoTime();
            if(now - lastFrame >= timePerFrame)
            {
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
