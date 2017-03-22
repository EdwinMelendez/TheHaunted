import java.util.ArrayList;

/**
 * Created by DarthVader on 3/22/17.
 */
public class Level {


    private static ArrayList<Room> rooms = new ArrayList<>();

    public static ArrayList<Room> getRooms() {
        return rooms;
    }

    public static void setRooms(ArrayList<Room> rooms) {
        Level.rooms = rooms;
    }//getters and setters

    public static void Initialize(){

    }

    private static void BuildLevel(){

    }
}
