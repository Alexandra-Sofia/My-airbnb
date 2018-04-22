package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import entities.Reservation;

@WebServlet("/bookRequest")
public class BookRequest extends HttpServlet {


    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int listingId=Integer.parseInt(request.getParameter("listingId"));
        int userId=Integer.parseInt(request.getParameter("userId"));
        String dateOfArrival=request.getParameter("dateOfArrival");
        String dateOfDepart=request.getParameter("dateOfDepart");
        int numOfDays=Integer.parseInt(request.getParameter("numOfDays"));
        String message = null;
        Reservation r = new Reservation();
        String result = r.MakeReservation(listingId,userId,dateOfArrival,dateOfDepart, numOfDays);
        /*String result = r.MakeReservation(3480576,43,"2018-06-15","2018-06-10", 5);*/
        response.getWriter().write(result);
    }


    private final void serveLoginPageWithMessage(String msg, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().setAttribute("message", msg);
        if (!resp.isCommitted()) resp.sendRedirect(resp.encodeRedirectURL(String.format("%s/", req.getContextPath())));
    }

}
