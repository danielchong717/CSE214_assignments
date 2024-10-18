package hw03;

import java.util.ArrayList;

/**
 * This hw03.OptimalSimulator class implements the simulation. This class will contain a single static method called simulate that accepts the following four parameters, carries out the simulation, and prints the results.
 *
 *
 * @author Daniel Chong
 * email: daniel.chong@stonybrook.edu
 * Stony Brook ID: 115715024
 */
public class OptimalSimulator {
    /**
     * The simulate method accepts the following four parameters, carries out the simulation, and prints the results,
     * the probability of a request being introduced per time unit (a double between 0.0 and 1.0, inclusive),
     * the number of floors in the building (an int greater than 1),
     * the number of elevators in the building (an int greater than 0), and
     * the length of the simulation in time units (an int greater than 0), on a more accurate level.
     * @param probability
     * double value representing probability happening
     * @param numberOfFloors
     * int value representing number of floors of the building
     * @param numberOfElevators
     * int value representing number of elevators of the building
     * @param lengthOfSimulation
     * int value representing the length of the simulation
     */
    public void simulate(double probability, int numberOfFloors, int numberOfElevators, int lengthOfSimulation) {
        int currentTime = lengthOfSimulation;
        int totalWaitTime = 0;
        int numOfRequests = 0;
        if (probability < 0 || probability > 1)
            System.out.println("Invalid input of probability");
        if (numberOfFloors <= 0)
            System.out.println("Invalid input of the number of floors");
        if (lengthOfSimulation <= 0)
            System.out.println("Invalid input of the length of the simulation");
        if (numberOfElevators <= 0)
            System.out.println("Invalid input of number of elevators");
        if ((probability < 0 || probability > 1) || numberOfFloors <= 0 || lengthOfSimulation <= 0 || numberOfElevators <= 0)
            return;
        try {
            BooleanSource happening = new BooleanSource(probability);
            ArrayList<Elevator> elevatorList = new ArrayList<>();
            RequestQueue queue = new RequestQueue();
            while (numberOfElevators != 0) {
                Elevator elevator = new Elevator();
                elevatorList.add(elevator);
                numberOfElevators--;
            }
            while (currentTime > 0) {
                if (happening.requestArrived()) {
                    Request request = new Request(numberOfFloors);
                    queue.enqueue(request);
                    numOfRequests++;
                }
                for (int i = 0; i < elevatorList.size(); i++) {
                    if (queue.isEmpty() == false && elevatorList.get(i).getElevatorState() == 0) {
                        elevatorList.get(i).setRequest(queue.dequeue());
                        elevatorList.get(i).setElevatorState(1);
                    }
                    if (elevatorList.get(i).getElevatorState() == 1) {
                        if (elevatorList.get(i).getCurrentFloor() < elevatorList.get(i).getRequest().getSourceFloor()) {
                            elevatorList.get(i).setCurrentFloor(elevatorList.get(i).getCurrentFloor() + 1);
                            totalWaitTime++;
                        }
                        else if (elevatorList.get(i).getCurrentFloor() > elevatorList.get(i).getRequest().getSourceFloor()) {
                            elevatorList.get(i).setCurrentFloor(elevatorList.get(i).getCurrentFloor() - 1);
                            totalWaitTime++;
                        }
                        else {
                            if (elevatorList.get(i).getCurrentFloor() == elevatorList.get(i).getRequest().getSourceFloor()) {
                                elevatorList.get(i).setElevatorState(2);
                            }
                        }
                    }
                    if (elevatorList.get(i).getElevatorState() == 2) {
                        if (elevatorList.get(i).getCurrentFloor() < elevatorList.get(i).getRequest().getDestinationFloor()) {
                            elevatorList.get(i).setCurrentFloor(elevatorList.get(i).getCurrentFloor() + 1);
                        }
                        else if (elevatorList.get(i).getCurrentFloor() > elevatorList.get(i).getRequest().getDestinationFloor()) {
                            elevatorList.get(i).setCurrentFloor(elevatorList.get(i).getCurrentFloor() - 1);
                        }
                        else {
                            elevatorList.get(i).setElevatorState(0);
                        }
                    }
                }
                currentTime--;
            }
            double averageTime = (double) totalWaitTime / numOfRequests;
            if (numOfRequests == 0 || numOfRequests < 0)
                averageTime = 0;
            System.out.println("Total Wait Time: " + totalWaitTime);
            System.out.println("Total Requests: " + numOfRequests);
            System.out.println("Average Wait Time: " + String.format("%.2f", averageTime));
        }
        catch (IllegalArgumentException e) {
            System.out.println("Invalid probability.");
        }
    }
}
