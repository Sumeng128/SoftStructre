package softStructure.threeCS;


// ContactServerMain.java
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ContactServerMain {
    public static void main(String[] args) {
        try {
            ContactServer contactServer = new ContactServerImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("//localhost/ContactServer", contactServer);
            System.out.println("Contact server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}