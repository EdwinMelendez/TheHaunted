import javax.swing.*;

public class TextBuffer  {



    private static String outputBuffer;


    public static void Add(String text){

        outputBuffer += text + "\n";
    }

    public static String Output(){

       return outputBuffer;
    }

    public static void Reset(){
        outputBuffer = "";
    }

}
