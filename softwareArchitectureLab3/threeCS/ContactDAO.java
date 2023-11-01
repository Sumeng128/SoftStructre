package softStructure.threeCS;

// ContactDAO.java
import java.util.ArrayList;
import java.util.List;

public interface ContactDAO {
    List<Contact> getAllContacts();
    void addContact(Contact contact);
    void updateContact(Contact contact);
    void deleteContact(String name);
}

