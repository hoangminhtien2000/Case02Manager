package model;

public class User extends Account {

    public User() {
    }

    public User(int id, String username, String password, String name, int age, String gender) {
        super(id, username, password, name, age, gender);
    }

    @Override
    public String toString() {
        String toString = String.format("%-15s%-5d%-15s%-15s%-20s%-5d%-8s", "User", super.getId(), super.getUsername(), super.getPassword(), super.getName(), super.getAge(), super.getGender());
        return toString;
    }
}