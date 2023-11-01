package example;

import example.client.CalTaxServiceLocator;
import example.client.CalTax_PortType;

import java.util.Scanner;

public class Test {
    public static void main(String[] argv) {
        try {
            CalTaxServiceLocator locator = new CalTaxServiceLocator();
            CalTax_PortType service = locator.getCalTax();
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入工资：");
            String in = sc.next();
            System.out.println(service.calTax(in));
        } catch (javax.xml.rpc.ServiceException ex) {
            ex.printStackTrace();
        } catch (java.rmi.RemoteException ex) {
            ex.printStackTrace();
        }
    }
}