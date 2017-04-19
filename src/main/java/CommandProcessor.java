import javax.swing.*;
import java.awt.*;


public  class CommandProcessor {


    public static GameEngineGui gui;


    public static void ProcessCommand(String line) throws Exception{

        String command = TextUtils.ExtractCommand(line.toLowerCase());
        //System.out.println("command execute");
        System.out.println(command);
        String argument = TextUtils.ExtractArguments(line.toLowerCase());
        //System.out.println("argument execute");
        System.out.println(argument);
        switch (command){

            case "exit":
                GameManager.EndGame();
                break;

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
                TextBuffer.Reset();
                Player.DisplayInventory();
                break;
            case "whereami":
                TextBuffer.Reset();
                Player.GetCurrentRoom().ShowTitle();
                break;

            default:
                TextBuffer.Reset();
                TextBuffer.AddDescription("That doesn't make sense...");
                break;
        }
        GameManager.ApplyRules();
        //TextBuffer.Reset();

        String outRoom = TextBuffer.OutputRoomName();
        String outDescript = TextBuffer.OutputDescription();
        String outDirect = TextBuffer.OutputDirection();
        String outItem = TextBuffer.OutputItem();

        gui.DisplayRoomName(outRoom);
        gui.DisplayRoomDescription(outDescript);
        gui.DisplayDirections(outDirect);
        gui.DisplayItems(outItem);


    }

    public static void ShowHelp(){

        TextBuffer.Reset();
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
