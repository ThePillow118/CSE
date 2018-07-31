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
    private int front,rear;

    /**
     *
     */
    public RequestQueue(){
        front = -1;
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
     * @param newRequest
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
