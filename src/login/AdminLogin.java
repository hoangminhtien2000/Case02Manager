package login;

import manager.AccountManager;
import manager.ProductManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public  class AdminLogin {
    static Scanner scanner = new Scanner(System.in);

    public static void managerAccount() {
        while (true) {
            String string = """
                    ----------------Quản lý Account------------------
                    1. Tạo tài khoản
                    2. Danh sách tài khoản
                    3. Sửa Password
                    4. Xoá Account
                    5. Tìm Account
                    6. Quay lại""";
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
                    AccountManager.addAdminUser();
                    break;
                case 2:
                    AccountManager.showlistAccount();
                    break;
                case 3:
                    AccountManager.editInformationAccount();
                    break;
                case 4:
                    AccountManager.deleteAccount();
                    break;
                case 5:
                    AccountManager.findAccount();
                    break;
                case 6:
                    return;
                default:
                    break;
            }
        }
    }

    public static void managerProduct() {
        while (true) {
            String string = """
                    ------------------Quản lý sản phẩm-----------------
                    1. Thêm sản phẩm                
                    2. Xoá sản phẩm
                    3. Danh sách sản phẩm
                    4. Sắp xếp sản phẩm theo giá
                    5. Thêm số lượng sản phẩm
                    6. Quay lại""";
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
                    ProductManager.addProduct();
                    break;
                case 2:
                    ProductManager.delete();
                    break;
                case 3:
                    System.out.println("\nDanh sách sản phẩm: ");
                    ProductManager.showProduct();
                    System.out.print("\nNhấn ENTER để tiếp tục");
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.println("\nDanh sách sản phẩm: ");
                    ProductManager.showProductSortPrice();
                    System.out.print("\nNhấn ENTER để tiếp tục");
                    scanner.nextLine();
                    break;
                case 5:
                    ProductManager.addNumberProduct();
                    break;
                case 6:
                    return;
                default:
                    break;
            }
        }
    }

    public static void loginAdmin(){
        while (true) {
            String string = """
                    \n----------Bạn đã đăng nhập bằng tài khoản Admin----------
                    1. Quản lý Account
                    2. Quản lý sản phẩm
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
                    managerAccount();
                    break;
                case 2:
                    managerProduct();
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        }
    }
}
