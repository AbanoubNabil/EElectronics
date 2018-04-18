/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import com.mycompany.eelectronics_iti.Products;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author bombo
 */
public class ProductsDAO {
    
     public void createProduct(Products product){
        System.out.println("before product save /update ");
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.persist(product);
        System.out.println("after product save /update  ");
        session.getTransaction().commit();
        session.close();
    }
    public void deleteProduct(int id){
        System.out.println("before product delete ");
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.delete(session.get(Products.class, id));
        System.out.println("after product delete  ");
        session.getTransaction().commit();
        session.close();
    }
    public ArrayList<Products> retrieveAllProduct(){
     ArrayList<Products> res=new ArrayList<>();
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        String queryString = "from Products ";
        Query q = session.createQuery(queryString);
        res = (ArrayList) q.list();
        System.out.println("after product delete  ");
        session.getTransaction().commit();
        session.close();
        return res;
    }
     public Products retrieveProductById(int pid){
     ArrayList<Products> res=new ArrayList<>();
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        String queryString = "from Products p where p.productId = ? ";
        Query q = session.createQuery(queryString);
        q.setInteger(0, pid);
        res = (ArrayList) q.list();
        System.out.println("after retrieve product delete  ");
        session.getTransaction().commit();
        session.close();
        return res.get(0);
    }
    public void updateProduct(Products product){
        System.out.println("before product update ");
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.update(product);
        System.out.println("after product update  ");
        session.getTransaction().commit();
        session.close();
    
    }
}
