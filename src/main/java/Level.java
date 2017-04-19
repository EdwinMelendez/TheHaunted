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

        ArrayList<Room> databaseRooms = Database.loadRooms();
        ArrayList<Item> databaseItems = Database.loadItems();


        for (Item item : databaseItems) {
            for (Room room : databaseRooms) {
                if (room.getTitle().equals(item.getTitle())) {
                    room.addItem(item);
                }
            }
        }

        // Add rooms to correct place in 2D array

        rooms = new Room[2][3];     // TODO figure out actual size of level and use that to create 2d array

        for (Room room : databaseRooms) {

            int x = room.getX();
            int y = room.getY();

            rooms[x][y] = room;

        }


        databaseRooms = Database.loadRooms();
        databaseItems = Database.loadItems();

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
//        ////////////////////////////Dining Hall[1,0]/////////////////////////////////
//
//        //create new rooms
//        diningHall = new Room();
//        rooms[1][0] = diningHall;
//
//        //setup room
//        TextBuffer.Reset();
//        diningHall.setTitle("Dining Hall");
//        diningHall.setDescription("You enter the Dining Hall. The long mahogany table is lined with flickering candles. " +
//                "There are two covered plates on the table. Upon lifting the covers you notice a small key on one plate and a small" +
//                "on the other which reads: 'Youth Forever'... \n" +
//                "There is a door to the WEST. There is a inscribed locked door to the EAST which reads: Speak my name.");
//
//        diningHall.AddExit(Direction.West);
//        //diningHall.AddExit(Direction.East);
//
//        //create item
//        smallKey = new Item("Small Key", "There is a tiny bird carved into the base of the key. ", 1);
//
//
//        //add item to room
//        diningHall.getItems().add(smallKey);
//
//
//
//        ////////////////////////////Armour Room[2,0]/////////////////////////////////
//
//        //create new rooms
//        armourRoom = new Room();
//        rooms[2][0] = armourRoom;
//
//        //setup room
//        TextBuffer.Reset();
//        armourRoom.setTitle("Armour Room");
//        armourRoom.setDescription("As the door creaks open you notice the entire room is lined with old knight armour." +
//                " There is a giant LOCKED armoire on the NORTH wall of the room ");
//        //armourRoom.AddExit(Direction.North);
//        armourRoom.AddExit(Direction.West);
//        //armourRoom.AddExit(Direction.East);
//        //create item
//
//
//        //add item to room
//
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
//
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
//
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








        //initialize start position
        Player.setPosX(0);
        Player.setPosY(0);

    }
}
