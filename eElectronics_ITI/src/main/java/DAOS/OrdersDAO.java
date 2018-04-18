/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import com.mycompany.eelectronics_iti.Orders;
import com.mycompany.eelectronics_iti.Users;
import java.util.ArrayList;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author bombo
 */
public class OrdersDAO {

    public void createOrder(Orders order) {
        System.out.println("before order update ");
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(order);
        System.out.println("after order update  ");
        session.getTransaction().commit();
        session.close();
    }

    public void deleteOrder(Orders order) {
        System.out.println("before order delete ");
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(order);
        System.out.println("after order delete  ");
        session.getTransaction().commit();
        session.close();
    }
    
public void deleteUserOrders(int uId) {
         
       
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        String queryString = "delete Users u where u.userId = ?";
        
        Query q = session.createQuery(queryString);
        q.setInteger(0, uId);
        q.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public ArrayList<Orders> retrieveAllOrders() {
        ArrayList<Orders> allOrders = new ArrayList<>();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String queryString = "from Orders ";
        Query q = session.createQuery(queryString);
        allOrders=(ArrayList<Orders>) q.list();
        System.out.println("after all Orders : "+allOrders.size());
        session.getTransaction().commit();
        session.close();
        return allOrders;
    }

    public void updateOrder(Orders order) {
        System.out.println("before order update ");
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(order);
        System.out.println("after order update  ");
        session.getTransaction().commit();
        session.close();
    }
    
   

}
