/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import com.mycompany.eelectronics_iti.Products;
import dao.RetriveProducts;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author eslam java
 */
public class EElectronicsContextListener implements ServletContextListener, ServletContextAttributeListener {

    
   private RetriveProducts ProductsDao;
   
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
         ProductsDao=new RetriveProducts();
         ArrayList<Products> products=ProductsDao.retriveAllProducts();
         sce.getServletContext().setAttribute("AllProducts",products );
         
         Iterator<Products> productsIterator = products.iterator();
         
         HashSet<String> categories=new HashSet<>();
         
         while (productsIterator.hasNext()) {
            
             Products product=productsIterator.next();
            categories.add(product.getProductCategory());
            
        }
         
         sce.getServletContext().setAttribute("categories",categories);
         
         
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent arg0) {
    }
}
