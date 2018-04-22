package servlets;
/**
 * Created by Alexandra on 27/4/2017.
 */

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entities.Listing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SearchController extends HttpServlet{
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

        Listing L= new Listing();
        String city = request.getParameter("city");
        String dateFrom = request.getParameter("dateFrom");
        String dateTo = request.getParameter("dateTo");
        String visitors = request.getParameter("visitors");

        String pageSize = request.getParameter("pageSize");
        if(pageSize==null || pageSize.isEmpty()) pageSize="12";

        String page = request.getParameter("page");
        if(page==null || page.isEmpty()) page="1";
        List<Listing> results=L.getSearchListings(page,pageSize,city,dateFrom,dateTo,visitors);
        //List<String> places=L.getSearchPlaces();
        //List<Integer> guests=L.getMostGuests();
        /*for (Object[] obj : places) {
            System.out.print(obj[0]);
            System.out.print(obj[1]);
        }*/
        request.setAttribute("SEARCHRESULTS", results);
        request.setAttribute("PAGESIZE", Integer.parseInt(pageSize));
        request.setAttribute("PAGE", Integer.parseInt(page));

        //request.setAttribute("PLACES", places);
        //request.setAttribute("GUESTS", guests);
        //getServletContext().getRequestDispatcher("/views/home.jsp").forward (request, response);

        getServletContext().getRequestDispatcher("/views/search-results.jsp").forward (request, response);
    }

}