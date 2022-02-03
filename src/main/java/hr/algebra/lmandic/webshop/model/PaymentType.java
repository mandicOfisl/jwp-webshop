package hr.algebra.lmandic.webshop.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "PaymentType")
public @Data class PaymentType implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPaymentType", unique = true)
    private int id;
    
    @Column(name = "name", unique = true, nullable = false)
    private String name;
   
    @OneToMany(mappedBy = "paymentType", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Set<Purchase> purchases;
}
