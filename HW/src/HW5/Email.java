import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Comparator;

/**
 * @author
 * Joseph Winicki, SBU ID: 110505644
 * Assignment:
 * Homework #5 for CSE 214, Summer 2018
 * Date:
 * August 8th 2018
 *
 *
 * This class is to be used in the Mailbox class and is used to create new emails that are composed by the user
 **/
public class Email implements Serializable {
    private String to, cc, bcc, subject, body;
    private GregorianCalendar timestamp;

    /**
     * Creates a new instance of the Email object with the "to", "cc", "bcc", "subject", and "body" fields set to the
     * inputted Strings as well as gets the current time and stores it in timestamp.
     * @param to - the contact(s) for the "to" field
     * @param cc - the contact(s) for the "cc" field
     * @param bcc - the contact(s) for the "bcc" field
     * @param subject - the title or "subject" for this Email
     * @param body - all of the text in the body of this Email
     */
    public Email(String to, String cc, String bcc, String subject, String body) {
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.subject = subject;
        this.body = body;
        timestamp = new GregorianCalendar();
    }

    /**
     * Gets the string literal that stores the "to" field
     * @return
     * Returns the string value of the "to" field
     */
    public String getTo() {
        return to;
    }

    /**
     * Changes the "to" field of this Email object
     * @param to - the new String to replace this "to" field
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * Gets the string literal that stores the "cc" field
     * @return
     * Returns the string value of the "cc" field
     */
    public String getCc() {
        return cc;
    }


    /**
     * Changes the "cc" field of this Email object
     * @param cc - the new String to replace this "cc" field
     */
    public void setCc(String cc) {
        this.cc = cc;
    }

    /**
     * Gets the string literal that stores the "bcc" field
     * @return
     * Returns the string value of the "bcc" field
     */
    public String getBcc() {
        return bcc;
    }

    /**
     * Changes the "bcc" field of this Email object
     * @param bcc - the new String to replace this "bcc" field
     */
    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    /**
     * Gets the string literal that stores the "subject" field
     * @return
     * Returns the string value of the "subject" field
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Changes the "subject" field of this Email object
     * @param subject - the new String to replace this "subject" field
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Gets the string literal that stores all the text in the email's body
     * @return
     * Returns the string value of the "cc" field
     */
    public String getBody() {
        return body;
    }

    /**
     * Changes the "body" field of this Email object
     * @param body - the new String to replace this "body" field
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Gets the time that this email was created
     * @return
     * Returns the timestamp of which this email was created
     */
    public GregorianCalendar getTimestamp() {
        return timestamp;
    }

    /**
     * Changes the timestamp of this Email object
     * @param timestamp - new timestamp for this Email object
     */
    public void setTimestamp(GregorianCalendar timestamp) {
        this.timestamp = timestamp;
    }

    /**
     *
     */
    public static Comparator<Email> EmailsSubjectComparatorDescending = new Comparator<Email>() {
        @Override
        public int compare(Email o1, Email o2) {
            String subject1 = o1.getSubject();
            String subject2 = o2.getSubject();

            return subject1.compareTo(subject2);
        }
    };

    public static Comparator<Email> EmailsSubjectComparatorAscending = new Comparator<Email>() {
        @Override
        public int compare(Email o1, Email o2) {
            String subject1 = o1.getSubject();
            String subject2 = o2.getSubject();

            return subject2.compareTo(subject1);
        }
    };


    public static Comparator<Email> EmailsTimestampComparatorDescending = new Comparator<Email>() {
        @Override
        public int compare(Email o1, Email o2) {
            GregorianCalendar timestamp1 = o1.getTimestamp();
            GregorianCalendar timestamp2= o2.getTimestamp();

            return timestamp1.compareTo(timestamp2);
        }
    };


    public static Comparator<Email> EmailsTimestampComparatorAscending = new Comparator<Email>() {
        @Override
        public int compare(Email o1, Email o2) {
            GregorianCalendar timestamp1 = o1.getTimestamp();
            GregorianCalendar timestamp2= o2.getTimestamp();

            return timestamp2.compareTo(timestamp1);
        }
    };

    public String formatCal(){
        SimpleDateFormat format = new SimpleDateFormat();
        format.setCalendar(timestamp);
        return format.toString();
    }

    @Override
    public String toString() {
        return String.format("%3| %3s | %3s",timestamp.toString(),subject);
    }
}
