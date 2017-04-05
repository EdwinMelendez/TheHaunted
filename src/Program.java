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

        //while(quit == false){
            //String output = TextBuffer.OutputItem();
            //CommandProcessor.ProcessCommand(output);
            //gui.Display(output);
        //}


    }
}
