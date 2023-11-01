package softStructure.threeCS.dataaccess;

import softStructure.threeCS.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class DataAccess {
    private List<Contact> contacts;

    public DataAccess() {
        contacts = new ArrayList<>();
    }

    public boolean addContact(Contact contact) {
        return contacts.add(contact);
    }

    public boolean updateContact(Contact updatedContact) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(updatedContact.getName())) {
                contact.setAddress(updatedContact.getAddress());
                contact.setPhoneNumber(updatedContact.getPhoneNumber());
                return true;
            }
        }
        return false;
    }

    public boolean deleteContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                return contacts.remove(contact);
            }
        }
        return false;
    }

    public String[] getContactList() {
        String[] contactList = new String[contacts.size()];
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            contactList[i] = "Name: " + contact.getName() +
                    ", Address: " + contact.getAddress() +
                    ", Phone Number: " + contact.getPhoneNumber();
        }
        return contactList;
    }
}

