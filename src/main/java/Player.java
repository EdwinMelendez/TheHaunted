import java.util.ArrayList;

/**
 * Created by DarthVader on 3/22/17.
 */
public class Player {


    private static int posX;
    private static int posY;

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

        inventoryItems = new ArrayList<Item>();
    }


    public static void Move(String direction){

        Room room = Player.GetCurrentRoom();


        if(!room.CanExit(direction)){
            TextBuffer.AddDescription("Invalid Direction");
            return;
        }


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
        Player.GetCurrentRoom().Describe();



    }

    public static void PickupItem(String itemName){

        Room room = Player.GetCurrentRoom();
        Item item = room.GetItem(itemName);

        if (itemName.equals("")){
            TextBuffer.AddItem("Which item?");
            return;
        }

        if(item != null){
            if (Player.getInventoryWeight() + item.getWeight() > Player.weightCap){
                TextBuffer.AddItem("Inventory capacity reached. Please drop an item to pick up another.");
                return;
            }

            room.getItems().remove(item);
            Player.inventoryItems.add(item);
            TextBuffer.AddItem(item.getPickupText());
        }
        else{
            TextBuffer.AddItem("There is no " + itemName + " in this room.");
        }
    }

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

    public static Room GetCurrentRoom(){

        //TextBuffer.Reset();
       // return (Room) Level.rooms.subList(posX,posY);
        return Level.rooms[posX][posY];
    }

    public static Item GetInventoryItem(String itemName){

        for(Item item : inventoryItems){
            if (item.getTitle().toLowerCase().contains(itemName.toLowerCase())){
                return  item;
            }
        }
        return null;
    }
}
