package Entity;

import java.util.ArrayList;
import java.util.Objects;

public class Product {
    private String productId;
    private String name;
    private String imagefile;
    private double price;
    private static ArrayList<Product> elements = new ArrayList<>();


    public static Product getInstance(String productId, String name, String imagefile, double price){
        for(int i = 0;i < elements.size();i++){
            if(elements.get(i).getProductId().equals(productId)){
                return elements.get(i);
            }
        }
        synchronized (Product.class){
            for(int i = 0;i < elements.size();i++){
                if(elements.get(i).getProductId().equals(productId)){
                    return elements.get(i);
                }
            }
            Product newProd = new Product(productId,name,imagefile,price);
            elements.add(newProd);
            return newProd;
        }
    }
    private Product(String productId, String name, String imagefile, double price) {
        this.productId = productId;
        this.name = name;
        this.imagefile = imagefile;
        this.price = price;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return productId.equals(product.getProductId());
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setImagefile(String imagefile) {
        this.imagefile = imagefile;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getImagefile() {
        return imagefile;
    }

    public double getPrice() {
        return price;
    }
}
