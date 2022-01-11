public class Hotel {
    // private String for Hotel's name, private Room[] for Hotel's Rooms
    private String hotelName;
    private Room[] hotelRooms;

    // constructor that creates a Hotel using an input hotel name and array of Rooms
    public Hotel(String name, Room[] rooms) {
        this.hotelName = name;
        // make deep copy of Room array
        Room[] roomsCopy = new Room[rooms.length];
        for (int i = 0; i < rooms.length; i++) {
            roomsCopy[i] = new Room(rooms[i]);
        }
        this.hotelRooms = roomsCopy;
    }

    // method that takes a room type as input and returns the price of the first Room that matches the type in the Hotel's
    // array of Rooms
    public int reserveRoom(String roomType) {

        // find Room that matches input type
        Room foundRoom = Room.findAvailableRoom(this.hotelRooms, roomType);

        // throw an exception if there is no such room
        if (foundRoom == null) {
            throw new IllegalArgumentException("No such room available.");
        }
        // change availability of the room
        foundRoom.changeAvailability();
        // return the price of the room
        return foundRoom.getPrice();
    }

    // method that takes as input a type of Room and changes the availability of the first Room that matches the type in
    // the Hotel's array of Rooms to true
    public boolean cancelRoom(String cancelType) {

        if (Room.makeRoomAvailable(this.hotelRooms, cancelType) == true) {
            return true;
        }
        // returns false if no such Room is available to be changed
        return false;
    }
}
