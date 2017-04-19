import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

/**
 * Created by DarthVader on 3/22/17.
 */
public class GameManager {


    public static void ShowTitleScreen(){
        System.out.println("Welcome to The Haunted");
    }


    public static void StartGame(){

        Player.GetCurrentRoom().Describe();

    }

    public static void EndGame(){

        Program.quit = true;
        System.out.println("Exiting Game...");
        System.exit(0);
    }

    public static void ApplyRules(){



        //TextBuffer.Reset();
    }

}
