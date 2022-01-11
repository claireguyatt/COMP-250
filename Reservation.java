abstract public class Reservation {
    // private field for name of client on Reservation
    private String clientName;

    // constructor that initializes client's name to input String
    public Reservation(String clientName) {
        this.clientName = clientName;
    }

    // get method for client name on Reservation
    public final String reservationName() {
        return this.clientName;
    }

    // abstract methods to get costs & compare Objects

    abstract public int getCost();

    abstract public boolean equals(Object o);

}
