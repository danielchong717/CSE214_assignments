package hw05;

import java.util.Comparator;
/**
 * This hw05.SubjectComparator class implements Comparator, with an overriden compare method that compares the Subject of the two emails.
 *
 *
 * @author Daniel Chong
 * email: daniel.chong@stonybrook.edu
 * Stony Brook ID: 115715024
 */
public class SubjectComparator implements Comparator {
    /**
     * Overrides the original compare method and compares the variable subject to see which one is the higher order alphabetically.
     * @param o1 the first email to be compared.
     * @param o2 the second email to be compared.
     * @return
     * An int value that represents if o1 is higher or o1 is lower.
     */
    @Override
    public int compare(Object o1, Object o2) {
        Email email = (Email) o1;
        Email email2 = (Email) o2;
        return (email.getSubject()).compareTo(email2.getSubject());
    }
}
