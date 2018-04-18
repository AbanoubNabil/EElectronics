/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoggingServlets;

import DAOS.UsersDAO;
import com.mycompany.eelectronics_iti.Users;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;

/**
 *
 * @author bombo
 */
@WebServlet(name = "SignupServlet", urlPatterns = {"/SignupServlet"})
public class SignupServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsersDAO userDao = new UsersDAO();
        Users user = new Users();
        System.out.println("in depost \n");
        user.setUserName(request.getParameter("name"));
        user.setUserPhone(request.getParameter("phone"));
        user.setUserGender(request.getParameter("gender"));
        user.setUserEmail(request.getParameter("email"));
        user.setUserPassword(request.getParameter("password"));
        user.setUserBalance(Double.parseDouble(request.getParameter("balance")));
        String city=request.getParameter("city");
        if(city == null){
            city=" ";
            }
        user.setUserAddress(request.getParameter("country")+","+city+","+request.getParameter("address"));
        System.out.println(user);
        userDao.createUser(user);
        System.out.println("after create");
        response.sendRedirect("login.jsp");

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsersDAO userDao = new UsersDAO();
        Users user = new Users();
        System.out.println("in depost \n");
        user.setUserName(request.getParameter("name"));
        //user.set(request.getParameter("birth"));
        user.setUserPhone(request.getParameter("phone"));
        user.setUserGender(request.getParameter("gender"));
        user.setUserEmail(request.getParameter("email"));
        user.setUserPassword(request.getParameter("password"));
        user.setUserBalance(Double.parseDouble(request.getParameter("balance")));
        String city=request.getParameter("city");
        if(city == null){
            city=" ";
            }
        user.setUserAddress(request.getParameter("country")+","+city+","+request.getParameter("address"));
        System.out.println(user);
        userDao.createUser(user);
        System.out.println("after create");
         response.sendRedirect("login.jsp");

    }

}
