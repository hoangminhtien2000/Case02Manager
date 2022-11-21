import manager.ManagerAccount;
import manager.ManagerProduct;
import model.Admin;
import model.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerAccount managerAccount=new ManagerAccount();
        ManagerProduct managerProduct=new ManagerProduct();
        while (true) {
            System.out.println("Quản lý Account");
            System.out.println("1. Đăng nhập:");
            System.out.println("2. Đăng kí:");
            System.out.println("3. Thoát.");
            System.out.println("\nNhập lựa chọn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    int index = managerAccount.IndexAccount();
                    if (index != -1) {
                        if (managerAccount.getAccounts().get(index) instanceof Admin admin){
                            managerAccount.managerAdmin();
                        }
                        if (managerAccount.getAccounts().get(index) instanceof User user){
                            managerAccount.managerUser();
                        }
                    } else
                       System.out.println("Đăng nhập thất bại.");
                    scanner.nextLine();
                    break;
                case 2:
                    managerAccount.addUser();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}