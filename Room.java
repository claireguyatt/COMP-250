public class Room {
    // private String for the Room's type, int for Room's price (in cents), and boolean for Room's availability status
    private String roomType;
    private int roomPrice;
    private boolean roomAvailability;

    // constructor that creates a Room using a type of room as input
    public Room(String roomType) {

        // ensure the input is a proper room type
        if ((roomType.equals("double") || roomType.equals("queen") || roomType.equals("king")) == false) {
            throw new IllegalArgumentException("No such room type can be created.");
        }
        // initialize roomType to input String
        this.roomType = roomType;

        // initialize roomPrice in cents, based off roomType

        if (this.roomType.equals("double")) {
            this.roomPrice = 90 * 100;
        } else if (this.roomType.equals("queen")) {
            this.roomPrice = 110 * 100;
        } else if (this.roomType.equals("king")) {
            this.roomPrice = 150 * 100;
        }

        // set roomAvailability to true
        this.roomAvailability = true;
    }

    // constructor that takes a Room as input and makes a copy of the room
    public Room(Room r) {

        this.roomType = r.roomType;
        this.roomPrice = r.roomPrice;
        this.roomAvailability = r.roomAvailability;
    }

    // get method for Room's type
    public String getType() {
        return this.roomType;
    }

    // get method for Room's price
    public int getPrice() {
        return this.roomPrice;
    }

    // method that changes Room's availability
    public void changeAvailability() {
        if (this.roomAvailability == false) {
            this.roomAvailability = true;
        } else {
            this.roomAvailability = false;
        }
    }

    // method that takes an array of Rooms and a Room type an returns the first available Room in the array that matches the type
    public static Room findAvailableRoom(Room[] arrRoom, String type) {

        Room available;
        for (int i = 0; i < arrRoom.length; i++) {
            if ((arrRoom[i].getType()).equals(type)) {
                if (arrRoom[i].roomAvailability == true) {
                    return arrRoom[i];
                }
            }
        }
        // returns null if no such room is available
        return null;
    }

    // method that takes an array of Rooms and a Room type and changes the first unavailable Room in the array
    // that matches the type to available
    public static boolean makeRoomAvailable(Room[] arrRoom, String type) {
        // find unavailable Room that matches input type
        for (int i = 0; i < arrRoom.length; i++) {
            if ((arrRoom[i].getType()).equals(type)) {
                if (arrRoom[i].roomAvailability == false) {
                    // change Room's availability
                    arrRoom[i].roomAvailability = true;
                    return true;
                }
            }
        }
        // return false if no such room was available to be changed
        return false;
    }
}
