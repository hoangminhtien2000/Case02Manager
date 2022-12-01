package login;

import manager.ProductManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserLogin {
    static Scanner scanner = new Scanner(System.in);
    public static void findProduct(){
        while (true) {
            String string = """
                    \n--------Bạn có muốn tìm mức giá sản phẩm không?--------
                    1. Có                 
                    2. Không""";
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
                    ProductManager.productSortPrice();
                    ProductManager.showProductPrice();
                    ProductManager.totalBillProduct();
                    return;
                case 2:
                    ProductManager.showProduct();
                    ProductManager.totalBillProduct();
                    return;
                default:
                    break;
            }
        }
    }


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
                    findProduct();
                    break;
                case 2:
                    return;
                default:
                    break;
            }
        }
    }
}
