import java.io.Serializable;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
        System.out.println("Date Ascending");
        newFolder.addEmail(new Email("Me","","","Drugs","My Drogas"));
        newFolder.addEmail(new Email("Me","","","Me","My Drogas"));
        newFolder.addEmail(new Email("Me","","","Songs","My Drogas"));
        newFolder.addEmail(new Email("Me","","","Aoki","My Drogas"));
        newFolder.sortByDateDescending();
        System.out.println(newFolder.toString());
        newFolder.setCurrentSortingMethod("Subject Descending");
        newFolder.sortBySubjectDescending();
        System.out.println("\nSubject Descending");
        System.out.println(newFolder.toString());
        newFolder.removeEmail(1);
        System.out.println(newFolder.toString());
    }

    public void addFolder(Folder folder) throws ExistingFolderException{
        for(int i = 0; i < folders.size();i++){
            if(folders.get(i).getName().equals(folder.getName()))
                throw new ExistingFolderException();
        }
        folders.add(folder);
    }

    public void deleteFolder(String name){
        if(folders.isEmpty())
            System.out.println("There are no folders to delete.");
        else{
            for(int i = 0; i < folders.size();i++){
                if(folders.get(i).getName().equals(name))
                    folders.remove(i);
            }
        }
    }

    public void composeEmail(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter recipient (To): ");
        String to = in.nextLine();
        System.out.println("Enter carbon copy recipients (CC): ");
        String cc = in.nextLine();
        System.out.println("Enter blind carbon copy recipients (BCC): ");
        String bcc = in.nextLine();
        System.out.println("Enter subject line: ");
        String subject  = in.nextLine();
        System.out.println("Enter body: ");
        String body  = in.nextLine();
        inbox.addEmail(new Email(to,cc,bcc,subject,body));
        System.out.println("Email successfully added.");
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
