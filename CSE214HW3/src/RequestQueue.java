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
 *
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
     *
     * @return
     * @throws EmptyQueueException
     * Preconditions: The RequestQueue has at least one element in the queue
     */
    public Request dequeue() throws EmptyQueueException{
        Request answer;
        if(this.isEmpty()){
            throw new EmptyQueueException();
        }
        else {
            answer = (Request) this.get(front);
            this.remove(front);
        }
        return answer;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString(){
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < this.size();i++){
            if(this.get(i) == null)
                break;
            Request requestAtIndex = (Request) this.get(i);
            answer.append(requestAtIndex.toString());
        }
        return answer.toString();
    }


}
