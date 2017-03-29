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
                TextBuffer.AddDescription("That doesn't make sense...");
                break;
        }
        GameManager.ApplyRules();

        String output = TextBuffer.OutputItem();

        gui.Display(output);

        TextBuffer.Reset();
    }

    public static void ShowHelp(){

        TextBuffer.AddItem("Available Commands:");
        TextBuffer.AddItem("--------------------");
        TextBuffer.AddItem("help");
        TextBuffer.AddItem("exit");
        TextBuffer.AddItem("move [north,south,east,west]");
        TextBuffer.AddItem("look");
        TextBuffer.AddItem("pickup");
        TextBuffer.AddItem("drop");
        TextBuffer.AddItem("inventory");
        TextBuffer.AddItem("whereami");


    }

}
