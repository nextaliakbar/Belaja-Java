package programmer.zaman.now.application;

import programmer.zaman.now.data.Product;

public class ProductApp {
    public static void main(String[] args) {
        Product product1 = new Product("Mac Book Pro", 10000);
        Product product2 = new Product("Mac Book Pro", 10000);
        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product1.equals(product2));
        System.out.println(product1.hashCode() == product2.hashCode());
    }
}
