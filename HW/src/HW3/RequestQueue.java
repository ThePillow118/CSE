import java.util.Vector;

/**
 * @author
 *    Joseph Winicki SBU ID: 110505644
 * Assignment:
 *    Homework #3 for CSE 214, Summer 2018
 * Date:
 *    July 25th, 2018
 */

/**
 * The RequestQueue is a regular queue that extends the Vector class in order to utilize all of the capabilities
 * of the Vector class to implement a queue. This queue has a reference to the front which is the first element of
 * the queue. This class is used to store Requests that are waiting to be handled by Elevator(s) in the Simulator
 * class.
 */
public class RequestQueue extends Vector {
    private int front;

    /**
     * Constructs an instance of RequestQueue with the front of the queue initialized to not be part of the queue.
     */
    public RequestQueue(){
        front = -1;
    }

    /**
     * Gets the int index of the front of the queue of this RequestQueue
     * @return
     * Returns the front index of this RequestQueue
     */
    public int getFront() {
        return front;
    }

    /**
     * Enqueues a new Request object onto the RequestQueue to be picked up by an elevator.
     * @param newRequest - new Request to be enqueued to the RequestQueue
     */
    public void enqueue(Request newRequest) {
        if(this.size() == 0){
            front = 0;
            this.add(newRequest);
        }
        else{
            this.add(this.size(),newRequest);
        }
    }

    /**
     * Dequeues/removes the first item in the queue and returns the Request that was removed
     * @return
     * The return value is null if there is no request in the queue or the first Reqeust in the queue
     * Preconditions: The RequestQueue has at least one element in the queue
     */
    public Request dequeue(){
        Request answer;
        if(this.isEmpty()){
            return null;
        }
        else {
            answer = (Request) this.get(front);
            this.remove(front);
        }
        return answer;
    }


}
