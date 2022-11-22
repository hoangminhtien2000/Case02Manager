package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User extends Account {
    private int AccountId;
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
        String toString=String.format("%-15s%-5d%-15s%-15s%-13s%-13s","User",super.getId(),super.getUsername(),super.getPassword(),super.getPhone(),super.getBirthday());
        return toString;
    }
}