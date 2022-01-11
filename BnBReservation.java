public class BnBReservation extends HotelReservation {

    // constructor that creates a new Hotel reservation using its superclass constructor
    public BnBReservation(String clientName, Hotel hotel, String roomType, int numberNights) {
        super(clientName, hotel, roomType, numberNights);
    }

    // method that calculates and returns cost of Hotel + breakfast fee
    public int getCost() {

        // get cost of breakfast by multiplying 10$ * number of nights in the Hotel * 100 to convert amount to cents
        int breakfastCost = getNumOfNights() * 10 * 100;

        // return total cost (basic cost of Hotel reservation plus extra breakfast cost)
        return (super.getCost() + breakfastCost);
    }
}
