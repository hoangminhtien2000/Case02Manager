package manager;

import model.Account;
import model.Admin;
import model.Date;
import model.User;
import sort.SortAccount_id;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ManagerAccount {
    static Scanner scanner = new Scanner(System.in);
    static List<Account> accounts = new ArrayList<>();

    public static List<Account> getAccounts() {
        return accounts;
    }

    public static void showlistAccount() {
        if (accounts.size() == 0) {
            System.out.println("Danh sách không có tài khoản nào! Mời tạo tài khoản.");
            scanner.nextLine();
        } else {
            System.out.println("\nDanh sách Account: ");
            Collections.sort(accounts,new SortAccount_id());
            for (int i = 0; i < accounts.size(); i++) {
                System.out.println(accounts.get(i).toString());
            }
            scanner.nextLine();
        }
    }

    public static void addArr() {
        System.out.println("\t1. Admin");
        System.out.println("\t2. User");
        System.out.println("Nhập loại tài khoản muốn tạo:");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            Account admins = createAccount(true);
            accounts.add(admins);
        } else if (choice == 2) {
            Account users = createAccount(false);
            accounts.add(users);
        }
    }

    public static Account createAccount(boolean isAdmin) {
        System.out.println("Nhập thông tin tài khoản: ");
        System.out.println("Nhập Id:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập Username: ");
        String username = scanner.nextLine();
        System.out.println("Nhập Password: ");
        String password = scanner.nextLine();
        System.out.println("Nhập Phone Number: ");
        String phone = scanner.nextLine();
        System.out.println("Nhập Birthday: ");
        System.out.println("Nhập Day: ");
        int day = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập Month: ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập Year: ");
        int year = Integer.parseInt(scanner.nextLine());
        Date birthday = new Date(day, month, year);
        if (isAdmin) {
            Account admins = new Admin(id, username, password, phone, birthday);
            return admins;
        } else {
            Account users = new User(id, username, password, phone, birthday);
            return users;
        }
    }

    public static void editAccount() {
        int index;
        System.out.println("Đăng nhập để sửa: ");
        index = Index();
        if (index == -1) {
            System.out.println("Tài khoản không tồn tại.");
            scanner.nextLine();
        } else {
            System.out.println("Nhập Password mới:");
            String password = scanner.nextLine();
            accounts.get(index).setPassword(password);
            System.out.printf("Đã sửa Password của Account có Username '%s' trong danh sách", accounts.get(index).getUsername());
            scanner.nextLine();
        }
    }

    public static int Index() {
        System.out.println("Nhập Username:");
        String username = scanner.nextLine();
        System.out.println("Nhập Password:");
        String password = scanner.nextLine();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username) && accounts.get(i).getPassword().equals(password))
                return i;
        }
        return -1;
    }

    public static String Account1() {
        int index;
        System.out.println("Nhập thông tin tài khoản muốn tìm: ");
        index = Index();
        if (index == -1) {
            return "Tài khoản không tồn tại";
        } else {
            return accounts.get(index).toString();
        }
    }

    public static void delete() {
        int index;
        System.out.println("Nhập thông tin tài khoản muốn xoá: ");
        index = Index();
        if (index < 0) {
            System.out.println("Username không đúng.");
            scanner.nextLine();
        } else {
            System.out.printf("Đã xoá Account có Username '%s' trong danh sách", accounts.get(index).getUsername());
            accounts.remove(index);
            scanner.nextLine();
        }

    }

    public static void editInformationAccount() {
        if (accounts.size() == 0) {
            System.out.println("Danh sách không có tài khoản nào! Mời tạo tài khoản.");
            scanner.nextLine();
        } else {
            editAccount();
        }
    }

    public static void deleteAccount() {
        if (accounts.size() == 0) {
            System.out.println("Danh sách không có tài khoản nào! Mời tạo tài khoản.");
            scanner.nextLine();
        } else {
            delete();
        }
    }

    public static void findAccount() {
        if (accounts.size() == 0) {
            System.out.println("Danh sách không có tài khoản nào! Mời tạo tài khoản.");
            scanner.nextLine();
        } else {
            System.out.println(Account1());
            scanner.nextLine();
        }
    }
}
