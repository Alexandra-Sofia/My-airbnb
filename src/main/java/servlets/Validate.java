package servlets;

/**
 * Created by alex on 28/6/2017.
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import entities.User;
import services.LoginService;

@WebServlet("/validate")
public class Validate extends HttpServlet {

    LoginService service = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println("--\n\nuser: "+username+"  pas: "+password+"--");
        System.out.println("--validation is called!--");
        /*String message = service.doLogin(username,password);*/
        String message = null;
        User u = new User();
        List<User> user = u.getValidation(username, password);
        System.out.println("--test:"+user.isEmpty()+"\n\n--");
        if (user.isEmpty()) {
            message = "FAILURE";
        } else {
            message = "SUCCESS";
        }
        if(message=="SUCCESS") {
            // Create a session object if it is already not  created.
            HttpSession session = request.getSession(true);
            // Get session creation time.
            Date createTime = new Date(session.getCreationTime());
            // Get last access time of this web page.
            Date lastAccessTime = new Date(session.getLastAccessedTime());
            session.setMaxInactiveInterval(30*60);
            Cookie loginCookie = new Cookie("user",username);
            //setting cookie to expiry in 30 mins
            loginCookie.setMaxAge(30*60);
            response.addCookie(loginCookie);
            System.out.println("--\n\nflag: "+user.get(0).getAdmin()+"--");
            if(user.get(0).getAdmin()==true){

                request.getSession().setAttribute("user","admin");
                message = "ADMIN";
            }
            else{
                request.getSession().setAttribute("user", username);
            }
            
            request.getSession().setAttribute("userID", user.get(0).getId());
            response.getWriter().write(message);
          
        }

    }

   /* @Override*//*this exists so i dont call the default doPost and hell breaks loose*//*
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ip = request.getParameter("ip");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        try {
            User u=new User();
            List<User> user=u.getValidation(login,password);
            if (user.isEmpty()) {
                *//*PrintWriter out= response.getWriter();
                out.println("<font color=red>Either user name or password is wrong!</font>");*//*
                request.setAttribute("layout","error");
                getServletContext().getRequestDispatcher("/views/sign-up.jsp").forward(request, response);
            }

            // Create a session object if it is already not  created.
            HttpSession session = request.getSession(true);
            // Get session creation time.
            Date createTime = new Date(session.getCreationTime());
            // Get last access time of this web page.
            Date lastAccessTime =new Date(session.getLastAccessedTime());
            String userIDKey = new String("userID");
            *//*String userID = new String(user.getUsername());*//*

            if (session.isNew()){
                String title = "Welcome to my website";
                request.getSession().setAttribute("title", title);
            }
            request.getSession().setAttribute("user", user.get(0).getUsername());
            if(user.get(0).getAdmin()==false){
                request.setAttribute("USER", user.get(0));
                Cookie loginCookie = new Cookie("user","banana");
                //setting cookie to expiry in 30 mins
                loginCookie.setMaxAge(30*60);
                response.addCookie(loginCookie);
                getServletContext().getRequestDispatcher("/views/profile.jsp").forward(request, response);
            }
            else {
                Cookie loginCookie = new Cookie("user",login);
                //setting cookie to expiry in 30 mins
                loginCookie.setMaxAge(30*60);
                response.addCookie(loginCookie);
                response.sendRedirect(response.encodeRedirectURL(String.format("%s/administration", request.getContextPath())));
            }

        }
        catch (Exception e) {
            throw new ServletException(e);
        }

    }*/

    private final void serveLoginPageWithMessage(String msg, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().setAttribute("message", msg);
        if (!resp.isCommitted()) resp.sendRedirect(resp.encodeRedirectURL(String.format("%s/", req.getContextPath())));
    }

}
