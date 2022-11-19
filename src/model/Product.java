package model;

public class Product {
    private  int id;
    private int number;
    private String name;
    private double price;
    private static int count=0;

    public Product() {
    }

    public Product(String name, int number, double price) {
        this.id=count;
        this.name = name;
        this.number = number;
        this.price = price;
        count++;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String covertPrice(double price) {
        String covertPrice = String.format("%,.0f vnd", price);
        return covertPrice;
    }

    public void addNumber(int number) {
        setNumber(getNumber() + number);
    }

    public void buy(int number) {
        setNumber(getNumber() - number);
    }

    public double bill(int number) {
        return number * getPrice();
    }
    public String covertBill(double bill) {
        String covertBill = String.format("%,.0f vnd", bill);
        return covertBill;
    }
    @Override
    public String toString() {
        return "Product{" +"id='" + id + '\'' + "name='" + name + ", number=" + number + '\'' + ", price= " + covertPrice(getPrice()) + '}';
    }
}