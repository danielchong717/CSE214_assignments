package hw02;

import java.util.*;
/**
 * The hw02.DepartmentStore class will implement a main method that provides
 * a menu with the following options to interact with
 * the program and update the store inventory information.
 *
 *
 * @author Daniel Chong
 * email: daniel.chong@stonybrook.edu
 * Stony Brook ID: 115715024
 */
public class DepartmentStore {
    /**
     * Main method that provides a menu with the following options to interact with the program and update the store inventory information.
     * @param args
     * Main method.
     * @throws Exception
     * Exception thrown when there are invalid inputs.
     */
    public static void main(String[] args) throws Exception {
        ItemList list = new ItemList();
        Scanner sc = new Scanner(System.in);
        String option = "";
        System.out.println();
        System.out.println("    Welcome!");
        while (!option.equals("Q")) {
            System.out.println();
            System.out.println("    C - Clean store");
            System.out.println("    I - Insert an item into the list ");
            System.out.println("    L - List by location");
            System.out.println("    M - Move an item in the store ");
            System.out.println("    O - Checkout");
            System.out.println("    P - Print all items in store");
            System.out.println("    R - Print by RFID tag number         (optional - extra credit)");
            System.out.println("    U - Update inventory system");
            System.out.println("    Q - Exit the program.");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.print("Please select an option: ");
            option = sc.next();
            String name = "";
            String rfid = "";
            String originalLocation = "";
            String currentLocation = "";
            double price = 0;
            sc.nextLine();
            switch (option) {
                case "C":
                    System.out.println("The following item(s) have been moved back to their original locations:");
                    list.cleanStore();
                    break;
                case "I":
                    System.out.print("Enter the name: ");
                    name = sc.nextLine();
                    System.out.print("Enter the RFID: ");
                    rfid = sc.nextLine();
                    System.out.print("Enter the original location: ");
                    originalLocation = sc.nextLine();
                    System.out.print("Enter the price: ");
                    price = sc.nextDouble();
                    list.insertInfo(name, rfid, price, originalLocation);
                    break;
                case "L":
                    System.out.print("Enter the location: ");
                    currentLocation = sc.nextLine();
                    list.printByLocation(currentLocation);
                    break;
                case "M":
                    System.out.print("Enter the RFID: ");
                    rfid = sc.nextLine();
                    System.out.print("Enter the original location: ");
                    originalLocation = sc.nextLine();
                    System.out.print("Enter the new location: ");
                    currentLocation = sc.nextLine();
                    try {
                        list.moveItem(rfid, originalLocation, currentLocation);
                    }
                    catch (Exception e) {

                    }
                    break;
                case "O":
                    System.out.print("Enter the cart number: ");
                    currentLocation = sc.nextLine();
                    list.checkOut(currentLocation);
                    break;
                case "P":list.printAll();break;
                case "R":;break;
                case "U":;break;
                case "Q":;break;
            }
        }
        sc.close();
    }
}
