package servlets;
/**
 * Created by Alexandra on 24/4/2017.
 */
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

/*Here i will add the initialization of a list of popular apartments for the homepage*/

public class HomepageController extends HttpServlet{
    private static final long serialVersionUID = 9154372860383130250L;

    static Logger log = Logger.getLogger("HomepageController.class");

    /*static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/airbnb?autoReconnect=true&useSSL=false";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "alex26713";*/

    public void init() throws ServletException {
        super.init();

        /*if (logger.isInfoEnabled()) logger.info("[{}] has been initialized with {}", servlets.HomepageController.class.getSimpleName(), service);*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String uriRequest = request.getRequestURI().toLowerCase();

        log.trace("Hello World!");
        log.debug("How are you today?");
        log.info("I am fine.");
        log.error("I am programming.");
        log.warn("I love programming.");
        log.fatal("I am now dead. I should have been a movie star.");

        try {
            System.out.println("\n--home is called!--\n");
            HttpSession session = request.getSession(true);
            if (session.isNew()) {
                request.getSession().setAttribute("user", "visitor");
            }
            Listing L = new Listing();
            List<Listing> suggest = L.getHomepageSuggestions();
            List<String> places = L.getSearchPlaces();
            List<Integer> guests = L.getMostGuests();

            request.setAttribute("SUGGESTIONS", suggest);
            request.setAttribute("PLACES", places);
            request.setAttribute("GUESTS", guests);
            getServletContext().getRequestDispatcher("/views/home.jsp").forward(request, response);

        }
        catch (Exception e) {
            throw new ServletException(e);
        }


    }

}