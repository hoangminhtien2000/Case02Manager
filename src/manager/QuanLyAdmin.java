package manager;

import java.util.Scanner;

public class QuanLyAdmin {
    static Scanner scanner = new Scanner(System.in);

    public static void ManagerAdmin() {
        System.out.println("\nBạn đã đăng nhập bằng tài khoản Admin");
        scanner.nextLine();
        while (true) {
            System.out.println("\n----------------Quản lý Account------------------");
            System.out.println("1. Tạo tài khoản:");
            System.out.println("2. Danh sách tài khoản:");
            System.out.println("3. Sửa Password: ");
            System.out.println("4. Xoá Account:");
            System.out.println("5. Tìm Account:");
            System.out.println("------------------Quản lý sản phẩm-----------------");
            System.out.println("6. Thêm sản phẩm:");
            System.out.println("7. Sửa thông tin sản phẩm:");
            System.out.println("8. Xoá sản phẩm:");
            System.out.println("9. Danh sách sản phẩm:");
            System.out.println("10. Thêm số lượng sản phẩm:");
            System.out.println("11. Đăng xuất.");
            System.out.println("\nNhập lựa chọn:");
            int choice1 = Integer.parseInt(scanner.nextLine());
            switch (choice1) {
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
                    ManagerProduct.addArr();
                    break;
                case 7:
                    ManagerProduct.edit();
                    break;
                case 8:
                    ManagerProduct.delete();
                    break;
                case 9:
                    System.out.println("\nDanh sách sản phẩm: ");
                    ManagerProduct.show();
                    scanner.nextLine();
                    break;
                case 10:
                    ManagerProduct.addNumberProduct();
                    break;
                case 11:
                    return;
                default:
                    break;
            }
        }
    }
}