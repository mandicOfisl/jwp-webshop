/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author C
 */
@Entity
@Table(name = "Purchase")
public class Purchase {
    
    @Id
    @Column(name = "idPurchase", unique = true)
    private int idPurchase;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "purchaseDate", nullable = false)
    private Date purchaseDate;
    
}
