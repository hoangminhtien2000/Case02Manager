package model;

public class Account {
    private  int id;
    private String username;
    private String password;
    private String phone;
    private String birthday;
    private static int count=0;

    public Account() {
    }

    public Account( String username, String password, String phone, String birthday) {
        this.id=count;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.birthday = birthday;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

}
