package softStructure.threeCS.presentation;

import softStructure.threeCS.businesslogic.BusinessLogic;

import java.util.Scanner;

public class UserInterface {
    private BusinessLogic businessLogic;

    public UserInterface() {
        businessLogic = new BusinessLogic();
    }

    public void displayMenu() {
        System.out.println("Personal Contact Management System");
        System.out.println("1. Add Contact");
        System.out.println("2. Update Contact");
        System.out.println("3. Delete Contact");
        System.out.println("4. Display Contact List");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    public void processUserInput() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addContact(scanner);
                    break;
                case 2:
                    updateContact(scanner);
                    break;
                case 3:
                    deleteContact(scanner);
                    break;
                case 4:
                    displayContactList();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);
    }

    private void addContact(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        boolean success = businessLogic.addContact(name, address, phoneNumber);
        if (success) {
            System.out.println("Contact added successfully.");
        } else {
            System.out.println("Failed to add contact.");
        }
    }

    private void updateContact(Scanner scanner) {
        System.out.print("Enter name of the contact to update: ");
        String name = scanner.nextLine();
        System.out.print("Enter new address: ");
        String address = scanner.nextLine();
        System.out.print("Enter new phone number: ");
        String phoneNumber = scanner.nextLine();

        boolean success = businessLogic.updateContact(name, address, phoneNumber);
        if (success) {
            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Failed to update contact.");
        }
    }

    private void deleteContact(Scanner scanner) {
        System.out.print("Enter name of the contact to delete: ");
        String name = scanner.nextLine();

        boolean success = businessLogic.deleteContact(name);
        if (success) {
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Failed to delete contact.");
        }
    }

    private void displayContactList() {
        String[] contacts = businessLogic.getContactList();
        if (contacts.length > 0) {
            System.out.println("Contact List:");
            for (String contact : contacts) {
                System.out.println(contact);
            }
        } else {
            System.out.println("No contacts found.");
        }
    }

    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        userInterface.processUserInput();
    }
}

