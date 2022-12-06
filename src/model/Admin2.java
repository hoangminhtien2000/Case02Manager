package model;

public class Admin2 extends Account {

    public Admin2() {
    }

    public Admin2( int id,String username, String password,String name, int age,String gender) {
        super(id,username, password, name, age, gender);
    }

    @Override
    public String toString() {
        String toString = String.format("%-15s%-5d%-15s%-15s%-20s%-5d%-8s", "Admin2", super.getId(), super.getUsername(), super.getPassword(), super.getName(), super.getAge(), super.getGender());
        return toString;
    }
}
