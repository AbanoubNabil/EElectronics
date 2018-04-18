package adminservlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DAOS.UsersDAO;
import com.mycompany.eelectronics_iti.Users;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = {"/GetAllUsers"})
public class GetAllUsers extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsersDAO userdao = new UsersDAO();
        ArrayList<Users> allusers = new ArrayList<>();
        HttpSession session;
        response.setContentType("text/html;charset=UTF-8");
        allusers = userdao.retrieveAllUsers();
        session = request.getSession(true);
        session.setAttribute("allusers", allusers);
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
