import manager.ManagerAccount;
import manager.QuanLyAdmin;
import manager.QuanLyUser;
import model.Admin;
import model.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Quản lý Account");
            System.out.println("1. Đăng nhập:");
            System.out.println("2. Đăng kí:");
            System.out.println("3. Thoát.");
            System.out.println("\nNhập lựa chọn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    int index = ManagerAccount.Index();
                    if (index != -1) {
                        if (ManagerAccount.getAccounts().get(index) instanceof Admin admin){
                            QuanLyAdmin.ManagerAdmin();
                        }
                        if (ManagerAccount.getAccounts().get(index) instanceof User user){
                            QuanLyUser.ManagerUser();
                        }
                    } else
                       System.out.println("Đăng nhập thất bại.");
                    scanner.nextLine();
                    break;
                case 2:
                    ManagerAccount.addArr();
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