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

    public static void Simulate(double probability, int numFloors, int numElevators, int simLength) {
        BooleanSource chance = new BooleanSource(probability);
        RequestQueue requests = new RequestQueue();
        Vector<Elevator> elevators = new Vector<Elevator>(numElevators);
        int totalWait = 0;
        for (int x = 0; x < numElevators; x++) {
            elevators.add(new Elevator());
        }
        int elapsedTime = 0;
        try {
            while (elapsedTime <= simLength) {
                if (chance.requestArrived()) {
                    requests.enqueue(new Request(numFloors));
                    Request front = (Request) requests.elementAt(requests.getFront());
                    System.out.println("The following request queued: " + front.toString());
                    front.setTimeEntered(elapsedTime);
                }
                if(requests.size() != 0){
                    for(int i = 0; i< numElevators; i++){
                        if(requests.size() == 0)
                            break;
                        if(elevators.get(i).getElevatorState() == -1){
                            elevators.get(i).setRequest( (Request) requests.firstElement());
                            elevators.get(i).setElevatorState(-2);
                            System.out.println("The following request was dequeued: " + requests.dequeue().toString());
                        }

                    }
                }
                int j = 0, wait = 0;
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
                    else if(elevators.get(j).getCurrentFloor() == elevators.get(j).getRequest().getSourceFloor()){
                        elevators.get(j).setElevatorState(-3);
                        if(elevators.get(j).getCurrentFloor() > elevators.get(j).getRequest().getDestinationFloor())
                            elevators.get(j).setCurrentFloor(elevators.get(j).getCurrentFloor() - 1);
                        else if(elevators.get(j).getCurrentFloor() < elevators.get(j).getRequest().getDestinationFloor())
                            elevators.get(j).setCurrentFloor(elevators.get(j).getCurrentFloor() + 1);
                        wait = elapsedTime - elevators.get(j).getRequest().getTimeEntered();
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
                System.out.println(requests.toString());
                System.out.print("Elevators: ");
                for (int p = 0; p < numElevators; p++){
                    System.out.print(elevators.get(p).toString() + ", ");
                }
                elapsedTime++;
                System.out.println();
                System.out.println("Total wait time: " + totalWait + " Elapsed Time: " + elapsedTime);
            }
            double avg = (double)totalWait/ (double)elapsedTime;
            System.out.printf("\nAvg. Wait Time: %.2f", avg);
        }
        catch(EmptyQueueException e){
            System.out.println("");
        }
    }
}