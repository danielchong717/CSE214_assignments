package hw04;

import java.util.Scanner;
/**
 * This Tree class implements a reference to the root of the tree and other useful methods.
 *
 *
 * @author Daniel Chong
 * email: daniel.chong@stonybrook.edu
 * Stony Brook ID: 115715024
 */
public class Tree {
    TreeNode root;
    TreeNode node = null;
    /**
     * Default constructor of this Tree class.
     */
    public Tree() {
        root = null;
    }

    /**
     * A method to add a TreeNode to the tree. The location will be a child of parentLabel.
     * The child node should be left justified meaning that it should first be placed in the
     * left most TreeNode reference, then the middle, then the right.
     * A return value of true indicates that the node was successfully added to the tree.
     * Otherwise, the return value is false. More info on the label is in the input file format.
     * Note: You can use a different method signature if you need to, or define a separate method for adding each child
     * (i.e. addNodeLeft, addNodeMiddle, addNodeRight).
     * @param label
     * String representation of the label
     * @param prompt
     * String value of the prompt for the new node.
     * @param message
     * String value of the message for the new node.
     * @param parentLabel
     * The matching String's parent node for this node to be added to.
     * @return
     * A boolean value saying if adding the node was successful or not
     */
    public boolean addNode(String label, String prompt, String message, String parentLabel) {
        TreeNode node = new TreeNode();
        node.setLabel(label);
        node.setPrompt(prompt);
        node.setMessage(message);
        TreeNode nodePtr = root;
        boolean added = false;
        if (nodePtr == null) {
            root = node;
            added = true;
        }
        else {
            nodePtr = nodePtr.getNodeReference(parentLabel);
            if (nodePtr.getLeft() == null) {
                nodePtr.setLeft(node);
                added = true;
            }
            else if (nodePtr.getMiddle() == null) {
                nodePtr.setMiddle(node);
                added = true;
            }
            else if (nodePtr.getRight() == null) {
                nodePtr.setRight(node);
                added = true;
            }
        }
        return added;
    }

    /**
     * This method will be used to start the question and answer session.
     */
    public void beginSession() {
        Scanner input = new Scanner(System.in);
        String choice = "";
        if (node == null)
            node = root;
        while (!node.isALeaf()) {
            if (node == root) {
                System.out.println(node.getMessage());
                if (node.getLeft() != null)
                    System.out.println("1 " + node.getLeft().getPrompt());
                if (node.getMiddle() != null)
                    System.out.println("2 " + node.getMiddle().getPrompt());
                if (node.getRight() != null)
                    System.out.println("3 " + node.getRight().getPrompt());
                System.out.println("0 Exit Session.");
                System.out.print("Choice> ");
                choice = input.nextLine();
                if (choice.equals("1"))
                    node = node.getLeft();
                if (choice.equals("2"))
                    node = node.getMiddle();
                if (choice.equals("3"))
                    node = node.getRight();
                if (choice.equals("0"))
                    break;
            }
            else {
                System.out.println("\n" + node.getMessage());
                if (node.getLeft() != null)
                    System.out.println("1 " + node.getLeft().getPrompt());
                if (node.getMiddle() != null)
                    System.out.println("2 " + node.getMiddle().getPrompt());
                if (node.getRight() != null)
                    System.out.println("3 " + node.getRight().getPrompt());
                System.out.println("0 Exit Session.");
                System.out.print("Choice> ");
                choice = input.nextLine();
                switch (choice) {
                    case "1":node = node.getLeft();break;
                    case "2":node = node.getMiddle();break;
                    case "3":node = node.getRight();break;
                }
                if (choice.equals("0"))
                    break;
                if (node.isALeaf())
                    System.out.println("\n" + node.getMessage() + "\n");
            }
        }
        System.out.println("Thank you for using this automated help service!\n");
        node = null;
    }
}
