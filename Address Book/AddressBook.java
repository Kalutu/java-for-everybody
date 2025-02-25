
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystemException;

public class AddressBook {

    static ArrayList<ContactAddress> contacts = new ArrayList<ContactAddress>();
    static Scanner input = new Scanner(System.in);

    public static void RunAddressBook(String[] args) {
        int choice;
        do {
            System.out.println("ADDRESS BOOK");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Add Contacts to file");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    getContactFile();
                    break;
                case 6:
                    System.out.println("Exiting Address Book...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    public static void getContactFile() {

        if (contacts.size() > 0) {

            FileWriter FW;

            try {

                FW = new FileWriter("Contacts.txt");

                contacts.forEach(contact -> {

                    try {
                        FW.write(contact + "\n \n");

                    } catch (IOException ex) {
                        System.out.println("Not able to add contact");
                    }

                });
                FW.close();
            } catch (IOException ex) {
                System.out.println("Cannot create file");
            }

        } else {
            System.out.println("No contacts to added to file");
        }

    }

    public static void addContact() {
        System.out.print("Enter name: ");
        String name = input.next();
        System.out.print("Enter address: ");
        String address = input.next();
        System.out.print("Enter phone number: ");
        String phone = input.next();
        System.out.print("Enter email: ");
        String email = input.next();
        ContactAddress c = new ContactAddress(name, address, phone, email);
        contacts.add(c);
        System.out.println("Contact added successfully!");
    }

    public static void viewContacts() {
        if (contacts.size() == 0) {
            System.out.println("No contacts found!");
            return;
        }
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("Contact " + (i + 1) + ":");
            System.out.println(contacts.get(i));
        }
    }

    public static void searchContact() {
        System.out.print("Enter name to search: ");
        String name = input.next();
        boolean found = false;
        for (ContactAddress c : contacts) {
            if (c.getName().equals(name)) {
                System.out.println("Contact details:");
                System.out.println(c);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found!");
        }
    }

    public static void deleteContact() {
        System.out.print("Enter name to delete: ");
        String name = input.next();
        boolean found = false;
        for (ContactAddress c : contacts) {
            if (c.getName().equals(name)) {
                contacts.remove(c);
                System.out.println("Contact deleted successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found!");
        }
    }
}

class ContactAddress {

    private String name;
    private String address;
    private String phone;
    private String email;

    public ContactAddress(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return "Name: " + name + "\nAddress: " + address
                + "\nPhone: " + phone + "\nEmail: " + email;
    }
}
