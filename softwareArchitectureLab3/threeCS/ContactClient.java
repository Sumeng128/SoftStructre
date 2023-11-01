package softStructure.threeCS;

import softStructure.threeCS.Contact;
import softStructure.threeCS.ContactServer;

import java.rmi.Naming;
import java.util.Scanner;

public class ContactClient {
    public static void main(String[] args) {
        try {
            ContactServer contactServer = (ContactServer) Naming.lookup("//localhost/ContactServer");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("请选择操作：");
                System.out.println("1. 添加联系人");
                System.out.println("2. 更新联系人");
                System.out.println("3. 删除联系人");
                System.out.println("4. 获取所有联系人");
                System.out.println("0. 退出");

                int choice = scanner.nextInt();
                scanner.nextLine(); // 处理换行符

                switch (choice) {
                    case 1:
                        System.out.print("请输入联系人姓名：");
                        String name = scanner.nextLine();
                        System.out.print("请输入联系人地址：");
                        String address = scanner.nextLine();
                        System.out.print("请输入联系人电话：");
                        String phone = scanner.nextLine();

                        Contact newContact = new Contact(name, address, phone);
                        contactServer.addContact(newContact);
                        System.out.println("联系人添加成功！");
                        break;
                    case 2:
                        System.out.println("请输入要更新的联系人姓名：");
                        String updateName = scanner.nextLine();
                        System.out.println("请输入新的联系人地址：");
                        String updateAddress = scanner.nextLine();
                        System.out.println("请输入新的联系人电话：");
                        String updatePhone = scanner.nextLine();

                        Contact updatedContact = new Contact(updateName, updateAddress, updatePhone);
                        contactServer.updateContact(updatedContact);
                        System.out.println("联系人更新成功！");
                        break;
                    case 3:
                        System.out.println("请输入要删除的联系人姓名：");
                        String deleteName = scanner.nextLine();
                        contactServer.deleteContact(deleteName);
                        System.out.println("联系人删除成功！");
                        break;
                    case 4:
                        Contact[] contacts = contactServer.getAllContacts();
                        System.out.println("所有联系人：");
                        for (Contact contact : contacts) {
                            System.out.println(contact);
                        }
                        break;
                    case 0:
                        System.out.println("程序已退出。");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("无效的选择，请重新输入！");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
