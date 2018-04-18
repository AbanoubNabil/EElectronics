package adminservlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DAOS.ProductsDAO;
import com.mycompany.eelectronics_iti.Products;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bombo
 */
@WebServlet(urlPatterns = {"/DeleteProduct"})
public class DeleteProduct extends HttpServlet {

    private ServletContext servletContext;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        servletContext = request.getServletContext();
        ArrayList<Products> allProducts;
        allProducts = (ArrayList<Products>) servletContext.getAttribute("AllProducts");

        if (request.getParameter("id") != null) {

            Products p=null;
            Integer pid = Integer.parseInt(request.getParameter("id"));
            for (Products i : allProducts) {
                if (i.getProductId() == pid) {
                   p=i;
                }
                
            }
            if(p!=null){
                allProducts.remove(p);
            }
            new ProductsDAO().deleteProduct(pid);

            

        }
        response.sendRedirect("AllProducts.jsp");

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

}
