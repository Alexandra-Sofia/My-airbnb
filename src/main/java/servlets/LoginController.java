package servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Alexandra on 27/4/2017.
 */
/*@WebServlet("/LoginServlet")*/
public class LoginController extends HttpServlet{
    private static final long serialVersionUID = 9154372860383130250L;

    private static final Logger logger = LoggerFactory.getLogger(HomepageController.class.getName());

    public void init() throws ServletException {
        super.init();

        /*if (logger.isInfoEnabled()) logger.info("[{}] has been initialized with {}", servlets.HomepageController.class.getSimpleName(), service);*/
    }
    /*@Override*/
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uriRequest = request.getRequestURI().toLowerCase();
        /*Defines an object that receives requests from the client and sends them to any resource (such as a servlet, HTML file, or JSP file) on the server.*/
        getServletContext().getRequestDispatcher("/views/sign-up.jsp").forward (request, response);
    }
}
