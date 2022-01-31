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
import hr.algebra.lmandic.webshop.model.Category;

/**
 *
 * @author C
 */
public class CategoryRepo {

    private final Properties sqlProps = PropertiesRepo.getSqlProperties();
private final EntityManagerFactory emf = RepoFactory.getEntityManagerFactory();
    

    public List<Category> getCategories() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("from Category");

        List<Category> result = null;

        try {
            result = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return result;
    }

    public int insertCategory(Category category) {
        EntityManager em = emf.createEntityManager();
        Query query = 
                em.createNativeQuery("insert into Category (idCategory, name) values (?id, ?name)");
        query.setParameter("id", category.getId());
        query.setParameter("name", category.getName());
        
        int rows;
        
        try {
            
            em.getTransaction().begin();
            rows = query.executeUpdate();
            em.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } 
        
        return rows;

    }
}
