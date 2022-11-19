package model;

public class Admin extends Account {

    public Admin() {
    }

    public Admin( String username, String password, String phone, String birthday) {
        super( username, password, phone, birthday);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + super.getId() + '\'' +
                "username='" + super.getUsername() + '\'' +
                ", password='" + super.getPassword() + '\'' +
                ", phone='" + super.getPhone() + '\'' +
                ", birthday=" + super.getBirthday() +
                '}';
    }
}
