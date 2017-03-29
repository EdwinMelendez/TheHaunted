import javax.swing.*;
import java.awt.*;

/**
 * Created by DarthVader on 3/22/17.
 */
public  class CommandProcessor {


    public static GameEngineGui gui;


    public static void ProcessCommand(String line){

        String command = TextUtils.ExtractCommand(line.trim().trim().toLowerCase());
        String argument = TextUtils.ExtractArguments(line.trim().trim().toLowerCase());

        switch (command){

            case "exit":
                Program.quit = true;
                return;

            case "help":
                ShowHelp();
                break;

            case "move":
                Player.Move(argument);
                break;

            case "look":
                Player.GetCurrentRoom().Describe();
                break;

            case "pickup":
                Player.PickupItem(argument);
                break;

            case "drop":
                Player.DropItem(argument);
                break;

            case "inventory":
                Player.DisplayInventory();
                break;
            case "whereami":
                Player.GetCurrentRoom().ShowTitle();
                break;

            default:
                TextBuffer.Add("That doesn't make sense...");
                break;
        }
        GameManager.ApplyRules();
        String output = TextBuffer.Output();
        gui.Display(output);
        TextBuffer.Reset();
    }

    public static void ShowHelp(){

        TextBuffer.Add("Available Commands:");
        TextBuffer.Add("--------------------");
        TextBuffer.Add("help");
        TextBuffer.Add("exit");
        TextBuffer.Add("move [north,south,east,west]");
        TextBuffer.Add("look");
        TextBuffer.Add("pickup");
        TextBuffer.Add("drop");
        TextBuffer.Add("inventory");
        TextBuffer.Add("whereami");


    }

}
