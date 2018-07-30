import javax.naming.event.ObjectChangeListener;
import java.util.Vector;

/**
 * @author
 *    Joseph Winicki SBU ID: 110505644
 * Assignment:
 *    Homework #3 for CSE 214, Summer 2018
 * Date:
 *    July 25th, 2018
 */
public class Simulator {

    public static void Simulate(double probability, int numFloors, int numElevators, int simLength){
        BooleanSource chance = new BooleanSource(probability);
        RequestQueue requests = new RequestQueue();
        Vector<Elevator> elevators= new Vector<Elevator>(numElevators);
        for(int x = 0; x < numElevators;x++){
            elevators.add(new Elevator());
        }
        int elapsedTime = 0;
        try {
            while (elapsedTime <= simLength) {
                if (chance.requestArrived()) {// if request comes in
                    Request newRequest = new Request(numFloors); // create a new request
                    requests.enqueue(newRequest);// enqueue the request
                    requests.getRequestQueue().get(requests.getRear()).setTimeEntered(elapsedTime);//sets the time entered for request
                }
                if((Request) requests.get(requests.getFront()) != null) { // checks if front of queue is empty, if not looks for free elevator
                    Request front = requests.getRequest(requests.getFront());
                    for (int i = 0; i < numElevators; i++) { // checks if an elevator is IDLE
                        if (elevators.get(i).getElevatorState() == -1) { // If elevator i is IDLE give it the first request in the queue and dequeue
                            Elevator currentElevator = elevators.get(i);
                            currentElevator.setRequest(front);
                            requests.dequeue();
                        }
                    }
                }
                elapsedTime++;
            }
        }
        catch (EmptyQueueException e) {
            System.out.println("The queue is empty.");
        }
        catch(FullQueueException e ){
            System.out.println("The queue is full.");
        }
    }
}
