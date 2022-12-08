package io;

import java.io.*;
import java.util.LinkedList;

public class ReadWrite<E> {
    static public String srcAccount = "dataAccount.txt";
    static public String srcProduct = "dataProduct.txt";
    static public String srcBin = "dataBin.txt";

    public LinkedList<E> readFile(String src){
        LinkedList<E> list = new LinkedList<>();
        try (FileInputStream fis = new FileInputStream(src);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            list = (LinkedList<E>) ois.readObject();
        } catch (ClassNotFoundException | ClassCastException | IOException e) {
            System.out.println("File không tồn tại " +
                    "hoặc có lỗi trong lúc đọc.");
            e.printStackTrace();
        }
        return list;
    }
    public void writeFile(LinkedList<E> list, String src) {
        try (FileOutputStream fos = new FileOutputStream(src);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(list);
        } catch (Exception e) {
            System.out.println("File không tồn tại " +
                    "hoặc có lỗi trong lúc ghi.");
            e.printStackTrace();
        }
    }
}
