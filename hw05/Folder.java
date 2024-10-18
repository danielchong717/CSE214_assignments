package hw05;

import java.util.ArrayList;
import java.util.*;
/**
 * This hw05.Folder class implements an email folder and will handle all the logic for adding and removing emails.
 *
 *
 * @author Daniel Chong
 * email: daniel.chong@stonybrook.edu
 * Stony Brook ID: 115715024
 */
public class Folder {
    private ArrayList<Email> emails;
    private String name;
    private String currentSortingMethod;
    private DateComparator dateComparator = new DateComparator();
    private SubjectComparator subjectComparator = new SubjectComparator();
    /**
     * Default constructor of the class hw05.Folder.
     */
    public Folder() {
        name = "";
        currentSortingMethod = "";
        emails = new ArrayList<>();
    }
    /**
     * Returns the total count of emails in this folder.
     * @return
     * An int value of the total amount of emails.
     */
    public int totalEmails() {
        return emails.size();
    }
    /**
     * Returns the String value stored in the variable name.
     * @return
     * String value to be returned.
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the folder name of this hw05.Folder class.
     * @param name
     * String value to be assigned to.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Returns the email with the given int index in the ArrayList<hw05.Email> emails.
     * @param index
     * The hw05.Email object's index on the emails array list to be returned.
     * @return
     * An hw05.Email object of the index.
     */
    public Email getEmail(int index) {
        return emails.get(index);
    }
    /**
     * Adds an email to the folder according to the current sorting method.
     * @param email
     * hw05.Email email to be added.
     */
    public void addEmail(Email email) {
        emails.add(email);
    }
    /**
     * Removes an email from the folder by index.
     * @param index
     * int value that represents the index of the email that is to be removed.
     * @return
     * The email object that was removed.
     */
    public Email removeEmail(int index) {
        if (index > -1 && index < emails.size()) {
            return emails.remove(index);
        }
        return null;
    }
    /**
     * Sorts the emails alphabetically by subject in ascending order.
     */
    public void sortBySubjectAscending() {
        Collections.sort(emails, subjectComparator);
    }
    /**
     * Sorts the emails alphabetically by subject in descending order.
     */
    public void sortBySubjectDescending() {
        Collections.sort(emails, subjectComparator.reversed());
    }
    /**
     * Sorts the emails by date in ascending order.
     */
    public void sortByDateAscending() {
        Collections.sort(emails, dateComparator);
    }
    /**
     * Sorts the emails by date in descending order.
     */
    public void sortByDateDescending() {
        Collections.sort(emails, dateComparator.reversed());
    }
}
