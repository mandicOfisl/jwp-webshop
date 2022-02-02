/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.lmandic.webshop.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

/**
 *
 * @author C
 */
public @Data
class ShoppingCart {

    private HashMap<Product, Integer> items = new HashMap<>();
    

    private int itemsNumber = 0;

    private BigDecimal totalAmount = new BigDecimal(0);

    public void put(Product product, Integer quantity) {

        int q = items.containsKey(product) ? 
                items.get(product) + quantity : quantity;

        items.put(product, q);
        
        itemsNumber = calculateProperty(items, "quantity").intValue();
        
        totalAmount = calculateProperty(items, "price");
    }
    
    public void remove(Product product) {
        items.remove(product);
        
        itemsNumber = calculateProperty(items, "quantity").intValue();
        
        totalAmount = calculateProperty(items, "price");
    }
    
    public void changeQuantity(Product product, Integer quantity) {
        items.put(product, quantity);
        
        itemsNumber = calculateProperty(items, "quantity").intValue();
        
        totalAmount = calculateProperty(items, "price");
        
        
    }

    private BigDecimal calculateProperty
        (HashMap<Product, Integer> items, String countedProperty) {
        BigDecimal sum = new BigDecimal(0);
        
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            sum.add(countedProperty.equals("price") ?
                    entry.getKey().getPrice().multiply(new BigDecimal(entry.getValue())) :
                        new BigDecimal(entry.getValue()));
        }
        
        return sum;
    }


}
