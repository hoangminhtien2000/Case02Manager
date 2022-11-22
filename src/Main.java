import manager.ManagerAccount;
import manager.ManagerProduct;
import model.Admin;
import model.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerAccount managerAccount=new ManagerAccount();
        ManagerProduct managerProduct=new ManagerProduct();
        while (true) {
            String string= """
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
            }while (true);
            switch (choice) {
                case 1:
                    int index = managerAccount.IndexAccount();
                    if (index != -1) {
                        if (managerAccount.getAccounts().get(index) instanceof Admin admin){
                            managerAccount.managerAdmin(index);
                        }
                        if (managerAccount.getAccounts().get(index) instanceof User user){
                            managerAccount.managerUser(index);
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