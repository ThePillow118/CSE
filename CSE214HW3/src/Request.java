/**
 * @author
 *    Joseph Winicki SBU ID: 110505644
 * Assignment:
 *    Homework #3 for CSE 214, Summer 2018
 * Date:
 *    July 25th, 2018
 */
public class Request implements Cloneable{

    private int sourceFloor,destinationFloor,timeEntered;

    /**
     * Constructs and instance of Request with given sourceFloor, destinationFloor, and timeEntered
     * @param numberOfFloors - number of floors in the building that will be used to make sourceFloor and
     *                       destinationFloor
     */
    public Request(int numberOfFloors) {
        sourceFloor = (int)(1 + Math.random() * numberOfFloors);
        destinationFloor = (int)(1 + Math.random() * numberOfFloors);
    }

    /**
     * Gets the sourceFloor of this request
     * @return
     * Returns the int value of the source floor of this Request
     */
    public int getSourceFloor() {
        return sourceFloor;
    }

    /**
     * Changes the source floor to the given sourceFloor
     * @param sourceFloor - the source floor that will become the new destinationFloor
     */
    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }

    /**
     * Gets the destinationFloor of this request
     * @return
     * Returns the int value of the destination floor of this Request
     * @return
     */
    public int getDestinationFloor() {
        return destinationFloor;
    }

    /**
     * Changes the destination floor to the given destinationFloor
     * @param destinationFloor - the destination floor that will become the new destinationFloor
     */
    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    /**
     * Gets the time this request was entered
     * @return
     * Returns the int value of the time this Request was entered
     *
     */
    public int getTimeEntered() {
        return timeEntered;
    }

    /**
     * changes or adds a time this Request was entered with the given timeEntered
     * @param timeEntered - the time this request was entered
     */
    public void setTimeEntered(int timeEntered) {
        this.timeEntered = timeEntered;
    }

    @Override
    public String toString() {
        return ("(" + sourceFloor + ", " + destinationFloor + ", " + timeEntered + ")");
    }
}
