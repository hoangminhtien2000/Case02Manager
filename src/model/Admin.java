package model;

public class Admin extends Account {

    public Admin() {
    }

    public Admin(int id, String username, String password, String phone, Date birthday) {
        super(id, username, password, phone, birthday);

    }

    public int getIsAdmin() {
        super.setIsAdmin(1);
        return super.getIsAdmin();
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + super.getId() +
                ", username='" + super.getUsername() + '\'' +
                ", password='" + super.getPassword() + '\'' +
                ", phone='" + super.getPhone() + '\'' +
                ", birthday=" + super.getBirthday() +
                '}';
    }

}
