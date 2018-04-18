/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminservlets;

import DAOS.UsersDAO;
import com.mycompany.eelectronics_iti.Users;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author men3m
 */
@WebServlet(urlPatterns = {"/EditProfile"})
public class EditProfile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Users user = new Users();

            String userName = request.getParameter("userName");
            String email = request.getParameter("Email");
            String phone = request.getParameter("phone");
            double  palance = Double.parseDouble(request.getParameter("Balance"));
            String gender = request.getParameter("gender");
            String password = request.getParameter("password");
            String address = request.getParameter("address");

            System.out.println("=================" + request.getParameter("userName"));
            System.out.println("=================" + request.getParameter("Email"));
            System.out.println("=================" + request.getParameter("phone"));
            System.out.println("=================" + request.getParameter("Balance"));
            System.out.println("=================" + request.getParameter("gender"));
            System.out.println("=================" + request.getParameter("password")); 
            
            user.setUserName(userName);
            user.setUserEmail(email);
            user.setUserGender(gender);
            user.setUserPassword(password);
            user.setUserPhone(userName);
            user.setUserBalance(palance);
            user.setUserId(Integer.parseInt(request.getParameter("id")));
            user.setUserAddress(address);
            edit_Profile(user);
            request.getSession().setAttribute("user", user);
            response.sendRedirect("UserProfile.jsp");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
     public void edit_Profile(Users user) throws SQLException {
         new UsersDAO().updateUser(user);
}

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
