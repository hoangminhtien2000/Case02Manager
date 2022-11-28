package model;

import java.util.ArrayList;
import java.util.List;

public class User extends Account {
    private List<Cart> carts = new ArrayList<>();

    public User() {
    }

    public User(int id, String username, String password, String name, int age, String gender) {
        super(id, username, password, name, age, gender);
    }

//    public List<Cart> getCarts() {
//        return carts;
//    }
//
//    public void setCarts(List<Cart> carts) {
//        this.carts = carts;
//    }
//
//    public void buyProduct(Cart cart){
//        Scanner scanner = new Scanner(System.in);
//        int number = Integer.parseInt(scanner.nextLine());
//        cart.setNumber(number);
//        this.getCarts().add(cart);
//    }

    @Override
    public String toString() {
        String toString = String.format("%-15s%-5d%-15s%-15s%-20s%-5d%-8s", "User", super.getId(), super.getUsername(), super.getPassword(), super.getName(), super.getAge(), super.getGender());
        return toString;
    }
}