/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.lmandic.webshop.repository;

import hr.algebra.lmandic.webshop.factory.RepoFactory;
import hr.algebra.lmandic.webshop.model.UserLogin;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author C
 */
public class UserLoginRepo {

    private final EntityManagerFactory emf = RepoFactory.getEntityManagerFactory();

    public List<UserLogin> getUserLogins() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("from UserLogin");

        List<UserLogin> result = null;

        try {
            result = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int insertUserLogin(UserLogin userLogin) {
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();

        Query query = em.createNativeQuery("insert into userlogin (userlogindate, ipaddress, userid) VALUES (?,?,?)");
        query.setParameter(1, userLogin.getUserLoginDate());
        query.setParameter(2, userLogin.getIpAddress());
        query.setParameter(3, userLogin.getUserAccount().getId());

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
    
    
    public List<UserLogin> getUserLoginsByUserId(int userId) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createNativeQuery("select * from userlogins where userid = ?");
        query.setParameter(1, userId);
        
        List<UserLogin> result = null;

        try {
            result = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
