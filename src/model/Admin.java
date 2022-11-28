package model;

public class Admin extends Account {

    public Admin() {
    }

    public Admin( int id,String username, String password,String name, int age,String gender) {
        super(id,username, password, name, age, gender);
    }

    @Override
    public String toString() {
        String toString = String.format("%-15s%-5d%-15s%-15s%-20s%-5d%-8s", "Admin", super.getId(), super.getUsername(), super.getPassword(), super.getName(), super.getAge(), super.getGender());
        return toString;
    }
}
