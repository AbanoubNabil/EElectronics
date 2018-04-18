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
@WebServlet(name = "DeleteProductFromCart", urlPatterns = {"/DeleteProductFromCart"})
public class DeleteProductFromCart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        Integer productId = Integer.parseInt(request.getParameter("productId"));

        ArrayList<Products> userCartProducts = (ArrayList<Products>) session.getAttribute("userCart");
       HashMap<Integer,Integer> productsCartMap= (HashMap<Integer, Integer>) session.getAttribute("cartMap");

        for (Products p : userCartProducts) {

            if (p.getProductId() == productId) {

                userCartProducts.remove(p);
            }

        }

        for (Map.Entry<Integer, Integer> entrySet : productsCartMap.entrySet()) {
            Integer key = entrySet.getKey();
            if (key.equals(productId)) {

                boolean removed = userCartProducts.remove(entrySet.getKey());
                session.removeAttribute("cartMap");
                session.setAttribute("cartMap", productsCartMap);
               
            }

        }

        double totalOrderPrice = 0;
        for (Map.Entry<Integer, Integer> entrySet : ((HashMap<Integer, Integer>) session.getAttribute("cartMap")).entrySet()) {

            int key = entrySet.getKey();
            int value = entrySet.getValue();
            for (Products p2 : (ArrayList<Products>) session.getAttribute("userCart")) {
                if (p2.getProductId() == key) {

                    totalOrderPrice += value * p2.getProductPrice();
                }

            }
        }
         session.setAttribute("totalOrderPrice", totalOrderPrice);

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
    public String getServletInfo() {
        return "Short description";
    }

}
