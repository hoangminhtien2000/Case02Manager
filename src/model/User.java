package model;

public class User extends Account {
    public User() {
    }

    public User(int id, String username, String password, String phone, String birthday) {
        super(id, username, password, phone, birthday);
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
