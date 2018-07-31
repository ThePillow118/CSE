/**
 * The PlaylistOperations Java application tests the methods of the Playlist class and
 * allows the user to maniuplate a single Playlist by performing operations on it. In
 * addition to this, the user can also create multiple playlists and switch between
 * managing each one.
 * @author
 *    Joseph Winicki, USB ID #110505644
 * Assignment:
 *    Homework #1 for CSE 214, Summer 2018
 * Date:
 *    July 16th, 2018
 */
import java.util.Scanner;

public class PlaylistOperations {

    /**
     * The main method that runs a menu drive application which first creates an empty
     * Playlist and then prompts the user to create a name for the Playlist. After the
     * name is given, it will continuously prompt the user for a menu command selecting
     * the operation. The required information is then requested from the user based on
     * the selected operation. Following is the list of menu options and their required
     * information:
     *
     * Add Song:                A <Title> <Artist> <Minutes> <Seconds> <Position>
     * Get Song:                G <Position>
     * Remove Song:             R <Position>
     * Print All Songs:         P
     * Print Songs By Artist:   B <Artist>
     * Size:                    S
     * Quit:                    Q
     * Copy Current Playlist:   C <NewPlaylistName>
     * Display All Playlist:    D
     * Compare Current Playlist:E <PlaylistToCompare>
     * Create a New Playlist    N <NewPlaylistName>
     * Change Current Playlist: V <PlaylistName>
     * @param args - arguments to be run by the program
     */
    public static void main(String[] args){
        int counter = 0;
        Playlist A = new Playlist("");
        Playlist[] playlists = new Playlist[1000];
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like the name of this Playlist to be? Include at least one character.");
        String name = input.nextLine();
        if(name.equals("")) {
            A.setName("");
            System.out.println("No input detected, name of Playlist is now \"\"");
        }
        else {
            A.setName(name);
            System.out.println("The name of this Playlist is " + name);
        }
        playlists[counter] = A;
        counter++;
        Playlist current = A;
        boolean stop = false;
        while(!stop){
            try {
                printMenu();
                String choice = input.nextLine().toUpperCase();
                if (choice.isEmpty()) {
                    throw new IllegalArgumentException();
                }

                switch (choice.charAt(0)) {
                    case 'A':
                        addSong(current);
                        break;

                    case 'B':
                        System.out.println("What is the name of the artist?");
                        Playlist.getSongsByArtist(A,input.nextLine()).printAllSongs();
                        break;

                    case 'C':
                        System.out.println("What would you like the new Playlist's name to be?");
                        String playName = input.nextLine();
                        Playlist newPlaylist = (Playlist) current.clone();
                        playlists[counter] = newPlaylist;
                        counter++;
                        newPlaylist.setName(playName);
                        System.out.println("Copied playlist " + current.getName() + " to playlist " + playName + ".");
                        break;

                    case 'D':
                        for(int i = 0; i < counter;i++){
                            System.out.printf("Position:%-10d Playlist Name:%s\n",i+1,playlists[i].getName());
                        }
                        break;

                    case 'E':
                        System.out.println("Which playlist would you like to compare?");
                        String compare = input.nextLine();
                        boolean same = false;
                        for(int i =0;i<counter;i++){
                            if(playlists[i].getName().equals(compare)){
                                same = current.equals(playlists[i]);
                            }
                        }
                        if(same)
                            System.out.println("The two playlists are the same.");
                        else if(!same)
                            System.out.println("The two playlists are have different songs.");
                        break;

                    case 'G':
                        System.out.println("Enter the position of the song: ");
                        int position = input.nextInt();
                        SongRecord song = current.getSong(position);
                        System.out.print(String.format("%-10s%-26s%-26s%10s\n","Song#","Artist","Title",
                                "Time"));
                        System.out.print("--------------------------------------------------------------" +
                                "-----------\n");
                        System.out.printf("%-10d%-26s",position,song.toString());
                        System.out.println();
                        input.nextLine();
                        break;

                    case 'N':
                        System.out.println("What would you like the new playlist's name to be?");
                        String newName = input.nextLine();
                        Playlist brandNewPlaylist = new Playlist("");
                        if(name.equals("")) {
                            brandNewPlaylist.setName("");
                            System.out.println("No input detected, name of new playlist is now \"\"");
                        }
                        else {
                            brandNewPlaylist.setName(newName);
                            System.out.println("Playlist "+ newName + " has been added and is now the current playlist.");
                        }
                        playlists[counter] = brandNewPlaylist;
                        counter++;
                        current = brandNewPlaylist;
                        break;

                    case 'R':
                        System.out.println("Enter the position: ");
                        int pos = input.nextInt();
                        if(current.getSizeCounter() < pos){
                            System.out.println("The position is not in the list.");
                            break;
                        }
                        else {
                            current.removeSong(pos);
                            System.out.println("Song removed at position: " + pos);
                        }
                        break;

                    case 'P':
                        current.printAllSongs();
                        break;

                    case 'S':
                        System.out.println("There are " + current.getSizeCounter() + " song(s) in this playlist.");
                        break;

                    case 'Q':
                        stop = true;
                        break;

                    case 'V':
                        System.out.println("What is the name of the playlist you want to change to?");
                        if(counter == 1) {
                            System.out.println("There is only one playlist.");
                            break;
                        }
                        int x = counter -1;
                        String switchName = input.nextLine();
                        while(x >= 0) {
                            if (playlists[x].getName().equals(switchName)){
                                current = playlists[x];
                                System.out.println("Current playlist changed to "+ switchName);
                                break;
                            }
                            x--;
                        }
                        if(x == -1)
                            System.out.println("Playlist name not found.");
                        break;

                    default:
                        System.out.println("Invalid input. Please try an input from the menu.");
                }
            }
            catch(IllegalArgumentException e){
                System.out.println("You must input at least one character.");
            }
        }
        System.out.println("Thanks for trying out the playlist maker!");

    }

    /**
     * Prints out the Menu listing the options for the user to choose from
     */
    public static void printMenu(){
        System.out.println("\nA) Add song\nB) Print Songs by Artist\nC) Copy current Playlist\n" +
                "D) Display all Playlists\nE) Compare current Playlist\nG) Get Song\n"+
                "N) Create a new Playlist\nR) Remove Song\nP) Print Every Song\nS) Size of Playlist\n" +
                "Q) Quit\nV) Change current playlist\n");
    }

    /**
     * Takes in input from the user for adding a song to the Playlist
     * @param playlist - Playlist to have a song added to it
     * @throws IllegalArgumentException - if there is an invalid time inputted an IllegalArgumentException
     * is thrown to prevent the user from adding an invalid SongRecord
     */
    public static void addSong(Playlist playlist){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter song title: ");
        String title = in.nextLine();
        System.out.println("Enter the song artist: ");
        String artist = in.nextLine();
        System.out.println("Enter the song length (minutes): ");
        int minutes = in.nextInt();
        System.out.println("Enter the song length (seconds): ");
        int secs = in.nextInt();
        System.out.println("Enter the position for the song to be added: ");
        int pos = in.nextInt();
        try {
            if(pos - 1 > playlist.getSizeCounter())
                throw new IllegalArgumentException();
            if (minutes >= 0 && (secs >= 0 && secs <= 59)) {
                SongRecord newSong = new SongRecord();
                newSong.setArtist(artist);
                newSong.setMinutes(minutes);
                newSong.setSeconds(secs);
                newSong.setTitle(title);
                playlist.addSong(newSong, pos);
                System.out.println("Added new song: " + title + " by " + artist);
            } else {
                throw new IllegalArgumentException();
            }
        }
        catch(IllegalArgumentException e){
            System.out.println("Invalid time or position for adding a new song.");
        }
    }
}
