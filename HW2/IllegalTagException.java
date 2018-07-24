/**
 * An exception thrown in the ItemList class to indicate that the String used as an argument in the class methods
 * is not exactly 9 characters in length and contain only hexadecimal characters.
 *
 * @author
 *    Joe
 * Assignment:
 *    Homework #2 for CSE 214, Summer 2018
 * Date:
 *    July 18th, 2018
 */
public class IllegalTagException extends Exception {

    /**
     * Default constructor for the IllegalTagException
     *
     * Postcondition:
     *  The object is created
     */
    public IllegalTagException(){
        super();
    }
}
