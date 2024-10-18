package hw05;

import java.io.*;
import java.util.ArrayList;
import java.util.*;
/**
 * This hw05.Mailbox class implements an email box, and it will contain all the folders and the remaining logic. It contains the following data values: inbox, trash, folders, and mailbox.
 *
 *
 * @author Daniel Chong
 * email: daniel.chong@stonybrook.edu
 * Stony Brook ID: 115715024
 */
public class Mailbox {
    private Folder inbox;
    private Folder trash;
    private ArrayList<Folder> folders;
    public static Mailbox mailbox;
    /**
     * Adds the given folder to the list of custom folders.
     * Note: check to make sure a folder with that given name does not already exist. If it does, return an error in some manner.
     * @param folder
     * hw05.Folder object to be added.
     */
    public void addFolder(Folder folder) {
        if (folder == null) {
            throw new NullPointerException("hw05.Folder is null.");
        }
        if (folders == null) {
            folders = new ArrayList<>();
        }
        folders.add(folder);
    }
    /**
     * Removes the given folder from the list of custom folders
     * @param name
     * String value of the folder to be deleted.
     */
    public void deleteFolder(String name) {
        for (Folder folder : folders) {
            if (folder.getName().equals(name)) {
                folders.remove(folder);
                System.out.println("hw05.Folder successfully deleted.");
                break;
            }
        }
    }

    /**
     * Gets user input on the contents of the email and adds it to the inbox.
     */
    public void composeEmail() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the email address this email is sent to: ");
        String to = in.nextLine();
        System.out.print("Enter the email address you would like this email to be cc'd with: ");
        String cc = in.nextLine();
        System.out.print("Enter the email address you would like this email to be bcc'd with: ");
        String bcc = in.nextLine();
        System.out.print("Enter the email's subject: ");
        String subject = in.nextLine();
        System.out.print("Enter the email's body: ");
        String body = in.nextLine();
        Email newEmail = new Email(to, cc, bcc, subject, body);
        inbox.addEmail(newEmail);
    }

    /**
     * Moves the email to the trash. (This method shouldn’t remove any emails from folders,
     * the method removeEmail should be called and then deleteEmail is called on the result)
     * @param email
     * hw05.Email object that is to be moved to trash.
     */
    public void deleteEmail(Email email) {
        for (Folder folder : folders) {
            for (int i = 0; i < folder.totalEmails(); i++) {
                Email deleted = folder.getEmail(i);
                if (email.equals(deleted)) {
                    folder.removeEmail(i);
                    trash.addEmail(deleted);
                    System.out.println("Successfully moved the email to trash");
                    break;
                }
            }
        }
        for (int i = 0; i < inbox.totalEmails(); i++) {
            Email deleted = inbox.getEmail(i);
            if (email.equals(deleted)) {
                inbox.removeEmail(i);
                trash.addEmail(deleted);
                System.out.println("Successfully moved the email to trash");
                break;
            }
        }
    }
    /**
     * Removes all emails from the trash folder.
     */
    public void clearTrash() {
        for (int i = 0; i < trash.totalEmails(); i++) {
            trash.removeEmail(trash.totalEmails() - 1);
        }
    }
    /**
     * Takes the given email and puts it in the given folder.
     * If the folder cannot be found, instead move it to the Inbox.
     * (Again, this method shouldn’t remove any emails from folders,
     * the method removeEmail should be called and then moveEmail is called on the result)
     * @param email
     * hw05.Email object to be put into.
     * @param target
     * The selected folder to be put into.
     */
    public void moveEmail(Email email, Folder target) {
        boolean found = false;
        if (email != null && target != null) {
            for (Folder folder : folders) {
                for (int i = 0; i < folder.totalEmails(); i++) {
                    if (email.equals(folder.getEmail(i))) {
                        Email moved = folder.removeEmail(i);
                        target.addEmail(moved);
                        found = true;
                        break;
                    }
                }
            }
        }
        else
            throw new NullPointerException("hw05.Email or the target folder, or both, are null.");
        if (!found)
            inbox.addEmail(email);
    }
    /**
     * Returns a folder by folder name.
     * @param name
     * String value of the name of the folder.
     * @return
     * The hw05.Folder object.
     */
    public Folder getFolder(String name) {
        for (Folder index : folders) {
            if (index.getName().equals(name))
                return index;
        }
        return null;
    }
    /**
     * Getter method for the list of custom folders.
     * @return
     * The ArrayList of hw05.Folder objects.
     */
    public ArrayList<Folder> getFolders() {
        return folders;
    }
    /**
     * The main method of this application.
     * @param args
     * All the inputs passed in this main method.
     */
    public static void main(String args[]) {
        try {
            FileInputStream file = new FileInputStream("mailbox.obj");
            ObjectInputStream fin = new ObjectInputStream(file);
            mailbox = (Mailbox) fin.readObject();
            file.close();
        }
        catch(IOException a){
            System.out.println("Previous save not found, starting with an empty mailbox.");
            mailbox = new Mailbox();
            mailbox.inbox = new Folder();
            mailbox.trash = new Folder();
        }
        catch(ClassNotFoundException c){
            System.out.println("Previous save not found, starting with an empty mailbox.");
            mailbox = new Mailbox();
            mailbox.inbox = new Folder();
            mailbox.trash = new Folder();
        }
        Scanner in = new Scanner(System.in);
        String choice = "";
        while (!choice.equals("Q")) {
            System.out.println("\nhw05.Mailbox:\n--------\nInbox\nTrash");
            if (mailbox.getFolders() != null) {
                for (Folder folder : mailbox.getFolders()) {
                    if (folder != null) {
                        System.out.println(folder.getName());
                    }
                }
            }
            System.out.println("\nA - Add folder\nR - Remove folder\nC - Compose email\nF - Open folder\nI - Open Inbox\nT - Open Trash\nQ - Quit\n");
            System.out.print("Enter a user option: ");
            choice = in.nextLine();
            System.out.println();
            String folderName;
            Folder folder;
            Email email;
            switch (choice) {
                case("A"):System.out.print("Enter folder name: "); folderName = in.nextLine(); folder = new Folder(); folder.setName(folderName); mailbox.addFolder(folder); break;
                case("R"):System.out.print("Enter folder name: "); folderName = in.nextLine(); mailbox.deleteFolder(folderName); break;
                case("C"):System.out.print("Enter recipient (To): "); String toEmail = in.nextLine(); System.out.print("Enter carbon copy recipients (CC): "); String ccEmail = in.nextLine(); System.out.print("\nEnter blind carbon copy recipients (BCC): "); String bccEmail = in.nextLine(); System.out.print("\nEnter subject line: "); String subject = in.nextLine(); System.out.print("\nEnter body: "); String body = in.nextLine(); email = new Email(toEmail, ccEmail, bccEmail, subject, body); mailbox.inbox.addEmail(email); System.out.println("hw05.Email successfully added to Inbox."); break;
                case("F"):
                    int index;
                    System.out.print("Enter folder name: ");
                    folderName = in.nextLine();
                    folder = mailbox.getFolder(folderName);
                    String folderChoice = "";
                    while (!folderChoice.equals("R")) {
                        if (folder == null) {
                            System.out.println("hw05.Folder not found.");
                            break;
                        }
                        else {
                            if (folder.totalEmails() == 0) {
                                System.out.println("\n" + folder.getName() + " is empty.");
                            }
                            else {
                                System.out.println(folder.getName() + "\n");
                                System.out.println("Index |        Time       | Subject\n-----------------------------------");
                                for (int i = 0; i < folder.totalEmails(); i++) {
                                    email = folder.getEmail(i);
                                    System.out.println("  " + (i + 1) + "   |  " + email.timePrint() + "| " + email.getSubject());
                                }
                                System.out.println();
                            }
                        }
                        System.out.println("\nM - Move email\nD - Delete email\nV - View email contents\nSA - Sort by subject line in ascending order\nSD - Sort by subject line in descending order\nDA - Sort by date in ascending order\nDD - Sort by date in descending order\nR - Return to mailbox\n");
                        System.out.print("Enter a user option: ");
                        folderChoice = in.nextLine();
                        System.out.println();
                        switch (folderChoice) {
                            case("M"):
                                System.out.print("Enter the index of the email to move: ");
                                index = in.nextInt();
                                if (index <= 0) {
                                    System.out.println("Invalid index.");
                                    break;
                                }
                                email = folder.getEmail(index - 1);
                                System.out.println("\nFolders:\nInbox\nTrash");
                                if (mailbox.getFolders() != null) {
                                    for (Folder g : mailbox.getFolders()) {
                                        if (g != null)
                                            System.out.println(g.getName());
                                    }
                                }
                                System.out.print("\nSelect a folder to move \"" + email.getSubject() + "\" to: ");
                                folderName = in.nextLine();
                                if (folder == null)
                                    System.out.println("Current folder is null.");
                                else if (mailbox.getFolder(folderName) == null)
                                    System.out.println("\"" + email.getSubject() + "\" cannot be moved to " + folderName + ".");
                                else if (folderName.equals("Inbox")) {
                                    mailbox.moveEmail(email, mailbox.inbox);
                                    System.out.println("\"" + email.getSubject() + "\" successfully moved to Inbox.");
                                }
                                else if (folderName.equals("Trash")) {
                                    mailbox.moveEmail(email, mailbox.trash);
                                    System.out.println("\"" + email.getSubject() + "\" successfully moved to Trash.");
                                }
                                else {
                                    mailbox.moveEmail(email, mailbox.getFolder(folderName));
                                    System.out.println("\"" + email.getSubject() + "\" successfully moved to " + folderName + ".");
                                }
                                break;
                            case("D"):
                                System.out.print("Enter email index: "); index = in.nextInt();
                                if (index <= 0 || index > mailbox.inbox.totalEmails()) {
                                    System.out.println("Invalid index.");
                                    break;
                                }
                                else
                                    mailbox.deleteEmail(folder.getEmail(index - 1));
                                break;
                            case("V"):
                                System.out.print("Enter email index: ");
                                index = in.nextInt();
                                System.out.println();
                                if (index <= 0 || index > folder.totalEmails())
                                    System.out.print("Invalid index.");
                                else {
                                    System.out.println("To: " + folder.getEmail(index - 1).getTo());
                                    System.out.println("CC " + folder.getEmail(index - 1).getCc());
                                    System.out.println("BCC " + folder.getEmail(index - 1).getBcc());
                                    System.out.println("Subject " + folder.getEmail(index - 1).getSubject());
                                    System.out.println(folder.getEmail(index - 1).getBody());
                                } break;
                            case("SA"): folder.sortBySubjectAscending(); break;
                            case("SD"): folder.sortBySubjectDescending(); break;
                            case("DA"): folder.sortByDateAscending(); break;
                            case("DD"): folder.sortByDateDescending(); break;
                        }
                        if (choice.equals("R"))
                            return;
                    }
                    break;
                case("I"):
                    String inboxChoice = "";
                    while (!inboxChoice.equals("R")) {
                        if (mailbox.inbox == null || mailbox.inbox.totalEmails() == 0)
                            System.out.println("Inbox is empty.");
                        else {
                            System.out.println("Inbox\n");
                            System.out.println("Index |        Time       | Subject\n-----------------------------------");
                            for (int i = 0; i < mailbox.inbox.totalEmails(); i++) {
                                email = mailbox.inbox.getEmail(i);
                                System.out.println("  " + (i + 1) + "   |  " + email.timePrint() + "| " + email.getSubject());
                            }
                        }
                        System.out.println("\nM - Move email\nD - Delete email\nV - View email contents\nSA - Sort by subject line in ascending order\nSD - Sort by subject line in descending order\nDA - Sort by date in ascending order\nDD - Sort by date in descending order\nR - Return to mailbox\n");
                        System.out.print("Enter a user option: ");
                        inboxChoice = in.nextLine();
                        System.out.println();
                        switch (inboxChoice) {
                            case("M"):
                                System.out.print("Enter the index of the email to move: "); index = in.nextInt();
                                if (index <= 0) {
                                    System.out.println("Invalid index.");
                                    break;
                                }
                                email = mailbox.inbox.getEmail(index - 1);
                                System.out.println("\nFolders:\nInbox\nTrash");
                                if (mailbox.getFolders() != null) {
                                    for (Folder g : mailbox.getFolders()) {
                                        if (g != null) {
                                            System.out.println(g.getName());
                                        }
                                    }
                                }
                                System.out.print("\nSelect a folder to move \"" + email.getSubject() + "\" to: ");
                                folderName = in.nextLine();
                                if (mailbox.inbox == null)
                                    System.out.println("Inbox is null.");
                                else if (folderName.equals("Inbox")) {
                                    mailbox.moveEmail(email, mailbox.inbox);
                                    System.out.println("\"" + email.getSubject() + "\" successfully moved to Inbox.");
                                }
                                else if (folderName.equals("Trash")) {
                                    mailbox.moveEmail(email, mailbox.trash);
                                    System.out.println("\"" + email.getSubject() + "\" successfully moved to Trash.");
                                }
                                else {
                                    mailbox.moveEmail(email, mailbox.getFolder(folderName));
                                    System.out.println("\"" + email.getSubject() + "\" successfully moved to " + folderName + ".");
                                }
                                break;
                            case("D"):
                                System.out.print("Enter email index: "); index = in.nextInt();
                                if (index <= 0 || index > mailbox.inbox.totalEmails()) {
                                    System.out.println("Invalid index.");
                                    break;
                                }
                                else
                                    mailbox.deleteEmail(mailbox.inbox.getEmail(index - 1));
                                break;
                            case("V"):
                                System.out.print("Enter email index: ");
                                index = in.nextInt();
                                System.out.println();
                                if (index <= 0 || index > mailbox.inbox.totalEmails())
                                    System.out.print("Invalid index.");
                                else {
                                    System.out.println("To: " + mailbox.inbox.getEmail(index - 1).getTo());
                                    System.out.println("CC " + mailbox.inbox.getEmail(index - 1).getCc());
                                    System.out.println("BCC " + mailbox.inbox.getEmail(index - 1).getBcc());
                                    System.out.println("Subject " + mailbox.inbox.getEmail(index - 1).getSubject());
                                    System.out.println(mailbox.inbox.getEmail(index - 1).getBody());
                                } break;
                            case("SA"): mailbox.inbox.sortBySubjectAscending(); break;
                            case("SD"): mailbox.inbox.sortBySubjectDescending(); break;
                            case("DA"): mailbox.inbox.sortByDateAscending(); break;
                            case("DD"): mailbox.inbox.sortByDateDescending(); break;
                        }
                        if (choice.equals("R"))
                            return;
                    }
                    break;
                case("T"):
                    String trashChoice = "";
                    while (!trashChoice.equals("R")) {
                        if (mailbox.trash == null || mailbox.trash.totalEmails() == 0)
                            System.out.println("Trash is empty.");
                        else {
                            System.out.println("Trash\n");
                            System.out.println("Index |        Time       | Subject\n-----------------------------------");
                            for (int i = 0; i < mailbox.trash.totalEmails(); i++) {
                                email = mailbox.trash.getEmail(i);
                                System.out.println("  " + (i + 1) + "   |  " + email.timePrint() + "| " + email.getSubject());
                            }
                        }
                        System.out.println("\nM - Move email\nD - Delete email\nV - View email contents\nSA - Sort by subject line in ascending order\nSD - Sort by subject line in descending order\nDA - Sort by date in ascending order\nDD - Sort by date in descending order\nR - Return to mailbox\n");
                        System.out.print("Enter a user option: ");
                        inboxChoice = in.nextLine();
                        System.out.println();
                        switch (inboxChoice) {
                            case("M"):
                                System.out.print("Enter the index of the email to move: "); index = in.nextInt();
                                if (index <= 0) {
                                    System.out.println("Invalid index.");
                                    break;
                                }
                                email = mailbox.trash.getEmail(index - 1);
                                System.out.println("\nFolders:\nInbox\nTrash");
                                if (mailbox.getFolders() != null) {
                                    for (Folder g : mailbox.getFolders()) {
                                        if (g != null) {
                                            System.out.println(g.getName());
                                        }
                                    }
                                }
                                System.out.print("\nSelect a folder to move \"" + email.getSubject() + "\" to: ");
                                folderName = in.nextLine();
                                if (mailbox.trash == null)
                                    System.out.println("Trash is null.");
                                else if (folderName.equals("Inbox")) {
                                    mailbox.moveEmail(email, mailbox.inbox);
                                    System.out.println("\"" + email.getSubject() + "\" successfully moved to Inbox.");
                                }
                                else if (folderName.equals("Trash")) {
                                    mailbox.moveEmail(email, mailbox.trash);
                                    System.out.println("\"" + email.getSubject() + "\" successfully moved to Trash.");
                                }
                                else {
                                    mailbox.moveEmail(email, mailbox.getFolder(folderName));
                                    System.out.println("\"" + email.getSubject() + "\" successfully moved to " + folderName + ".");
                                }
                                break;
                            case("D"):
                                System.out.print("Enter email index: "); index = in.nextInt();
                                if (index <= 0 || index > mailbox.trash.totalEmails()) {
                                    System.out.println("Invalid index.");
                                    break;
                                }
                                else
                                    mailbox.deleteEmail(mailbox.trash.getEmail(index - 1));
                                break;
                            case("V"):
                                System.out.print("Enter email index: ");
                                index = in.nextInt();
                                System.out.println();
                                if (index <= 0 || index > mailbox.trash.totalEmails())
                                    System.out.print("Invalid index.");
                                else {
                                    System.out.println("To: " + mailbox.trash.getEmail(index - 1).getTo());
                                    System.out.println("CC " + mailbox.trash.getEmail(index - 1).getCc());
                                    System.out.println("BCC " + mailbox.trash.getEmail(index - 1).getBcc());
                                    System.out.println("Subject " + mailbox.trash.getEmail(index - 1).getSubject());
                                    System.out.println(mailbox.trash.getEmail(index - 1).getBody());
                                } break;
                            case("SA"): mailbox.trash.sortBySubjectAscending(); break;
                            case("SD"): mailbox.trash.sortBySubjectDescending(); break;
                            case("DA"): mailbox.trash.sortByDateAscending(); break;
                            case("DD"): mailbox.trash.sortByDateDescending(); break;
                        }
                        if (choice.equals("R"))
                            return;
                    }
                    break;
            }
            if (choice.equals("Q"))
                break;
        }
        try {
            FileOutputStream file = new FileOutputStream("mySaveFile.obj");
            ObjectOutputStream fout = new ObjectOutputStream(file);
            fout.writeObject(mailbox);
            fout.close();
            System.out.println("Successfully saved mailbox to file.");
        }
        catch(IOException a) {
            System.out.println("Error, the save is unsuccessful.");
        }
    }
}
