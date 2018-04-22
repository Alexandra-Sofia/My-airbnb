package org.apache.jsp.inc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_when_test.release();
    _jspx_tagPool_c_choose.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Header</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"rsr/styles/myStyle.css\"/>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"rsr/styles/jquery.fancybox.min.css\"/>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"rsr/bootstrap/css/bootstrap.css\"/>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"rsr/styles/datepicker.css\"/>\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Merienda+One' rel='stylesheet' type='text/css'/>\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'/>\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n");
      out.write("\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"./js/jquery-1.11.3.min.js\" ></script>\n");
      out.write("    <script language=\"JavaScript\" type=\"text/javascript\" src=\"/js/jquery-ui-personalized-1.5.2.packed.js\"></script>\n");
      out.write("    <script language=\"JavaScript\" type=\"text/javascript\" src=\"/js/sprinkle.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"/WebApp/scripts/newListingForm.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    /*i dont like this version*/\n");
      out.write("    ");
      out.write("\n");
      out.write("</script>\n");

    String userName = null;
    Cookie[] cookies = request.getCookies();
    if(cookies !=null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("user")) userName = cookie.getValue();
        }
    }
    /*if(userName == null) response.sendRedirect("login.html");*/

      out.write("\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div id=\"top-header\" class=\"basic-header\" >\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-6 col-md-6 col-sm-6 col-xs-12\">\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/\">\n");
      out.write("                        <img class=\"logo\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/rsr/images/logo2.png\" />\n");
      out.write("                        <h2 class=\"cute-font\" style=\"display: inline\">Hosting.gr as ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2>\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-6 col-md-6 col-xs-6 text-right\">\n");
      out.write("                    ");
      if (_jspx_meth_c_choose_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("         </div>\n");
      out.write("        ");
      out.write("\n");
      out.write("        <div class=\"row\" style=\"margin: 0%;\">\n");
      out.write("            <ul class=\"col-lg-12 col-md-12 hidden-xs myorange\">\n");
      out.write("                <li style=\"color: #ffffff;\"><a href=\"#about\">ALL LISTINGS</a></li>\n");
      out.write("            </ul>\n");
      out.write("            ");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        ");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <button onclick=\"topFunction()\" id=\"myBtn\" title=\"Go to top\">Top</button>\n");
      out.write("</body>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/scripts/login.js\"></script>\n");
      out.write("<script>\n");
      out.write("    // When the user scrolls down 20px from the top of the document, show the button\n");
      out.write("    window.onscroll = function() {scrollFunction()};\n");
      out.write("\n");
      out.write("    function scrollFunction() {\n");
      out.write("        if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {\n");
      out.write("            document.getElementById(\"myBtn\").style.display = \"block\";\n");
      out.write("        } else {\n");
      out.write("            document.getElementById(\"myBtn\").style.display = \"none\";\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    // When the user clicks on the button, scroll to the top of the document\n");
      out.write("    function topFunction() {\n");
      out.write("        document.body.scrollTop = 0;\n");
      out.write("        document.documentElement.scrollTop = 0;\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_choose_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent(null);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                        ");
        if (_jspx_meth_c_when_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                        ");
        if (_jspx_meth_c_when_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                        ");
        out.write("\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
    return false;
  }

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user == 'visitor' || sessionScope.user ==null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                            <a class=\" \" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/sign_up\"><div class=\"top-button\">Sign up</div></a>\n");
        out.write("                            <a class=\"loginbutton\" href=\"#loginform\"><div class=\"top-button\">Login</div></a>\n");
        out.write("\n");
        out.write("                            ");
        out.write("\n");
        out.write("                            <form id=\"loginform\" action=\"\" hidden>\n");
        out.write("                                <div class=\"imgcontainer\">\n");
        out.write("                                    <img src=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/rsr/images/avatar.jpg\" alt=\"Avatar\" class=\"avatar\">\n");
        out.write("                                </div>\n");
        out.write("                                <div class=\"container\">\n");
        out.write("                                    <label><b>Username</b></label>\n");
        out.write("                                    <input type=\"text\" id=\"username\" placeholder=\"Enter Username\" name=\"login\" required>\n");
        out.write("\n");
        out.write("                                    <label><b>Password</b></label>\n");
        out.write("                                    <input type=\"password\" id=\"password\" placeholder=\"Enter Password\" name=\"password\" required>\n");
        out.write("\n");
        out.write("                                    <div id=\"message\" ");
        out.write(">message goes here</div>\n");
        out.write("\n");
        out.write("                                    <button name=\"login\" id=\"login\" ");
        out.write(">Login</button>\n");
        out.write("                                    <input type=\"checkbox\" checked=\"checked\"> Remember me\n");
        out.write("                                </div>\n");
        out.write("\n");
        out.write("                                <div class=\"container\" style=\"background-color:#f1f1f1\">\n");
        out.write("                                    <button type=\"button\" class=\"cancelbtn\">Cancel</button>\n");
        out.write("                                    <span class=\"psw\">Forgot <a href=\"#\">password?</a></span>\n");
        out.write("                                </div>\n");
        out.write("\n");
        out.write("                            </form>\n");
        out.write("\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
    return false;
  }

  private boolean _jspx_meth_c_when_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_1.setPageContext(_jspx_page_context);
    _jspx_th_c_when_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_1 = _jspx_th_c_when_1.doStartTag();
    if (_jspx_eval_c_when_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                           ");
        out.write("\n");
        out.write("                            <a class=\" \" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/profile\"><div class=\"top-button mygreen\">My Profile</div></a>\n");
        out.write("                            <a class=\" \" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/Logout\"><div class=\"top-button\">Logout</div></a>\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_when_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
    return false;
  }
}
