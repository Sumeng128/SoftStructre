package softStructure.BS.persentation;

import softStructure.BS.businessLogic.ContactService;
import softStructure.BS.model.Contact;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static ContactService contactService;

    public static void main(String[] args) {
        contactService = new ContactService();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("请选择操作：");
            System.out.println("1. 添加联系人");
            System.out.println("2. 修改联系人");
            System.out.println("3. 删除联系人");
            System.out.println("4. 查询联系人");
            System.out.println("0. 退出");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 消耗换行符

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
                    getAllContacts();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("无效的选择！");
                    break;
            }
        }

        scanner.close();
    }

    private static void addContact(Scanner scanner) {
        System.out.println("请输入联系人姓名：");
        String name = scanner.nextLine();

        System.out.println("请输入联系人住址：");
        String address = scanner.nextLine();

        System.out.println("请输入联系人电话：");
        String phone = scanner.nextLine();

        Contact contact = new Contact(name, address, phone);
        contactService.addContact(contact);

        System.out.println("联系人添加成功！");
    }

    private static void updateContact(Scanner scanner) {
        List<Contact> contacts = contactService.getAllContacts();
        if (contacts.isEmpty()) {
            System.out.println("通讯录为空！");
            return;
        }

        System.out.println("请选择要修改的联系人：");
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            System.out.println((i + 1) + ". " + contact.getName() + " " + contact.getAddress() + " " + contact.getPhone());
        }

        int choice = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符

        if (choice < 1 || choice > contacts.size()) {
            System.out.println("无效的选择！");
            return;
        }

        int index = choice - 1;
        Contact existingContact = contacts.get(index);

        System.out.println("请输入新的联系人姓名（留空表示不修改）：");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            existingContact.setName(name);
        }

        System.out.println("请输入新的联系人住址（留空表示不修改）：");
        String address = scanner.nextLine();
        if (!address.isEmpty()) {
            existingContact.setAddress(address);
        }

        System.out.println("请输入新的联系人电话（留空表示不修改）：");
        String phone = scanner.nextLine();
        if (!phone.isEmpty()) {
            existingContact.setPhone(phone);
        }

        contactService.updateContact(index, existingContact);

        System.out.println("联系人更新成功！");
    }

    private static void deleteContact(Scanner scanner) {
        List<Contact> contacts = contactService.getAllContacts();
        if (contacts.isEmpty()) {
            System.out.println("通讯录为空！");
            return;
        }

        System.out.println("请选择要删除的联系人：");
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            System.out.println((i + 1) + ". " + contact.getName() + " " + contact.getAddress() + " " + contact.getPhone());
        }

        int choice = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符

        if (choice < 1 || choice > contacts.size()) {
            System.out.println("无效的选择！");
            return;
        }

        int index = choice - 1;
        contactService.deleteContact(index);

        System.out.println("联系人删除成功！");
    }

    private static void getAllContacts() {
        List<Contact> contacts = contactService.getAllContacts();
        if (contacts.isEmpty()) {
            System.out.println("通讯录为空！");
            return;
        }

        System.out.println("所有联系人：");
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            System.out.println((i + 1) + ". " + contact.getName() + " " + contact.getAddress() + " " + contact.getPhone());
        }
    }
}

