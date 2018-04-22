package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.*;

import javax.servlet.*;
import javax.servlet.http.*;

import entities.Listing;
import org.apache.log4j.Logger;

public class ProfileController extends HttpServlet{

    static Logger log = Logger.getLogger("HomepageController.class");

    public void init() throws ServletException {
        super.init();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String uriRequest = request.getRequestURI().toLowerCase();

        try {
            HttpSession session = request.getSession(false);
            session.setMaxInactiveInterval(30*60);
            getServletContext().getRequestDispatcher("/views/profile.jsp").forward(request, response);

        }
        catch (Exception e) {
            throw new ServletException(e);
        }


    }
}
