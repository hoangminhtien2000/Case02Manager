package sort;

import model.Product;

import java.util.Comparator;

public class SortProduct_FirstName_LastNumber implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        if (product1.getName().compareTo(product2.getName()) == 0)
            return product1.getNumber() - product2.getNumber();
        return product1.getName().compareTo(product2.getName());
    }
}
