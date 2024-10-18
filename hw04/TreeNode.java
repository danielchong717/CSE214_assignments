package hw04;

/**
 * This TreeNode class implements three references to other TreeNodes: left, middle, right.
 *
 *
 * @author Daniel Chong
 * email: daniel.chong@stonybrook.edu
 * Stony Brook ID: 115715024
 */
public class TreeNode {
    private TreeNode left;
    private TreeNode middle;
    private TreeNode right;
    private String label;
    private String message;
    private String prompt;
    /**
     * Default constructor of the class TreeNode.
     */
    public TreeNode() {
        left = null;
        middle = null;
        right = null;
    }
    /**
     * Returns a reference to the TreeNode that has the given label.
     * The return value is null if the label is not found.
     * @param label
     * String value of the targeted node with the label
     * @return
     * TreeNode object with this label
     */
    public TreeNode getNodeReference(String label) {
        TreeNode result = null;
        if (this.getLabel().equals(label)) {
            result = this;
        }
        if (this.getLeft() != null && result == null) {
            result = this.getLeft().getNodeReference(label);
        }
        if (this.getMiddle() != null && result == null) {
            result = this.getMiddle().getNodeReference(label);
        }
        if (this.getRight() != null && result == null) {
            result = this.getRight().getNodeReference(label);
        }
        return result;
    }
    /**
     * Traverses the tree in preorder, and prints the contents of the tree to the screen.
     */
    public void preOrder() {
        TreeNode current = this;
        if (current == null) {
            System.out.print("");
        }
        System.out.println("Label: " + current.getLabel());
        System.out.println("Prompt: " + current.getPrompt());
        System.out.println("Message: " + current.getMessage() + "\n");
        if (current.getLeft() != null)
            current.getLeft().preOrder();
        if (current.getMiddle() != null)
            current.getMiddle().preOrder();
        if (current.getRight() != null)
            current.getRight().preOrder();
    }
    /**
     * A method that check if the node is a leaf or not.
     * @return
     * a boolean value that signals true if it is false if it is not.
     */
    public boolean isALeaf() {
        if (left == null && middle == null && right == null) {
            return true;
        }
        return false;
    }
    /**
     * Getter method for the node to the left of this node.
     * @return
     * A TreeNode object that is left of this node.
     */
    public TreeNode getLeft() {
        return left;
    }
    /**
     * Setter method that sets the left node of this node to a given node.
     * @param left
     * A TreeNode object to be set to.
     */
    public void setLeft(TreeNode left) {
        this.left = left;
    }
    /**
     * Getter method for the node to the middle of this node.
     * @return
     * A TreeNode object that is middle of this node.
     */
    public TreeNode getMiddle() {
        return middle;
    }
    /**
     * Setter method that sets the middle node of this node to a given node.
     * @param middle
     * A TreeNode object to be set to.
     */
    public void setMiddle(TreeNode middle) {
        this.middle = middle;
    }
    /**
     * Getter method for the node to the right of this node.
     * @return
     * A TreeNode object that is right of this node.
     */
    public TreeNode getRight() {
        return right;
    }
    /**
     * Setter method that sets the right node of this node to a given node.
     * @param right
     * A TreeNode object to be set to.
     */
    public void setRight(TreeNode right) {
        this.right = right;
    }
    /**
     * Getter method for the label variable of this node.
     * @return
     * A String value of the label of this node.
     */
    public String getLabel() {
        return label;
    }
    /**
     * Setter method for the label variable of this node.
     * @param label
     * A String value to be set to.
     */
    public void setLabel(String label) {
        this.label = label;
    }
    /**
     * Getter method for the message variable of this node.
     * @return
     * A String value of the message of this node.
     */
    public String getMessage() {
        return message;
    }
    /**
     * Setter method for the message variable of this node.
     * @param message
     * A String value to be set to.
     */
    public void setMessage(String message) {
        this.message = message;
    }
    /**
     * Getter method for the prompt variable of this node.
     * @return
     * A String value of the prompt of this node.
     */
    public String getPrompt() {
        return prompt;
    }
    /**
     * Setter method for the prompt variable of this node.
     * @param prompt
     * A String value to be set to.
     */
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}
