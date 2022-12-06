import io.IO;
import login.AdminLogin;
import login.UserLogin;
import manager.AccountManager;

import model.Admin;
import model.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IO.readAccount();
        IO.readProduct();
        IO.readBin();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String string = """
                    \n------------------------PHẦN MỀM QUẢN LÝ TÀI KHOẢN---------------------
                                         ~ Người thực hiện: Hoàng Minh Tiến ~                   
                    1. Đăng nhập:
                    2. Đăng kí:
                    3. Thoát.""";
            System.out.println(string);
            int choice;
            do {
                try {
                    System.out.println("Mời nhập lựa chọn: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Phải nhập số!");
                }
            } while (true);
            switch (choice) {
                case 1:
                    int index = AccountManager.IndexAccount();
                    if (index != -1) {
                        if (AccountManager.getAccounts().get(index) instanceof Admin admin) {
                            AdminLogin.loginAdmin();
                        }
                        if (AccountManager.getAccounts().get(index) instanceof User user) {
                            UserLogin.loginUser();
                        }
                    } else {
                        System.out.println("Đăng nhập thất bại.");
                        System.out.print("\nNhấn ENTER để tiếp tục");
                        scanner.nextLine();
                    }
                    break;
                case 2:
                    AccountManager.register();
                    break;
                case 3:
                    IO.writeAccount();
                    IO.writeProduct();
                    IO.writeBin();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}