import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DarthVader on 3/22/17.
 */
public class Room {

    private String title;
    private String description;

    private ArrayList<String> exits;
    private ArrayList<Item> items;

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

    //getters and setters


    public Room() {
        exits = new ArrayList<String>();
        items = new ArrayList<Item>();
    }


    public void Describe(){

        TextBuffer.AddDescription(this.description);
        TextBuffer.AddItem(this.GetItemList());
        TextBuffer.AddDirection(this.GetExitList());
    }

    public void ShowTitle(){
        TextBuffer.AddRoomName(this.title);
    }

    public Item GetItem(String itemName){

        for (Item item : this.items){
            if (item.getTitle().toLowerCase() == itemName.toLowerCase());
            return item;
        }
        return null;
    }

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

    public Boolean CanExit(String direction){

        for (String validExit : exits) {
            if(direction == validExit){
                return true;
            }
        }
        return false;

    }

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

//    private String GetCoordinates(){
//
//        for (int x = 0; x < Level.getRooms().toArray().length; x++){
//            for (int y = 0; y < Level.getRooms().toArray().length; y++){
//                if (this == Level.setRooms();{
//                    return "[" + y.
//                }
//            }
//        }
//    }






}
