package manager;

import model.Cart;
import model.Product;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ManagerCart {
    Scanner scanner = new Scanner(System.in);
     List<Cart> carts = new LinkedList<>();
    public void addCart( Cart cart) {
        //Product product = createProduct();
        carts.add(cart);
        System.out.printf("Đã thêm sản phẩm '%s' vào giỏ hàng", cart.getName());
        scanner.nextLine();
    }

    public void showCart() {
        if (carts.isEmpty()){
            System.out.println("Không có sản phẩm nào");
        }else {
            for (Cart cart : carts) {
                System.out.println(cart.toString());
            }
        }
    }

}
