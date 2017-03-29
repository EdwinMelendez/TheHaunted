import javax.swing.*;

public class TextBuffer  {



    private static String outputBuffer;


    public static void Add(String text){

        outputBuffer += text + "\n";
    }

    public static void Display(JTextPane textPane){

        textPane.setText("");

        textPane.setText(TextUtils.WordWrap(outputBuffer));


        outputBuffer ="";
    }

}
