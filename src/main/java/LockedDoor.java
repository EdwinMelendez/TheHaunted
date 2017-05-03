import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

/**
 * Created by DarthVader on 4/26/17.
 */
public class LockedDoor {

    private String roomName;
    private String lockedDirection;
    private String itemNeeded;

    private ArrayList<String> newExits;

    public ArrayList<String> getNewExits() {
        return newExits;
    }

    public void setNewExits(ArrayList<String> newExits) {
        this.newExits = newExits;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getLockedDirection() {
        return lockedDirection;
    }

    public void setLockedDirection(String lockedDirection) {
        this.lockedDirection = lockedDirection;
    }

    public String getItemNeeded() {
        return itemNeeded;
    }

    public void setItemNeeded(String itemNeeded) {
        this.itemNeeded = itemNeeded;
    }

    public LockedDoor(String roomName, String lockedDirection, String itemNeeded) {
        this.roomName = roomName;
        this.lockedDirection = lockedDirection;
        this.itemNeeded = itemNeeded;
    }

    public LockedDoor(){
        newExits = new ArrayList<String>();
    }

    public Boolean CanExitNewRoom(String direction) {

        return newExits.contains(direction);
    }

    public void AddExitNewRoom(String direction){

        if (this.newExits.indexOf(direction) == -1){
            //System.out.println(direction);
            this.newExits.add(direction);
        }

    }

    @Override
    public String toString() {
        return "LockedDoor{" +
                "roomName='" + roomName + '\'' +
                ", lockedDirection='" + lockedDirection + '\'' +
                ", itemNeeded='" + itemNeeded + '\'' +
                '}';
    }
}
