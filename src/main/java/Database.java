

import java.sql.*;
import java.util.ArrayList;


public class Database {

    static Connection conn;

    public static void connect() {
//        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:Level.db";
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

            String allRoomsSql = "SELECT * FROM rooms";
            Statement statement = conn.createStatement();

            ResultSet allRoomsRS = statement.executeQuery(allRoomsSql);

            ArrayList<Room> rooms = new ArrayList<>();

            while (allRoomsRS.next()) {

                String title = allRoomsRS.getString("title");
                String description = allRoomsRS.getString("description");

                int x = allRoomsRS.getInt("x");
                int y = allRoomsRS.getInt("y");

                Room room = new Room(title, description, x , y);

                boolean north = allRoomsRS.getBoolean("N");
                boolean south = allRoomsRS.getBoolean("S");
                boolean east = allRoomsRS.getBoolean("E");
                boolean west = allRoomsRS.getBoolean("W");

                if (north) { room.AddExit(Direction.North); }
                if (south) { room.AddExit(Direction.South); }
                if (east) { room.AddExit(Direction.East); }
                if (west) { room.AddExit(Direction.West); }


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

        // TODO

        return null;
    }
}
