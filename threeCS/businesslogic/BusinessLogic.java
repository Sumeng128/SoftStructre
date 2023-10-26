package softStructure.threeCS.businesslogic;

import softStructure.threeCS.model.Contact;
import softStructure.threeCS.dataaccess.DataAccess;

public class BusinessLogic {
    private DataAccess dataAccess;

    public BusinessLogic() {
        dataAccess = new DataAccess();
    }

    public boolean addContact(String name, String address, String phoneNumber) {
        Contact contact = new Contact(name, address, phoneNumber);
        return dataAccess.addContact(contact);
    }

    public boolean updateContact(String name, String address, String phoneNumber) {
        Contact contact = new Contact(name, address, phoneNumber);
        return dataAccess.updateContact(contact);
    }

    public boolean deleteContact(String name) {
        return dataAccess.deleteContact(name);
    }

    public String[] getContactList() {
        return dataAccess.getContactList();
    }
}
