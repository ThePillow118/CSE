import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.Scanner;

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
        Scanner in = new Scanner(System.in);
        try{
            FileInputStream file = new FileInputStream("myMailbox.obj");
            ObjectInputStream fin = new ObjectInputStream(file);
            mailbox = (Mailbox) fin.readObject();
            file.close();
        }
        catch(IOException e){}
        catch(ClassNotFoundException c){}
        if(mailbox == null) {
            System.out.println("No previous mailbox found, creating a new one.");
            mailbox = new Mailbox();
        }
        System.out.println(mailbox.toString());
        String choice = "";
        boolean quit = false;
        while(quit){
            printMailboxMenu();
            System.out.println("Enter an option: ");
            switch (choice.toUpperCase().charAt(0)){
                case 'A':
                    try {
                        System.out.println("Enter folder name: ");
                        String folderName = in.nextLine();
                        mailbox.addFolder(new Folder(folderName));
                    }
                    catch(ExistingFolderException e){
                        System.out.println("A folder with that name already exists.");
                    }
                    break;
                case 'R':
                    System.out.println("Enter folder name: ");
                    String folderName = in.nextLine();
                    mailbox.deleteFolder(folderName);
                    break;
                case'C':
                    mailbox.composeEmail();
                    break;
                case'F':
                    System.out.println("Enter folder name: ");
                    String folder = in.nextLine();
                    boolean inFolder = true;
                    Folder currentFolder = mailbox.getFolder(folder);
                    if(currentFolder == null){
                        System.out.println("The given folder name does not exist.");
                    }
                    else {
                        while (inFolder) {
                            System.out.println(currentFolder.getName());
                            printFolderMenu();
                            System.out.println("Enter an option: ");
                            String folderChoice = "";
                            switch (folderChoice.toUpperCase()) {
                                case "M":
                                    System.out.println("Enter the index of the email to move: ");
                                    int index = in.nextInt();
                                    System.out.println("Folders");
                                    break;
                                case "D":
                                    break;
                                case "V":
                                    break;
                                case "SA":
                                    break;
                                case "SD":
                                    break;
                                case "DA":
                                    break;
                                case "DD":
                                    break;
                                case "R":
                                    inFolder = false;
                                    break;
                                default:
                                    System.out.println("Enter a valid choice from the menu.");
                                    break;
                            }
                        }
                    }

                    break;
                case'I':

                    break;
                case'T':
                    break;
                case'E':
                    mailbox.clearTrash();
                    break;
                case'Q':
                    System.out.println("Thanks for using this Mailbox service!");
                    quit = true;
                    break;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }
        try{
            FileOutputStream file = new FileOutputStream("myMailbox.obj");
            ObjectOutputStream fout = new ObjectOutputStream(file);
            fout.close();
        }catch(IOException e){
            System.out.println("ERROR");
        }
    }

    public Mailbox() {
        folders = new ArrayList<Folder>();
        inbox = new Folder("Inbox");
        trash = new Folder("Trash");
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
            for(int i = 0; i <= folders.size();i++){
                if(i == folders.size()){
                    System.out.println("Folder not found.");
                    break;
                }
                if(folders.get(i).getName().equals(name)) {
                    folders.remove(i);
                    break;
                }
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

    public void deleteEmail(Email email)throws IllegalArgumentException{
        moveEmail(email,trash);
    }

    /**
     * Removes all emails from the trash folder
     */
    public void clearTrash(){
        trash.getEmails().clear();
    }


    public void moveEmail(Email email,Folder target)throws IllegalArgumentException{
        if(target == null || email == null)
            throw new IllegalArgumentException();
        else{
            if(folders.indexOf(target) == -1) {
                System.out.println("Folder not found.");

            }
            else{
                target.addEmail(email);
            }
        }
    }

    public Folder getFolder(String name) throws IllegalArgumentException{
        Folder answer = null;
        if(name == null) {
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < folders.size();i++){
            if(folders.get(i).getName().equals(name)) {
                answer = folders.get(i);
                break;
            }

        }
        return answer;
    }

    public static void printFolderMenu(){
        System.out.println("M - Move Email\nD - Delete Email\nV - View email contents" +
                "\nSA - Sort by subject in ascending order\nSD - Sort by subject in descending order" +
                "\nDA - Sort by date in ascending order\nDD - Sort by date in descending order\nR - Return to mailbox");
    }

    public static void printMailboxMenu(){
        System.out.println("A - Add Folder\nR - Remove Folder\nC - Compose Email\nF - Open Folder\nI - Open Inbox" +
                "\nT - Open Trash\nQ - Quit");
    }

    public String toString(){
        String answer = "Mailbox:\n--------\n"+inbox.getName()+"\n"+trash.getName();
        for(int i =0;i < folders.size();i++){
            answer += ("\n" + folders.get(i).getName());
        }
        return answer;
    }
}
