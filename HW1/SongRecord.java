/**
 * This class contains information about a particular audio file. This includes information
 * such as the artist, the title of the song, and the amount of time the song plays for in
 * minutes and seconds
 * @author
 *    Joseph Winicki, USB ID #110505644
 * Assignment:
 *    Homework #1 for CSE 214, Summer 2018
 * Date:
 *    July 16th, 2018
 */
public class SongRecord {

    public String title, artist;
    public int minutes,seconds;

    /**
     * Constructs an instance SongRecord with given title, artist, minutes, and seconds
     * of the song
     *
     * @param title - title of the song
     * @param art - artist of the song
     * @param min - amount of minutes of the length of the song
     * @param secs - amount of seconds in the song left after the minutes
     *
     * Postconditions:
     * This SongRecord has been instantiated with the given values for title, artist,
     * minutes, and seconds.
     *
     * Throws: IllegalArgumentException - if the given min or secs is invalid, outside of the range
     *             of acceptable lengths, this exception is thrown
     */
    public SongRecord(String title, String art, int min, int secs){

        try {
            if((secs < 0) || (secs > 59))
                throw new IllegalArgumentException();
            if(min < 0)
                throw new IllegalArgumentException();
            this.title = title;
            this.artist = art;
            this.minutes = min;
            this.seconds = secs;
        }
        catch (IllegalArgumentException e){
            System.out.println("Invalid song length.");
        }
    }

    /**
     * Constructs an instance of an empty SongRecord without any artist or title name and
     * has the minutes and seconds as invalid numbers.
     *
     * Postconditions:
     * This SongRecord has been instantiated with empty or null values.
     */
    public SongRecord(){
        title = null;
        artist = null;
        seconds = 0;
        minutes = 0;
    }

    /**
     * Gets the title of the SongRecord
     * @return
     * The return value is the String name of the song
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the SongRecord to the given String title
     * @param title - title of the song for this SongRecord
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the String name of the artist of this SongRecord
     * @return
     * The return value is the String name of the artist for this SongRecord
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Sets the artist of the SongRecord to the given String artist
     * @param artist - title of the artist for this SongRecord
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * Gets the int amount of minutes in the song of this SongRecord
     * @return
     * Returns the int value of the amount of minutes in this SongRecord
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Sets the int amount of minutes in the song for this SongRecord
     * @param minutes - amount of minutes in the song
     *
     * Throws:
     * IllegalArgumentException - Indicates that the minutes is not positive.
     */
    public void setMinutes(int minutes) {
        try{
            if(minutes < 0)
                throw new IllegalArgumentException("Minutes must be positive");
            this.minutes = minutes;
        }
        catch (IllegalArgumentException e){
        }
    }

    /**
     * Gets the amount of seconds in the song for this SongRecord
     * @return
     * The return value is the amount of seconds after after minutes in this
     * SongRecord
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * Sets the amount of seconds after minutes in the song
     * @param seconds - amount of seconds left in the song after minutes
     *
     * Precondition:
     * The parameter seconds must be between 0 and 59
     *
     * Throws:
     * IllegalArgumentException - Indicates that seconds is not within the range 0 - 59
     */
    public void setSeconds(int seconds) {
        try {
            if((seconds < 0) || (seconds > 59))
                throw new IllegalArgumentException("Seconds must be 0 - 59");
            this.seconds = seconds;
        }
        catch (IllegalArgumentException e){
        }
    }

    /**
     * Creates a deep copy of this SongRecord
     * @return
     * The return value is a copy of this SongRecord. Future
     * changes to the copy will not affect the original, and
     * vice versa. Return value must be typecast to a
     * SongRecord before it can be used.
     */
    public Object clone(){
        SongRecord clone = new SongRecord();
        clone.setTitle(title);
        clone.setArtist(artist);
        clone.setSeconds(seconds);
        clone.setMinutes(minutes);
        return clone;
    }

    /**
     * Compares two SongRecord objects and returns whether the contents of
     * the two objects are the same
     * @param compare - the second SongRecord object to be compared
     * @return
     * The return value is true if the contents of both SongRecords are the same
     * and false if any value is not the same
     */
    public boolean equals(SongRecord compare){
        if(compare.getArtist().equals(getArtist()) &&
                compare.getTitle().equals(getTitle()) &&
                (compare.getMinutes() == getMinutes()) &&
                (compare.getSeconds() == getSeconds()))
            return true;
        return false;
    }
    /**
     * Gets the string representation of the SongRecord in a neatly formatted fashion
     * @return
     * The value returned is the String representation of the SongRecord object
     */
    @Override
    public String toString() {
        if(title == null || artist == null)
            return "";
        return String.format("%-26s%-26s%7d:%02d",artist,title,minutes,seconds);
    }
}
