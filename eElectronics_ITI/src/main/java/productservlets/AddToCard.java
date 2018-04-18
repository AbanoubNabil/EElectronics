/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productservlets;

import com.mycompany.eelectronics_iti.Products;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author eslam java
 */
@WebServlet(name = "AddToCard", urlPatterns = {"/AddToCard"})
public class AddToCard extends HttpServlet {

    private ServletContext servletContext;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        int addedProductId = Integer.parseInt(request.getParameter("productId"));
        boolean addedFlag = true;
        if (session != null) {
            if (session.getAttribute("userCart") != null) {
                Products retrivedProduct = getProductWithId(addedProductId);
                ArrayList<Products> userCart = (ArrayList<Products>) session.getAttribute("userCart");
                for (Products p : userCart) {

                    if (p.getProductId() == retrivedProduct.getProductId()) {

                        out.write("addedToCart");
                        addedFlag = false;
                        break;

                    }
                }

                if (addedFlag) {

                    userCart.add(retrivedProduct);

                }

            }

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected Products getProductWithId(int productId) {
        ArrayList<Products> allProducts;
        Products p = null;
        allProducts = (ArrayList<Products>) servletContext.getAttribute("AllProducts");

        for (Products i : allProducts) {
            if (i.getProductId() == productId) {
                p = i;
            }
        }
        //retrieve from DB
//        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
//        Session session=sessionFactory.openSession();
//        
//        session.beginTransaction();
//         p=(Products)session.get(Products.class, productId);
//         
////         String queryString = "from Products p where p.productId = ? ";
////         Query q=session.createQuery(queryString).setInteger(0, productId);
////         retrievedProduct=(ArrayList<Products>)q.list();
////        session.persist(c);
//         
//        System.out.println(p.getProductId() + "the name " + p.getProductName()); 
//        session.getTransaction().commit();
//        session.close();
        return p;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {

        servletContext = config.getServletContext();
    }

}
