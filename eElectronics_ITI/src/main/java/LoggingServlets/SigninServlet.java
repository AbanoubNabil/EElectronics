/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoggingServlets;

import DAOS.AdminsDAO;
import DAOS.UsersDAO;
import com.mycompany.eelectronics_iti.Admin;
import com.mycompany.eelectronics_iti.Users;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bombo
 */
@WebServlet(name = "SigninServlet", urlPatterns = {"/SigninServlet"})
public class SigninServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsersDAO userDao = new UsersDAO();
        AdminsDAO adminDao = new AdminsDAO();

        String userEmail = null;
        String password = null;
        Users user = null;
        Admin admin;
        // if request comming from form 
        if (request.getParameter("email") != null && request.getParameter("password") != null) {
            userEmail = request.getParameter("email");
            password = request.getParameter("password");
            System.out.println("emai : " + userEmail + "" + password);
            if (adminDao.isAdmin(userEmail, password)) {
                admin = adminDao.getUserByEmail(userEmail);
                HttpSession session = request.getSession(true);
                session.setMaxInactiveInterval(60 * 60 * 24 * 30);
                session.setAttribute("admin", admin);
                session.setAttribute("isadmin", true);
                response.sendRedirect("index.jsp");

            } else if (userDao.isUser(userEmail, password)) {

                user = userDao.getUserByEmail(userEmail);
//                    Cookie userEmailCookie = new Cookie("userEmail", userEmail);
//                    Cookie userPassCookie = new Cookie("userPass", password);
//                    userEmailCookie.setMaxAge(60 * 60 * 24 * 30);
//                    userPassCookie.setMaxAge(60 * 60 * 24 * 30);
//                    response.addCookie(userEmailCookie);
//                    response.addCookie(userPassCookie);

                HttpSession session = request.getSession(true);
                session.setMaxInactiveInterval(60 * 60 * 24 * 30);
                session.setAttribute("user", user);
                session.setAttribute("isadmin", false);
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("loginerr.jsp");

            }
        }

    }
}
