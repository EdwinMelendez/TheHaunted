import java.util.HashMap;


public class GameManager {



    public static void ShowTitleScreen(){
        System.out.println("Welcome to The Haunted");
    }

    //describes the players current position, this method is run once at the beggining of the game
    public static void StartGame(){
        Player.GetCurrentRoom().Describe();
    }

    //ends game when you type 'exit'
    public static void EndGame(){
        Program.quit = true;
        System.out.println("Exiting Game...");
        System.exit(0);
    }

    //Apply rules method
    public static void ApplyRules() {

        //loads hash map of locked doors and the items needed to unlock those doors
        HashMap<String, String> lockedDoorsAndItemsNeededToUnlock = Database.loadLockedDoors(Player.GetCurrentRoom().getTitle());

        //room variable holding player's current position
        Room currentRoom = Player.GetCurrentRoom();

        //for each string direction in hash map key set
        for (String direction : lockedDoorsAndItemsNeededToUnlock.keySet()){

            //string variable holding item required for the direction they unlock
            String itemRequired = lockedDoorsAndItemsNeededToUnlock.get(direction);

            //if the current room the player is standing in is holding item required
            if(Player.GetCurrentRoom().doesContain(itemRequired)){

                //add's exit direction for the item dropped in that room
                currentRoom.AddExit(direction);

                //string variable holding the changed room description
                String newDescription = Database.getDescriptionForRoom(currentRoom);

                //if the new description is not null
                if(newDescription != null){

                    //sets the current room description with the new changed room description
                    currentRoom.setDescription(newDescription);
                }
            }
        }
    }
}


