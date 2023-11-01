package softStructure.threeCS;

// ContactDAOImpl.java
import java.util.ArrayList;
import java.util.List;

public class ContactDAOImpl implements ContactDAO {
    private List<Contact> contacts;

    public ContactDAOImpl() {
        contacts = new ArrayList<>();
    }

    @Override
    public List<Contact> getAllContacts() {
        return contacts;
    }

    @Override
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public void updateContact(Contact contact) {
        for (Contact c : contacts) {
            if (c.getName().equals(contact.getName())) {
                c.setAddress(contact.getAddress());
                c.setPhoneNumber(contact.getPhoneNumber());
                break;
            }
        }
    }

    @Override
    public void deleteContact(String name) {
        for (Contact c : contacts) {
            if (c.getName().equals(name)) {
                contacts.remove(c);
                break;
            }
        }
    }
}

