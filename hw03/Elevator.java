package hw03;

/**
 * This hw03.Elevator class implements data about the status of the elevator.
 *
 *
 * @author Daniel Chong
 * email: daniel.chong@stonybrook.edu
 * Stony Brook ID: 115715024
 */
public class Elevator {
    private int currentFloor;
    private static final int IDLE = 0;
    private static final int TO_SOURCE = 1;
    private static final int TO_DESTINATION = 2;
    private int elevatorState;
    Request request;
    /**
     * Default constructor for the object hw03.Elevator
     */
    public Elevator() {
        request = null;
        elevatorState = IDLE;
        currentFloor = 1;
    }

    /**
     * Getter method for the member variable currentFloor
     * @return
     * int value representing currentFloor
     */
    public int getCurrentFloor() {
        return currentFloor;
    }

    /**
     * Setter method for the member variable currentFloor
     * @param currentFloor
     * int value the floor the elevator to be set to
     */
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
    /**
     * Getter method for the member variable elevatorState
     * @return
     * int value representing elevatorState
     */
    public int getElevatorState() {
        return elevatorState;
    }

    /**
     * Setter method for the member variable elevatorState
     * @param elevatorState
     * int value to be set to.
     */
    public void setElevatorState(int elevatorState) {
        this.elevatorState = elevatorState;
    }

    /**
     * Getter method for the member variable request
     * @return
     * hw03.Request object stored in the member variable request of this hw03.Elevator object.
     */
    public Request getRequest() {
        return request;
    }
    /**
     * Setter method for the member variable request
     * @param request
     * hw03.Request object for request member variable to be set to.
     */
    public void setRequest(Request request) {
        this.request = request;
    }
}
