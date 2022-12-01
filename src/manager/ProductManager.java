package manager;

import model.Product;
import sort.SortProduct_Price;

import java.util.*;

public class ProductManager {
    static Scanner scanner = new Scanner(System.in);
    static List<Product> products = new LinkedList<>();

    static {
        products.add(new Product(0, "Iphone", 5, 9000000));
    }

    static List<Product> productsPrice = new LinkedList<>();

    static {
        Collections.sort(productsPrice, new SortProduct_Price());
    }

    public static List<Product> getProducts() {
        return products;
    }

    public static void setProducts(List<Product> products) {
        ProductManager.products = products;
    }

    public static List<Product> getProductsPrice() {
        return productsPrice;
    }

    public static void setProductsPrice(List<Product> productsPrice) {
        ProductManager.productsPrice = productsPrice;
    }

    public static void showProduct() {
        if (products.isEmpty()) {
            System.out.println("Không có sản phẩm nào");
            System.out.print("\nNhấn ENTER để tiếp tục");
            scanner.nextLine();
        } else {
            System.out.printf("%-5s%-15s%-10s%s\n", "STT", "Tên sản phẩm", "Số lượng", "Giá");
            for (Product product : products) {
                System.out.println(product.toString());
            }
        }
    }

    public static void showProductPrice() {
        if (productsPrice.isEmpty()) {
            System.out.println("Không có sản phẩm nào nằm trong mức giá bạn muốn tìm");
            System.out.print("\nNhấn ENTER để tiếp tục");
            scanner.nextLine();
        } else {
            System.out.printf("%-5s%-15s%-10s%s\n", "STT", "Tên sản phẩm", "Số lượng", "Giá");
            for (Product product : productsPrice) {
                System.out.println(product.toString());
            }
        }
    }

    public static void addProduct() {
        Product product = createProduct();
        products.add(product);
        System.out.printf("Đã thêm sản phẩm '%s' vào danh sách", product.getName());
        System.out.print("\nNhấn ENTER để tiếp tục");
        scanner.nextLine();
    }

//    public static void addProductPrice() {
//
//        setProductsPrice();
//
//    }

    public static void productSortPrice(){
        double priceFirst;
        double priceLast;
        do {
            do {
                try {
                    System.out.println("Nhập mức giá khởi đầu: ");
                    priceFirst = Double.parseDouble(scanner.nextLine());
                    System.out.println("Nhập mức giá cuối cùng: ");
                    priceLast = Double.parseDouble(scanner.nextLine());
                    break;
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Phải nhập số!");
                }
            } while (true);
            if (priceFirst <= 0 || priceFirst > priceLast) System.out.println("Phải nhập mức giá lớn hơn 0 và giá khởi đầu không lớn hơn giá cuối cùng");
        } while (priceFirst <= 0 || priceFirst > priceLast);
        for (Product product : products) {
            if (product.getPrice()>=priceFirst&&product.getPrice()<=priceLast)productsPrice.add(product);
        }
    }

    public static Product createProduct() {
        System.out.println("Nhập thông tin sản phẩm! ");
        int id = products.get(products.size() - 1).getId() + 1;
        int index;
        String name;
        do {
            index = -1;
            System.out.println("Nhập tên sản phẩm:");
            name = scanner.nextLine();
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getName().equals(name))
                    index = i;
            }
            if (index != -1) System.out.println("\nSản phẩm đã tồn tại, mời nhập tên khác.");
        } while (index != -1);
        int number;
        double price;
        do {
            do {
                try {
                    System.out.println("Nhập số lượng sản phẩm: ");
                    number = Integer.parseInt(scanner.nextLine());
                    System.out.println("Nhập giá sản phẩm: ");
                    price = Double.parseDouble(scanner.nextLine());
                    break;
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Phải nhập số!");
                }
            } while (true);
            if (number <= 0 || price <= 0) System.out.println("Phải nhập số lượng và giá sản phẩm lớn hơn 0");
        } while (number <= 0 || price <= 0);
        Product product = new Product(id, name, number, price);
        return product;
    }

    public static int IndexProduct() {
        int id;
        do {
            try {
                System.out.println("Nhập ID sản phẩm:");
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Phải nhập số");
            }
        } while (true);
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id)
                return i;
        }
        return -1;
    }

    public static void delete() {
        showProduct();
        int index;
        System.out.println("Nhập thông tin phẩm muốn xoá: ");
        index = IndexProduct();
        if (index < 0) {
            System.out.println("Sản phẩm không tồn tại.");
            System.out.print("\nNhấn ENTER để tiếp tục");
            scanner.nextLine();
        } else {
            if (products.get(index).getName().equals("Iphone")) {
                System.out.println("Không cho phép xoá sản phẩm này!");
                System.out.print("\nNhấn ENTER để tiếp tục");
                scanner.nextLine();
            } else {
                System.out.printf("Đã xoá sản phẩm '%s' trong danh sách", products.get(index).getName());
                products.remove(index);
                System.out.print("\nNhấn ENTER để tiếp tục");
                scanner.nextLine();
            }
        }
    }

    public static void addNumberProduct() {
        showProduct();
        int number;
        int index;
        index = IndexProduct();
        if (index == -1) {
            System.out.println("Sản phẩm không tồn tại.");
            System.out.print("\nNhấn ENTER để tiếp tục");
            scanner.nextLine();
        } else {
            do {
                do {
                    try {
                        System.out.println("Nhập số lượng sản phẩm muốn thêm: ");
                        number = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (InputMismatchException | NumberFormatException e) {
                        System.out.println("Phải nhập số!");
                    }
                } while (true);
                if (number <= 0) {
                    System.out.println("\nMời nhập lại số lượng sản phẩm");
                }
            } while (number <= 0);
            products.get(index).addNumber(number);
            System.out.printf("Đã thêm %d '%s' vào danh sách sản phẩm.", number, products.get(index).getName());
            System.out.print("\nNhấn ENTER để tiếp tục");
            scanner.nextLine();
        }
    }

    public static void totalBillProduct() {
        int number;
        int index;
        index = IndexProduct();
        if (index == -1) {
            System.out.println("Sản phẩm không tồn tại.");
            System.out.print("\nNhấn ENTER để tiếp tục");
            scanner.nextLine();
        } else {
            if (products.get(index).getNumber() > 0) {
                do {
                    do {
                        try {
                            System.out.println("Nhập số lượng sản phẩm muốn mua:");
                            number = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (InputMismatchException | NumberFormatException e) {
                            System.out.println("Phải nhập số!");
                        }
                    } while (true);
                    if (number > products.get(index).getNumber() || number <= 0) {
                        System.out.println("\nMời nhập lại số lượng sản phẩm");
                    }
                } while (products.get(index).getNumber() < number || number <= 0);
                products.get(index).buy(number);
                System.out.printf("Đã mua sản phẩm '%s' với số lượng %d.", products.get(index).getName(), number);
                System.out.println("\nTổng số tiền phải thanh toán: " + products.get(index).covertBill(products.get(index).bill(number)));
                System.out.print("\nNhấn ENTER để tiếp tục");
                scanner.nextLine();
            } else {
                System.out.println("Sản phẩm hiện tại đã hết hàng.");
                System.out.print("\nNhấn ENTER để tiếp tục");
                scanner.nextLine();
            }
        }
    }
}