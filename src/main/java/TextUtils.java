/**
 * Created by DarthVader on 3/22/17.
 */
public class TextUtils {


    //extracts command
    public static String ExtractCommand (String line){

        int index = line.indexOf(' ');


        if (index == - 1){
            return line;
        }
        else {
            return line.substring(0, index).trim();
        }

    }

    //extracts arguments
    public static String ExtractArguments(String line) throws Exception{

        int index = line.indexOf(' ');

        try {
    if (index == -1) {
        return "";

    } else {
        return line.substring(index).trim();
    }
}catch (Exception e){
    System.out.println("Error extracting argument");
}
return "";
    }

}
