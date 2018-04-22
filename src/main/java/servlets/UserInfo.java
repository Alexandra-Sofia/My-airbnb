package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import entities.User;
import entities.Host;

public class UserInfo extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        User u = new User();
        List<User> user = u.getUnique(username);
        u=user.get(0);
        request.setAttribute("USERINFO", user.get(0));

       /* Host h=new Host();
        List<Host> host = h.getfromId(user.get(0).getHost_id());
        h=host.get(0);*/

        Gson gson = new Gson();
        JsonObject myObj = new JsonObject();
        JsonElement userObj = gson.toJsonTree(u);
        /*JsonElement hostObj = gson.toJsonTree(h);*/
        myObj.addProperty("success", true);

        myObj.add("userinfo", userObj);
        /*myObj.add("hostinfo", hostObj);*/

        System.out.println(myObj.toString());
        response.getWriter().write(myObj.toString());
    }


}
