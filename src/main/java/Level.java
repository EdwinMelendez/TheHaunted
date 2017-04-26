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

    private static void BuildLevel() throws NullPointerException{
        //initialize start position
        Player.setPosX(0);
        Player.setPosY(0);

        ArrayList<Room> databaseRooms = Database.loadRooms();
        ArrayList<Item> databaseItems = Database.loadItems();
//        databaseRooms = Database.loadRooms();
//        databaseItems = Database.loadItems();

        for (Item item : databaseItems) {

            for (Room room : databaseRooms) {

                if (room.getTitle().equals(item.getRoom())) {
                    room.addItem(item);
                }
            }
        }

        // Add rooms to correct place in 2D array

        rooms = new Room[3][4];     // TODO figure out actual size of level and use that to create 2d array

        for (Room room : databaseRooms) {

            int x = room.getX();
            int y = room.getY();

            rooms[x][y] = room;

        }




//        //List of room names and items
//        rooms = new Room[3][2];
//        Room grandFoyer;
//        Room diningHall;
//        Room armourRoom;
//        Room kitchen;
//        Room musicRoom;
//        Room grandLibrary;
//        Room masterBedroom;
//        Room childsRoom;
//        Room ritualCellar;
//        Room grandTheater;
//        Room wineCellar;
//        Room Coffin;
//
//        Item chalice;
//        Item kitchenKey;
//        Item smallKey;
//        Item garlic;
//        Item musicBox;
//        Item cagedCat;
//        Item cagedMouse;
//        Item woodenStake;
//        Item ritualWine;
//        Item butcherKey;
//
//
//        ////////////////////////////Grand Foyer[0,0]/////////////////////////////////
//
//        //create new rooms
//        grandFoyer = new Room();
//        rooms[0][0] = grandFoyer;
//
//        //setup room
//        TextBuffer.Reset();
//        grandFoyer.setTitle("Grand Foyer");
//        grandFoyer.setDescription("You find yourself in the Grand Foyer. There is a dank stench looming and the only light in the room " +
//                "is coming from the cracks in the boarded windows." +
//                "There is an ornate Golden Chalice " +
//                "sitting on a lone Pedestal; curiously untarnished. You spot a Key lying beside the chalice with a note attached. " +
//                "There are a set of winding wooden stairs to your SOUTH, and a wooden door to your EAST.");
//        grandFoyer.AddExit(Direction.East);
//        grandFoyer.AddExit(Direction.South);
//        //create item
//        chalice = new Item("Golden Chalice", "The chalice seemed to hum slightly when you pick it up.", 1);
//        kitchenKey = new Item("Kitchen Key", "The note attached reads: 'Be wary of your thirst for knowledge'... " +
//                "It seems heavily used.", 1);
//
//        //add item to room
//        grandFoyer.getItems().add(chalice);
//        grandFoyer.getItems().add(kitchenKey);
//











    }
}
