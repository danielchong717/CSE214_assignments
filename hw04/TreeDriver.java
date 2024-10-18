package hw04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * This TreeDriver class implements the main() method, and it should display a menu.
 *
 *
 * @author Daniel Chong
 * email: daniel.chong@stonybrook.edu
 * Stony Brook ID: 115715024
 */
public class TreeDriver {
    /**
     * Main method of the TreeDriver class that implements all the questionnaire.
     * @param args
     * All arguments passed through during the run.
     */
    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner in = new Scanner(System.in);
        String choice = "";
        while (!choice.equals("Q")) {
            System.out.println("L - Load a Tree.");
            System.out.println("H - Begin a Help Session.");
            System.out.println("T - Traverse the Tree in preorder.");
            System.out.println("Q - Quit");
            System.out.print("Choice> ");
            choice = in.nextLine();
            System.out.println();
            switch (choice) {
                case "L":
                    System.out.print("Enter the file name> ");
                    String fileName = in.nextLine();
                    File file = new File(fileName);
                    String parentLabel = "";
                    String data;
                    int numOfChildren = 0;
                    try {
                        Scanner fileScan = new Scanner(file);
                        while (fileScan.hasNextLine()) {
                            if (tree.root == null) {
                                parentLabel = "root";
                                data = fileScan.nextLine();
                                String label = data;
                                data = fileScan.nextLine();
                                String prompt = data;
                                data = fileScan.nextLine();
                                String message = data;
                                tree.addNode(label, prompt, message, parentLabel);
                                data = fileScan.nextLine();
                                numOfChildren = Integer.parseInt(String.valueOf(data.charAt(data.length() - 1)));
                            }
                            else {
                                for (int i = 0; i < numOfChildren; i++) {
                                    data = fileScan.nextLine();
                                    String label = data;
                                    data = fileScan.nextLine();
                                    String prompt = data;
                                    data = fileScan.nextLine();
                                    String message = data;
                                    tree.addNode(label, prompt, message, parentLabel);
                                }
                                if (fileScan.hasNext()) {
                                    data = fileScan.nextLine();
                                    numOfChildren = Integer.parseInt(String.valueOf(data.charAt(data.length() - 1)));
                                    parentLabel = data.substring(0, data.length() - 2);
                                }
                            }
                        }
                        System.out.println("\nTree created successfully!\n");
                    }
                    catch (FileNotFoundException e) {
                        System.out.println("An error occurred: No such file.\n");
                    }
                    break;
                case "H":
                    System.out.println("Help Session Starting...");
                    if (tree.root == null) System.out.println("An error occurred: The tree is empty.\n");
                    else tree.beginSession(); break;
                case "T":
                    if (tree.root == null) System.out.println("An error occurred: The tree is empty.\n");
                    else {
                        System.out.println("Traversing the tree in preorder: ");
                        tree.root.preOrder();
                    } break;
                case "Q": System.out.println("Thank you for using our automated help services!\n"); break;
            }
        }
    }
}
