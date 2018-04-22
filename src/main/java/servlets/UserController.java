package servlets;

/**
 * Created by alex on 12/9/2017.
 */

import entities.User;
import java.io.IOException;
import java.util.List;
import entities.User;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class UserController extends HttpServlet{
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Cookie loginCookie = new Cookie("user","user");
        //setting cookie to expiry in 30 mins
        loginCookie.setMaxAge(30*60);
        response.addCookie(loginCookie);

        /*query for all users*/
        User users = new User();
        List<User> suggest = users.getAllUsers();
        request.setAttribute("USERS", users);
        /*query for all listings*/
        /*query for current reservations*/

        getServletContext().getRequestDispatcher("/views/profile.jsp").forward(request, response);

    }

}
