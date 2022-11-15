package manager;

import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerProduct {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Product> products = new ArrayList<>();

    static public void show() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).toString());
        }
        scanner.nextLine();
    }

    public static void addArr() {
        Product product = createProduct();
        products.add(product);
        System.out.printf("Đã thêm sản phẩm '%s' vào danh sách", product.getName());
    }

    public static Product createProduct() {
        System.out.println("Nhập thông tin sản phẩm cần thêm: ");
        System.out.println("Nhập id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        double price = scanner.nextDouble();
        Product product = new Product(id, name, price);
        return product;
    }

    public static int Index() {
        System.out.println("Nhập tên sản phẩm:");
        String name = scanner.nextLine();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name))
                return i;
        }
        return -1;
    }

    public static void delete() {
        int index;
        System.out.println("Nhập tên sản phẩm muốn xoá: ");
        index = Index();
        if (index < 0) {
            System.out.println("Sản phẩm không tồn tại.");
            scanner.nextLine();
        } else {
            System.out.printf("Đã xoá Account có sản phẩm '%s' trong danh sách", products.get(index).getName());
            products.remove(index);
            scanner.nextLine();
        }
    }

    public static void edit() {
        int index;
        index = Index();
        if (index == -1) {
            System.out.println("Sản phẩm không tồn tại.");
            scanner.nextLine();
        } else {
            System.out.printf("Đã sửa thông tin của sản phẩm '%s' trong danh sách", products.get(index).getName());
            Product product = createProduct();
            products.set(index, product);
            scanner.nextLine();
        }
    }
}