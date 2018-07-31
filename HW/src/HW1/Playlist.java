/**
 * The Playlist class implements an abstract data type for a playlist of audio
 * files supporting common operations on such lists of audio files. It implements
 * an array of SongRecord objects in order to do so.
 * @author
 *    Joseph Winicki, USB ID #110505644
 * Assignment:
 *    Homework #1 for CSE 214, Summer 2018
 * Date:
 *    July 16th, 2018
 */
public class Playlist implements Cloneable{

    public final int MAX_SONGS = 50;
    private SongRecord[] songList;
    private int sizeCounter = 0;
    private String name;

    /**
     * Constructs an instance of the Playlist class with no
     * SongRecord objects in it and a name
     *
     * Postcondition:
     * This Playlist has been initialized to an empty list
     * of SongRecords and has a String name given to it
     */
    public Playlist(String name){
        this.songList = new SongRecord[MAX_SONGS];
        this.name = name;
        for(int i = 0; i < MAX_SONGS; i++)
            songList[i] = new SongRecord();
        sizeCounter = 0;
    }

    /**
     * Gets the name of this Playlist
     * @return
     * Return value is the String name of this Playlist
     */
    public String getName() {
        return name;
    }

    /**
     * Changes the name of this Playlist to a given name
     * @param name - name to change this Playlist's name to
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value of the sizeCounter which is the amount of
     * SongRecords in this Playlist
     * @return
     * Returns an int value of the number of SongRecords in this
     * Playlist
     */
    public int getSizeCounter() {
        return sizeCounter;
    }

    /**
     * Generates a copy of this Playlist
     * @return
     * The return value is a copy of this Playlist. Future
     * changes to the copy will not affect the original, and
     * vice versa. Return value must be typecast to a
     * Playlist before it can be used.
     */

    public Object clone(){
        Playlist cloned = new Playlist(this.name);
        cloned.sizeCounter = sizeCounter;
        int index = 0;
        while(index < sizeCounter && songList[index] != null){
            cloned.songList[index] = songList[index];
            index++;
        }
        return cloned;
    }

    /**
     * Compares this Playlist to another object for equality
     * @param
     * obj - an object in which this Playlist is compared
     * @return
     * Returns a value of true if the obj refers to a Playlist
     * object with the same SongRecords in the same order as
     * this Playlist. Otherwise, the return value is false.
     */
    public boolean equals(Object obj){
        if(obj instanceof Playlist) {
            Playlist list  = (Playlist) obj;
            if(list.sizeCounter != sizeCounter)
                return false;
            for(int i = 0; i < list.sizeCounter;i++){
                if(!list.songList[i].equals(songList[i])){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Determines the number of SongRecords currently in
     * this Playlist.
     *
     * Preconditions:
     * This Playlist object has been instantiated.
     * @return
     * The return value is the number of SongRecords in
     * this Playlist
     */
    public int size(){
        return sizeCounter;
    }

    /**
     * Adds a song to this Playlist at a specific given position
     * @param
     * song - the new SongRecord object to add to this
     * Playlist
     * @param
     * position - the position in in the Playlist where the
     * song will be inserted
     *
     * Preconditions:
     * The SongRecord object has been instantiated and 1 <= position <=
     * songs_currently_in_playlist + 1. The number of SongRecord objects
     * in this Playlist is less than max_songs.
     *
     * Postcondition:
     * The new SongRecord is now stored at the desired position in the Playlist
     * All SongRecords that were originally in positions greater than or equal
     * to position are moved back one position. (Ex: If there are 5 songs in
     * a Playlist, positions 1 - 5, and you insert a new SongRecord at position
     * 4, the new SongRecord will now be at position 4, the SongRecord that was
     * at position 4 will be moved to position 5, and the SongRecord at position
     * 5 will now be moved to position 6).
     *
     * Throws:
     * IllegalArgumentException -
     * Indicates that the position is not within the valid range.
     *
     * FullPlaylistException -
     * Indicates that there is no more room inside of the Playlist to
     * store the new SongRecord object.
     */
    public void addSong(SongRecord song, int position){
        try {
            if (sizeCounter >= MAX_SONGS)
                throw new FullPlaylistException();
            else if(position < 1 || position > 50)
                throw new IllegalArgumentException();
            else if(position > 1 && position > sizeCounter+1)
                throw new IllegalArgumentException();
           else {
                for (int i = sizeCounter; i > position - 1; i--) {
                    if (i >= MAX_SONGS)
                        throw new IllegalArgumentException();
                    songList[i] = songList[i - 1];
                }
                songList[position - 1] = song;
                sizeCounter += 1;
            }
        }
        catch(FullPlaylistException e){
            System.out.println("The playlist is full.");
        }
        catch(IllegalArgumentException e){
            System.out.println("The position given is not valid for adding a song.");
        }

    }

    /**
     * Removes a SongRecord from this Playlist at a specific position
     * @param
     * position - the position in the Playlist where the song will be removed
     *          from
     *
     * Preconditions:
     * This SongRecord object has been instantiated and 1<= position <=
     * songs_currently_in_playlist
     *
     * Postcondition:
     * The SongRecord at the desired position in the Playlist has been removed.
     * All SongRecords that were originally in positions greater than or equal
     * to position are moved forward one position. (Ex: If there are 5 songs in
     * a Playlist, positions 1 - 5, and you remove the SongRecord at position 4,
     * the SongRecord that was at position 5 will be moved to position 4).
     *
     * Throws:
     * IllegalArgumentException - Indicates that position is not within the valid
     *          range
     */
    public void removeSong(int position){
        try {
            if(position < 1 || position > 50 || position > sizeCounter)
                throw new IllegalArgumentException();
            for(int i = sizeCounter-1; i > position -1;i--){
                if(i >= MAX_SONGS)
                    break;
                songList[i-1] = songList[i];
            }
            sizeCounter -= 1;
        }
        catch(IllegalArgumentException e){
            System.out.println("The position given is not valid for removing a song.");
        }
    }

    /**
     * Checks the Playlist to see if songList is empty and if it is returns a
     * value of true. Otherwise returns a value of false
     * @return
     * The return value is true if the songList is empty and true if it is not
     * empty
     */
    public boolean isEmpty(){
        if(songList[0] == null)
            return true;
        return false;
    }

    /**
     * Gets the SongRecord at the given position in this Playlist object
     * @param
     * position - position of the SongRecord to retrieve
     * @return
     * The SongRecord at the specified position in this Playlist object is the
     * return value
     *
     * Preconditions:
     * This Playlist object has been instantiated and 1 <= position <=
     * songs_currently_in_playlist
     *
     * Throws:
     * IllegalArgumentException - Indicates that the position is not within the
     * valid range
     */
    public SongRecord getSong(int position){
            try{
                if(position > 50 || position < 1)
                    throw new IllegalArgumentException();

                else if(this.songList[position -1] == null)
                        throw new IllegalArgumentException();
                else{
                    return songList[position -1];
                }
            }
            catch (IllegalArgumentException e){
                System.out.println("That position does not exist. Please try again.");
                return null;
            }

    }


    /**
     * Prints a neatly formatted table of each SongRecord in the Playlist on its
     * own line with its position number
     *
     * Preconditions:
     * This Playlist object has been instantiated.
     *
     * Postconditions:
     * A neatly formatted table of each SongRecord in the Playlist on its own line
     * with its position number has been displayed to the user.
     */
    public void printAllSongs(){
        System.out.println(toString());
    }

    /**
     * Generates a new Playlist containing all SongRecords in the original Playlist
     * performed by the specified artist.
     * @param
     * originalList - the original Playlist
     * @param
     * artist - the name of the artist
     * @return
     * The return value is a Playlist object containing all SongRecords in the
     * original Playlist performed by the specified artist.
     */
    public static Playlist getSongsByArtist(Playlist originalList, String artist){
        if(originalList == null || artist == null)
            return null;
        Playlist byArtist = new Playlist("");
        int length = originalList.sizeCounter, pos = 0;
        for(int i = 0; i < length;i++ ){
           if(originalList.songList[i].getArtist().equals(artist)) {
               byArtist.addSong(originalList.songList[i],pos+1);
               pos++;
           }
        }
        return byArtist;
    }

    /**
     * Gets the String representation of this Playlist object, which is a neatly
     * formatted table of each SongRecord in the Playlist on its own line with its
     * position number
     *
     * @return
     * The value returned is the String representation of this Playlist object.
     */
    @Override
    public String toString(){
        String answer;
        answer = String.format("%-10s%-26s%-26s%10s\n","Song#","Artist","Title",
                "Time");
        answer += "-------------------------------------------------------------------------\n";
        for(int i = 0; i < sizeCounter;i++){
            answer += (String.format("%-10d",(i +1)) + songList[i].toString() + "\n");
        }
        return answer;
    }

}
