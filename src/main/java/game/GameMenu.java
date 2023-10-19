package game;

public class GameMenu {
    StartMenu startMenu;
    MenuWindow menuWindow;
    public GameMenu()
    {
        startMenu = new StartMenu();
        menuWindow = new MenuWindow(startMenu);
    }

}
