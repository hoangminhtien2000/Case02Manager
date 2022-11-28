package manager;

import model.Account;
import model.Admin;
import model.User;

import java.io.*;
import java.util.*;

public class ManagerAccount {
    static Scanner scanner = new Scanner(System.in);
    static List<Account> accounts = new LinkedList<>();
     static {
        boolean checkisAdmin = false;
        for (Account account : accounts) {
            if (account.getUsername().equals("tien") && account.getPassword().equals("123")) {
                checkisAdmin = true;

            }
        }
        if (checkisAdmin ==false) {
            accounts.add(new Admin("tien", "123", "Hoàng Minh Tiến", 22, "Nam"));
        }
    }

    public static List<Account> getAccounts() {
        return accounts;
    }

    public static void showlistAccount() {
        if (accounts.size() == 0) {
            System.out.println("Danh sách không có tài khoản nào! Mời tạo tài khoản.");
            scanner.nextLine();
        } else {
            System.out.println("\nDanh sách Account: ");
            System.out.printf("%-15s%-5s%-15s%-15s%-20s%-5s%-8s\n", "AccountType", "ID", "UserName", "Password", "Name", "Age", "Gender");
            for (int i = 0; i < accounts.size(); i++) {
                System.out.println(accounts.get(i).toString());
            }
            scanner.nextLine();
        }
    }

    public static void addUser() {
        Account users = createAccount(false);
        accounts.add(users);
    }

    public static void addAdminUser() {
        String string = """                    
                \t1. Admin:
                \t2. User:
                Nhập loại tài khoản muốn tạo:""";
        System.out.println(string);
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
        int index;
        String username;
        do {
            index = -1;
            System.out.println("Nhập Username:");
            username = scanner.nextLine();
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).getUsername().equals(username))
                    index = i;
            }
            if (index != -1) System.out.println("\nTên đăng nhập đã tồn tài, mời nhập tên khác.");
        } while (index != -1);
        System.out.println("Nhập Password: ");
        String password = scanner.nextLine();
        System.out.println("Nhập Name: ");
        String name = scanner.nextLine();
        int age;
        do {
            do {
                try {
                    System.out.println("Nhập Age: ");
                    age = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Phải nhập số");
                }
            } while (true);
            if (age < 10 || age > 130) System.out.println("Phải nhập số lớn hơn 10 và nhỏ hơn 130!");
        } while (age < 10 || age > 130);
        String gender;
        gender=scanGender();
        if (isAdmin) {
            Account admins = new Admin(username, password, name, age, gender);
            return admins;
        } else {
            Account users = new User(username, password, name, age, gender);
            return users;
        }
    }

    public static String scanGender() {
        String gender;
            int choise;
            String string = """
                    Nhập Gender:
                    \t1. Nam.
                    \t2. Nữ.
                    """;
            System.out.println(string);
            do {
                try {
                    do {

                        System.out.println("Nhập lựa chọn: ");
                        choise = Integer.parseInt(scanner.nextLine());
                           if (choise!=1&&choise!=2) System.out.println("Phải nhập 1 hoặc 2");
                    }while (choise!=1&&choise!=2);
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
                    gender="";
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
            scanner.nextLine();
        } else {
            System.out.println("Nhập Password mới:");
            String password = scanner.nextLine();
            accounts.get(index).setPassword(password);
            System.out.printf("Đã sửa Password của Account có Username '%s' trong danh sách", accounts.get(index).getUsername());
            scanner.nextLine();
        }
    }

    public static int IndexAccount() {
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
        index = IndexAccount();
        if (index == -1) {
            return "Tài khoản không tồn tại";
        } else {
            return accounts.get(index).toString();
        }
    }

    public static void delete() {
        int index;
        System.out.println("Nhập thông tin tài khoản muốn xoá: ");
        index = IndexAccount();
        if (index < 0) {
            System.out.println("Tài khoản không tồn tại.");
            scanner.nextLine();
        } else {
            if (accounts.get(index).getUsername().equals("tien")&&accounts.get(index).getPassword().equals("123")){
                System.out.println("Không cho phép xoá tài kkoản này!");
                scanner.nextLine();
            }
            else {
                System.out.printf("Đã xoá Account có Username '%s' trong danh sách", accounts.get(index).getUsername());
                accounts.remove(index);
                scanner.nextLine();
            }
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

    public static void writeObjectAccount() {
        try (FileOutputStream fos = new FileOutputStream("dataObjectListAccount.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//            for (Account account : accounts) {
//                oos.writeObject(account);
//            }
//            oos.writeObject(null);
            oos.writeObject(accounts);
        } catch (Exception e) {
            System.out.println("File không tồn tại " +
                    "hoặc có lỗi trong lúc ghi.");
            e.printStackTrace();
        }
    }

    public static void readObjectAccount() {
        try (FileInputStream fis = new FileInputStream("dataObjectListAccount.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
//            accounts = new ArrayList<>();
//             while (true){
//                Account account = (Account) ois.readObject();
//                if (account == null) break;
//                accounts.add(account);
//            }
            List<Account> account = (List<Account>) ois.readObject();
            accounts = (LinkedList<Account>) account;
        } catch (ClassNotFoundException | ClassCastException | IOException e) {
            System.out.println("File không tồn tại " +
                    "hoặc có lỗi trong lúc đọc.");
            e.printStackTrace();
        }
    }


    public static void managerAdmin(int index) {
        System.out.println("\nBạn đã đăng nhập bằng tài khoản Admin");
        scanner.nextLine();
        while (true) {
            String string = """
                    ----------------Quản lý Account------------------
                    1. Tạo tài khoản:
                    2. Danh sách tài khoản:
                    3. Sửa Password:
                    4. Xoá Account:
                    5. Tìm Account:
                    ------------------Quản lý sản phẩm-----------------
                    6. Thêm sản phẩm:
                    7. Sửa thông tin sản phẩm:
                    8. Xoá sản phẩm:
                    9. Danh sách sản phẩm:
                    10. Thêm số lượng sản phẩm:
                    11. Đăng xuất:
                    """;
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
                    addAdminUser();
                    break;
                case 2:
                    showlistAccount();
                    break;
                case 3:
                    editInformationAccount();
                    break;
                case 4:
                    deleteAccount();
                    break;
                case 5:
                    findAccount();
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
                    ManagerProduct.showProduct();
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

    public static void managerUser(int index) {
        User curUser = (User) accounts.get(index);
        System.out.println("\nBạn đã đăng nhập bằng tài khoản User");
        scanner.nextLine();
        while (true) {
            String string = """
                    1. Mua hàng:
                    2. Giỏ hàng:
                    3. Đăng xuất:
                    """;
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
                    ManagerProduct.showProduct();
                    ManagerProduct.totalBillProduct();
                    break;
                case 2:
                    ManagerProduct.managerCart.showCart();
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        }
    }
}