package IO;

import manager.ManagerAccount;
import manager.ManagerProduct;
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
            oos.writeObject(ManagerAccount.getAccounts());
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
             ManagerAccount.setAccounts((LinkedList<Account>) account) ;
        } catch (ClassNotFoundException | ClassCastException | IOException e) {
            System.out.println("File không tồn tại " +
                    "hoặc có lỗi trong lúc đọc.");
            e.printStackTrace();
        }
    }

    public static void writeProduct() {
        try (FileOutputStream fos = new FileOutputStream("dataProduct.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(ManagerProduct.getProducts());
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
            ManagerProduct.setProducts((ArrayList<Product>) product);
        } catch (ClassNotFoundException | ClassCastException | IOException e) {
            System.out.println("File không tồn tại " +
                    "hoặc có lỗi trong lúc đọc.");
            e.printStackTrace();
        }
    }

}
