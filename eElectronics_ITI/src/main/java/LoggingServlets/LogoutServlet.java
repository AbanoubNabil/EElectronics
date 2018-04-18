/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoggingServlets;

import java.io.IOException;
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
@WebServlet(name = "LogoutServlet", urlPatterns = {"/LogoutServlet"})
public class LogoutServlet extends HttpServlet {

 
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null && cookies.length > 1) {
//            for (Cookie c : cookies) {
//                
//                if (c.getName().equalsIgnoreCase("userPass")) {
//                    c.setMaxAge(0);
//                    response.addCookie(c);
//                    break;
//                }
//            }
//        }
        HttpSession session = request.getSession(false);
        session.removeAttribute("user");
        session.removeAttribute("admin");
        session.removeAttribute("isadmin");
        response.sendRedirect("index.jsp");
    }
    
}
