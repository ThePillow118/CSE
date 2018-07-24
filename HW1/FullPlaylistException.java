/**
 * An exception thrown in the Playlist class to indicate that the
 * integer used as an argument in the class methods is not within the valid
 * range accepted as elements in the set.
 *
 * @author
 *    Joseph Winicki, USB ID #110505644
 * Assignment:
 *    Homework #1 for CSE 214, Summer 2018
 * Date:
 *    July 16th, 2018
 */
public class FullPlaylistException extends Exception{

    /**
     * Default constructor for the FullPlaylistException
     *
     * Postcondition:
     *  The object is created
     */
    public FullPlaylistException(){
        super();
    }
}
