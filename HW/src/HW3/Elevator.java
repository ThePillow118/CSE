/**
 * @author
 *    Joseph Winicki SBU ID: 110505644
 * Assignment:
 *    Homework #3 for CSE 214, Summer 2018
 * Date:
 *    July 25th, 2018
 */

/**
 *
 */
public class Elevator {
    private int currentFloor, elevatorState;
    private final int IDLE = -1,TO_SOURCE = -2,TO_DESTINATION = -3;
    Request request;

    /**
     *Constructs and instance of Elevator
     *
     * Postconditions: The current floor of the elvator is set to 1, the elevator is in the IDLE state, and it does
     * not have any request to be handled
     */
    public Elevator() {
        currentFloor = 1;
        elevatorState = IDLE;
        request = null;
    }

    /**
     * Gets the request to be handled by this elevator
     * @return
     * Returns the request object being handled by this Elevator
     */
    public Request getRequest() {
        return request;
    }

    /**
     * Changes the request to be handled by this Elevator
     * @param request - the request that will be handled by this Elevator
     */
    public void setRequest(Request request) {
        this.request = request;
    }

    /**
     * Gets the current floor this Elevator is on
     * @return
     * Returns the floor number that this elevator is on
     */
    public int getCurrentFloor() {

        return currentFloor;
    }

    /**
     * Changes the current floor this elevator is on
     * @param currentFloor - the floor this elevator is going to next
     */
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    /**
     * Gets the current state of the elevator
     * @return
     * Returns whether the elevator is idle, going to a destination with a request, or going to the source of a
     * request
     */
    public int getElevatorState() {
        return elevatorState;
    }

    /**
     * Changes the state of the elevator to idle, to source, or
     * @param elevatorState
     */
    public void setElevatorState(int elevatorState) {
        this.elevatorState = elevatorState;
    }

    /**
     * Gives the string representation of the Elevators values: state, current floor, destination floor, and
     * request information
     * @return
     * Returns a string representation of the Elevators values: state, current floor, destination floor, and
     * request information
     */
    @Override
    public String toString(){
        String state = "IDLE";
        if(elevatorState == TO_SOURCE)
            state = "TO_SOURCE";
        else if(elevatorState == TO_DESTINATION)
            state = "TO_DEST";
        String requestString;
        if(request == null)
            requestString = "------";
        else
            requestString = request.toString();
        String answer = "[FLOOR: " + currentFloor + ", " + state + ", " + requestString + "]" ;
        return answer;
    }
}
