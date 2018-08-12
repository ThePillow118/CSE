import java.io.Serializable;
import java.util.ArrayList;
import java.io.Serializable;
/**
 * @author
 * Joseph Winicki, SBU ID: 110505644
 * Assignment:
 * Homework #5 for CSE 214, Summer 2018
 * Date:
 * August 8th 2018
 *
 **/
public class Mailbox implements Serializable {
    private Folder inbox, trash;
    public static Mailbox mailbox;
    private ArrayList<Folder> folders;

    public static void main(String[] args){
        Folder newFolder = new Folder("Inbox");
        newFolder.getEmails().add(new Email("Me","","","Drugs","My Drogas"));
        newFolder.getEmails().add(new Email("Me","","","Me","My Drogas"));
        newFolder.getEmails().add(new Email("Me","","","Songs","My Drogas"));
        newFolder.getEmails().add(new Email("Me","","","Aoki","My Drogas"));
        System.out.println(newFolder.toString());
    }

    public void addFolder(Folder folder){

    }

    public void deleteFolder(String name){

    }

    public void composeEmail(){

    }

    public void deleteEmail(Email email){

    }

    /**
     * Removes all emails from the trash folder
     */
    public void clearTrash(){
        trash.getEmails().clear();
    }


    public void moveEmail(){

    }

    public Folder getFolder(){
        return null;
    }
}
