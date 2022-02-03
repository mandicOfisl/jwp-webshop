package hr.algebra.lmandic.webshop.repository;

import hr.algebra.lmandic.webshop.factory.RepoFactory;
import hr.algebra.lmandic.webshop.model.UserAccount;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;


public class UserRepo {
    
    private final EntityManagerFactory emf = RepoFactory.getEntityManagerFactory();

    public UserAccount getUserByName(String username) {
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createNativeQuery("select * from useraccount where username = :name");
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
