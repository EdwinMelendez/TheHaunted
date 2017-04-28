

import java.sql.*;
import java.util.ArrayList;


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
            String url = "jdbc:sqlite:Game.db";
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

                int x = allRoomsRS.getInt("x");
                int y = allRoomsRS.getInt("y");


                Room room = new Room(title, description, x, y);

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
                String pickuptxt = allItemsRS.getString("pickuptxt");
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

                String title = allChangedRoomsRS.getString("title");
                String description = allChangedRoomsRS.getString("description");

                int x = allChangedRoomsRS.getInt("x");
                int y = allChangedRoomsRS.getInt("y");


                Room changedRoom = new Room(title, description, x, y);

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


    public static ArrayList<LockedDoor> loadExits(String roomN){

        try {
            connect();

            String allLocksSql = "SELECT * FROM LockedDoors WHERE RoomName = ?";


            //Statement statement = conn.createStatement();


            PreparedStatement lockQuery = conn.prepareStatement(allLocksSql);


            lockQuery.setString(1, roomN);


            ResultSet allLocksRS = lockQuery.executeQuery(allLocksSql);

            ArrayList<LockedDoor> locks = new ArrayList<LockedDoor>();

            while(allLocksRS.next()){
                String roomName = allLocksRS.getString("RoomName");
                String lockedDirection = allLocksRS.getString("LockedDirection");
                String itemNeeded = allLocksRS.getNString("ItemNeeded");

                LockedDoor lockedDoor = new LockedDoor(roomName,lockedDirection,itemNeeded.split(","));

                locks.add(lockedDoor);
            }


            disconnect();

            return locks;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }


    public static ArrayList<Room> doorQuery(){

        try{
            connect();

            String query = "SELECT description, east, west, north, south, x, y " +
                    "FROM ChangedRooms WHERE variant = title IN Rooms AND " +
                    "LockedDirection IN LockedDoors LIKE newDirection IN ChangedRooms";
            PreparedStatement descriptionQuery = conn.prepareStatement(query);

            ResultSet doorRs = descriptionQuery.executeQuery(query);


            ArrayList<Room> newExit = new ArrayList<Room>();

            while (doorRs.next()){
                String variant = doorRs.getString("variant");
                String description = doorRs.getString("description");

                int x = doorRs.getInt("x");
                int y = doorRs.getInt("y");


                Room newDoor = new Room(variant, description, x, y);

                boolean north = doorRs.getBoolean("north");
                boolean south = doorRs.getBoolean("south");
                boolean east = doorRs.getBoolean("east");
                boolean west = doorRs.getBoolean("west");

                if (north) {
                    newDoor.AddExit(Direction.North);
                }
                if (south) {
                    newDoor.AddExit(Direction.South);
                }
                if (east) {
                    newDoor.AddExit(Direction.East);
                }
                if (west) {
                    newDoor.AddExit(Direction.West);
                }

                newDoor.setX(x);
                newDoor.setY(y);

                newExit.add(newDoor);
            }


            disconnect();

            return newExit;

        }catch (SQLException dq){
            dq.printStackTrace();
        }

return null;

    }

}
