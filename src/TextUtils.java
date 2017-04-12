/**
 * Created by DarthVader on 3/22/17.
 */
public class TextUtils {



    public static String ExtractCommand (String line){

        int index = line.indexOf(' ');


        if (index == - 1){
            return line;
        }
        else {
            return line.substring(0, index);
        }

    }


    public static String ExtractArguments(String line) throws Exception{

        int index = line.indexOf(' ');
//        String [] part = line.trim().split("\\s+");
//        String lastWord = part[part.length - 1];
        //String lastWord = line.substring(index + 1, line.length() - index - 1);


        try {
    if (index == -1) {
        return "";

    } else {
        //System.out.println(lastWord);
        //return (line.substring(index + 1, line.length() - index -1));
        return line.substring(index);

    }
}catch (Exception e){
    System.out.println("Error extracting argument");
}

return "";
    }


    public static String WordWrap(String text){

        return text;
    }





    public static void main(String[] args) {

    }
}
