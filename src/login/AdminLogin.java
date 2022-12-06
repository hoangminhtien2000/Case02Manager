package login;

import manager.AccountManager;
import manager.ProductManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public  class AdminLogin {
    static Scanner scanner = new Scanner(System.in);

    public static void managerAccount() {
        while (true) {
            AccountManager.showlistAccount();
            String string = """
                    \n----------------Quản lý tài khoản------------------
                    1. Tạo tài khoản Admin2
                    2. Sửa mật khẩu
                    3. Khoá tài khoản
                    4. Tìm tài khoản(Theo tên gần đúng)
                    5. Thùng rác
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
                    AccountManager.admin2create();
                    break;
                case 2:
                    AccountManager.editInformationAccount();
                    break;
                case 3:
                    AccountManager.lockAccount();
                    break;
                case 4:
                    AccountManager.findAccount();
                    break;
                case 5:
                    if (AccountManager.getBin().isEmpty()) {
                        System.out.println("Chưa có tài khoản nào bị khoá.");
                        System.out.print("\nNhấn ENTER để tiếp tục");
                        scanner.nextLine();
                    } else {
                        managerBin();
                    }
                    break;
                case 6:
                    return;
                default:
                    break;
            }
        }
    }

    public static void managerBin(){
        while (true) {
            AccountManager.showListBin();
            String string = """
                    \n----------------Quản lý thùng rác------------------                  
                    1. Khôi phục tài khoản
                    2. Xoá tài khoản khỏi thùng rác
                    3. Dọn dẹp thùng rác.
                    4. Quay lại""";
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
                    System.out.println("\n----------------Khôi phục tài khoản--------------");
                    AccountManager.showListBin();
                    AccountManager.restore();
                    break;
                case 2:
                    System.out.println("\n----------------Xoá tài khoản khỏi thùng rác--------------");
                    AccountManager.showListBin();
                    AccountManager.deleteAccount();
                    break;
                case 3:
                    AccountManager.clearBin();
                    return;
                case 4:
                    return;
                default:
                    break;
            }
        }
    }

    public static void managerProduct() {
        while (true) {
            ProductManager.showProduct();
            String string = """
                    \n------------------Quản lý sản phẩm-----------------             
                    1. Thêm sản phẩm
                    2. Xoá sản phẩm
                    3. Sắp xếp sản phẩm theo giá
                    4. Thay đổi số lượng sản phẩm
                    5. Thay đổi giá của sản phẩm
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
                    System.out.println("\nDanh sách sản phẩm sắp xếp theo mức giá: ");
                    ProductManager.showProductSortPrice();
                    System.out.print("\nNhấn ENTER để tiếp tục");
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.println("\n----------------Thay đổi số lượng của sản phẩm--------------");
                    ProductManager.editNumberProduct();
                    break;
                case 5:
                    System.out.println("\n----------------Thay đổi giá của sản phẩm--------------");
                    ProductManager.editPriceProduct();
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
                    1. Quản lý tài khoản
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
