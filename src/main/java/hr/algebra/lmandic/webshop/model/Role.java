/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author C
 */
@Entity
@Table(name = "Role")
public @Data class Role implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRole", unique = true)
    private int id;
    
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    
    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Set<User> users;
}
