package servlets;

/**
 * Created by alex on 28/6/2017.
 */

import java.io.*;
import javax.persistence.EntityManager;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.annotation.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import db.PersistenceManager;
import entities.User;

@WebServlet("/newuser")
public class newUser extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Do not allow GET requests
        request.getSession().invalidate();
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String e_mail = request.getParameter("e-mail");
        String phone_nu = request.getParameter("phone_number");
        String landlord = request.getParameter("landlord");
        /*String visitor = request.getParameter("visitor");*/

        try {
            User u=new User();
            List<User> user=u.getUnique(username);
            if (!user.isEmpty()) {
                request.getSession().setAttribute("message", "username already in use");
                getServletContext().getRequestDispatcher("/views/sign-in.jsp").forward(request, response);
                return;
            }
            User newuser = new User();
            newuser.setEmail(e_mail);
            newuser.setFirstName(name);
            newuser.setUsername(username);
            newuser.setPassword(password);
            newuser.setLastName(surname);
            newuser.setTelephone(phone_nu);
            EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
            em.getTransaction().begin();
            em.persist(newuser);
            em.getTransaction().commit();
            /*if(landlord=="true") {
                request.getSession().setAttribute("message", "To add apartment you have to wait for administration confirmation");
            }*/
            response.sendRedirect(response.encodeRedirectURL(String.format("%s/index.jsp", request.getContextPath())));
            /*// Create a session object if it is already not  created.
            HttpSession session = request.getSession(true);
            // Get session creation time.
            Date createTime = new Date(session.getCreationTime());
            // Get last access time of this web page.
            Date lastAccessTime =new Date(session.getLastAccessedTime());
            String userIDKey = new String("userID");

            if (session.isNew()){
                String title = "Welcome to my website";
                request.getSession().setAttribute("title", title);
            }
            request.getSession().setAttribute("user", user.get(0).getUsername());
            if(user.get(0).getAdmin()==false || user.get(0).getAdmin()){
                request.setAttribute("USER", user.get(0));
                getServletContext().getRequestDispatcher("/views/profile.jsp").forward(request, response);
            }
            else {

                *//*getServletContext().getRequestDispatcher("/administration").forward(request, response);*//*
                response.sendRedirect(response.encodeRedirectURL(String.format("%s/administration", request.getContextPath())));
            }*/

        }
        catch (Exception e) {
            throw new ServletException(e);
        }

    }

}
