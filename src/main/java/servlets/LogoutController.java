package servlets;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Alexandra on 27/4/2017.
 */
public class LogoutController extends HttpServlet{
    private static final long serialVersionUID = 9154372860383130250L;

    private static final Logger logger = LoggerFactory.getLogger(HomepageController.class.getName());

    public void init() throws ServletException {
        super.init();

        /*if (logger.isInfoEnabled()) logger.info("[{}] has been initialized with {}", servlets.HomepageController.class.getSimpleName(), service);*/
    }
    /*@Override*/
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uriRequest = request.getRequestURI().toLowerCase();
        Cookie loginCookie = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("user")){
                    loginCookie = cookie;
                    break;
                }
            }
        }
        if(loginCookie != null){
            loginCookie.setMaxAge(0);
            response.addCookie(loginCookie);
        }
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(response.encodeRedirectURL(String.format("%s/index.jsp", request.getContextPath())));
        getServletContext().getRequestDispatcher("/index.jsp").forward (request, response);
    }
}
