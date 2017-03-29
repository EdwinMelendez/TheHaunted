import java.util.ArrayList;

/**
 * Created by DarthVader on 3/22/17.
 */
public class Room {

    private String title;
    private String description;

    private ArrayList<String> exits = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();



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

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }//getters and setters



    public void Describe(){

        TextBuffer.AddDescription(this.description);
        TextBuffer.AddItem(this.GetItemList());
        TextBuffer.AddDirection(this.GetExitList());
    }

    public void ShowTitle(){

    }

    public Item GetItem(String itemName){
        return null;
    }

    public void AddExit(String direction){

    }

    public void RemoveExit(String direction){

    }

    public Boolean CanExit(String direction){
        return false;
    }

    private  String GetItemList(){

        return "";
    }

    private String GetExitList(){

        return "";

    }

    private String GetCoordinates(){

        return "";

    }






}
