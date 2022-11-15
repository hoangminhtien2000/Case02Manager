import model.Account;
import model.Admin;
import model.User;

public class tesst {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        ManagerAccount managerAccount = new ManagerAccount();
//        QuanLyAdmin quanLyAdmin = new QuanLyAdmin();
//        ManagerAdmin managerAdmin = new ManagerAdmin();
//        managerAccount.register2();
//        managerAccount.register2();
//        int check1 = managerAccount.getAccounts()[0].getIsAdmin();
//        int check = managerAccount.getAccounts()[1].getIsAdmin();
//        System.out.println(check);
//        System.out.println(check1);

        Admin admin=new Admin();
        User user=new User();
        Account account=new Account();
        System.out.println(admin.getIsAdmin());
        System.out.println(user.getIsAdmin());
        System.out.println(account.getIsAdmin());
    }
}
