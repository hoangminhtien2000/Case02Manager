package login;

import manager.ProductManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin2Login {
    static Scanner scanner = new Scanner(System.in);
    public static void loginAdmin2(){
        while (true) {
            ProductManager.showProduct();
            String string = """
                    \n----------Bạn đã đăng nhập bằng tài khoản Admin2----------
                    1. Thay đổi số lượng sản phẩm
                    2. Thay đổi giá sản phẩm
                    3. Đăng xuất""";
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
                    System.out.println("\n----------------Thay đổi số lượng của sản phẩm--------------");
                    ProductManager.editNumberProduct();
                    break;
                case 2:
                    System.out.println("\n----------------Thay đổi giá của sản phẩm--------------");
                    ProductManager.editPriceProduct();
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        }
    }
}
