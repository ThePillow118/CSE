/**
 * @author
 *    Joseph Winicki SBU ID: 110505644
 * Assignment:
 *    Homework #2 for CSE 214, Summer 2018
 * Date:
 *    July 18th, 2018
 */
public class ItemList {
    private ItemInfoNode head;
    private ItemInfoNode tail;

    /**
     * Creates an instance ItemList with no fields initialized
     */
    public ItemList() {
    }

    /**
     *
     * @return
     */
    public ItemInfoNode getHead() {
        return head;
    }

    /**
     *
     * @param head
     */
    public void setHead(ItemInfoNode head) {
        this.head = head;
    }

    /**
     *
     * @return
     */
    public ItemInfoNode getTail() {
        return tail;
    }

    /**
     *
     * @param tail
     */
    public void setTail(ItemInfoNode tail) {
        this.tail = tail;
    }

    /**
     * Converts a hexadecimal String into an int decimal equivalent in order to assist with ordering
     * ItemInfoNodes in the ItemList
     * @param hex - String of hexadecimal values
     * @return
     * Returns the equivalent decimal value in int form of the hexadecimal String
     */
    public int hexToDec(String hex){
        hex = hex.toUpperCase();
        String hexDigits = "0123456789ABCDEF";
        int dec = 0;
        for(int i = 0; i < hex.length();i++){
            char hexC = hex.charAt(i);
            int d = hexDigits.indexOf(hexC);
            dec = 16 * dec + d;
        }
        return dec;
    }

    public boolean isEmpty() {
    return (head == null);
    }

    /**
     * Inserts a new ItemInfoNode into the ItemList with the given name, rfidTag, price, and initial position.
     * @param name - name of the item for this ItemInfoNode
     * @param rfidTag - rfid Number of the tag given to this Item
     * @param price - price of the item for this ItemInfoNode
     * @param initPosition - initial position that this item is located at
     */
    public void insertInfo(String name, String rfidTag, double price, String initPosition)
            throws IllegalArgumentException{

        ItemInfoNode newNode = new ItemInfoNode();
        newNode.setInfo(new ItemInfo(name,rfidTag,initPosition,initPosition,price));
        ItemInfoNode ptr = head;
        int rfidTagInt =  hexToDec(rfidTag);
        int currentRfidTagVal = 0;
        if (isEmpty())
            head = newNode;
        else {
            while (!ptr.getInfo().getRfidTagNumber().equals(rfidTag) && ptr.getNext() != null) {
                currentRfidTagVal = hexToDec(ptr.getInfo().getRfidTagNumber());
                if(currentRfidTagVal > rfidTagInt)
                    break;
                ptr = ptr.getNext();
            }
            if(ptr.getNext() != null && rfidTagInt > currentRfidTagVal) {
                ItemInfoNode next = ptr.getNext();
                ptr.setNext(newNode);
                ItemInfoNode prev = ptr.getPrev();
                newNode.setNext(next);
                newNode.setPrev(prev);
                next.setPrev(newNode);
            }
            else if(ptr.getNext() != null && rfidTagInt < currentRfidTagVal){
                ItemInfoNode prev = ptr.getPrev();
                prev.setNext(newNode);
                newNode.setPrev(prev);
                ptr.setPrev(newNode);
                newNode.setNext(ptr);
            }
            else if(ptr.equals(head)){
                newNode.setNext(head);
                head.setPrev(newNode);
                head = newNode;
            }
            else{
                ptr.setNext(newNode);
                newNode.setPrev(ptr);
                newNode.setNext(null);
                tail = newNode;
            }
        }
    }

    /**
     * Removes a the given delete ItemInfoNode in the ItemList
     * @param delete - Node to be deleted from the ItemList
     * @throws IllegalArgumentException - Throws this IllegalArgument exception if the head is null or the given
     * ItemInfoNode is null as it will be impossible to delete anything
     */
    public void removeNode(ItemInfoNode delete) throws IllegalArgumentException{
        if(isEmpty() || delete == null)
            throw new IllegalArgumentException();
        else if(head.equals(delete)){
            head.getNext().setPrev(null);
            head = head.getNext();
        }
        else if(tail.equals(delete)){
            ItemInfoNode prev = tail.getPrev();
            prev.setNext(null);
            tail = prev;
        }
        else{
            ItemInfoNode ptr = delete;
            ItemInfoNode prev = ptr.getPrev();
            ItemInfoNode next = ptr.getNext();
            prev.setNext(next);
            next.setPrev(prev);
        }
    }
    /**
     * Removes all nodes in the list that have current location listed as "out" and displays a list of all items
     * that have been removed in this fashion.
     *
     * This algorithm's Big O notation is O(N) as it needs to traverse the entire ItemList to find each of the
     * ItemInfoNodes that are checked out and removes them.
     */
    public void removeAllPurchased(){
        ItemInfoNode ptr= head;
        if(isEmpty()){
            return;
        }
        else {
            while (ptr.getNext() != null){
                if(ptr.getInfo().getCurrentLocation().equals("out")) {
                    System.out.println(ptr.toString());
                    ptr = ptr.getNext();
                    removeNode(ptr.getPrev());
                }
            }
        }
    }

    /**
     *
     * @param rfidTag - the rfid number tag of the item we are looking to move
     * @param source - the source location of the item we are looking to move
     * @param dest - the location that this item will be moved to
     * @return
     * Returns a value of true if the item is found with the correct source and rfidTag, and returns
     * false if it is not found.
     */
    public boolean moveItem(String rfidTag,String source, String dest) {
        boolean found = false;
        if (isEmpty())
            return found;
        else{
            ItemInfoNode ptr = head;
            while(ptr.getNext() != null){
                if(ptr.getInfo().getRfidTagNumber().equals(rfidTag) &&
                        ptr.getInfo().getCurrentLocation().equals(source)){
                    found = true;
                    ptr.getInfo().setCurrentLocation(dest);
                    return found;
                }
                ptr = ptr.getNext();
            }
        }
        return (found);
    }

    /**
     * Prints out this ItemList in a tabular and neat manner.
     *
     * The Big O notation for this algorithm is O(N) as it traverses the entire list and prints out each
     * ItemInfoNode's toString.
     */
    public void printAll(){
        System.out.print(toString());
    }

    /**
     *Take every item that is currently in the store and on the wrong shelf and places it back where it belongs
     * (its original location). Items that are "out" or currently in a cart are not affected by this command. Display
     * a table for all out of place items moved in this fashion, including each item's name, rfidTagNumber, current location(before the move), original location and price.
     */
    public void cleanStore(){

    }

    /**
     *
     */
    public double checkOut(String cartNumber){
        double totalCost = 0;
        if(isEmpty())
            return totalCost;
        else if(head.getNext() == null)
            totalCost += head.getInfo().getPrice();
        else{
            ItemInfoNode ptr = head;
            while(ptr.getNext() != null){
                if(ptr.getInfo().getCurrentLocation().equals(cartNumber)){
                    totalCost += ptr.getInfo().getPrice();
                    ptr.getInfo().setCurrentLocation("out");
                    System.out.print(ptr.getInfo().toString());
                }
                ptr = ptr.getNext();
            }
        }
        return totalCost;
    }


    /**
     *
     */
    @Override
    public String toString() {
        String toString = String.format("%33s%12s\n","Original","Current");
        toString += String.format("%-15s%-10s%-10s%10s%10s\n","Item Name","RFID","Location",
                "Location","Price");
        toString += String.format("%-15s%-10s%-10s%10s%10s\n","---------","----","--------","--------",
                "-----");
        ItemInfoNode ptr = head;
        while(ptr != null){
            toString += ptr.getInfo().toString();
            ptr = ptr.getNext();
        }
        return toString;
    }
}
