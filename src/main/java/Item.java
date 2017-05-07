public class Item {


    //Item class
    private String title;
    private String pickupText;
    private int weight = 1;
    private String room;

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPickupText() {
        return pickupText;
    }

    public void setPickupText(String pickupText) {
        this.pickupText = pickupText;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }//getters and setters

    public Item(String title, String pickupText, int weight, String room) {
        this.title = title;
        this.pickupText = pickupText;
        this.weight = weight;
        this.room = room;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", pickupText='" + pickupText + '\'' +
                ", weight=" + weight +
                '}';
    }
}
