package hw03;

import java.util.*;
/**
 * This hw03.Analyzer class implements a main method which prompts the user, on separate lines, for each of the 4 parameters required for the simulate method of the hw03.Simulator class.
 *
 *
 * @author Daniel Chong
 * email: daniel.chong@stonybrook.edu
 * Stony Brook ID: 115715024
 */
public class Analyzer {
    /**
     * Main method that runs the program, prompts the user, on separate lines, for each of the 4 parameters required for the simulate method of the hw03.Simulator class. Checks the validity for all of these inputs.
     * @param args
     * Empty arguments for this main method to run
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Simulator simulator = new Simulator();
        System.out.println("Welcome to the hw03.Elevator simulator!\n");
        System.out.print("Which method would you like to be ran? Enter 1 for optimal and 0 for regular: ");
        int method = input.nextInt();
        System.out.println();
        while (method == 0 || method == 1) {
            if (method == 0) {
                System.out.print("Please enter the probability of arrival for Requests: ");
                double probability = input.nextDouble();
                System.out.print("Please enter the number of floors: ");
                int numFloors = input.nextInt();
                System.out.print("Please enter the number of elevators: ");
                int numElevators = input.nextInt();
                System.out.print("Please enter the length of the simulation (in time units): ");
                int length = input.nextInt();
                simulator.simulate(probability, numFloors, numElevators, length);
                method = -1;
            }
            if (method == 1) {
                System.out.print("Please enter the probability of arrival for Requests: ");
                double probability = input.nextDouble();
                System.out.print("Please enter the number of floors: ");
                int numFloors = input.nextInt();
                System.out.print("Please enter the number of elevators: ");
                int numElevators = input.nextInt();
                System.out.print("Please enter the length of the simulation (in time units): ");
                int length = input.nextInt();

                method = -1;
            }
        }
    }
}
