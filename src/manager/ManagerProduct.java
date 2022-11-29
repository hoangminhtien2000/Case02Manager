package manager;

import model.Product;

import java.util.*;

public class ManagerProduct {
    static Scanner scanner = new Scanner(System.in);
    static List<Product> products = new LinkedList<>();

    static {
        products.add(new Product("iphone", 5, 9000000));
    }

    public static List<Product> getProducts() {
        return products;
    }

    public static void showProduct() {
        if (products.isEmpty()) {
            System.out.println("Không có sản phẩm nào");
        } else {
            System.out.printf("%-5s%-15s%-10s%s\n","STT","Tên sản phẩm","Số lượng","Giá");
            for (Product product : products) {
                System.out.println(product.toString());
            }
        }
    }

    public static void addArr() {
        Product product = createProduct();
        products.add(product);
        System.out.printf("Đã thêm sản phẩm '%s' vào danh sách", product.getName());
        scanner.nextLine();
    }

    public static Product createProduct() {
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
            try {
                System.out.println("Nhập số lượng sản phẩm: ");
                number = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập giá sản phẩm: ");
                price = Double.parseDouble(scanner.nextLine());
                break;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Phải nhập số!");
            }
        }while (true);
        Product product = new Product(name, number, price);
        return product;
    }

    public static int IndexProduct() {
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

    public static void edit() {
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

    public static void addNumberProduct() {
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
                do {
                    try {
                        System.out.println("Mời nhập lựa chọn: ");
                        number = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (InputMismatchException | NumberFormatException e) {
                        System.out.println("Phải nhập số!");
                    }
                }while (true);
                if (number <= 0) {
                    System.out.println("\nMời nhập lại số lượng sản phẩm");
                }
            } while (number <= 0);
            products.get(index).addNumber(number);
            System.out.printf("Đã thêm '%s' với số lượng %d.", products.get(index).getName(), number);
            scanner.nextLine();
        }
    }

    public static void totalBillProduct() {
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
                    do {
                        try {
                            System.out.println("Mời nhập lựa chọn: ");
                            number = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (InputMismatchException | NumberFormatException e) {
                            System.out.println("Phải nhập số!");
                        }
                    }while (true);
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