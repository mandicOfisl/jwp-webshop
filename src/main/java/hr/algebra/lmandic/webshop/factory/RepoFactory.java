package hr.algebra.lmandic.webshop.factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author C
 */
public class RepoFactory {
    
    private static final EntityManagerFactory emf 
            = Persistence.createEntityManagerFactory("webShop");

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
