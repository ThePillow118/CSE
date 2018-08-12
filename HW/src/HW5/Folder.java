import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author
 * Joseph Winicki, SBU ID: 110505644
 * Assignment:
 * Homework #5 for CSE 214, Summer 2018
 * Date:
 * August 8th 2018
 *
 * This class is used for storing Emails and handling them. Functions provided by this class include adding and removing
 * Emails from a certain folder as well as sorting them by date or subject in ascending or descending order.
 **/

public class Folder implements Serializable {
    private ArrayList<Email> emails;
    private String name,currentSortingMethod;

    public Folder(ArrayList<Email> emails, String name, String currentSortingMethod) {
        this.emails = emails;
        this.name = name;
        this.currentSortingMethod = currentSortingMethod;
    }

    public Folder(String name) {
        this.name = name;
        emails = new ArrayList<>();
    }

    /**
     * Gets this Folder's list of emails
     * @return
     * Returns the ArrayList of emails that are currently in this folder
     */
    public ArrayList<Email> getEmails() {
        return emails;
    }

    /**
     * Changes the list of emails inside this Folder
     * @param emails - new ArrayList to become the new list of Emails in this folder
     */
    public void setEmails(ArrayList<Email> emails) {
        this.emails = emails;
    }

    /**
     * Gets the String name of this folder
     * @return
     * Returns the name of this folder
     */
    public String getName() {
        return name;
    }

    /**
     * Changes the name of this Folder to the given name
     * @param name - new name for this Folder
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the current method of sorting for the emails inside this folder
     * @return
     * Returns the name of the sorting method currently being used to sort the folder
     */
    public String getCurrentSortingMethod() {
        return currentSortingMethod;
    }

    /**
     * Changes the sorting method for this Folder to the given sorting method
     * @param currentSortingMethod - the new sorting method for this folder
     */
    public void setCurrentSortingMethod(String currentSortingMethod) {
        this.currentSortingMethod = currentSortingMethod;
    }

    public void addEmail(Email email){

    }

    /**
     * Removes an email from this Folder
     * @param index - index of the Email to be removed
     * @return
     * Returns the email that is removed, but if the email is not found it returns a null value
     */
    public Email removeEmail(int index){
        Email email = emails.get(index);
        if(email == null)
            return null;
        else{
            emails.remove(index);
        }
        return email;
    }

    public void sortBySubjectAscending(){
        emails.sort(Email.EmailsSubjectComparatorAscending);
    }

    public void sortBySubjectDescending(){
        emails.sort(Email.EmailsSubjectComparatorDescending);
    }
    public void sortByDateAscending(){
        emails.sort(Email.EmailsTimestampComparatorAscending);
    }
    public void sortByDateDescending(){
        emails.sort(Email.EmailsTimestampComparatorDescending);
    }

    @Override
    public String toString(){
        String answer = "";
        for(int i = 0; i < emails.size();i++){
            String date = emails.get(i).getTimestamp().toString();
            answer += String.format("%n %d | %3s | %3s",i+1,emails.get(i).getTimestamp().toString(),emails.get(i).getSubject());
        }
       return answer;
    }
}
