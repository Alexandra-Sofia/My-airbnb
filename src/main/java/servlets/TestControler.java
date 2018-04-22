package servlets;

/**
 * Created by Alexandra on 28/4/2017.
 */


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestControler extends HttpServlet {
    private static final long serialVersionUID = 9154372860383130250L;

    private static final Logger logger = LoggerFactory.getLogger(HomepageController.class.getName());

    public void init() throws ServletException {
        super.init();

        /*if (logger.isInfoEnabled()) logger.info("[{}] has been initialized with {}", servlets.HomepageController.class.getSimpleName(), service);*/
    }
    /*@Override*/
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uriRequest = request.getRequestURI().toLowerCase();

       /* if (uriRequest.endsWith("main.jsp") || uriRequest.endsWith("index.jsp")) {
            ResponseUtils.sendMovedPermanently(response, String.format("%s/", request.getContextPath()));
            return;
        }*/

       /*Here i will add the initialization of a list of popular apartments for the homepage*/
        /*Apartment A=null;
        request.setAttribute("APART", A);*/
        getServletContext().getRequestDispatcher("/views/testing.jsp").forward (request, response);
    }

}
