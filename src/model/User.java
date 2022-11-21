package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User extends Account {
    Scanner scanner = new Scanner(System.in);
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

    public void buyProduct(Cart cart){
        int number = Integer.parseInt(scanner.nextLine());
        cart.setNumber(number);
        this.getCarts().add(cart);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + super.getId() + '\'' +
                ", username='" + super.getUsername() + '\'' +
                ", password='" + super.getPassword() + '\'' +
                ", phone='" + super.getPhone() + '\'' +
                ", birthday=" + super.getBirthday() +
                carts + '}';
    }
}