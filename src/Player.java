import java.util.ArrayList;

/**
 * Created by DarthVader on 3/22/17.
 */
public class Player {


    private static int posX;
    private static int posY;

    private static ArrayList<Item> inventoryItems = new ArrayList<>();
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

    public static int getInventoryWeight(){ return 0; }//TODO: Finish weight Calculation getters and setters

    public static void Move(String direction){

    }

    public static void PickupItem(String itemName){

    }

    public static void DropItem(String itemName){

    }

    public static void DisplayInventory(){

    }

    public static Room GetCurrentRoom(){

        return null;
    }

    public static Item GetInventoryItem(String itemName){

        return null;
    }
}
