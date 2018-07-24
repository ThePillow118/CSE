/**
 * The ItemInfo class contains various information about a specific item that can or has been sold in a given department
 * store.
 * @author
 *    Joseph Winicki SBU ID: 110505644
 * Assignment:
 *    Homework #2 for CSE 214, Summer 2018
 * Date:
 *    July 18th, 2018
 */
public class ItemInfo {
    private String productName,rfidTagNumber,originalLocation,currentLocation;
    private double price;

    /**
     * Constructs an instance ItemInfo with given productName, rfidTagNumber, originalLocation, currentLocation, and
     * price of the item
     * @param productName - a String name of the product
     * @param rfidTagNumber - a String that encodes the radio frequency for scanning the item
     * @param originalLocation - a String that encodes the original shelf position of the item
     * @param currentLocation - a String that represents the location of the item at the current time
     * @param price - the double price of the product
     *
     * Postconditions:
     *              rfidTagNumber must be 9 characters long and in hexadecimal format(base 16) which means each
     *              character is either a digit from 0 to 9 or one of the letters A through F, where case is not
     *              important. The length of this String is to be fixed at 9.
     *
     */
    public ItemInfo(String productName, String rfidTagNumber, String originalLocation, String currentLocation,
                    double price){
        this.productName = productName;
        this.rfidTagNumber = rfidTagNumber;
        this.originalLocation = originalLocation;
        this.currentLocation = originalLocation;
        this.price = price;
    }

    /**
     * Creates an instance ItemInfo with no fields initialized
     */
    public ItemInfo() {
    }

    /**
     * Gets the String productName from this ItemInfo
     * @return
     * returns the String value for the productName from this ItemInfo
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Changes this ItemInfo's productName to the given productName
     * @param productName - new productName for this ItemInfo
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Gets the String rfidTagNumber from this ItemInfo
     * @return
     * returns the String value for the rfidTagNumber from this ItemInfo
     */
    public String getRfidTagNumber() {
        return rfidTagNumber;
    }

    /**
     * Changes this ItemInfo's rfidTagNumber to the given rfidTagNumber
     * @param rfidTagNumber - new rfidTagNumber for this ItemInfo
     */
    public void setRfidTagNumber(String rfidTagNumber) {
        this.rfidTagNumber = rfidTagNumber;
    }

    /**
     * Gets the String originalLocation from this ItemInfo
     * @return
     * returns the String value for the originalLocation from this ItemInfo
     */
    public String getOriginalLocation() {
        return originalLocation;
    }

    /**
     * Changes this ItemInfo's originalLocation to the given originalLocation
     * @param originalLocation - new originalLocation for this ItemInfo
     */
    public void setOriginalLocation(String originalLocation) {
        this.originalLocation = originalLocation;
    }

    /**
     * Gets the String currentLocation from this ItemInfo
     * @return
     * returns the String value for the currentLocation from this ItemInfo
     */
    public String getCurrentLocation() {
        return currentLocation;
    }

    /**
     * Changes this ItemInfo's currentLocation to the given currentLocation
     * @param currentLocation
     */
    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    /**
     * Gets the double price from this ItemInfo
     * @return
     * returns the double value for the price from this ItemInfo
     */
    public double getPrice() {
        return price;
    }

    /**
     * Changes this ItemInfo's price to the given price
     * @param price - new price for this ItemInfo
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * Creates a deep copy of this ItemInfo object
     * @return
     * The return value is a copy of this ItemInfo object. Future changes to the copy will not affect the
     * original, and vice versa. Return value must be typecast to a ItemInfo before it can be used.
     */
    public Object clone(){
        ItemInfo clone = new ItemInfo();
        clone.price = this.price;
        clone.currentLocation = this.currentLocation;
        clone.originalLocation = this.originalLocation;
        clone.productName = this.productName;
        clone.rfidTagNumber = this.rfidTagNumber;
        return clone;
    }

    /**
     * Creates the String version to display the contents of ItemInfo in a neat, tabular manner
     * @return
     * Returns the String version of ItemInfo to represent the contents of ItemInfo in a neat,tabular
     * manner
     */
    @Override
    public String toString() {
        return String.format("%-13s%-8s%10s%12s%11.2f\n",productName,rfidTagNumber,originalLocation,currentLocation,
                price);
    }
}
