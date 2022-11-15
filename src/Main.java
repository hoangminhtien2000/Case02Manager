import manager.ManagerAccount;
import manager.ManagerProduct;
import manager.QuanLyAdmin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuanLyAdmin quanLyAdmin = new QuanLyAdmin();
        while (true) {
            System.out.println("\nQuản lý Account");
            System.out.println("1. Đăng nhập:");
            System.out.println("2. Đăng kí:");
            System.out.println("3. Thoát");
            System.out.println("\nNhập lựa chọn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    int index = ManagerAccount.Index();
                    if (index != -1) {
                        int check = ManagerAccount.getAccounts().get(index).getIsAdmin();
                        switch (check) {
                            case 0:
                                System.out.println("\nBạn đã đăng nhập bằng tài khoản User");
                                ManagerProduct.show();
                                scanner.nextLine();
                                break;
                            case 1:
                                System.out.println("\nBạn đã đăng nhập bằng tài khoản Admin");
                                scanner.nextLine();
                                quanLyAdmin.ManagerAdmin();
                                break;
                            default:
                                break;
                        }
                    } else
                       System.out.println("Đăng nhập thất bại");
                    break;
                case 2:
                    ManagerAccount.addArr();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}