import java.util.ArrayList;

public class Level {

    //Level array lists made up of loaded database objects

    //Array list of room objects
    public static ArrayList<Room> databaseRooms = Database.loadRooms();

    //Array list of item objects
    private static ArrayList<Item> databaseItems = Database.loadItems();

    //2D array of rooms
    public static Room[][] rooms;

    public static Room[][] getRooms() {
        return rooms;
    }

    public static void setRooms(Room[][] rooms) {
        Level.rooms = rooms;
    }
    //getters and setters

    //runs method that builds the initial game
    public static void Initialize(){
        BuildLevel();
    }

    //builds initial game
    private static void BuildLevel() {

        //initialize start position
        Player.setPosX(1);
        Player.setPosY(0);

        //for item objects in array list of items
        for (Item item : databaseItems) {

            //for room objects in array list of rooms
            for (Room room : databaseRooms) {

                //if the room's title corresponds to the item's room title
                if (room.getTitle().equals(item.getRoom())) {

                    //adds the item to that room
                    room.addItem(item);
                }
            }
        }

        //Creates 2D room grid
        rooms = new Room[3][4];

        //for room objects in array list of rooms
        for (Room room : databaseRooms) {

            //gets x and y coordinates
            int x = room.getX();
            int y = room.getY();

            //assigns matching x and y coordinates to each room in 2D grid
            rooms[x][y] = room;

        }

    }
}
