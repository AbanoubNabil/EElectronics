/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eelectronics_iti;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author eslam java
 */
public class Test {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();


        Users user=new Users();
        
        user.setUserName("islam");
        user.setUserEmail("islamanwar27@gmail.com");
        user.setUserBalance(100);
        user.setUserGender("male");
        user.setUserPassword("islam");
        user.setUserPhone("0128973254");
        
        
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
        
        session.close();
    
       

    }
}