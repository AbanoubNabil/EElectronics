/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import com.mycompany.eelectronics_iti.Products;
import com.mycompany.eelectronics_iti.Users;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author eslam java
 */
public class SessionCreatedListner implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ArrayList<Products> userCart= new ArrayList<Products>();
        se.getSession().setAttribute("userCart", userCart);
        se.getSession().setAttribute("totalOrderPrice", 0.0);
        se.getSession().setAttribute("cartMap", new HashMap<Integer, Integer>());
        Users user=new Users();
        user.setUserBalance(100000);
       // se.getSession().setAttribute("user", user);
        System.out.println("==========================================userCart attribute is created======================================== ");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    }
}
