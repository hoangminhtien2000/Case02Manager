import login.LoginAdmin;
import login.LoginUser;
import manager.ManagerAccount;
import manager.ManagerProduct;
import model.Admin;
import model.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManagerAccount.readObjectAccount();
        ManagerProduct.readObjectProduct();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String string = """
                    \nLOGIN/REGISTER:
                    1. Đăng nhập:
                    2. Đăng kí:
                    3. Thoát.
                    """;
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
                    int index = ManagerAccount.IndexAccount();
                    if (index != -1) {
                        if (ManagerAccount.getAccounts().get(index) instanceof Admin admin) {
                            LoginAdmin.loginAdmin();
                        }
                        if (ManagerAccount.getAccounts().get(index) instanceof User user) {
                            LoginUser.loginUser();
                        }
                    } else {
                        System.out.println("Đăng nhập thất bại.");
                        System.out.print("\nNhấn ENTER để tiếp tục");
                        scanner.nextLine();
                    }
                    break;
                case 2:
                    ManagerAccount.addUser();
                    break;
                case 3:
                    ManagerAccount.writeObjectAccount();
                    ManagerProduct.writeObjectProduct();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}