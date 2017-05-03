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

    public static void ApplyRules()  {

        ArrayList<Room> databaseRooms = Database.loadRooms();
        ArrayList<Room> databaseChangedRooms = Database.loadChangedRooms();
        ArrayList<LockedDoor> databaseLocks = Database.loadExits(Player.GetCurrentRoom().getTitle());

        Boolean lock = true;


        for (LockedDoor lockedDoor : databaseLocks){

            String itemRequired = lockedDoor.getItemNeeded();

            if (Player.GetCurrentRoom().getItems().contains(itemRequired)){

                for (Room room : databaseRooms){

                    for(Room changedRoom : databaseChangedRooms){

                        if(room.getVariant().equals(changedRoom.getVariant())){

                            room.setExits(changedRoom.getExits());
                            room.setDescription(changedRoom.getDescription());

                        }


                    }
                }
            }
            else if(!Player.GetCurrentRoom().getItems().contains(itemRequired)){
                lock = false;
                break;
            }

        }


       }






        //TextBuffer.Reset();
    }


