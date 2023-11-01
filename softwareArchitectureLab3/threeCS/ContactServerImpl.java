package softStructure.threeCS;

// ContactServerImpl.java
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ContactServerImpl extends UnicastRemoteObject implements ContactServer {
    private ContactDAO contactDAO;

    public ContactServerImpl() throws RemoteException {
        contactDAO = new ContactDAOImpl();
    }

    @Override
    public Contact[] getAllContacts() throws RemoteException {
        List<Contact> contacts = contactDAO.getAllContacts();
        return contacts.toArray(new Contact[contacts.size()]);
    }

    @Override
    public void addContact(Contact contact) throws RemoteException {
        contactDAO.addContact(contact);
    }

    @Override
    public void updateContact(Contact contact) throws RemoteException {
        contactDAO.updateContact(contact);
    }

    @Override
    public void deleteContact(String name) throws RemoteException {
        contactDAO.deleteContact(name);
    }
}
