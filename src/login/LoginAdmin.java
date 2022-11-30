package login;

import manager.ManagerAccount;
import manager.ManagerProduct;

import java.util.InputMismatchException;
import java.util.Scanner;

public  class LoginAdmin {
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
                    ManagerAccount.addAdminUser();
                    break;
                case 2:
                    ManagerAccount.showlistAccount();
                    break;
                case 3:
                    ManagerAccount.editInformationAccount();
                    break;
                case 4:
                    ManagerAccount.deleteAccount();
                    break;
                case 5:
                    ManagerAccount.findAccount();
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
                    4. Thêm số lượng sản phẩm
                    5. Quay lại""";
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
                    ManagerProduct.addArr();
                    break;
                case 2:
                    ManagerProduct.delete();
                    break;
                case 3:
                    System.out.println("\nDanh sách sản phẩm: ");
                    ManagerProduct.showProduct();
                    System.out.print("\nNhấn ENTER để tiếp tục");
                    scanner.nextLine();
                    break;
                case 4:
                    ManagerProduct.addNumberProduct();
                    break;
                case 5:
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
