package softStructure.threeCS;

// ContactServer.java
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ContactServer extends Remote {
    Contact[] getAllContacts() throws RemoteException;
    void addContact(Contact contact) throws RemoteException;
    void updateContact(Contact contact) throws RemoteException;
    void deleteContact(String name) throws RemoteException;
}

