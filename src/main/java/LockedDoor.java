/**
 * Created by DarthVader on 4/26/17.
 */
public class LockedDoor {

    private String roomName;
    private String lockedDirection;
    private String itemNeeded;

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

    @Override
    public String toString() {
        return "LockedDoor{" +
                "roomName='" + roomName + '\'' +
                ", lockedDirection='" + lockedDirection + '\'' +
                ", itemNeeded='" + itemNeeded + '\'' +
                '}';
    }
}
