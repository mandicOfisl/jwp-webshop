package hr.algebra.lmandic.webshop.repository;

import hr.algebra.lmandic.webshop.factory.RepoFactory;
import hr.algebra.lmandic.webshop.model.Category;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import hr.algebra.lmandic.webshop.model.Product;
import java.math.BigDecimal;

/**
 *
 * @author C
 */
public class ProductRepo {

    private final EntityManagerFactory emf = RepoFactory.getEntityManagerFactory();

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
    
    public List<Product> getProductsByCategoryId(Category category) {
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("select p from Product p where p.category = :catId");
        query.setParameter("catId", category);
        
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
        
        List<Product> result = null;
        
        return 0;
    }

    public Product getProductById(Integer id) {
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("select p from Product p where p.id = :id");
        query.setParameter("id", id);
        
        Product result = null;
        
        try {
            result = (Product) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return result;
    }
    
    public int update(Integer id, String name, Integer catId, BigDecimal price) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Query query = em.createNativeQuery("update product set name = ?, price = ?, categoryid = ? where idproduct = ?");
        query.setParameter(1, name);
        query.setParameter(2, price);
        query.setParameter(3, catId);
        query.setParameter(4, id);
        
        int res;

        try {
            res = query.executeUpdate();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return -1;
        }

        return res;     
        
    }

    public int delete(Integer productId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Query query = em.createNativeQuery("delete from product where idproduct = ?");
        query.setParameter(1, productId);
                
        int res;

        try {
            res = query.executeUpdate();
            
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return -1;
        }

        return res;     
    }

}
