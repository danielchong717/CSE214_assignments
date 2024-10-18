package hw02;

/**
 * This hw02.ItemInfoNode class implements a
 * reference to an hw02.ItemInfo object as well as to two other
 * hw02.ItemInfoNode objects, referred to as prev and next.
 *
 *
 * @author Daniel Chong
 * email: daniel.chong@stonybrook.edu
 * Stony Brook ID: 115715024
 */
public class ItemInfoNode {
    private ItemInfo itemInfo;
    private ItemInfoNode next;
    private ItemInfoNode prev;
    /**
     * Constructor for hw02.ItemInfoNode
     */
    public ItemInfoNode() {
        itemInfo = null;
        next = null;
        prev = null;
    }

    /**
     * Setter method for itemInfo variable
     * @param info
     * hw02.ItemInfo object to be set to.
     */
    public void setInfo(ItemInfo info) {
        itemInfo = new ItemInfo(info.getName(), info.getRfidTagNumber(), info.getPrice(), info.getOriginalLocation(), info.getCurrentLocation());
    }
    /**
     * Getter method for itemInfo variable
     * @return
     * hw02.ItemInfo object
     */
    public ItemInfo getInfo() {
        return itemInfo;
    }
    /**
     * Setter method for next variable
     * @param node
     * hw02.ItemInfoNode object to be set to.
     */
    public void setNext(ItemInfoNode node) {
        next = new ItemInfoNode();
        next.itemInfo = new ItemInfo(node.itemInfo.getName(), node.itemInfo.getRfidTagNumber(), node.itemInfo.getPrice(), node.itemInfo.getOriginalLocation(), node.itemInfo.getCurrentLocation());
    }
    /**
     * Setter method for prev variable
     * @param node
     * hw02.ItemInfoNode object to be set to.
     */
    public void setPrev(ItemInfoNode node) {
        prev = new ItemInfoNode();
        prev.itemInfo = new ItemInfo(node.itemInfo.getName(), node.itemInfo.getRfidTagNumber(), node.itemInfo.getPrice(), node.itemInfo.getOriginalLocation(), node.itemInfo.getCurrentLocation());
    }
    /**
     * Getter method for next variable
     * @return
     * hw02.ItemInfoNode object of next
     */
    public ItemInfoNode getNext() {
        return next;
    }
    /**
     * Getter method for prev variable
     * @return
     * hw02.ItemInfoNode object of prev
     */
    public ItemInfoNode getPrev() {
        return prev;
    }
}
