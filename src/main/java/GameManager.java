import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by DarthVader on 3/22/17.
 */
public class GameManager {


    public static void ShowTitleScreen(){
        System.out.println("Welcome to The Haunted");
    }

    public static Room[][] updatedRoom;

    public static void StartGame(){

        Player.GetCurrentRoom().Describe();

    }

    public static void EndGame(){

        Program.quit = true;
        System.out.println("Exiting Game...");
        System.exit(0);
    }

    public static void ApplyRules() throws NullPointerException{

        ArrayList<Room> databaseNewRooms = Database.doorQuery();
       //ArrayList<Item> databaseItems = Database.loadItems();
       //ArrayList<Room> databaseChangedRooms = Database.loadChangedRooms();
        ArrayList<LockedDoor>  databaseLocks = Database.loadExits(Player.GetCurrentRoom().getTitle());

try {
    for (LockedDoor lock : databaseLocks) {

        boolean unlock = true;

        for (String itemRequired : lock.getItemNeeded()) {

            if (!Player.GetCurrentRoom().getItems().contains(itemRequired.split(","))) {
                unlock = false;
                break;
            }

        }
        if (unlock) {

            for (Room room : databaseNewRooms) {
                room.getDescription();
                room.getExits();
                room.getX();
                room.getY();
            }
        }

    }
}catch (NullPointerException npe){
    npe.printStackTrace();
}
        }






        //TextBuffer.Reset();
    }


