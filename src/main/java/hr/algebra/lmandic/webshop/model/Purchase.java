
package hr.algebra.lmandic.webshop.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;


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
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private UserAccount userAcc;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paymentTypeId", nullable = false)
    private PaymentType paymentType;
    
    @OneToMany(mappedBy = "purchase", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Set<ProductPurchase> productPurchases = new HashSet<ProductPurchase>(); 
    
}
