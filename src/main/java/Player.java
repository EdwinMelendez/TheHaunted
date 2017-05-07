import java.util.ArrayList;


public class Player {

    //Player class
    private static int posX;
    private static int posY;

    //Player holds array list of items with a weight cap of 6
    private static ArrayList<Item> inventoryItems = new ArrayList<Item>();
    private static int moves = 0;
    private static int weightCap = 6;


    public static int getPosX() {
        return posX;
    }

    public static void setPosX(int posX) {
        Player.posX = posX;
    }

    public static int getPosY() {
        return posY;
    }

    public static void setPosY(int posY) {
        Player.posY = posY;
    }

    public static int getMoves() {
        return moves;
    }

    public static void setMoves(int moves) {
        Player.moves = moves;
    }

    public static int getWeightCap() {
        return weightCap;
    }

    public static void setWeightCap(int weightCap) {
        Player.weightCap = weightCap;
    }

    public static int getInventoryWeight(){

        int result = 0;

        for(Item item : inventoryItems){
            result += item.getWeight();
        }
        return result;
    }


    public Player(){

        //inventory array list
        inventoryItems = new ArrayList<Item>();
    }


    public static void Move(String direction){

        //gets players current room
        Room room = Player.GetCurrentRoom();

        //if can not move a direction
        if(!room.CanExit(direction)){
            //prompts user that they typed an invalid direction
            TextBuffer.AddDescription("Invalid Direction");
            return;
        }

        //increments move counter
        Player.moves++;

        if (direction.equals(Direction.North)) {
            posX--;

        } else if (direction.equals(Direction.South)) {
            posX++;

        } else if (direction.equals(Direction.East)) {
            posY++;

        } else if (direction.equals(Direction.West)) {
            posY--;

        }

        //describes player's current room
        Player.GetCurrentRoom().Describe();



    }

    //method for picking up an item
    public static void PickupItem(String itemName){

        Room room = Player.GetCurrentRoom();
        Item item = room.GetItem(itemName);

        //if the user didn't type an item name it asks which item the user meant
        if (itemName.equals("")){
            TextBuffer.AddItem("Which item?");
            return;
        }

        //if item is not null
        if(item != null){

            //if the inventory weight exceeds capacity doesn't allow user to pick up any more items
            if (Player.getInventoryWeight() + item.getWeight() > Player.weightCap){
                TextBuffer.AddItem("Inventory capacity reached. Please drop an item to pick up another.");
                return;
            }

            //otherwise remove item from room array list
            room.getItems().remove(item);

            //adds item to inventory
            Player.inventoryItems.add(item);

            //displays item pick up text
            TextBuffer.AddItem(item.getPickupText());
        }
        else{

            //displays if you typed the wrong name
            TextBuffer.AddItem("There is no " + itemName + " in this room.");
        }
    }

    //method for dropping items works similar to picking up item method
    public static void DropItem(String itemName){

        Room room = Player.GetCurrentRoom();
        Item item = GetInventoryItem(itemName);

        if(item != null){
            room.getItems().add(item);
            Player.inventoryItems.remove(item);

            TextBuffer.AddItem("The "+ itemName + " has been dropped into this room.");
        }
        else{
            TextBuffer.AddItem("There is no "+ itemName + " in your inventory.");
        }
    }

    //display inventory method
    public static void DisplayInventory(){

        String message = "Your inventory contains:";
        String items = "";
        String underline = "------------------------";

        if(inventoryItems.size() > 0){
            for(Item item : inventoryItems){
                items += "\n[" + item.getTitle() + "] Wt: " + item.getWeight();
            }
        }
        else{
            items = "\n<no items>";
        }

        items += "\n\nTotal Wt: " + Player.getInventoryWeight() + " / " + Player.weightCap;

        TextBuffer.AddItem(message + "\n" + underline + items);
    }

    //gets current room
    public static Room GetCurrentRoom(){

        return Level.rooms[posX][posY];
    }

    //gets inventory item
    public static Item GetInventoryItem(String itemName){

        for(Item item : inventoryItems){
            if (item.getTitle().toLowerCase().contains(itemName.toLowerCase())){
                return  item;
            }
        }
        return null;
    }
}
