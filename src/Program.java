/**
 * Created by DarthVader on 3/22/17.
 */
public class Program {

    public static boolean quit = false;

    public static void main(String[] args) {

        GameManager.ShowTitleScreen();

        GameEngineGui gui = new GameEngineGui();

        CommandProcessor.gui = gui;

        while(quit == false){
            String output = TextBuffer.Output();
            CommandProcessor.ProcessCommand(output);
            //gui.Display(output);
        }


    }
}
