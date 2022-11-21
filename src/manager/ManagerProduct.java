package manager;

import model.Cart;
import model.Product;

import java.util.*;

public class ManagerProduct {
    Scanner scanner = new Scanner(System.in);
    static List<Product> products = new LinkedList<>();

    static {
        products.add(new Product("iphone", 5, 9000000));
    }

    // public static Map<String,Product>products=new HashMap<>();
    ManagerCart managerCart = new ManagerCart();

    public static List<Product> getProducts() {
        return products;
    }

    public void showProduct() {
        if (products.isEmpty()) {
            System.out.println("Không có sản phẩm nào");
        } else {
            //Collections.sort(products, new SortProduct_FirstName_LastNumber());
            for (int i = 0; i < products.size(); i++) {
                System.out.println(products.get(i).toString());
            }
        }
    }

    public void addArr() {
        Product product = createProduct();
        products.add(product);
        System.out.printf("Đã thêm sản phẩm '%s' vào danh sách", product.getName());
        scanner.nextLine();
    }

    public Product createProduct() {
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
        System.out.println("Nhập số lượng sản phẩm: ");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập giá sản phẩm: ");
        double price = Double.parseDouble(scanner.nextLine());
        Product product = new Product(name, number, price);
        return product;
    }

    public int IndexProduct() {
        System.out.println("Nhập tên sản phẩm:");
        String name = scanner.nextLine();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name))
                return i;
        }
        return -1;
    }

    public void delete() {
        int index;
        System.out.println("Nhập tên sản phẩm muốn xoá: ");
        index = IndexProduct();
        if (index < 0) {
            System.out.println("Sản phẩm không tồn tại.");
            scanner.nextLine();
        } else {
            System.out.printf("Đã xoá Account có sản phẩm '%s' trong danh sách", products.get(index).getName());
            products.remove(index);
            scanner.nextLine();
        }
    }

    public void edit() {
        int index;
        index = IndexProduct();
        if (index == -1) {
            System.out.println("Sản phẩm không tồn tại.");
            scanner.nextLine();
        } else {
            System.out.printf("Đã sửa thông tin của sản phẩm '%s' trong danh sách\n", products.get(index).getName());
            Product product = createProduct();
            products.set(index, product);
            scanner.nextLine();
        }
    }

    public void addNumberProduct() {
        showProduct();
        int number;
        int index;
        index = IndexProduct();
        if (index == -1) {
            System.out.println("Sản phẩm không tồn tại.");
            scanner.nextLine();
        } else {
            System.out.println(products.get(index).toString());
            do {
                System.out.println("Nhập số lượng sản phẩm muốn thêm");
                number = Integer.parseInt(scanner.nextLine());
                if (number <= 0) {
                    System.out.println("\nMời nhập lại số lượng sản phẩm");
                }
            } while (number <= 0);
            products.get(index).addNumber(number);
            System.out.printf("Đã thêm '%s' với số lượng %d.", products.get(index).getName(), number);
            scanner.nextLine();
        }
    }

    public void totalBillProduct() {
        int number;
        int index;
        index = IndexProduct();
        if (index == -1) {
            System.out.println("Sản phẩm không tồn tại.");
            scanner.nextLine();
        } else {
            if (products.get(index).getNumber() > 0) {
                do {
                    System.out.println("Nhập số lượng sản phẩm muốn mua");
                    number = Integer.parseInt(scanner.nextLine());
                    if (number > products.get(index).getNumber() || number <= 0) {
                        System.out.println("\nMời nhập lại số lượng sản phẩm");
                    }
                } while (products.get(index).getNumber() < number || number <= 0);
                products.get(index).buy(number);
                System.out.printf("Đã mua sản phẩm '%s' với số lượng %d.", products.get(index).getName(), number);
                System.out.println("\nTổng số tiền phải thanh toán: " + products.get(index).covertBill(products.get(index).bill(number)));

//                Cart cart=new Cart(products.get(index).getName(),number,products.get(index).bill(number));
//                managerCart.addCart(cart);

                scanner.nextLine();
            } else {
                System.out.println("Sản phẩm hiện tại đã hết hàng.");
                scanner.nextLine();
            }
        }
    }

//    public Cart muaSanPham(){
//        int number= Integer.parseInt(scanner.nextLine());;
//        int index;
//        index = IndexProduct();
//        products.get(index).buy(number);
//        System.out.printf("Đã mua sản phẩm '%s' với số lượng %d.", products.get(index).getName(), number);
//        System.out.println("\nTổng số tiền phải thanh toán: " + products.get(index).covertBill(products.get(index).bill(number)));
//                Cart cart=new Cart(products.get(index).getName(),number,products.get(index).bill(number));
//                return cart;
//    }

}