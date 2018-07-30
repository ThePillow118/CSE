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
public class RequestQueue extends Vector implements Cloneable{
    private final int MAX_CAPACITY = 50;
    private Vector <Request> requestQueue;
    private int front,rear;

    /**
     *
     */
    public RequestQueue(){
        front = -1;
        rear = -1;
        requestQueue = new Vector<Request>(MAX_CAPACITY);
    }

    /**
     *
     * @param requestQueue
     */
    public void setRequestQueue(Vector<Request> requestQueue) {
        this.requestQueue = requestQueue;
    }

    /**
     *
     * @param front
     */
    public void setFront(int front) {
        this.front = front;
    }

    /**
     *
     * @param rear
     */
    public void setRear(int rear) {
        this.rear = rear;
    }

    /**
     *
     * @return
     */
    public Vector<Request> getRequestQueue() {

        return requestQueue;
    }

    /**
     *
     * @return
     */
    public int getFront() {
        return front;
    }

    /**
     *
     * @return
     */
    public int getRear() {
        return rear;
    }

    /**
     *
     * @param newRequest
     */
    public void enqueue(Request newRequest) throws FullQueueException{
        if(requestQueue.isEmpty()){
            front = 0;
            rear = front;
            requestQueue.add(newRequest);
        }
        else if(requestQueue.size() >= MAX_CAPACITY) {
            throw new FullQueueException();
        }
        else{
            requestQueue.add(++rear,newRequest);
        }
    }

    /**
     *
     * @return
     * @throws EmptyQueueException
     */
    public Request dequeue() throws EmptyQueueException{
        Request answer;
        if(requestQueue.isEmpty()){
            throw new EmptyQueueException();
        }
        answer = requestQueue.get(front);
        return answer;
    }

    /**
     *
     * @param index
     * @return
     */
    public Request getRequest(int index){
        return requestQueue.get(index);
    }


}
