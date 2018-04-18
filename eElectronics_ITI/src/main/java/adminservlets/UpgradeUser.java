/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminservlets;

import DAOS.AdminsDAO;
import DAOS.OrdersDAO;
import DAOS.UsersDAO;
import com.mycompany.eelectronics_iti.Admin;
import com.mycompany.eelectronics_iti.Users;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bombo
 */
@WebServlet(name = "UpgradeUser", urlPatterns = {"/UpgradeUser"})
public class UpgradeUser extends HttpServlet {

    AdminsDAO admndao = new AdminsDAO();
    UsersDAO userdao = new UsersDAO();
    OrdersDAO orderDao=new OrdersDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int id = Integer.parseInt(request.getParameter("id"));
        Users user=userdao.getUserById(id);
        Admin admin = new Admin();
        
        admin.setAdminName(user.getUserName());
        admin.setAdminEmail(user.getUserEmail());
        admin.setAdminPassword(user.getUserPassword());
        admin.setAdminGender(user.getUserGender());
        admin.setAdminPhone(user.getUserPhone());
        admin.setAdminCountry(user.getUserAddress());
        
        admndao.createAdmin(admin);      
        response.sendRedirect("AllUsers.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
