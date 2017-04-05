import java.util.ArrayList;
import java.util.List;

/**
 * Created by DarthVader on 3/22/17.
 */
public class Level {


    public static Room[][] rooms;

    public static Room[][] getRooms() {
        return rooms;
    }

    public static void setRooms(Room[][] rooms) {
        Level.rooms = rooms;
    }
//getters and setters

    public static void Initialize(){

        BuildLevel();
    }

    private static void BuildLevel(){

        //TODO: Change this method so that it uses txt file or server to update levels

        rooms = new Room[2][1];

        Room room;
        Item item = new Item();

        //create new room
        room = new Room();
        rooms[0][0] = room;
        //setup room
        TextBuffer.Reset();
        room.setTitle("Red Room");
        room.setDescription("You've entered a red room");
        room.AddExit(Direction.East);


        /////////////////////////////////////////////////////////////////


        //create new room
        room = new Room();
        rooms[1][0] = room;
        //setup room
        TextBuffer.Reset();
        room.setTitle("Blue Room");
        room.setDescription("You've entered a blue room");
        item.setTitle("red key");
        item.setPickupText("You've picked up the red key");
        item.getWeight();

        room.AddExit(Direction.West);


        Player.setPosX(0);
        Player.setPosY(0);

    }
}
