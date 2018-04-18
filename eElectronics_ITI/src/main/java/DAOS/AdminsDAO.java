/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import com.mycompany.eelectronics_iti.Admin;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author bombo
 */

public class AdminsDAO {

     public void createAdmin(Admin a) {
        System.out.println("before product update ");
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(a);
        System.out.println("after product update  ");
        session.getTransaction().commit();
        session.close();
    }

    public void deleteAdmin(Admin a) {
        System.out.println("before admin delete ");
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(a);
        System.out.println("after admin delete  ");
        session.getTransaction().commit();
        session.close();
    }

//    public ArrayList<Admin> retrieveAdmin(Admin a) {
//        ArrayList<Admin> res = new ArrayList<>();
//
//        return res;
//    }

    public void updateAdmin(Admin a) {
        System.out.println("before admin update ");
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(a);
        System.out.println("after admin update  ");
        session.getTransaction().commit();
        session.close();
    }

    public boolean isAdmin(String email, String pass) {
        boolean res = false;
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String queryString = "from Admin A where A.adminEmail = ? and A.adminPassword = ? ";
        Query q = session.createQuery(queryString);
        q.setString(0, email);
        q.setString(1, pass);
        ArrayList <Admin> admins = (ArrayList) q.list();
        if (admins.isEmpty()) {
             res = false;
        }else{
            res= true ;
        }
        session.getTransaction().commit();
        session.close();
        return res;
    }
    public Admin getUserByEmail(String email) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String queryString = "from Admin a where a.adminEmail = ? ";
        Query q = session.createQuery(queryString);
        q.setString(0, email);
        ArrayList <Admin> admin = (ArrayList) q.list();
        session.getTransaction().commit();
        session.close();
        return admin.get(0);
    }

}
