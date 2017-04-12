import javax.swing.*;

/**
 * Created by DarthVader on 3/22/17.
 */
public class Program {

    public static boolean quit = false;

    public static void main(String[] args) {

        GameManager.ShowTitleScreen();

        GameEngineGui gui = new GameEngineGui();

        Level.Initialize();

        GameManager.StartGame();


        CommandProcessor.gui = gui;

       //if(quit) System.exit(0);


    }
}
