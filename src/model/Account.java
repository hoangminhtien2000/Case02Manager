package model;

import java.util.Scanner;

public class Account {
    private int id;
    private String username;
    private String password;
    private String name;
    private int age;
    private String gender;
    private static int countId = 0;

    public Account() {
    }

    public Account(String username, String password,String name, int age,String gender) {
        this.id = countId++;
        this.username = username;
        this.password = password;
        this.name=name;
        this.age = age;
        this.gender=gender;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
