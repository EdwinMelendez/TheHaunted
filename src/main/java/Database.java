

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


public class Database {

    static Connection conn;

    public static void connect() {
//        Connection conn = null;
        try {
            // db parameters


            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            String url = "jdbc:sqlite:ColorsGame.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);


            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
//        } finally {
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
        }
    }

//    public static void main(String[] args) {
//
//
//        connect();
//    }

    public static ArrayList<Room> loadRooms() {

        try {
            connect();

            String allRoomsSql = "SELECT * FROM Rooms";
            Statement statement = conn.createStatement();

            ResultSet allRoomsRS = statement.executeQuery(allRoomsSql);

            ArrayList<Room> rooms = new ArrayList<Room>();

            while (allRoomsRS.next()) {

                String title = allRoomsRS.getString("title");
                String description = allRoomsRS.getString("description");
                String variant = allRoomsRS.getString("variant");

                int x = allRoomsRS.getInt("x");
                int y = allRoomsRS.getInt("y");


                Room room = new Room(title, description, x, y, variant);

                boolean north = allRoomsRS.getBoolean("north");
                boolean south = allRoomsRS.getBoolean("south");
                boolean east = allRoomsRS.getBoolean("east");
                boolean west = allRoomsRS.getBoolean("west");

                if (north) {
                    room.AddExit(Direction.North);
                }
                if (south) {
                    room.AddExit(Direction.South);
                }
                if (east) {
                    room.AddExit(Direction.East);
                }
                if (west) {
                    room.AddExit(Direction.West);
                }

                room.setX(x);
                room.setY(y);

                rooms.add(room);

            }

            disconnect();

            return rooms;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static void disconnect() {

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<Item> loadItems() {

        try {
            connect();

            String allItemsSql = "SELECT * FROM Items";
            Statement statement = conn.createStatement();

            ResultSet allItemsRS = statement.executeQuery(allItemsSql);

            ArrayList<Item> items = new ArrayList<Item>();

            while (allItemsRS.next()) {

                String title = allItemsRS.getString("title");
                String pickuptxt = allItemsRS.getString("description");
                Integer weight = allItemsRS.getInt("weight");
                String room = allItemsRS.getString("room");

                Item item = new Item(title, pickuptxt, weight, room);

                items.add(item);

            }

            disconnect();

            return items;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static ArrayList<Room> loadChangedRooms() {

        try {
            connect();


            String allChangedRoomsSql = "SELECT * FROM ChangedRooms";
            Statement statement = conn.createStatement();

            ResultSet allChangedRoomsRS = statement.executeQuery(allChangedRoomsSql);

            ArrayList<Room> changeRooms = new ArrayList<Room>();

            while (allChangedRoomsRS.next()) {

                String variant = allChangedRoomsRS.getString("variant");
                String title = allChangedRoomsRS.getString("title");
                String description = allChangedRoomsRS.getString("description");



                int x = allChangedRoomsRS.getInt("x");
                int y = allChangedRoomsRS.getInt("y");


                Room changedRoom = new Room(title, description, x, y, variant);

                boolean north = allChangedRoomsRS.getBoolean("north");
                boolean south = allChangedRoomsRS.getBoolean("south");
                boolean east = allChangedRoomsRS.getBoolean("east");
                boolean west = allChangedRoomsRS.getBoolean("west");

                if (north) {
                    changedRoom.AddExit(Direction.North);
                }
                if (south) {
                    changedRoom.AddExit(Direction.South);
                }
                if (east) {
                    changedRoom.AddExit(Direction.East);
                }
                if (west) {
                    changedRoom.AddExit(Direction.West);
                }

                changedRoom.setX(x);
                changedRoom.setY(y);

                changeRooms.add(changedRoom);

            }

            disconnect();

            return changeRooms;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static HashMap<String, String>loadLockedDoors(String roomN){

        try {
            connect();

            String allLocksSql = "SELECT * FROM LockedDoors WHERE RoomName LIKE ?";


            PreparedStatement lockQuery = conn.prepareStatement(allLocksSql);


            lockQuery.setString(1, roomN);

            System.out.println(lockQuery.toString());


            ResultSet allLocksRS = lockQuery.executeQuery();

           HashMap<String, String> locksAndTheirItems = new HashMap<String, String>();

           while(allLocksRS.next()){
               String direction = allLocksRS.getString("LockedDirection");
               String item = allLocksRS.getString("ItemNeeded");

               locksAndTheirItems.put(direction, item);
           }

           disconnect();

           return locksAndTheirItems;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }


    public static String  getDescriptionForRoom(Room room){

        try{

            connect();

            String descriptionFinder = "SELECT * FROM ChangedRooms WHERE variant LIKE ?" +
                    "AND east = ?" +
                    "AND west = ?" +
                    "AND north = ?" +
                    "AND south = ?";

            PreparedStatement getDescription = conn.prepareStatement(descriptionFinder);

            getDescription.setString(1, room.getTitle());



           ArrayList<String> exits = room.getExits();



            getDescription.setBoolean(2, exits.contains(Direction.East));
            getDescription.setBoolean(3, exits.contains(Direction.West));
            getDescription.setBoolean(4, exits.contains(Direction.North));
            getDescription.setBoolean(5, exits.contains(Direction.South));

            ResultSet resultSet = getDescription.executeQuery();

            boolean hasNewDescription = resultSet.next();

            String description = null;

            if(hasNewDescription){
                description = resultSet.getString("description");
            }

            disconnect();

            return description;


        }catch (SQLException uRsql){
            uRsql.printStackTrace();
        }

return null;
    }







}
