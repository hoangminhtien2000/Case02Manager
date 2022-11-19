package model;

public class Cart {
    private String name;
    private int number;
    private double bill;

    public Cart() {
    }

    public Cart(String name, int number, double bill) {
        this.name = name;
        this.number = number;
        this.bill = bill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", bill=" + bill +
                '}';
    }
}
