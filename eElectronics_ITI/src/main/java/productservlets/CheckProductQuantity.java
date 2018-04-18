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
import java.util.HashMap;
import java.util.Map;
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
@WebServlet(name = "CheckProductQuantity", urlPatterns = {"/CheckProductQuantity"})
public class CheckProductQuantity extends HttpServlet {

    
    
    private ServletConfig cnfg;
    private ServletContext context;   
    private ArrayList<Products> allProducts;
    
   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        context = cnfg.getServletContext();
       HttpSession  session = request.getSession(false);
        allProducts = (ArrayList<Products>) context.getAttribute("AllProducts");

       

        Integer addedProductId = Integer.parseInt(request.getParameter("addedProductId"));
        Integer addedProductQuantity = Integer.parseInt(request.getParameter("addedProductQuantity"));

        if (session != null) {

            if ((addedProductId != null) && (addedProductQuantity != 0)) {

                for (Products p : allProducts) {
                    if (p.getProductId() == addedProductId) {
                       int available = p.getProductQuantity();
                        if (available >= addedProductQuantity) {
                            out.print(p.getProductPrice() * addedProductQuantity);
                            //if it is exists it will override its value
                           HashMap<Integer, Integer> cartProductsMap = (HashMap<Integer, Integer>) session.getAttribute("cartMap");
                            cartProductsMap.put(p.getProductId(), addedProductQuantity);
                            
                            double totalOrderPrice = 0;
                            for (Map.Entry<Integer, Integer> entrySet : cartProductsMap.entrySet()) {

                                int key = entrySet.getKey();
                                int value = entrySet.getValue();
                                for (Products p2 : (ArrayList<Products>) session.getAttribute("userCart")) {
                                    if (p2.getProductId() == key) {

                                        totalOrderPrice += value * p2.getProductPrice();
                                    }

                                }

                            }

                            session.setAttribute("totalOrderPrice", totalOrderPrice);

                        } else {
                            out.print("no enough items MAX item avilabel is " + available);
                        }
                    }
                }

            }// else if (addedProductQuantity == 0) {
            // out.print("invalid quantity 0 ");
            // }
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

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        cnfg = config;

    }
}
