package model;

public class User extends Account {
    public User() {
    }

    public User(int id, String username, String password, String phone, Date birthday) {
        super(id, username, password, phone, birthday);
    }

    public int getIsAdmin() {
        super.setIsAdmin(0);
        return super.getIsAdmin();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + super.getId() +
                ", username='" + super.getUsername() + '\'' +
                ", password='" + super.getPassword() + '\'' +
                ", phone='" + super.getPhone() + '\'' +
                ", birthday=" + super.getBirthday() +
                '}';
    }
}
