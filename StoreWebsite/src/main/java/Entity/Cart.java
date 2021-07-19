package Entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cart {
    private HashMap<Product,Integer> productsInCart;

    public Cart(){
        productsInCart = new HashMap<>();
    }

    public int getProduct(Product p){
        return productsInCart.get(p);
    }

    public HashSet<Product> getProducts(){
        HashSet<Product> products = new HashSet<>();
        for(Product p : productsInCart.keySet()){
            products.add(p);
        }
        return products;
    }

    public boolean contains(Product p){
        if(productsInCart.containsKey(p))return true;
        return false;
    }

    public double totalSum(){
        double ret = 0;
        for(Product p : productsInCart.keySet()){
            ret += p.getPrice() * productsInCart.get(p);
        }
        return ret;
    }

    public void addToCart(Product prod){
        if(productsInCart.containsKey(prod)){
            int num = productsInCart.get(prod);
            productsInCart.put(prod,num + 1);
            return;
        }
        productsInCart.put(prod,1);
    }
    public void addToCart(Product prod,int quantity){
            if(quantity <= 0){
                productsInCart.remove(prod);
                return;
            }
            productsInCart.put(prod,quantity);
    }


}
