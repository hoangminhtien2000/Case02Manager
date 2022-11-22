package model;

public class Admin extends Account {

    public Admin() {
    }

    public Admin( String username, String password, String phone, String birthday) {
        super( username, password, phone, birthday);
    }

    @Override
    public String toString() {
        String toString=String.format("%-15s%-5d%-15s%-15s%-13s%-13s","Admin",super.getId(),super.getUsername(),super.getPassword(),super.getPhone(),super.getBirthday());
        return toString;
    }
}
