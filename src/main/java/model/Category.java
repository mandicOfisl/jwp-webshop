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
@Table(name = "Category")
public class Category {
    
    @Id
    @Column(name = "idCategory", unique = true)
    private int idCategory;
    
    @Id
    @Column(name = "name", unique = true, nullable = false)
    private int name;    
    
}
