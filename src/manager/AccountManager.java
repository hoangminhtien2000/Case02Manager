package manager;

import model.Account;
import model.Admin;
import model.Admin2;
import model.User;
import sort.SortAccount_ID;

import java.util.*;
import java.util.regex.Pattern;

public class AccountManager {
    static Scanner scanner = new Scanner(System.in);
    static LinkedList<Account> accounts = new LinkedList<>();
    static LinkedList<Account> bin = new LinkedList<>();

    public static void checkListAccount() {
        boolean checkisAdmin = false;
        for (Account account : accounts) {
            if (account.getUsername().equals("tien@.tien") && account.getPassword().equals("tien123")) {
                checkisAdmin = true;
            }
        }
        if (checkisAdmin == false) {
            accounts.add(new Admin(0, "tien@.tien", "tien123", "Hoàng Minh Tiến", 22, "Nam"));
        }
    }

    public static LinkedList<Account> getBin() {
        return bin;
    }

    public static void setBin(LinkedList<Account> bin) {
        AccountManager.bin = bin;
    }

    public static LinkedList<Account> getAccounts() {
        return accounts;
    }

    public static void setAccounts(LinkedList<Account> accounts) {
        AccountManager.accounts = accounts;
    }

    public static void showlistAccount() {
        if (accounts.isEmpty()) {
            System.out.println("Danh sách không có tài khoản nào! Mời tạo tài khoản.");
            System.out.print("\nNhấn ENTER để tiếp tục");
            scanner.nextLine();
        } else {
            System.out.println("\n-------------------------------Danh sách tài khoản----------------------------------");
            System.out.printf("%-15s%-5s%-15s%-15s%-20s%-5s%-8s\n", "AccountType", "ID", "UserName", "Password", "Name", "Age", "Gender");
            for (Account account : accounts) {
                System.out.println(account.toString());
            }
        }
    }

    public static void showListBin() {
        if (bin.isEmpty()) {
            System.out.println("Chưa có tài khoản nào bị xoá");
            System.out.print("\nNhấn ENTER để tiếp tục");
            scanner.nextLine();
        } else {
            System.out.println("\n----------------------------Danh sách tài khoản đã bị khoá-------------------------");
            System.out.printf("%-15s%-5s%-15s%-15s%-20s%-5s%-8s\n", "AccountType", "ID", "UserName", "Password", "Name", "Age", "Gender");
            for (Account account : bin) {
                System.out.println(account.toString());
            }
        }
    }

//    public static void addAdminUser() {
//        String string = """
//                \t1. Admin:
//                \t2. User:
//                """;
//        System.out.println(string);
//        int choice;
//        do {
//            try {
//                System.out.println("Nhập loại tài khoản muốn tạo(Nhấn số khác 1 hoặc 2 để huỷ lệnh tạo tài khoản):");
//                choice = Integer.parseInt(scanner.nextLine());
//                break;
//            } catch (InputMismatchException | NumberFormatException e) {
//                System.out.println("Phải nhập số");
//            }
//        } while (true);
//        if (choice == 1) {
//            Account admins = createAccount(true);
//            accounts.add(admins);
//        } else if (choice == 2) {
//            Account users = createAccount(false);
//            accounts.add(users);
//        }
//    }

    public static String getUsername() {
        String username = "";
        while (true) {
            String string = """
                    Nhập tên đăng nhập:
                    Lưu ý: Có từ '6-31' kí tự, bắt đầu '0-9, a-z, A-Z' có đuôi '@.tien'.""";
            System.out.println(string);
            username = scanner.nextLine();
            boolean username1 = Pattern.matches("[0-9a-zA-Z@\\.]{6,31}", username);
            boolean username2 = Pattern.matches("[0-9a-zA-Z]*@\\.tien", username);
            if (username1 && username2) break;
            else {
                System.out.println("Nhập không đúng định dạng!");
                System.out.print("\nNhấn ENTER để nhập lại");
                scanner.nextLine();
            }
        }
        return username;
    }

    public static String getPassword() {
        String password = "";
        while (true) {
            String string = """
                    Nhập mật khẩu:
                    Lưu ý: Có '6-31' kí tự, các kí tự chỉ bao gồm '0-9, a-z, A-Z', có ít nhất 1 số và 1 chữ.""";
            System.out.println(string);
            password = scanner.nextLine();
            boolean password1 = Pattern.matches("[0-9a-zA-Z]{6,31}", password);
            boolean password2 = Pattern.matches("[0-9a-zA-Z]*[0-9]+[0-9a-zA-Z]*", password);
            boolean password3 = Pattern.matches("[0-9a-zA-Z]*[a-zA-Z]+[0-9a-zA-Z]*", password);
            if (password1 && password2 && password3) break;
            else {
                System.out.println("Nhập không đúng định dạng!");
                System.out.print("\nNhấn ENTER để nhập lại");
                scanner.nextLine();
            }
        }
        return password;
    }

    public static int findMaxID() {
        if (bin.isEmpty()) {
            return accounts.get(accounts.size() - 1).getId();
        } else {
            int max = accounts.get(accounts.size() - 1).getId();
            if (!bin.isEmpty()) {
                for (Account account : bin) {
                    if (account.getId() > max) max = account.getId();
                }
            }
            return max;
        }
    }

    public static Account createAccount(boolean isAdmin) {
        System.out.println("\nNhập thông tin tài khoản: ");
        int id = findMaxID() + 1;
        int index;
        String username;
        do {
            index = -1;
            username = getUsername();
//            for (int i = 0; i < accounts.size(); i++) {
//                if (accounts.get(i).getUsername().equals(username)){
//                    index = i;
//                    break;
//                }
//            }
//            for (int i = 0; i < bin.size(); i++) {
//                if (bin.get(i).getUsername().equals(username)){
//                    index = i;
//                    break;
//                }
//            }
            int maxSize = Math.max(accounts.size(), bin.size());
            for (int i = 0; i < maxSize; i++) {
                if (i < accounts.size() && accounts.get(i).getUsername().equals(username)) {
                    index = 1;
                    break;
                }
                if (i < bin.size() && bin.get(i).getUsername().equals(username)) {
                    index = 1;
                    break;
                }
            }
            if (index != -1) System.out.println("\nTên đăng nhập đã tồn tài, mời nhập tên khác.");
        } while (index != -1);
        String password = getPassword();
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        int age;
        do {
            do {
                try {
                    System.out.println("Nhập tuổi: ");
                    age = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Phải nhập số");
                }
            } while (true);
            if (age < 10 || age > 130) System.out.println("Phải nhập số lớn hơn 10 và nhỏ hơn 130!");
        } while (age < 10 || age > 130);
        String gender;
        gender = scanGender();
        if (isAdmin) {
            Account admins = new Admin(id, username, password, name, age, gender);
            return admins;
        } else {
            Account users = new User(id, username, password, name, age, gender);
            return users;
        }
    }

    public static Account createAccount2() {
        System.out.println("\nNhập thông tin tài khoản: ");
        int id = findMaxID() + 1;
        int index;
        String username;
        do {
            index = -1;
            username = getUsername();
            int maxSize = Math.max(accounts.size(), bin.size());
            for (int i = 0; i < maxSize; i++) {
                if (i < accounts.size() && accounts.get(i).getUsername().equals(username)) {
                    index = 1;
                    break;
                }
                if (i < bin.size() && bin.get(i).getUsername().equals(username)) {
                    index = 1;
                    break;
                }
            }
            if (index != -1) System.out.println("\nTên đăng nhập đã tồn tài, mời nhập tên khác.");
        } while (index != -1);
        String password = getPassword();
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        int age;
        do {
            do {
                try {
                    System.out.println("Nhập tuổi: ");
                    age = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Phải nhập số");
                }
            } while (true);
            if (age < 10 || age > 130) System.out.println("Phải nhập số lớn hơn 10 và nhỏ hơn 130!");
        } while (age < 10 || age > 130);
        String gender;
        gender = scanGender();
        Account admins2 = new Admin2(id, username, password, name, age, gender);
        return admins2;
    }

    public static String scanGender() {
        String gender;
        int choise;
        String string = """
                Nhập giới tính:
                \t1. Nam.
                \t2. Nữ.""";
        System.out.println(string);
        do {
            try {
                do {

                    System.out.println("Nhập lựa chọn: ");
                    choise = Integer.parseInt(scanner.nextLine());
                    if (choise != 1 && choise != 2) System.out.println("Phải nhập 1 hoặc 2");
                } while (choise != 1 && choise != 2);
                break;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Phải nhập số");
            }
        } while (true);
        switch (choise) {
            case 1:
                gender = "Nam";
                break;
            case 2:
                gender = "Nữ";
                break;
            default:
                gender = "";
                break;
        }
        return gender;
    }

    public static void editAccount() {
        int index;
        System.out.println("Nhập thông tin tài khoản muốn sửa: ");
        index = IndexAccount();
        if (index == -1) {
            System.out.println("Tài khoản không tồn tại.");
            System.out.print("\nNhấn ENTER để tiếp tục");
            scanner.nextLine();
        } else {
            if (accounts.get(index).getUsername().equals("tien@.tien") && accounts.get(index).getPassword().equals("tien123")) {
                System.out.println("Không cho phép sửa tài khoản này!");
                System.out.print("\nNhấn ENTER để tiếp tục");
                scanner.nextLine();
            } else {
                System.out.println("Nhập mật khẩu mới:");
                String password = scanner.nextLine();
                accounts.get(index).setPassword(password);
                System.out.printf("Đã sửa mật khẩu của tài khoản có tên đăng nhập '%s' trong danh sách", accounts.get(index).getUsername());
                System.out.print("\nNhấn ENTER để tiếp tục");
                scanner.nextLine();
            }

        }
    }

    public static int IndexAccount() {
        System.out.println("Nhập tên đăng nhập:");
        String username = scanner.nextLine();
        System.out.println("Nhập mật khẩu:");
        String password = scanner.nextLine();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username) && accounts.get(i).getPassword().equals(password))
                return i;
        }
        return -1;
    }

    public static int findID() {
        int id;
        do {
            try {
                System.out.println("Nhập ID tài khoản:");
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Phải nhập số");
            }
        } while (true);
        for (int i = 0; i < bin.size(); i++) {
            if (bin.get(i).getId() == id)
                return i;
        }
        return -1;
    }

    public static void Account1() {
        int count = 0;
        System.out.println("Nhập tên tài khoản muốn tìm:");
        String name = scanner.nextLine();
        System.out.printf("\n%-15s%-5s%-15s%-15s%-20s%-5s%-8s\n", "AccountType", "ID", "UserName", "Password", "Name", "Age", "Gender");
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(accounts.get(i).toString());
                count++;
            }
        }
        if (count == 0) System.out.printf("Không có tài khoản nào có tên '%s'\n", name);
    }

    public static void lock() {
        int index;
        System.out.println("Nhập thông tin tài khoản muốn khoá: ");
        index = IndexAccount();
        if (index < 0) {
            System.out.println("Tài khoản không tồn tại.");
            System.out.print("\nNhấn ENTER để tiếp tục");
            scanner.nextLine();
        } else {
            if (accounts.get(index).getUsername().equals("tien@.tien") && accounts.get(index).getPassword().equals("tien123")) {
                System.out.println("Không cho phép khoá tài khoản này!");
                System.out.print("\nNhấn ENTER để tiếp tục");
                scanner.nextLine();
            } else {
                System.out.printf("Đã khoá tài khoản có tên đăng nhập '%s' trong danh sách", accounts.get(index).getUsername());
                bin.add(accounts.remove(index));
                System.out.print("\nNhấn ENTER để tiếp tục");
                scanner.nextLine();
            }
        }
    }

    public static void admin2create() {
        Account admin2 = createAccount2();
        accounts.add(admin2);
    }

    public static void register() {
        Account users = createAccount(false);
        accounts.add(users);
    }

    public static void editInformationAccount() {
        if (accounts.size() == 0) {
            System.out.println("Danh sách không có tài khoản nào! Mời tạo tài khoản.");
            System.out.print("\nNhấn ENTER để tiếp tục");
            scanner.nextLine();
        } else {
            editAccount();
        }
    }

    public static void lockAccount() {
        if (accounts.size() == 0) {
            System.out.println("Danh sách không có tài khoản nào! Mời tạo tài khoản.");
            System.out.print("\nNhấn ENTER để tiếp tục");
            scanner.nextLine();
        } else {
            lock();
        }
    }

    public static void findAccount() {
        if (accounts.size() == 0) {
            System.out.println("Danh sách không có tài khoản nào! Mời tạo tài khoản.");
            System.out.print("\nNhấn ENTER để tiếp tục");
            scanner.nextLine();
        } else {
            Account1();
            System.out.print("\nNhấn ENTER để tiếp tục");
            scanner.nextLine();
        }
    }

    public static void restore() {
        int index;
        System.out.println("Nhập thông tin tài khoản muốn khôi phục: ");
        index = findID();
        if (index == -1) {
            System.out.println("Tài khoản không tồn tại.");
            System.out.print("\nNhấn ENTER để tiếp tục");
            scanner.nextLine();
        } else {
            System.out.printf("Đã khôi phục tài khoản có tên đăng nhập '%s' ", bin.get(index).getUsername());
            accounts.add(bin.remove(index));
            Collections.sort(accounts, new SortAccount_ID());
            System.out.print("\nNhấn ENTER để tiếp tục");
            scanner.nextLine();
        }
    }

    public static void deleteAccount() {
        int index;
        System.out.println("Nhập thông tin tài khoản muốn xoá: ");
        index = findID();
        if (index == -1) {
            System.out.println("Tài khoản không tồn tại.");
            System.out.print("\nNhấn ENTER để tiếp tục");
            scanner.nextLine();
        } else {
            System.out.printf("Đã xoá tài khoản có tên đăng nhập '%s' khỏi thùng rác ", bin.get(index).getUsername());
            bin.remove(index);
            System.out.print("\nNhấn ENTER để tiếp tục");
            scanner.nextLine();
        }
    }

    public static void clearBin() {
        bin.clear();
        System.out.println("Đã xoá toàn bộ tài khoản trong Bin.");
        System.out.println("Nhấn Enter để tiếp tục");
        scanner.nextLine();
    }
}