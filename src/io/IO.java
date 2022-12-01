package io;

import manager.AccountManager;
import manager.ProductManager;
import model.Account;
import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IO {
    public static void writeAccount() {
        try (FileOutputStream fos = new FileOutputStream("dataAccount.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(AccountManager.getAccounts());
        } catch (Exception e) {
            System.out.println("File không tồn tại " +
                    "hoặc có lỗi trong lúc ghi.");
            e.printStackTrace();
        }
    }

    public static void readAccount() {
        try (FileInputStream fis = new FileInputStream("dataAccount.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            List<Account> account = (List<Account>) ois.readObject();
             AccountManager.setAccounts((LinkedList<Account>) account) ;
        } catch (ClassNotFoundException | ClassCastException | IOException e) {
            System.out.println("File không tồn tại " +
                    "hoặc có lỗi trong lúc đọc.");
            e.printStackTrace();
        }
    }

    public static void writeProduct() {
        try (FileOutputStream fos = new FileOutputStream("dataProduct.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(ProductManager.getProducts());
        } catch (Exception e) {
            System.out.println("File không tồn tại " +
                    "hoặc có lỗi trong lúc ghi.");
            e.printStackTrace();
        }
    }

    public static void readProduct() {
        try (FileInputStream fis = new FileInputStream("dataProduct.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            List<Product> product = (List<Product>) ois.readObject();
            ProductManager.setProducts((LinkedList<Product>) product);
        } catch (ClassNotFoundException | ClassCastException | IOException e) {
            System.out.println("File không tồn tại " +
                    "hoặc có lỗi trong lúc đọc.");
            e.printStackTrace();
        }
    }
}