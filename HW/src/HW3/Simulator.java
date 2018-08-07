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
 * The Simulator class handles the entirety of this program. It is meant to simulate an elevator system in a building
 * by handling requests that come in with the given number of elevators. The chance of a request coming in to the
 * simulation is determined by the given probability. The simulation runs for the given time of simLength. The only
 * method in this class is Simulate which takes in the given parameters and performs the simulation.
 */
public class Simulator {

    /**
     * This method performs the acutal simulation of an elevator system with the given parameters. It first checks if a
     * request is made and then enqueues the request. If there is an empty elevator available it then dequeues the
     * request and sets the elevator's request to the dequeued request. Next, the program handles which direction the
     * elevator needs to go by looking at the currentFloor and current state the Elevator is in. After all Elevators
     * have been accounted for and movement of elevators has changed, the time elapsed is incremented until it reaches
     * the given simulation length. At the end of the program it prints out the total amount of waiting time, the total
     * amount of requests picked up from their source floors, and the average wait time.
     * @param probability - the probability of a request arriving
     * @param numFloors - number of floors in the elevator simulation
     * @param numElevators - number of elevators in this simulation
     * @param simLength - the amount of time units that this simulation will last for
     */
    public static void Simulate(double probability, int numFloors, int numElevators, int simLength) {
        BooleanSource chance = new BooleanSource(probability);
        RequestQueue requests = new RequestQueue();
        Vector<Elevator> elevators = new Vector<Elevator>(numElevators);
        int totalWait = 0, requestsPickedUp = 0;
        for (int x = 0; x < numElevators; x++) {
            elevators.add(new Elevator());
        }
        int elapsedTime = 0;
            while (elapsedTime <= simLength) {
                //Checking if a request arrives, then enqueueing it if there is a request that arrives
                if (chance.requestArrived()) {
                    requests.enqueue(new Request(numFloors));
                    Request front = (Request) requests.elementAt(requests.getFront());
                    front.setTimeEntered(elapsedTime);
                }
                //Checks to see if there are any idle elevators available to dequeue and handle a request
                if(requests.size() != 0){
                    for(int i = 0; i< numElevators; i++){
                        if(requests.size() == 0)
                            break;
                        if(elevators.get(i).getElevatorState() == -1){
                            elevators.get(i).setRequest( (Request) requests.firstElement());
                            elevators.get(i).setElevatorState(-2);
                            requests.dequeue();
                        }

                    }
                }
                int j = 0, wait = 0;
                //Checks each elevators position and state and moves them accordingly as well as
                //calculating the wait time for each handled request
                while(j < numElevators){
                    if(elevators.get(j).getRequest() == null)
                        break;
                    if(elevators.get(j).getElevatorState() == -2 && elevators.get(j).getCurrentFloor() !=
                            elevators.get(j).getRequest().getSourceFloor()){
                        if(elevators.get(j).getCurrentFloor() > elevators.get(j).getRequest().getSourceFloor())
                            elevators.get(j).setCurrentFloor(elevators.get(j).getCurrentFloor() - 1);
                        else if(elevators.get(j).getCurrentFloor() < elevators.get(j).getRequest().getSourceFloor())
                            elevators.get(j).setCurrentFloor(elevators.get(j).getCurrentFloor() + 1);
                    }
                    else if(elevators.get(j).getCurrentFloor() == elevators.get(j).getRequest().getSourceFloor() &&
                            elevators.get(j).getElevatorState() != -3){
                        elevators.get(j).setElevatorState(-3);
                        if(elevators.get(j).getCurrentFloor() > elevators.get(j).getRequest().getDestinationFloor())
                            elevators.get(j).setCurrentFloor(elevators.get(j).getCurrentFloor() - 1);
                        else if(elevators.get(j).getCurrentFloor() < elevators.get(j).getRequest().getDestinationFloor())
                            elevators.get(j).setCurrentFloor(elevators.get(j).getCurrentFloor() + 1);
                        wait = elapsedTime - elevators.get(j).getRequest().getTimeEntered();
                        requestsPickedUp++;
                    }
                    else if(elevators.get(j).getElevatorState() == -3 && elevators.get(j).getCurrentFloor() !=
                            elevators.get(j).getRequest().getDestinationFloor()){
                        if(elevators.get(j).getCurrentFloor() > elevators.get(j).getRequest().getDestinationFloor())
                            elevators.get(j).setCurrentFloor(elevators.get(j).getCurrentFloor() - 1);
                        else if(elevators.get(j).getCurrentFloor() < elevators.get(j).getRequest().getDestinationFloor())
                            elevators.get(j).setCurrentFloor(elevators.get(j).getCurrentFloor() + 1);
                    }
                    else if(elevators.get(j).getCurrentFloor() == elevators.get(j).getRequest().getDestinationFloor()){
                        elevators.get(j).setRequest(null);
                        elevators.get(j).setElevatorState(-1);
                    }
                    j++;
                }
                totalWait += wait;
                wait = 0;
                elapsedTime++;
            }
        double avg = (double)totalWait/ (double)requestsPickedUp;
        System.out.printf("\nTotal Wait: %d\nRequests: %d\nAvg. Wait Time: %.2f",totalWait,requestsPickedUp, avg);
    }
}