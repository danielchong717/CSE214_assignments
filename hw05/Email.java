package hw05;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * This hw05.Email class implements the following information about each email: to, cc, bcc, subject, body, and timestamp.
 *
 *
 * @author Daniel Chong
 * email: daniel.chong@stonybrook.edu
 * Stony Brook ID: 115715024
 */
public class Email implements Serializable {
    private String to;
    private String cc;
    private String bcc;
    private String subject;
    private String body;
    private GregorianCalendar timestamp;

    /**
     * Default constructor of the email.
     * @param to
     * String value for the member variable to to be set to.
     * @param cc
     * String value for the member variable cc to be set to.
     * @param bcc
     * String value for the member variable bcc to be set to.
     * @param subject
     * String value for the member variable subject to be set to.
     * @param body
     * String value for the member variable body to be set to.
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
     * Helper method to make the printing of the time easier.
     * @return
     * A String value of the email's time.
     */
    public String timePrint() {
        String minute = String.valueOf(timestamp.get(Calendar.MINUTE)).substring(0, 2);
        String space = "";
        String AMPM = "";
        if (timestamp.get(Calendar.HOUR) > 10)
            space = space.substring(0, space.length() - 1);
        if (timestamp.get(Calendar.HOUR) < 10)
            space += " ";
        if (timestamp.get(Calendar.MONTH) > 10)
            space = space.substring(0, space.length() - 1);
        if (timestamp.get(Calendar.MONTH) < 10)
            space += " ";
        if (timestamp.get(Calendar.DAY_OF_MONTH) > 10)
            space = space.substring(0, space.length() - 1);
        if (timestamp.get(Calendar.DAY_OF_MONTH) < 10)
            space += " ";
        if (timestamp.get(Calendar.AM_PM) == 1)
            AMPM = "PM";
        else
            AMPM = "AM";
        return timestamp.get(Calendar.HOUR) + ":" + minute + AMPM + " " + timestamp.get(Calendar.MONTH) + "/" + timestamp.get(Calendar.DAY_OF_MONTH) + "/" + timestamp.get(Calendar.YEAR) + space;
    }

    /**
     * Getter method for the member variable to.
     * @return
     * String value stored in the member variable to of class hw05.Email.
     */
    public String getTo() {
        return to;
    }
    /**
     * Setter method for the member variable to.
     * @param to
     * String value for the member variable to to be set to in class hw05.Email.
     */
    public void setTo(String to) {
        this.to = to;
    }
    /**
     * Getter method for the member variable cc.
     * @return
     * String value stored in the member variable cc of class hw05.Email.
     */
    public String getCc() {
        return cc;
    }
    /**
     * Setter method for the member variable cc.
     * @param cc
     * String value for the member variable cc to be set to in class hw05.Email.
     */
    public void setCc(String cc) {
        this.cc = cc;
    }
    /**
     * Getter method for the member variable bcc.
     * @return
     * String value stored in the member variable bcc of class hw05.Email.
     */
    public String getBcc() {
        return bcc;
    }
    /**
     * Setter method for the member variable bcc.
     * @param bcc
     * String value for the member variable bcc to be set to in class hw05.Email.
     */
    public void setBcc(String bcc) {
        this.bcc = bcc;
    }
    /**
     * Getter method for the member variable subject.
     * @return
     * String value stored in the member variable subject of class hw05.Email.
     */
    public String getSubject() {
        return subject;
    }
    /**
     * Setter method for the member variable subject.
     * @param subject
     * String value for the member variable subject to be set to in class hw05.Email.
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }
    /**
     * Getter method for the member variable timestamp.
     * @return
     * GregorianCalendar object stored in the member variable timestamp of class hw05.Email.
     */
    public GregorianCalendar getTimestamp() {
        return timestamp;
    }

    /**
     * Setter method for the member variable timestamp.
     * @param timestamp
     * GregorianCalendar object for the member variable timestamp to be set to in class hw05.Email.
     */
    public void setTimestamp(GregorianCalendar timestamp) {
        this.timestamp = timestamp;
    }
    /**
     * Getter method for the member variable body.
     * @return
     * String value stored in the member variable body of class hw05.Email.
     */
    public String getBody() {
        return body;
    }
    /**
     * Setter method for the member variable body.
     * @param body
     * String value for the member variable body to be set to in class hw05.Email.
     */
    public void setBody(String body) {
        this.body = body;
    }
}
