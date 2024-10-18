package hw02;

/**
 * This hw02.ItemInfo class contains various information about a specific item that can or has been sold in a given department store.
 * Include the product's name(String) and price(a positive double) as fields along with the information in the following format:
 * -rfidTagNumber: a String that encodes the radio frequency for scanning the item. It is 9 characters long and represented in hexadecimal format(base 16) which means each character is either a digit from 0 to 9 or one of the letters A through F, where case is not important. The length of this String is to be fixed at 9.
 * -Original Location: a String that encodes the original shelf position of the item. The first character is 's' to designate that it is a shelf position and it is followed by a 5 digit shelf number to further specify where it can be found in the store. (Examples may be "s00013", "s90909", "s32760", etc.). The length of the String is to be fixed at 6.
 * -Current Location: a String that represents the location of the item at the current time. It may be a shelf position (as described above), an encoding of a cart number, which is designated by the letter 'c' followed by a 3 digit number ("c101", "c001", "c347", etc.), or it may have been checked out by a customer already in which case the location will be represented by the String "out", where case is not important.
 * 
 * 
 * @author Daniel Chong
 * email: daniel.chong@stonybrook.edu
 * Stony Brook ID: 115715024
 */
public class ItemInfo {
    String name;
    String rfidTagNumber;
    double price;
    String originalLocation;
    String currentLocation;
    /**
     * Default constructor of this class hw02.ItemInfo.
     */
    public ItemInfo(String name, String rfidTagNumber, double price, String originalLocation, String currentLocation) {
        this.name = name;
        this.rfidTagNumber = rfidTagNumber;
        this.price = price;
        this.originalLocation = originalLocation;
        this.currentLocation = currentLocation;
    }

    /**
     * Getter method for name
     * @return
     * String value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for name
     * @param name
     * String value of name to be set to
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Getter method for RfidTagNumber
     * @return
     * String value of rfidtagnumber
     */
    public String getRfidTagNumber() {
        return rfidTagNumber;
    }
    /**
     * Setter method for rfidTagNumber
     * @param rfidTagNumber
     * String value of rfidTagNumber to be set to
     */
    public void setRfidTagNumber(String rfidTagNumber) {
        this.rfidTagNumber = rfidTagNumber;
    }
    /**
     * Getter method for price
     * @return
     * double value of price variable
     */
    public double getPrice() {
        return price;
    }
    /**
     * Setter method for price
     * @param price
     * double value for price to be set to
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter method for originalLocation
     * @return
     * String value of originalLocation
     */
    public String getOriginalLocation() {
        return originalLocation;
    }
    /**
     * Setter method for originalLocation
     * @param originalLocation
     * String value for originalLocation to be set to
     */
    public void setOriginalLocation(String originalLocation) {
        this.originalLocation = originalLocation;
    }

    /**
     * Getter method for currentLocation
     * @return
     * String value of currentLocation
     */
    public String getCurrentLocation() {
        return currentLocation;
    }
    /**
     * Setter method for currentLocation
     * @param currentLocation
     * String value for currentLocation to be set to
     */
    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }
}