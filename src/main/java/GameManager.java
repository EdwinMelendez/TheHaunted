import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by DarthVader on 3/22/17.
 */
public class GameManager {


    public static void ShowTitleScreen(){
        System.out.println("Welcome to The Haunted");
    }


    public static void StartGame(){

        Player.GetCurrentRoom().Describe();

    }

    public static void EndGame(){

        Program.quit = true;
        System.out.println("Exiting Game...");
        System.exit(0);
    }

    public static void ApplyRules() throws NullPointerException{

        ArrayList<Room> databaseRooms = Database.loadRooms();
       ArrayList<Item> databaseItems = Database.loadItems();
       ArrayList<Room> databaseChangedRooms = Database.loadChangedRooms();
        ArrayList<LockedDoor>  databaseLocks = Database.loadExits(Player.GetCurrentRoom().getTitle());


        for (LockedDoor lock : databaseLocks){

            for (String itemRequired : lock.getItemNeeded()){

                for ( Item itemsInRoom : Player.GetCurrentRoom().getItems() ) {

                    if (itemRequired.equalsIgnoreCase(itemsInRoom.getTitle())){


                    }



                }

            }
        }






        //TextBuffer.Reset();
    }

}
