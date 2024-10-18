package hw05;

import java.util.Calendar;
import java.util.Comparator;
/**
 * This hw05.DateComparator class implements Comparator, with an overriden compare method that compares the date of the two emails.
 *
 *
 * @author Daniel Chong
 * email: daniel.chong@stonybrook.edu
 * Stony Brook ID: 115715024
 */
public class DateComparator implements Comparator {
    /**
     * An overriden compare method that returns 1 if the date of o1 is newer than o2, 0 if they are the same, and -1 if o1 is older than o2.
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return
     */
    public int compare(Object o1, Object o2) {
        Email email = (Email) o1;
        Email email2 = (Email) o2;
        if (email.getTimestamp().get(Calendar.YEAR) > email2.getTimestamp().get(Calendar.YEAR))
            return 1;
        else if (email.getTimestamp().get(Calendar.YEAR) < email2.getTimestamp().get(Calendar.YEAR))
            return -1;
        else if (email.getTimestamp().get(Calendar.MONTH) > email2.getTimestamp().get(Calendar.MONTH))
            return 1;
        else if (email.getTimestamp().get(Calendar.MONTH) < email2.getTimestamp().get(Calendar.MONTH))
            return -1;
        else if (email.getTimestamp().get(Calendar.DAY_OF_MONTH) > email2.getTimestamp().get(Calendar.DAY_OF_MONTH))
            return 1;
        else if (email.getTimestamp().get(Calendar.DAY_OF_MONTH) < email2.getTimestamp().get(Calendar.DAY_OF_MONTH))
            return -1;
        else if (email.getTimestamp().get(Calendar.HOUR_OF_DAY) > email2.getTimestamp().get(Calendar.HOUR_OF_DAY))
            return 1;
        else if (email.getTimestamp().get(Calendar.HOUR_OF_DAY) < email2.getTimestamp().get(Calendar.HOUR_OF_DAY))
            return -1;
        else if (email.getTimestamp().get(Calendar.MINUTE) > email2.getTimestamp().get(Calendar.MINUTE))
            return 1;
        else if (email.getTimestamp().get(Calendar.MINUTE) < email2.getTimestamp().get(Calendar.MINUTE))
            return -1;
        else if (email.getTimestamp().get(Calendar.SECOND) > email2.getTimestamp().get(Calendar.SECOND))
            return 1;
        else if (email.getTimestamp().get(Calendar.SECOND) < email2.getTimestamp().get(Calendar.SECOND))
            return -1;
        else
            return 0;
    }
}
