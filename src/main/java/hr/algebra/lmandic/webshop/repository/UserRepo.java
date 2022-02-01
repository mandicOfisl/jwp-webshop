/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.lmandic.webshop.repository;

import hr.algebra.lmandic.webshop.factory.RepoFactory;
import hr.algebra.lmandic.webshop.model.Product;
import hr.algebra.lmandic.webshop.model.UserAccount;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author C
 */
public class UserRepo {
    
    private final EntityManagerFactory emf = RepoFactory.getEntityManagerFactory();

    public UserAccount getUserByName(String username) {
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("select u from UserAccount u where u.username = :name");
        query.setParameter("name", username);
        
        List<UserAccount> result = null;
        
        try {
            result = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return result != null && result.size() > 0 ? result.get(0) : null;
    }
    
    
    
    
}
