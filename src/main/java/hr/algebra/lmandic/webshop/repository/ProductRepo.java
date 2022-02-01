package hr.algebra.lmandic.webshop.repository;

import hr.algebra.lmandic.webshop.factory.RepoFactory;
import hr.algebra.lmandic.webshop.model.Category;
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
        //TypedQuery<Product> tq = em.createQuery(sqlProps.getProperty("getProducts"), Product.class);
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

}
