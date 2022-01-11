public class Basket {
    // private Basket attribute
    private Reservation[] reservations;

    // constructor that initializes reservations field as an empty Reservation Array
    public Basket() {
        this.reservations = new Reservation[]{};
    }
    // method that makes and returns a shallow copy of Customer's Reservations
    public Reservation[] getProducts() {

        // initialize reservations array copy
        Reservation[] reservationCopy = new Reservation[reservations.length];
        // make shallow copy of reservations array
        for (int i = 0; i < reservations.length; i++) {
            reservationCopy[i] = this.reservations[i];
        }
        // return copy
        return reservationCopy;
    }

    // add an input Reservation to the Basket of Reservations
    public int add(Reservation r) {

        // determine current length
        int resLength = this.reservations.length;
        // make a copy of the reservations array
        Reservation[] copy = getProducts();
        // increase length of reservations array by 1
        this.reservations = new Reservation[resLength + 1];
        // re-add all previous reservations
        for (int i = 0; i < copy.length; i++) {
            this.reservations[i] = copy[i];
        }
        // add new Reservation
        this.reservations[reservations.length-1] = r;
        // return updated reservations array length
        return this.reservations.length;
    }
    // method that removes input Reservation from Customer's Basket
    public boolean remove(Reservation r) {

        // if the input Reservation does not exist in the reservations array, return false
        boolean exists = false;
        int index = 0;
        for (int i = 0; i < this.reservations.length; i++) {
            // change boolean exists to true once input Reservation is found, then exit loop
            if (this.reservations[i].equals(r)) {
                // make note of where Reservation to be removed is in the array
                index = i;
                exists = true;
                break;
            }
        }
        // if the input Reservation was not found, return false
        if (exists == false) {
            return false;
        }

        // determine current reservations array length
        int resLength = this.reservations.length;
        // make a copy of the reservations array
        Reservation[] copy = getProducts();
        // decrease length of reservations array by 1
        this.reservations = new Reservation[resLength - 1];
        // remove input Reservation from copy array (replace with null)
        copy[index] = null;
        // re-add all remaining reservations to Reservation array of correct length
        // until loop gets to index of Reservation to be removed
        for (int i = 0; i < index; i++) {
            // add each Reservation in the same order
                this.reservations[i] = copy[i];
            }
        // skip over Reservation to be removed, and continue adding rest of Reservations
        for (int i = index; i < reservations.length; i++) {
            this.reservations[i] = copy[i+1];
        }
        // return true once operation is complete
        return true;
    }

    // method that empties reservations array
    public void clear() {
        this.reservations = new Reservation[]{};
    }

    // method that returns number of Reservations in Basket (length of reservations array)
    public int getNumOfReservations() {
        return this.reservations.length;
    }

    // method that adds up all the costs of all the Reservations and returns the number
    public int getTotalCost() {
        int totalCost = 0;
        for (int i = 0; i < this.reservations.length; i++) {
            totalCost = totalCost + this.reservations[i].getCost();
        }
        return totalCost;
    }
}
