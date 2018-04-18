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
public class UsersDAO {
    
    public void createUser(Users u) {
        System.out.println("before User update ");
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(u);
        System.out.println("after User update  ");
        session.getTransaction().commit();
        session.close();
    }

    public void deleteUser(Users u) {
        System.out.println("before user delete ");
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(u);
        System.out.println("after user delete  ");
        session.getTransaction().commit();
        session.close();
    }

    public ArrayList<Users> retrieveAllUsers() {
        ArrayList<Users> res = new ArrayList<>();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String queryString = "from Users ";
        Query q = session.createQuery(queryString);
        res=(ArrayList<Users>) q.list();
        System.out.println("after all users : "+res.size());
        session.getTransaction().commit();
        session.close();
        return res;
    }

    public void updateUser(Users u) {
        System.out.println("before user update ");
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(u);
        System.out.println("after user update  ");
        session.getTransaction().commit();
        session.close();

    }

    public boolean isUser(String email, String pass) {
        boolean res = false;
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String queryString = "from Users u where u.userEmail = ? and u.userPassword = ? ";
        Query q = session.createQuery(queryString);
        q.setString(0, email);
        q.setString(1, pass);
        ArrayList <Users> user = (ArrayList) q.list();
        
        if (user.isEmpty()) {
            res = false;
        } else {
            res = true;
        }
        session.getTransaction().commit();
        session.close();
        return res;
    }
     public Users getUserById(int uid) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String queryString = "from Users u where u.userId = ? ";
        Query q = session.createQuery(queryString);
        q.setInteger(0, uid);
        ArrayList <Users> user = (ArrayList) q.list();
        session.getTransaction().commit();
        session.close();
        return user.get(0);
    }
    public Users getUserByEmail(String email) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String queryString = "from Users u where u.userEmail = ? ";
        Query q = session.createQuery(queryString);
        q.setString(0, email);
        ArrayList <Users> user = (ArrayList) q.list();
        session.getTransaction().commit();
        session.close();
        return user.get(0);
    }
     //check for errors (not accurate)
      public Set retrieveUserOrders(int uId) {
         
        ArrayList<Users> allOrders = new ArrayList<>();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        System.out.println("before  all Orders : ");
        
        String queryString = "from users u where u.userId = ?";
        
        Query q = session.createQuery(queryString);
        q.setInteger(0, uId);
        allOrders=(ArrayList<Users>) q.list();
        System.out.println("after all Orders : "+allOrders.get(0));
        session.getTransaction().commit();
        session.close();
        return allOrders.get(0).getOrderses();
    }
}
