package sort;

import model.Product;

import java.util.Comparator;

public class SortProduct_Price implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        return (int)(product1.getPrice()-product2.getPrice());
    }
}
