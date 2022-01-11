public class HotelReservation extends Reservation {
    // private HotelReservation attributes
    private Hotel hotel;
    private String roomType;
    private int numberNights;
    private int nightCost;

    // constructor that takes initializes HotelReservation attributes to inputs
    public HotelReservation(String clientName, Hotel hotel, String roomType, int numberNights) {

        // call superclass constructor using input clientName
        super(clientName);

        // set private fields to input fields
        this.hotel = hotel;
        this.roomType = roomType;
        this.numberNights = numberNights;

        // method that reserves room at correct hotel
        // argument will be thrown from reserveRoom method in Hotel class if no such room is available
        this.nightCost = this.hotel.reserveRoom(roomType);

    }

    // get method for number of nights at Hotel
    public int getNumOfNights() {
        return this.numberNights;
    }

    // get method for cost of staying at Hotel
    public int getCost() {
        // multiply the cost of the Room type at the Hotel by the number of nights in the Room
        int totalCost = this.numberNights * this.nightCost;
        return totalCost;
    }

    // check that input Object is of same type & has same fields as this. HotelReservation
    public boolean equals(Object o) {

        // initialize as false
        boolean same = false;

        if (o instanceof HotelReservation) {
            if (this.reservationName().equals(((HotelReservation) o).reservationName())) {
                if (this.hotel.equals(((HotelReservation) o).hotel)) {
                    if (this.roomType.equals(((HotelReservation) o).roomType)) {
                        if (this.numberNights == ((HotelReservation) o).numberNights) {
                            if (this.numberNights * this.nightCost == ((HotelReservation) o).numberNights * (((HotelReservation) o).nightCost)) {
                                // change to true once everything has been confirmed the same
                                same = true;
                            }
                        }
                    }
                }
            }
        }
        // return result
        return same;
    }
}
