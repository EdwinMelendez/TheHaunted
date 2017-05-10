public  class CommandProcessor {


    public static GameEngineGui gui;


    public static void ProcessCommand(String line) throws Exception{

        //reset text windows
        TextBuffer.Reset();

        //extracts command (first word typed)
        String command = TextUtils.ExtractCommand(line.toLowerCase());

        //extracts argument (either direction or item names)
        String argument = TextUtils.ExtractArguments(line.toLowerCase());

            //quits game if you type 'exit'
        if (command.equals("exit")) {
            GameManager.EndGame();

            //shows list of commands
        } else if (command.equals("help")) {
            ShowHelp();

            //moving command
        } else if (command.equals("move")) {
            Player.Move(argument);

            //gets the description of the room
        } else if (command.equals("look")) {
            Player.GetCurrentRoom().Describe();

            //pick up an item
        } else if (command.equals("pickup")) {
            Player.PickupItem(argument);

            //drops an item
        } else if (command.equals("drop")) {
            Player.DropItem(argument);

            //displays inventory
        } else if (command.equals("inventory")) {
            TextBuffer.Reset();
            Player.DisplayInventory();

            //shows the room title
        } else if (command.equals("whereami")) {
            TextBuffer.Reset();
            Player.GetCurrentRoom().ShowTitle();

            //if wrong command is typed a message is displayed
        } else {
            TextBuffer.Reset();
            TextBuffer.AddDescription("That doesn't make sense...");

        }

        //applies game rules
        GameManager.ApplyRules();


        //displays the right text in the corresponding text boxes
        String outRoom = TextBuffer.OutputRoomName();
        String outDescript = TextBuffer.OutputDescription();
        String outDirect = TextBuffer.OutputDirection();
        String outItem = TextBuffer.OutputItem();

        gui.DisplayRoomName(outRoom);
        gui.DisplayRoomDescription(outDescript);
        gui.DisplayDirections(outDirect);
        gui.DisplayItems(outItem);


    }

    //show help method
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
