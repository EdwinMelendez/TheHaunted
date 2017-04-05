/**
 * Created by DarthVader on 3/22/17.
 */
public class TextUtils {


    public static String ExtractCommand (String line){

        int index = line.indexOf(' ');

        if (index == -1){
            return line;
        }
        else {
            return line.substring(0, index);
        }

    }


    public static String ExtractArguments(String line) throws Exception{

        int index = line.indexOf(' ');
try {
    if (index == -1) {
        return "";
    } else {
        return (line.substring(index + 1, line.length() - index - 1));
    }
}catch (Exception e){
    System.out.println("Error");
}

return "";
    }


    public static String WordWrap(String text){

        return text;
    }





    public static void main(String[] args) {

    }
}
