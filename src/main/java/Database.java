

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


    public static ArrayList<LockedDoor> loadExits(String roomN){

        try {
            connect();

            String allLocksSql = "SELECT * FROM LockedDoors WHERE RoomName LIKE ?";


            //Statement statement = conn.createStatement();


            PreparedStatement lockQuery = conn.prepareStatement(allLocksSql);


            lockQuery.setString(1, roomN);

            System.out.println(lockQuery.toString());


            ResultSet allLocksRS = lockQuery.executeQuery();

            ArrayList<LockedDoor> locks = new ArrayList<LockedDoor>();

            while(allLocksRS.next()){
                String roomName = allLocksRS.getString("RoomName");
                String lockedDirection = allLocksRS.getString("LockedDirection");
                String itemNeeded = allLocksRS.getString("ItemNeeded");

                LockedDoor lockedDoor = new LockedDoor(roomName,lockedDirection,itemNeeded);

                boolean north = allLocksRS.getBoolean("north");
                boolean south = allLocksRS.getBoolean("south");
                boolean east = allLocksRS.getBoolean("east");
                boolean west = allLocksRS.getBoolean("west");

                if (north) {
                    lockedDoor.AddExitNewRoom(Direction.North);
                }
                if (south) {
                    lockedDoor.AddExitNewRoom(Direction.South);
                }
                if (east) {
                    lockedDoor.AddExitNewRoom(Direction.East);
                }
                if (west) {
                    lockedDoor.AddExitNewRoom(Direction.West);
                }

                locks.add(lockedDoor);
            }


            disconnect();

            return locks;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }


    public static Room unlockedRoom(String roomN){

        try{

            connect();

            String unlockSql = "SELECT * FROM ChangedRooms WHERE variant LIKE ?" +
                    "AND east = ?" +
                    "AND west = ?" +
                    "AND north = ?" +
                    "AND south = ?";

            PreparedStatement unlockQuery = conn.prepareStatement(unlockSql);

            ArrayList<Room> changedRooms = Database.loadChangedRooms();

           ArrayList<LockedDoor> locks = Database.loadExits(Player.GetCurrentRoom().getTitle());

            unlockQuery.setString(1, roomN);
            ResultSet unlockRS = unlockQuery.executeQuery();

            for(Room unlockRoom : changedRooms) {

                for(LockedDoor lock : locks) {

                    if (unlockRoom.CanExit(Direction.East) == (lock.CanExitNewRoom(Direction.East))) {
                        unlockQuery.setInt(2, 1);
                    } else unlockQuery.setInt(2, 0);
                    if (unlockRoom.CanExit(Direction.West) == (lock.CanExitNewRoom(Direction.West))) {
                        unlockQuery.setInt(3, 1);
                    } else unlockQuery.setInt(3, 0);
                    if (unlockRoom.CanExit(Direction.North) == (lock.CanExitNewRoom(Direction.North))) {
                        unlockQuery.setInt(4, 1);
                    } else unlockQuery.setInt(4, 0);
                    if (unlockRoom.CanExit(Direction.South) == (lock.CanExitNewRoom(Direction.South))) {
                        unlockQuery.setInt(5, 1);
                    } else unlockQuery.setInt(5, 0);
                }

                while(unlockRS.next()){

                    String variant = unlockRS.getString("variant");
                    String title = unlockRS.getString("title");
                    String description = unlockRS.getString("description");

                    int x = unlockRS.getInt("x");
                    int y = unlockRS.getInt("y");

                    Room unlockingRoom = new Room(title, description, x, y, variant);

                    boolean north = unlockRS.getBoolean("north");
                    boolean south = unlockRS.getBoolean("south");
                    boolean east = unlockRS.getBoolean("east");
                    boolean west = unlockRS.getBoolean("west");

                    if (north) {
                        unlockingRoom.AddExit(Direction.North);
                    }
                    if (south) {
                        unlockingRoom.AddExit(Direction.South);
                    }
                    if (east) {
                        unlockingRoom.AddExit(Direction.East);
                    }
                    if (west) {
                        unlockingRoom.AddExit(Direction.West);
                    }

                    unlockingRoom.setX(x);
                    unlockingRoom.setY(y);

                    changedRooms.add(unlockingRoom);

                    return unlockRoom;
                }

            }








            disconnect();


        }catch (SQLException uRsql){
            uRsql.printStackTrace();
        }

return null;
    }







}
