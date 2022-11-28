import manager.ManagerAccount;
import model.Admin;
import model.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManagerAccount.readObjectAccount();
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
                            ManagerAccount.managerAdmin(index);
                        }
                        if (ManagerAccount.getAccounts().get(index) instanceof User user) {
                            ManagerAccount.managerUser(index);
                        }
                    } else {
                        System.out.println("Đăng nhập thất bại.");
                        scanner.nextLine();
                    }
                    break;
                case 2:
                    ManagerAccount.addUser();
                    break;
                case 3:
                    ManagerAccount.writeObjectAccount();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}