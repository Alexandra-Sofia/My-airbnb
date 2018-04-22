package servlets;

/**
 * Created by Alexandra on 3/5/2017.
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IncludeController extends HttpServlet {


   /* public void init() throws ServletException {
        super.init();
    }

    public void destroy() {
        super.destroy();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String requestUri = ((String) request.getAttribute("javax.servlet.include.request_uri")).toLowerCase();
        String requestInclude = requestUri.substring(requestUri.lastIndexOf("/") + 1, requestUri.lastIndexOf("."));
        String ctxPath = request.getContextPath();
        String path = requestUri.substring(requestUri.indexOf(ctxPath) + ctxPath.length(), requestUri.lastIndexOf("/"));

        if (Defaults.DEV_ENV) {
            ResponseUtils.trace(response, "%s: requestUri: %s, requestInclude: %s, ctxPath: %s, path: %s",
                    IncludeController.class.getSimpleName(), requestUri, requestInclude, ctxPath, path);
        }

        serveWithoutCache(requestInclude, path, request, response);
    }

    private boolean serveWithoutCache(String requestInclude, String path, HttpServletRequest req, HttpServletResponse resp) {

    }*/

}
