import javax.swing.*;

public class TextBuffer  {

//class for the three text area swing objects

    private static String descriptionBuffer;
    private static String itemBuffer;
    private static String directionBuffer;
    private static String roomNameBuffer;



    public static void AddDescription(String text){

        descriptionBuffer += text + "\n";
    }

    public static void AddItem(String text){

        itemBuffer += text + "\n";
    }
    public static void AddDirection(String text){

        directionBuffer += text + "\n";
    }
    public static void AddRoomName(String text) {
        roomNameBuffer += text;
    }

    public static String OutputDescription(){

       return descriptionBuffer;
    }
    public static String OutputItem(){

        return itemBuffer;
    }
    public static String OutputDirection(){

        return directionBuffer;
    }

    public static String OutputRoomName() {
        return roomNameBuffer;
    }


    //resets text areas
    public static void Reset(){
        descriptionBuffer = "";
        itemBuffer = "";
        directionBuffer = "";
        roomNameBuffer = "";
    }

}
