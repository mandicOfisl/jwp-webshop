/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.lmandic.webshop.repository;

import hr.algebra.lmandic.webshop.factory.RepoFactory;
import java.util.List;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import hr.algebra.lmandic.webshop.model.Product;

/**
 *
 * @author C
 */
public class ProductRepo {

    private final EntityManagerFactory emf = RepoFactory.getEntityManagerFactory();
    private final Properties sqlProps = PropertiesRepo.getSqlProperties();

    public List<Product> getProducts() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("from Product");
        
        List<Product> result = null;
        
        try {
            result = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return result;
    }
    
    
    public int insertProduct(Product newProduct){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Product> tq = em.createQuery(sqlProps.getProperty("getProducts"), Product.class);
        List<Product> result = null;
        
        
        
        
        
        return 0;
    }

}
