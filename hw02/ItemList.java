package hw02;

/**
 * This hw02.ItemList class implements references to the head
 * and tail of a list of hw02.ItemInfoNode nodes.
 *
 *
 * @author Daniel Chong
 * email: daniel.chong@stonybrook.edu
 * Stony Brook ID: 115715024
 */
public class ItemList {
    private ItemInfoNode head;
    private ItemInfoNode tail;
    private ItemInfoNode cursor;
    private ItemList removed;

    /**
     * Constructor for hw02.ItemList
     */
    public ItemList() {
        head = null;
        tail = null;
        cursor = null;
    }

    /**
     * Inserts the info into the list in its correct position based on its rfidTagNumber.
     * @param name
     * String value to be set to for the member variable name.
     * @param rfidTag
     * String value to be set to for the member variable rfidTag.
     * @param price
     * double value to be set to for the member variable price.
     * @param initPosition
     * String value to be set to for the member variable initPosition.
     */
    public void insertInfo(String name, String rfidTag, double price, String initPosition) {
        ItemInfoNode newNode = new ItemInfoNode();
        newNode.setInfo(new ItemInfo(name, rfidTag, price, initPosition, initPosition));
        if (head == null) {
            head = newNode;
            tail = head;
            cursor = newNode;
        }
        else {
            if (head == tail) {
                head.setNext(newNode);
                newNode.setPrev(head);
                tail = newNode;
            }
            else {
                cursor = tail;
                while (cursor != null) {
                    if (rfidTag.compareTo(cursor.getInfo().getRfidTagNumber()) >= 0) {
                        if (cursor == tail) {
                            cursor.setNext(newNode);
                            newNode.setPrev(cursor);
                            tail = newNode;
                        }
                        else {
                            cursor.getNext().setPrev(newNode);
                            newNode.setNext(cursor.getNext());
                            cursor.setNext(newNode);
                            newNode.setPrev(cursor);
                        }
                        break;
                    }
                    if (rfidTag.compareTo(cursor.getInfo().getRfidTagNumber()) < 0) {
                        cursor.getPrev().setNext(newNode);
                        newNode.setPrev(cursor.getPrev());
                        cursor.setPrev(newNode);
                        newNode.setNext(cursor);
                        break;
                    }
                    cursor = cursor.getPrev();
                }
                if (head == cursor) {
                    cursor.setPrev(newNode);
                    newNode.setNext(cursor);
                    head = newNode;
                }
            }
        }
    }

    /**
     * Helper method that identifies a node and removes the targeted node.
     * @param node
     * Targeted node to be removed.
     * @return
     * The hw02.ItemInfoNode that was removed.
     */
    public ItemInfoNode remove(ItemInfoNode node) {
        node.getNext().setPrev(node.getPrev());
        node.getPrev().setNext(node.getNext());
        node = node.getNext();
        return node;
    }

    /**
     * Removes all nodes in the list that have current location listed as "out" and displays a list of all items that have been removed in this fashion.
     */
    public void removeAllPurchased() {
        ItemInfoNode nodePtr = head;
        cursor = head;
        if (cursor != null) {
            while (cursor.getNext() != null) {
                if (cursor.getInfo().getCurrentLocation().equalsIgnoreCase("out")) {
                    ItemInfoNode node = remove(cursor);
                    removed.insertInfo(node.getInfo().getName(), node.getInfo().getRfidTagNumber(), node.getInfo().getPrice(), node.getInfo().getOriginalLocation());
                }
                cursor = cursor.getNext();
            }
        }
    }

    /**
     * Moves an item with a given rfidTagNumber from a source location to a dest location. The return value indicates whether or not an item of the given rfidTagNumber was found at the given source location.
     * @param rfidTag
     * String value for the member variable rfidTag to be set to.
     * @param source
     * String value given to check where we can move hw02.ItemInfoNode.
     * @param dest
     * String value given to check where we can most our hw02.ItemInfoNode.
     * @return
     * A boolean value that tells if the move was successful or not.
     * @throws Exception
     * When there is invalid inputs.
     */
    public boolean moveItem(String rfidTag, String source, String dest) throws Exception {
        cursor = head;
        ItemInfoNode src = new ItemInfoNode();
        ItemInfoNode dt = new ItemInfoNode();
        boolean found = false;
        if (cursor == null) {
            return false;
        }
        else {
            while (cursor.getNext() != null) {
                cursor = cursor.getNext();
                if (!dest.equals("cart") || !dest.equals("shelf") || !dest.equals("out") || source.equals("out")) {
                    throw new Exception();
                }
                else {
                    if (cursor.getInfo().getCurrentLocation().equals(source) && cursor.getInfo().getRfidTagNumber().equals(rfidTag)) {
                        found = true;
                        src = cursor;
                        break;
                    }
                }
            }
            while (cursor.getNext() != null) {
                cursor = cursor.getNext();
                if (cursor.getInfo().getCurrentLocation().equals(dest)) {
                    dt = cursor;
                    break;
                }
            }
            src.setNext(dt.getNext());
            src.setPrev(dt.getPrev());
            dt.setInfo(src.getInfo());
        }
        return found;
    }

    /**
     * Prints a neatly formatted list of all items currently in the list. The table should include each item's name,
     * rfidTagNumber, original location, current location, and price.
     * The list must be sorted in order of rfidTagNumber, although duplicate rfidTagNumber entries may be printed in any order.
     */
    public void printAll() {
        cursor = head;
        if (cursor == null) {
            System.out.println();
        }
        else {
            System.out.println("                               Original        Current");
            System.out.println("Item Name         RFID         Location        Location     Price");
            System.out.println("---------       ---------     ---------        ---------   ------");
            while (cursor != null) {
                String space = "";
                for (int i = 0; i < (16 - cursor.getInfo().getName().length()); i++) {
                    space += " ";
                }
                System.out.print(cursor.getInfo().getName() + space + cursor.getInfo().getRfidTagNumber() + "       " + cursor.getInfo().getOriginalLocation() + "          " + cursor.getInfo().getCurrentLocation() + "      ");
                System.out.printf("%.2f", cursor.getInfo().getPrice());
                System.out.println();
                cursor = cursor.getNext();
            }
        }
    }

    /**
     * Prints a neatly formatted list of all items in a specified current location. The table should include each item's name, rfidTagNumber, original location, current location, and price. The list must be sorted in order of rfidTagNumber, although duplicate rfidTagNumber entries may be printed in any order.
     * @param location
     * String representation of the location to be printed as.
     */
    public void printByLocation(String location) {
        cursor = head;
        if (cursor == null) {
            System.out.println();
        }
        else {
            System.out.println("                               Original        Current");
            System.out.println("Item Name         RFID         Location        Location     Price");
            System.out.println("---------       ---------     ---------        ---------   ------");

            while (cursor != null) {
                if (cursor.getInfo().getCurrentLocation().equalsIgnoreCase(location)) {
                    String space = "";
                    for (int i = 0; i < (16 - cursor.getInfo().getName().length()); i++) {
                        space += " ";
                    }
                    System.out.print(cursor.getInfo().getName() + space + cursor.getInfo().getRfidTagNumber() + "       " + cursor.getInfo().getOriginalLocation() + "          " + cursor.getInfo().getCurrentLocation() + "      ");
                    System.out.printf("%.2d", cursor.getInfo().getPrice());
                    System.out.println();
                }
                cursor = cursor.getNext();
            }
        }
    }

    /**
     * Take every item that is currently in the store
     * and on the wrong shelf and places it back where
     * it belongs (its original location). Items that are
     * "out" or currently in a cart are not affected by this command.
     * Display a table for all out of place items moved in this fashion,
     * including each item's name, rfidTagNumber, current location(before the move),
     * original location and price.
     */
    public void cleanStore() {
        cursor = head;
        if (cursor == null) {
            System.out.println();
        }
        else {
            System.out.println("                               Original        Current");
            System.out.println("Item Name         RFID         Location        Location     Price");
            System.out.println("---------       ---------     ---------        ---------   ------");
            while (cursor != null) {
                if (!cursor.getInfo().getCurrentLocation().equals(cursor.getInfo().getOriginalLocation())) {
                    String space = "";
                    for (int i = 0; i < (16 - cursor.getInfo().getName().length()); i++) {
                        space += " ";
                    }
                    System.out.println(cursor.getInfo().getName() + space + cursor.getInfo().getRfidTagNumber() + "       " + cursor.getInfo().getOriginalLocation() + "          " + cursor.getInfo().getCurrentLocation() + "      ");
                    System.out.printf("%.2f", cursor.getInfo().getPrice());
                    System.out.println();
                }
                cursor = cursor.getNext();
                if (cursor == null) {
                    break;
                }
            }
        }
    }

    /**
     * Goes through a given cart and checks out each item (changes its location to "out").
     * A neatly formatted list of the items checked out is to be printed and it must be sorted
     * in order of rfidTagNumber, although duplicate rfidTagNumber entries may be printed in any order.
     * The return value is the total cost for the items that were in the cart.
     * Throw appropriate exceptions for invalid cart numbers.
     * @param cartNumber
     * String representation of the cartNumber variable, found with the rfidtag.
     * @return
     * double value of the total cost.
     */
    public double checkOut(String cartNumber) {
        ItemInfoNode nodePtr = head;
        double total = 0;
        if (nodePtr == null)
            System.out.println();
        else {
            System.out.println("                               Original        Current");
            System.out.println("Item Name         RFID         Location        Location     Price");
            System.out.println("---------       ---------     ---------        ---------   ------");
            while (cursor != null) {
                if (cursor.getInfo().getCurrentLocation().equals(cartNumber)) {
                    String space = "";
                    for (int i = 0; i < (16 - nodePtr.getInfo().getName().length()); i++) {
                        space += " ";
                    }
                    System.out.println(cursor.getInfo().getName() + space + cursor.getInfo().getRfidTagNumber() + "       " + cursor.getInfo().getOriginalLocation() + "          " + cursor.getInfo().getCurrentLocation() + "      ");
                    System.out.printf("%.2f", cursor.getInfo().getPrice());
                    System.out.println();
                }
                total += cursor.getInfo().getPrice();
                cursor = cursor.getNext();
                if (cursor == null) {
                    break;
                }
            }
        }
        return total;
    }
}