import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
public class Room {

    //room class
    private String title;
    private String description;

    private ArrayList<String> exits;
    private ArrayList<Item> items;


    private String variant;

    private int x, y;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getExits() {
        return exits;
    }

    public void setExits(ArrayList<String> exits) {
        this.exits = exits;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    //getters and setters


    public Room(String title, String description, int x ,int y, String variant) {
        this();
        this.title = title;
        this.description = description;
        this.variant = variant;
    }

    //room holds array list of exits and items
    public Room() {
        exits = new ArrayList<String>();
        items = new ArrayList<Item>();

    }

    // describes current room, description, items, and exits
    public void Describe(){

        TextBuffer.AddDescription(this.description);
        TextBuffer.AddItem(this.GetItemList());
        TextBuffer.AddDirection(this.GetExitList());
    }

    //shows room title
    public void ShowTitle(){
        TextBuffer.AddRoomName(this.title);
    }

    //gets items
    public Item GetItem(String itemName){

        //for items in array list of items in room
        for (Item item : this.items){

            //if item title equals item name
            if (item.getTitle().toLowerCase().equals(itemName.toLowerCase())) {

                //returns items
                return item;
            }
        }
        return null;
    }

    //boolean does contain item
    public boolean doesContain(String itemName){

        //for item needed in array list of item
        for (Item itemNeeded : this.items){

            //if item needed title equals item name
            if(itemNeeded.getTitle().equalsIgnoreCase(itemName))

                //returns true
              return true;
        }
       return false;
    }


    //add item
    public void addItem(Item item) {
        items.add(item);
    }


    //adds exit
    public void AddExit(String direction){

        if (this.exits.indexOf(direction) == -1){
            this.exits.add(direction);
        }

    }

    public void RemoveExit(String direction){

        if(this.exits.indexOf(direction) != -1){
            this.exits.remove(direction);
        }
    }

    //can exit boolean
    public Boolean CanExit(String direction){

        return exits.contains(direction);

    }

    //returns string of items in room
    private  String GetItemList(){

        String itemString = "";
        String message = "Items in Room:...";
        String underline = "-----------------";

        if(this.items.size() > 0){
            for (Item item : this.items){
                itemString += "\n[" + item.getTitle() + "] ";
            }
        }
        else{
            itemString = "\n<none>";
        }

        return "\n" + message + "\n" + underline + itemString;
    }

    //returns string of exits
    private String GetExitList(){

        String exitString = "";
        String message = "Exits in Room:...";
        String underline = "-----------------";

        if(this.exits.size() > 0){
            for (String exitDirection : exits){
                exitString += "\n[" + exitDirection + "] ";
            }
        }
        else{
            exitString = "\n<none>";
        }
        return "\n" + message + "\n" + underline + exitString;
    }
}
