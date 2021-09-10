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
@Table(name = "Role")
public class Role {
    
    @Id
    @Column(name = "idRole", unique = true)
    private int idRole;
    
    @Column(name = "name", unique = true, nullable = false)
    private String name;
}
