package servlets;

/**
 * Created by Alexandra on 27/4/2017.
 */

import java.util.List;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Host;
import entities.Listing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListingController extends HttpServlet {
    private static final long serialVersionUID = 9154372860383130250L;

    private static final Logger logger = LoggerFactory.getLogger(HomepageController.class.getName());

    public void init() throws ServletException {
        super.init();

        /*if (logger.isInfoEnabled()) logger.info("[{}] has been initialized with {}", servlets.HomepageController.class.getSimpleName(), service);*/
    }
    /*@Override*/
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uriRequest = request.getRequestURI().toLowerCase();

       /* if (uriRequest.endsWith("main.jsp") || uriRequest.endsWith("index.jsp")) {
            ResponseUtils.sendMovedPermanently(response, String.format("%s/", request.getContextPath()));
            return;
        }*/

       /*Here i will add the initialization of a list of popular apartments for the homepage*/
        /*Apartment A = Apartment.getInstance();
        A.init();
        request.setAttribute("APART", A);*/


        Listing L= new Listing();
        String apartmentId= request.getParameter("id");
        List<Listing> results=L.getListing(apartmentId);
        request.setAttribute("APARTMENT", results.get(0));
        request.setAttribute("USERID", "43");
        System.out.println("\n\n\n\n\n\n\n");
        System.out.println(results.get(0).getHost());
        System.out.println("\n\n\n\n\n\n\n\n");
/*
        Host H = new Host();
        List<Host> hosts=H.getfromId(results.get(0).getHost());
        request.setAttribute("HOST", hosts.get(0));*/

        getServletContext().getRequestDispatcher("/views/listing.jsp").forward (request, response);
    }

}
