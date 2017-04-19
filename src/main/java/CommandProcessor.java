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
        if (command.equals("exit")) {
            GameManager.EndGame();

        } else if (command.equals("help")) {
            ShowHelp();

        } else if (command.equals("move")) {
            Player.Move(argument);

        } else if (command.equals("look")) {
            Player.GetCurrentRoom().Describe();

        } else if (command.equals("pickup")) {
            Player.PickupItem(argument);

        } else if (command.equals("drop")) {
            Player.DropItem(argument);

        } else if (command.equals("inventory")) {
            TextBuffer.Reset();
            Player.DisplayInventory();

        } else if (command.equals("whereami")) {
            TextBuffer.Reset();
            Player.GetCurrentRoom().ShowTitle();

        } else {
            TextBuffer.Reset();
            TextBuffer.AddDescription("That doesn't make sense...");

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
