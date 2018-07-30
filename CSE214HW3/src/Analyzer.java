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

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Elevator Simulator 2018!");
        System.out.println();
        System.out.println("Please enter the probability of arrival for Requests: ");
        double prob = in.nextDouble();
        System.out.println("Please enter the number of floors: ");
        int floors = in.nextInt();
        System.out.println("Please enter the number of elevators: ");
        int elevators = in.nextInt();
        System.out.println("Please enter the length of the simulation (in time units): ");
        int simLength = in.nextInt();
    }

}
