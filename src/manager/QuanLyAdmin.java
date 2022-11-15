package manager;

import java.util.Scanner;

public class QuanLyAdmin {
    static Scanner scanner = new Scanner(System.in);

    public static void ManagerAdmin() {
        System.out.println("Bạn đã đăng nhập bằng tài khoản Admin");
        scanner.nextLine();
        while (true) {
            System.out.println("\nQuản lý Account");
            System.out.println("1. Hiển thị list Account:");
            System.out.println("2. Sửa Password: ");
            System.out.println("3. Xoá Account:");
            System.out.println("4. Tìm Account:");
            System.out.println("\nQuan ly san pham");
            System.out.println("5. Them san pham");
            System.out.println("6. Sua san pham");
            System.out.println("7. Xoa san pham");
            System.out.println("8. Hien thi san pham");
            System.out.println("9. Thoát");
            System.out.println("\nNhập lựa chọn");
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
                    System.out.println("\nDanh sach san pham la: ");
                    ManagerProduct.show();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}