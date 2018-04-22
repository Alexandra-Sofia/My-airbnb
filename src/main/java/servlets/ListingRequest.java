package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import entities.Listing;

public class ListingRequest extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String listing_url = request.getParameter("listing_url");
        String country = request.getParameter("country");
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String zipcode = request.getParameter("zipcode");
        String neighborhood_cleansed = request.getParameter("neighborhood_cleansed");
        String price = request.getParameter("price");
        String weekly_price = request.getParameter("weekly_price");
        String monthly_price = request.getParameter("monthly_price");
        String security_deposit = request.getParameter("security_deposit");
        String cleaning_fee = request.getParameter("cleaning_fee");
        String guests_included = request.getParameter("guests_included");
        String extra_people = request.getParameter("extra_people");
        String minimum_nights = request.getParameter("minimum_nights");
        String maximum_nights = request.getParameter("maximum_nights");
        String cancellation_policy = request.getParameter("cancellation_policy");
        String property_type = request.getParameter("property_type");
        String room_type = request.getParameter("room_type");
        String accommodates = request.getParameter("accommodates");
        String bathrooms = request.getParameter("bathrooms");
        String bedrooms = request.getParameter("bedrooms");
        String beds = request.getParameter("beds");
        String bed_type = request.getParameter("bed_type");
        String square_feet = request.getParameter("square_feet");
        String amenities = request.getParameter("amenities");
        String summary = request.getParameter("summary");
        String space = request.getParameter("space");
        String description = request.getParameter("description");
        String neighborhood_overview = request.getParameter("neighborhood_overview");
        String notes = request.getParameter("notes");
        String transit = request.getParameter("transit");
        Listing r = new Listing();
        String result = r.InsertListing(name,listing_url,country,zipcode,neighborhood_cleansed,price,weekly_price,
                monthly_price,security_deposit,cleaning_fee,guests_included,extra_people,minimum_nights,maximum_nights,
                cancellation_policy,property_type,room_type,accommodates,bathrooms,bedrooms,beds,bed_type,square_feet,
                amenities,summary,space,description,neighborhood_overview,notes,transit);
        response.getWriter().write(result);
    }


    private final void serveLoginPageWithMessage(String msg, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().setAttribute("message", msg);
        if (!resp.isCommitted()) resp.sendRedirect(resp.encodeRedirectURL(String.format("%s/", req.getContextPath())));
    }
}
