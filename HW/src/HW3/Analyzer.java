import java.util.Scanner;

/**
 * @author
 *    Joseph Winicki SBU ID: 110505644
 * Assignment:
 *    Homework #3 for CSE 214, Summer 2018
 * Date:
 *    July 25th, 2018
 */
public class Analyzer {
    /**
     *  Prompts input from the user to put into the simulator to run the program. These inputs are the probability
     *  of a request coming in, the number of floors, the number of buildings, and the amount of time the
     *  simulation runs for.
     * @param args - arguments inputted to by run by the Analyzer class
     *
     * Postconditions: Probability is between 0 and 1, floors is an int greater than 1, number of elevators is
     *             an int greater than 0, and length of simulation is longer than 0 time units.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to Elevator Simulator 2018!");
            System.out.println();
            try {
                System.out.println("Please enter the probability of arrival for Requests: ");
                double prob = in.nextDouble();
                if (prob < 0 || prob > 1) {
                    throw new IllegalArgumentException();
                }
                System.out.println("Please enter the number of floors: ");
                int floors = in.nextInt();
                if (floors < 2)
                    throw new IllegalArgumentException();
                System.out.println("Please enter the number of elevators: ");
                int elevators = in.nextInt();
                if (elevators < 1)
                    throw new IllegalArgumentException();
                System.out.println("Please enter the length of the simulation (in time units): ");
                int simLength = in.nextInt();
                if (simLength < 1)
                    throw new IllegalArgumentException();
                Simulator.Simulate(prob, floors, elevators, simLength);
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println("Probability must be between 0 and 1, there must be at least 2 floors, there must" +
                        " be at least 1 elevator, and at least 1 time unit for simulation length.\n");
            }
        }
    }

}
