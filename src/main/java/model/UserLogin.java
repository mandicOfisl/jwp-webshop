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
@Table(name = "UserLogin")
public class UserLogin {
    
    @Id
    @Column(name = "idUserLogin", unique = true)
    private int idUserLogin;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "userLoginDate", nullable = false)
    private Date userLoginDate;
    
    @Column(name = "ipAddress", nullable = false)
    private String ipAddress;
}
