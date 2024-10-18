package hw03;

/**
 * This hw03.Request class implements data about the request of an elevator user, including where they are getting on and off, as well as when the request was made
 *
 *
 * @author Daniel Chong
 * email: daniel.chong@stonybrook.edu
 * Stony Brook ID: 115715024
 */
public class Request {
    private int sourceFloor;
    private int destinationFloor;
    private int timeEntered;
    // (int - the time that this request was placed on the queue)
    /**
     * A constructor that takes as a parameter the number of floors in the building
     * @param numberOfFloors
     * int value that represents number of floors in the building
     */
    public Request(int numberOfFloors) {
        sourceFloor = (int)(Math.random()*numberOfFloors);
        destinationFloor = (int)(Math.random()*numberOfFloors);
    }
    /**
     * Getter method for member variable sourceFloor
     * @return
     * int value that represents what the source floor is
     */
    public int getSourceFloor() {
        return sourceFloor;
    }
    /**
     * Setter method for member variable sourceFloor
     * @param sourceFloor
     * int value to be set to
     */
    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }
    /**
     * Getter method for member variable destinationFloor
     * @return
     * int value that represents what the destination floor is
     */
    public int getDestinationFloor() {
        return destinationFloor;
    }
    /**
     * Setter method for member variable destinationFloor
     * @param destinationFloor
     * int value to be set to
     */
    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }
    /**
     * Getter method for member variable timeEntered
     * @return
     * int value that represents what the timeEntered variable is
     */
    public int getTimeEntered() {
        return timeEntered;
    }
    /**
     * Setter method for member variable timeEntered
     * @param timeEntered
     * int value to be set to
     */
    public void setTimeEntered(int timeEntered) {
        this.timeEntered = timeEntered;
    }
}
