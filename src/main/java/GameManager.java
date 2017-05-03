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

    public static void ApplyRules() {

        //ArrayList<Room> databaseRooms = Database.loadRooms();
        ArrayList<Room> databaseChangedRooms = Database.loadChangedRooms();

        ArrayList<LockedDoor> databaseLocks = Database.loadExits(Player.GetCurrentRoom().getTitle());


        for (LockedDoor lockedDoor : databaseLocks){

        String itemRequired = lockedDoor.getItemNeeded();

        if (Player.GetCurrentRoom().doesContain(itemRequired)){

           Room roomChanged = Database.unlockedRoom(lockedDoor.getRoomName());

            for(Room room : Level.databaseRooms){

                room.setExits(roomChanged.getExits());

                room.setDescription(roomChanged.getDescription());
            }


        }


        }

       }






        //TextBuffer.Reset();
    }


