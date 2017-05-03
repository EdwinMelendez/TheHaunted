import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

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


        HashMap<String, String> lockedDoorsAndItemsNeededToUnlock = Database.loadLockedDoors(Player.GetCurrentRoom().getTitle());

        Room currentRoom = Player.GetCurrentRoom();

        for (String direction : lockedDoorsAndItemsNeededToUnlock.keySet()){

            String itemRequired = lockedDoorsAndItemsNeededToUnlock.get(direction);

            if(Player.GetCurrentRoom().doesContain(itemRequired)){

                currentRoom.AddExit(direction);

                String newDescription = Database.getDescriptionForRoom(currentRoom);

                if(newDescription != null){
                    currentRoom.setDescription(newDescription);
                }
            }
        }


       }






        //TextBuffer.Reset();
    }


