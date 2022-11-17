package manager;

import java.util.Scanner;

public class QuanLyAdmin {
    static Scanner scanner = new Scanner(System.in);
    public static void ManagerAdmin() {
        System.out.println("\nBạn đã đăng nhập bằng tài khoản Admin");
        scanner.nextLine();
        while (true) {
            System.out.println("\n----------------Quản lý Account------------------");
            System.out.println("1. Hiển thị list Account:");
            System.out.println("2. Sửa Password: ");
            System.out.println("3. Xoá Account:");
            System.out.println("4. Tìm Account:");
            System.out.println("------------------Quản lý sản phẩm-----------------");
            System.out.println("5. Thêm sản phẩm:");
            System.out.println("6. Sửa sản phẩm:");
            System.out.println("7. Xoá sản phẩm:");
            System.out.println("8. Hiển thị sản phẩm:");
            System.out.println("9. Đăng xuất.");
            System.out.println("\nNhập lựa chọn:");
            int choice1 = Integer.parseInt(scanner.nextLine());
            switch (choice1) {
                case 1:
                    ManagerAccount.showlistAccount();
                    break;
                case 2:
                    ManagerAccount.editInformationAccount();
                    break;
                case 3:
                    ManagerAccount.deleteAccount();
                    break;
                case 4:
                    ManagerAccount.findAccount();
                    break;
                case 5:
                    ManagerProduct.addArr();
                    break;
                case 6:
                    ManagerProduct.edit();
                    break;
                case 7:
                    ManagerProduct.delete();
                    break;
                case 8:
                    System.out.println("\nDanh sách sản phẩm: ");
                    ManagerProduct.show();
                    scanner.nextLine();
                    break;
                case 9:
                    return;
                default:
                    break;
            }
        }
    }
}