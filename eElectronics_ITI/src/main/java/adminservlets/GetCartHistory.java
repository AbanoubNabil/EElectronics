/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminservlets;


import DAOS.UsersDAO;
import com.mycompany.eelectronics_iti.Orders;
import com.mycompany.eelectronics_iti.Users;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bombo
 */
@WebServlet(name = "GetCartHistory", urlPatterns = {"/GetCartHistory"})
public class GetCartHistory extends HttpServlet {

   

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            UsersDAO userdao=new UsersDAO();
            
           Users u = userdao.getUserById(Integer.parseInt(request.getParameter("xyz"))); 
           
           request.setAttribute("order_list", u.getOrderses());
           
          RequestDispatcher rd= request.getRequestDispatcher("CartHistory.jsp");
          rd.forward(request, response);
          
    }
}
