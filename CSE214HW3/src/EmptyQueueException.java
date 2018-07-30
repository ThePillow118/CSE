/**
 * An exception thrown in the RequestQueue class to indicate that the
 * queue is empty
 *
 * @author
 *    Joseph Winicki SBU ID: 110505644
 * Assignment:
 *    Homework #3 for CSE 214, Summer 2018
 * Date:
 *    July 25th, 2018
 */
public class EmptyQueueException extends Exception{
    /**
     * Default constructor for the EmptyQueueException
     *
     * Postcondition:
     *  The object is created
     */
    public EmptyQueueException(){
        super();
    }
}
