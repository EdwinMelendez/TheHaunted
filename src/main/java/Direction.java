public abstract class Direction {

    //directions class
    public static final String North = "north";
    public static final String South = "south";
    public static final String East = "east";
    public static final String West = "west";

    public  String getNorth() {
        return North;
    }

    public  String getSouth() {
        return South;
    }

    public  String getEast() {
        return East;
    }

    public  String getWest() {
        return West;
    }

    public static Boolean IsValidDirection(String direction){
       return true;
   }

}
