package manager;

import model.Account;
import model.Admin;
import model.User;

import java.util.*;

public class ManagerAccount {
    Scanner scanner = new Scanner(System.in);
    static List<Account> accounts = new LinkedList<>();
    ManagerProduct managerProduct = new ManagerProduct();

    public ManagerProduct getmanagerProduct() {
        return managerProduct;
    }

    public void setmanagerProduct(ManagerProduct managerProduct) {
        this.managerProduct = managerProduct;
    }

    static {
        accounts.add(new Admin("tien", "123", "0987654321", "24/03/2000"));
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void showlistAccount() {
        if (accounts.size() == 0) {
            System.out.println("Danh sách không có tài khoản nào! Mời tạo tài khoản.");
            scanner.nextLine();
        } else {
            System.out.println("\nDanh sách Account: ");
            //Collections.sort(accounts,new SortAccount_ID());
            for (int i = 0; i < accounts.size(); i++) {
                System.out.println(accounts.get(i).toString());
            }
            scanner.nextLine();
        }
    }

    public void addUser() {
        Account users = createAccount(false);
        accounts.add(users);
    }

    public void addAdminUser() {
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

    public Account createAccount(boolean isAdmin) {
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
        System.out.println("Nhập Phone Number: ");
        String phone = scanner.nextLine();
        System.out.println("Nhập Birthday: ");
        String birthday = scanner.nextLine();
        if (isAdmin) {
            Account admins = new Admin(username, password, phone, birthday);
            return admins;
        } else {
            Account users = new User(username, password, phone, birthday);
            return users;
        }
    }

    public void editAccount() {
        int index;
        System.out.println("Đăng nhập để sửa: ");
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

    public int IndexAccount() {
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

    public String Account1() {
        int index;
        System.out.println("Nhập thông tin tài khoản muốn tìm: ");
        index = IndexAccount();
        if (index == -1) {
            return "Tài khoản không tồn tại";
        } else {
            return accounts.get(index).toString();
        }
    }

    public void delete() {
        int index;
        System.out.println("Nhập thông tin tài khoản muốn xoá: ");
        index = IndexAccount();
        if (index < 0) {
            System.out.println("Username không đúng.");
            scanner.nextLine();
        } else {
            System.out.printf("Đã xoá Account có Username '%s' trong danh sách", accounts.get(index).getUsername());
            accounts.remove(index);
            scanner.nextLine();
        }

    }

    public void editInformationAccount() {
        if (accounts.size() == 0) {
            System.out.println("Danh sách không có tài khoản nào! Mời tạo tài khoản.");
            scanner.nextLine();
        } else {
            editAccount();
        }
    }

    public void deleteAccount() {
        if (accounts.size() == 0) {
            System.out.println("Danh sách không có tài khoản nào! Mời tạo tài khoản.");
            scanner.nextLine();
        } else {
            delete();
        }
    }

    public void findAccount() {
        if (accounts.size() == 0) {
            System.out.println("Danh sách không có tài khoản nào! Mời tạo tài khoản.");
            scanner.nextLine();
        } else {
            System.out.println(Account1());
            scanner.nextLine();
        }
    }

    public void managerAdmin() {
        System.out.println("\nBạn đã đăng nhập bằng tài khoản Admin");
        scanner.nextLine();
        while (true) {
            String string= """
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
                    Nhập lựa chọn:""";
            System.out.println(string);
            int choice1 = Integer.parseInt(scanner.nextLine());
            switch (choice1) {
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
                    managerProduct.addArr();
                    break;
                case 7:
                    managerProduct.edit();
                    break;
                case 8:
                    managerProduct.delete();
                    break;
                case 9:
                    System.out.println("\nDanh sách sản phẩm: ");
                    managerProduct.showProduct();
                    scanner.nextLine();
                    break;
                case 10:
                    managerProduct.addNumberProduct();
                    break;
                case 11:
                    return;
                default:
                    break;
            }
        }
    }

    public void managerUser() {
        System.out.println("\nBạn đã đăng nhập bằng tài khoản User");
        scanner.nextLine();
        while (true) {
            String string= """
                    1. Mua hàng:
                    2. Giỏ hàng:
                    3. Đăng xuất:
                    Nhập lựa chọn:""";
            System.out.println(string);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    managerProduct.showProduct();
                    managerProduct.totalBillProduct();
                    break;
                case 2:
                    managerProduct.managerCart.showCart();
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        }
    }
}