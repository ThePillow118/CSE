/**
 * @author
 *    Joseph Winicki SBU ID: 110505644
 * Assignment:
 *    Homework #2 for CSE 214, Summer 2018
 * Date:
 *    July 18th, 2018
 */
public class ItemInfoNode {
    private ItemInfo info = new ItemInfo();
    private ItemInfoNode next;
    private ItemInfoNode prev;

    /**
     * Creates an instance ItemInfoNode with no fields initialized
     */
    public ItemInfoNode() {
    }

    /**
     * Gets the ItemInfo for this ItemInfoNode
     * @return
     * Returns the ItemInfo object for this ItemInfoNode
     */
    public ItemInfo getInfo() {
        return info;
    }

    /**
     * Changes this ItemInfoNode's ItemInfo to the given ItemInfo
     * @param info - the new ItemInfo that will replace this given ItemInfoNode's current ItemInfo
     */
    public void setInfo(ItemInfo info) {
        this.info = info;
    }

    /**
     * Gets the next ItemInfoNode's reference in an ItemList
     * @return
     * Returns the ItemInfoNode that is next in the ItemList
     */
    public ItemInfoNode getNext() {
        return next;
    }

    /**
     * Changes the next ItemInfoNode reference of this ItemInfoNode
     * @param next - the ItemInfoNode to change the next reference of this ItemInfoNode
     */
    public void setNext(ItemInfoNode next) {
        this.next = next;
    }

    /**
     * Gets the previous ItemInfoNode from this ItemInfoNode
     * @return
     * Returns the previous ItemInfoNode reference from this ItemInfoNode
     */
    public ItemInfoNode getPrev() {
        return prev;
    }

    /**
     * Changes the previous ItemInfoNode's refernce to the given ItemInfoNode prev
     * @param prev - the ItemInfoNode to change this ItemInfoNode's previous ItemInfoNode reference
     */
    public void setPrev(ItemInfoNode prev) {
        this.prev = prev;
    }

    /**
     * Compares this ItemInfoNode to the given ItemInfoNode to check if the contents of the node are the same.
     * These contents do not include the next or prev reference as the two nodes must be at difference positions
     * in an ItemList
     * @param compare - ItemInfoNode to be compared with this ItemInfoNode
     * @return
     * Returns true if the two ItemInfoNodes' contents are exactly the same and false if they are not
     */
    public boolean equals(ItemInfoNode compare){
        return(this.info.getRfidTagNumber().equals(compare.getInfo().getRfidTagNumber()) &&
                this.info.getCurrentLocation().equals(compare.info.getCurrentLocation())&&
                this.info.getOriginalLocation().equals(compare.info.getOriginalLocation())&&
                (this.info.getPrice() == compare.info.getPrice()) &&
                this.info.getProductName().equals(compare.info.getProductName()));
    }

    /**
     * Creates a deep copy of this ItemInfoNode object
     * @return
     * The return value is a copy of this ItemInfoNode. Future changes to the copy will not affect the
     * original, and vice versa. Return value must be typecast to a ItemInfoNode before it can be used.
     */
    public Object clone(){
        ItemInfoNode clone = new ItemInfoNode();
        clone.info = (ItemInfo) this.info.clone();
        return clone;
    }

}
