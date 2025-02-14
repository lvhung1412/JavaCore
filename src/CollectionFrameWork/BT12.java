package CollectionFrameWork;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BT12 {
    static class Product{
        public String name;
        public String id;
        public Double price;
        public Date dateOfManufacture;

        public Product(String name, String id, Double price, Date dateOfManufacture) {
            this.name = name;
            this.id = id;
            this.price = price;
            this.dateOfManufacture = dateOfManufacture;
        }

        @Override
        public String toString() {
            return "Product [name=" + name + ", id=" + id + ", price=" + price + ", dateOfManufacture="
                    + dateOfManufacture + "]";
        }
    }

    public static void sortByName(List<Product> products){
        Collections.sort(products, Comparator.comparing(p -> p.name));
    }

    public static void sortByPrice(List<Product> products){
        Collections.sort(products, Comparator.comparingDouble(p->p.price));
    }

    public static void sortByDateOfManufacture(List<Product> products){
        Collections.sort(products, Comparator.comparing(p-> p.dateOfManufacture));
    }

    public static void sortByPriceAndDateOfManufacture(List<Product> products){
        Collections.sort(products, Comparator
            .comparing((Product p) -> p.price)
            .thenComparing((Product p) -> p.dateOfManufacture));
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Laptop", "1", 1200.0, Date.valueOf("2000-11-11")));
        products.add(new Product("Smartphone","2", 800.0, Date.valueOf("2001-12-12")));
        products.add(new Product("Iphone","4", 900.0, Date.valueOf("2003-12-10")));
        products.add(new Product("Android","3", 1100.0, Date.valueOf("2000-09-09")));

        System.out.println("Ban đầu: ");
        for(Product product: products){
            System.out.println(product);
        }

        System.out.println("Sort by Name: ");
        sortByName(products);
        for(Product product: products){
            System.out.println(product);
        }

        System.out.println("Sort by Price: ");
        sortByPrice(products);
        for(Product product: products){
            System.out.println(product);
        }

        System.out.println("Sort by Date: ");
        sortByDateOfManufacture(products);
        for(Product product: products){
            System.out.println(product);
        }

        System.out.println("Sort by Price and Date: ");
        sortByPriceAndDateOfManufacture(products);
        for(Product product: products){
            System.out.println(product);
        }

    }
}
