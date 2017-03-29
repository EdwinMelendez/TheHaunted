import javax.swing.*;

public class TextBuffer  {



    private static String descriptionBuffer;
    private static String itemBuffer;
    private static String directionBuffer;



    public static void AddDescription(String text){

        descriptionBuffer += text + "\n";
    }

    public static void AddItem(String text){

        itemBuffer += text + "\n";
    }
    public static void AddDirection(String text){

        directionBuffer += text + "\n";
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

    public static void Reset(){
        descriptionBuffer = "";
        itemBuffer = "";
        directionBuffer = "";
    }

}
