package login;

import manager.ManagerProduct;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginUser {
    static Scanner scanner = new Scanner(System.in);
    public static void loginUser() {
        while (true) {
            String string = """
                    \n--------Bạn đã đăng nhập bằng tài khoản User--------
                    1. Mua hàng                 
                    2. Đăng xuất""";
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
                    ManagerProduct.showProduct();
                    ManagerProduct.totalBillProduct();
                    break;
                case 2:
                    return;
                default:
                    break;
            }
        }
    }
}
