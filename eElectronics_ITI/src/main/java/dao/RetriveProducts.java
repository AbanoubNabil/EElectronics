/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mycompany.eelectronics_iti.Products;
import com.mycompany.eelectronics_iti.Users;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author eslam java
 */
public class RetriveProducts {
    
   private  SessionFactory sessionFactory;
    
    public RetriveProducts(){
    
    sessionFactory = new Configuration().configure().buildSessionFactory();
        
    }
    
    public ArrayList retriveAllProducts(){
    
        ArrayList<Products> productsArray=new ArrayList<>();
        Session session = sessionFactory.openSession();
        
        Query q= session.createQuery("from Products ");
        productsArray=(ArrayList<Products>) q.list();
        
    
        session.close();
        return productsArray;
    }
    
       public void updateProductInDb(Products p) {
        System.out.println("before product update " + p.getProductQuantity());
       
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String queryString = "update Products p set product_quantity = ? where p.productId = ? ";
        Query q = session.createQuery(queryString);
        q.setInteger(0, p.getProductQuantity());
        q.setInteger(1, p.getProductId());
        int res = q.executeUpdate();
        System.out.println("after product update  " + p.getProductQuantity());
        session.getTransaction().commit();
        session.close();
    }
       
       public void updateUser(Users user){
       
           Session session = sessionFactory.openSession();
        session.beginTransaction();
        String queryString = "update Users u set userBalance = ? where u.userId = ? ";
        Query q = session.createQuery(queryString);
        q.setDouble(0, user.getUserBalance());
        q.setInteger(1, user.getUserId());
        int res = q.executeUpdate();
        System.out.println("after user update  " );
        session.getTransaction().commit();
        session.close();
           
       }
}
