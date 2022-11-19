package model;

import java.util.ArrayList;
import java.util.List;

public class User extends Account {
    private   List<Cart> carts = new ArrayList<>();
    public User() {
    }

    public User(String username, String password, String phone, String birthday) {
        super( username, password, phone, birthday);
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + super.getId() + '\'' +
                "username='" + super.getUsername() + '\'' +
                ", password='" + super.getPassword() + '\'' +
                ", phone='" + super.getPhone() + '\'' +
                ", birthday=" + super.getBirthday() +
                carts + '}';
    }
}
