public class Customer {
    // private Customer attributes
    private String customerName;
    private int customerBalance;
    private Basket plannedReservations;

    // constructor that initializes name & balance fields as inputs, and creates a new empty Basket
    public Customer(String customerName, int customerBalance) {

        this.customerName = customerName;
        this.customerBalance = customerBalance;
        this.plannedReservations = new Basket();

    }
    // get methods for Customer's name & balance
    public String getName() {
        return this.customerName;
    }
    public int getBalance() {
        return this.customerBalance;
    }

    // get method that returns the reference to the customer's Basket
    public Basket getBasket() {
        return this.plannedReservations;
    }

    // method that adds input int to Customer customerBalance;
    public int addFunds(int n) {
        // throws exception if input int is a negative number
        if (n<0) {
            throw new IllegalArgumentException("Can only add a positive amount to Customer's balance.");
        }
        this.customerBalance = this.customerBalance + n;
        return this.customerBalance;
    }

    // method that adds input Reservation to Customer's Basket
    public int addToBasket(Reservation r) {
        // initialize Customer's number of reservations to 0
        int numReservations = 0;
        // if name on input Reservation matches client's name, add input Reservation to customer's Basket
        if (this.customerName.equals(r.reservationName())) {
            numReservations = this.plannedReservations.add(r);
        }
        // if name doesn't match, throw exception
        else {
            throw new IllegalArgumentException("Client name does not match Reservation name");
        }
        // return Customer's total number of Reservations in their Basket
        return numReservations;
    }

    // method that creates new Reservation at a hotel or BnB and adds it to the Customer's Basket
    public int addToBasket(Hotel h, String rt, int n, boolean b) {

        // initialize number of Customer's Reservations to 0
        int numReservations = 0;
        // if Customer does not want breakfast included, make normal Hotel Reservation and add to Customer's Basket
        if (b = false) {
            HotelReservation r = new HotelReservation(this.customerName, h, rt, n);
            numReservations = plannedReservations.add(r);
        }
        // if Customer does want breakfast included, make BnB Reservation and add to Customer's Basket
        if (b = true) {
            BnBReservation r = new BnBReservation(this.customerName, h, rt, n);
            numReservations = plannedReservations.add(r);
        }
        // return total number of Customer's Reservations
        return numReservations;
    }

    // method that takes 2 input Airports and uses to create new Flight Reservation
    // and adds it to the Customer's Basket
    public int addToBasket(Airport a, Airport b) {

        // create Flight Reservation and add to Basket
        try {
            FlightReservation fl = new FlightReservation(this.customerName, a, b);
            plannedReservations.add(fl);
        }
        // if input Airports were the same Airport, catch Exception
        catch (IllegalArgumentException e) {
            System.out.println("Must input different airports to make flight reservation.");
        }
        // return number of Reservations in Customer's Basket
        return plannedReservations.getNumOfReservations();
    }
    // method that removes input Reservation from Customer's Basket
    public boolean removeFromBasket(Reservation r) {

        // remove input Reservation from customer's Basket
        boolean removed = plannedReservations.remove(r);
        // return if operation was successful (Reservation removed) or not
        return removed;
    }

    // method that checks out Customer with all their Reservations
    public int checkOut() {
        // ensures customer has enough money to pay for Reservations
        if (this.customerBalance < plannedReservations.getTotalCost()) {
            // throws exception if Customer does not have enough money to pay for their Reservations
            throw new IllegalStateException("Insufficient funds to check out.");
        }
        // if Customer has enough money, deducts cost of Reservations from Customer's balance
        // and clears Customer's Reservations
        else {
            this.customerBalance = this.customerBalance - this.plannedReservations.getTotalCost();
            this.plannedReservations.clear();
        }
        // returns Customer's updated balance
        return this.customerBalance;
    }
}
