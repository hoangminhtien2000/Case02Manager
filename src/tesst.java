import model.Account;
import model.Admin;
import model.User;

public class tesst {
    public static void main(String[] args) {
        Account admin=new Admin("long","123","0987654321","24/03/2000");
        Account admin1=new User("long1","123","0987654321","24/03/2000");
        Account admin2=new Admin("long","123","0987654321","24/03/2000");
        System.out.println(admin);
        System.out.println(admin1);
        System.out.println(admin2);
    }
}
