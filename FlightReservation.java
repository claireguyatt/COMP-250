public class FlightReservation extends Reservation {
    // private Airports for arrival & destination places of the Flight Reservation
    private Airport departure;
    private Airport arrival;

    // constructor that initializes fields as inputs
    public FlightReservation(String clientName, Airport departure, Airport arrival) {

        // call superclass constructor using input clientName
        super(clientName);

        if (departure.equals(arrival)) {
            throw new IllegalArgumentException("Must input different airports to make flight reservation.");
        }
        // set Flight Reservation's departure and arrival Airports to input Airports
        this.departure = departure;
        this.arrival = arrival;
    }

    // method that calculates & returns the cost of the Flight Reservation
    public int getCost() {

        // multiple tax by 100 to get cost in cents
        double tax = 53.75 * 100;
        // add up fees from departure and arrival Airports
        double fees = this.departure.getFees() + this.arrival.getFees();
        // get # gallons fuel needed by dividing distance between Airports by kilometres per 1 gallon of fuel
        double fuelKm = ((double) Airport.getDistance(departure, arrival)) / 167.52;
        // multiply amount of gallons needed by cost of 1 gallon fuel then by 100 to get cost in cents
        double fuelCost = fuelKm * 1.24 * 100;
        // add all costs and round to nearest higher integer
        int totalCost = (int) Math.ceil(tax + fees + fuelCost);
        return totalCost;
    }

    // check that input Object is of same type & has same fields as this. FlightReservation
    public boolean equals(Object o) {

        // initialize as false
        boolean same = false;

        if (o instanceof FlightReservation) {
            if (this.reservationName().equals(((FlightReservation) o).reservationName())) {
                if (this.departure.equals(((FlightReservation) o).departure)) {
                    if (this.arrival.equals(((FlightReservation) o).arrival)) {
                        // change to true once everything has been confirmed the same
                        same = true;
                    }
                }
            }
        }
        // return result
        return same;
    }
}
