/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productservlets;

import DAOS.OrdersDAO;
import com.mycompany.eelectronics_iti.Orders;
import com.mycompany.eelectronics_iti.Products;
import com.mycompany.eelectronics_iti.Users;
import dao.RetriveProducts;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author eslam java
 */
@WebServlet(name = "ProceedWithCheckOut", urlPatterns = {"/ProceedWithCheckOut"})
public class ProceedWithCheckOut extends HttpServlet {

    private ServletConfig conf;
    private ServletContext servletContext;
    private ArrayList<Products> allProducts;
    private RetriveProducts productsDao = new RetriveProducts();
    private OrdersDAO orderDao = new OrdersDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            servletContext = conf.getServletContext();
            allProducts = (ArrayList<Products>) servletContext.getAttribute("AllProducts");

            HttpSession session = request.getSession(false);
            HashMap< Integer, Integer> cartMap = (HashMap<Integer, Integer>) session.getAttribute("cartMap");
            Users user = (Users) session.getAttribute("user");
            double totalOrderPrice = (double) session.getAttribute("totalOrderPrice");
            int totalProductsNumber = 0;
            Orders order = new Orders();
            HashSet<Products> productsSet = new HashSet();

            if (user != null) {
                if (user.getUserBalance() > totalOrderPrice) {
                    for (Map.Entry<Integer, Integer> entrySet : cartMap.entrySet()) {
                        int key = entrySet.getKey();
                        for (Products p : allProducts) {
                            if (p.getProductId() == key) {
                                p.setProductQuantity(p.getProductQuantity() - entrySet.getValue());
                                productsDao.updateProductInDb(p);
                                totalProductsNumber += entrySet.getValue();
                                productsSet.add(p);
                            }
                        }
                    }

                    order.setOrderPrice(totalOrderPrice);
                    order.setOrderDate(new Date().toString());
                    order.setProductses(productsSet);

                    order.setOrderAmount(totalProductsNumber);
                    order.setUsers(user);

                    user.setUserBalance((int) (user.getUserBalance() - totalOrderPrice));
                    productsDao.updateUser(user);
                    orderDao.createOrder(order);
                    response.sendRedirect("checkout.jsp");
                } else {

                    response.sendRedirect("cart.jsp?userBalanceStatus=invalid");
                }
            } else {

                response.sendRedirect("login.jsp?loginStatus=invalid");

            }
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); //To change body of generated methods, choose Tools | Templates.
        conf = config;
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
