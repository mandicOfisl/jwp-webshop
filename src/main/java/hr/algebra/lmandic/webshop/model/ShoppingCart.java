/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.lmandic.webshop.model;

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

    private double totalAmount = 0;

    public void put(Product product, Integer quantity) {

        int q = items.containsKey(product) ? 
                items.get(product) + quantity : quantity;

        items.put(product, q);
        
        itemsNumber = (int) calculateProperty(items, "quantity");
        
        totalAmount = calculateProperty(items, "price");
    }

    private double calculateProperty
        (HashMap<Product, Integer> items, String countedProperty) {
        double sum = 0;
        
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            sum += countedProperty.equals("price") ?
                    entry.getKey().getPrice() * entry.getValue() :
                        entry.getValue();
        }
        
        return sum;
    }


}
