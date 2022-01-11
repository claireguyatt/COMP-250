public class Airport {
    // private ints for x & y coordinates of Airport in kilometres
    private int xCoo;
    private int yCoo;
    // private int for Airport fees in cents
    private int fees;

    // constructor that initializes all private fields with input ints
    public Airport(int xCoo, int yCoo, int fees) {

        this.xCoo = xCoo;
        this.yCoo = yCoo;
        this.fees = fees;
    }

    // get method for fees;
    public int getFees() {
        return this.fees;
    }

    // method that takes 2 Airports as input and returns the distance between them
    public static int getDistance(Airport a, Airport b) {

        // plug in numbers to distance formula
        double xVal = Math.pow((b.xCoo - a.xCoo),2);
        double yVal = Math.pow((b.yCoo - a.yCoo),2);
        double distance = Math.sqrt(xVal + yVal);

        // round to nearest higher integer and convert to an int
        int distanceFinal = (int) (Math.ceil(distance));

        //return distance
        return distanceFinal;
    }
}
