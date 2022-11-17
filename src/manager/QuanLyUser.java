package manager;

import java.util.Scanner;

public class QuanLyUser {
    static Scanner scanner = new Scanner(System.in);
    public static void ManagerUser() {
        System.out.println("\nBạn đã đăng nhập bằng tài khoản User");
        scanner.nextLine();
        while (true) {
            System.out.println("1. Mua hàng:");
            System.out.println("2. Đăng xuất.");
            System.out.println("\nNhập lựa chọn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    ManagerProduct.show();
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
