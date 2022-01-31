/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.lmandic.webshop.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author C
 */
@Entity
@Table(name = "Purchase")
public @Data class Purchase implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPurchase", unique = true)
    private int id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "purchaseDate", nullable = false)
    private Date purchaseDate;
    
    @Column(name = "amount", nullable = false)
    private double amount;
    
    @OneToMany(mappedBy = "purchase", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Set<ProductPurchase> productPurchases;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;
    
}
