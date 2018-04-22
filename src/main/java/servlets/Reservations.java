package servlets;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import entities.User;

import javax.servlet.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Reservations extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("userid");

       /* User u = new User();
        List<User> user = u.getUnique(username);
        u=user.get(0);
        request.setAttribute("USERINFO", user.get(0));

        Gson gson = new Gson();
        JsonObject myObj = new JsonObject();
        JsonElement countryObj = gson.toJsonTree(u);
        myObj.addProperty("success", true);
        myObj.add("userinfo", countryObj);
        System.out.println(myObj.toString());
        response.getWriter().write(myObj.toString());*/
    }


}
