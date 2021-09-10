/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author C
 */
@Entity
@Table(name = "ProductPurchase")
public class ProductPurchase {
    
    @Id
    @Column(name = "idProductPurchase", unique = true)
    private int idProductPurchase;
    
    @Column(name = "amount", nullable = false)
    private double amount;
}
