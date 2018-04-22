package org.apache.jsp.inc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class insertListingForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html");
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
      out.write("<div class=\"js-new-listing-form new-listing-form\">\n");
      out.write("\n");
      out.write("    <button data-fancybox data-src=\"#popup-holder\" class=\"attention-button js-new-listing\">New Listing</button>\n");
      out.write("    <div id=\"popup-holder\" style=\"display:none\">\n");
      out.write("    <h2>Insert new listing</h2>\n");
      out.write("    <form name=\"NewListing\" class=\"new-listing-form js-new-listing-form\" data-user-id=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.userID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("        <div class=\"col-lg-6 col-md-6 col-sm-6 col-xs-12\">\n");
      out.write("        <div class=\"part part-one\">\n");
      out.write("            <div class=\"title\">Location Information</div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("            Name: <br><input  class=\"form-input\" type=\"text\" name=\"name\"> <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("            Url: <br><input type=\"text\" class=\"form-input\" name=\"listing_url\" > <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("            Country: <br><input type=\"text\" class=\"form-input\" name=\"country\" > <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                State: <br><input type=\"text\" class=\"form-input\" name=\"state\" > <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("            City: <br><input type=\"text\" class=\"form-input\" name=\"city\" > <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("            Zip Code: <br><input type=\"text\" class=\"form-input\" name=\"zipcode\" > <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("            Neighborhood Name: <br><input type=\"text\" class=\"form-input\" name=\"neighborhood_cleansed\" > <br>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"part part-two\">\n");
      out.write("            <div class=\"title\">Pricing Details</div>\n");
      out.write("\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                Daily Price: <br><input type=\"text\" class=\"form-input\" name=\"price\"> <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("            Weekly Price: <br><input type=\"text\" class=\"form-input\" name=\"weekly_price\"> <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("            Monthly Price: <br><input type=\"text\" class=\"form-input\" name=\"monthly_price\"> <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("            Security Deposit: <br><input type=\"text\" class=\"form-input\" name=\"security_deposit\"> <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("            Cleaning fee: <br><input type=\"text\" class=\"form-input\" name=\"cleaning_fee\"> <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("            Guests Included: <br><input type=\"text\" class=\"form-input\" name=\"guests_included\"> <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("            Price per extra person: <br><input type=\"text\" class=\"form-input\" name=\"extra_people\"> <br>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("            <div class=\"part part-three\">\n");
      out.write("                <div class=\"title\">Reservation Details</div>\n");
      out.write("\n");
      out.write("                <div class=\"form-row\">\n");
      out.write("                    Minimum nights: <br><input type=\"text\" class=\"form-input\" name=\"minimum_nights\"> <br>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-row\">\n");
      out.write("                    Maximum nights: <br><input type=\"text\" class=\"form-input\" name=\"maximum_nights\"> <br>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-row\">\n");
      out.write("                    Cancellation policy :<br><input type=\"text\" class=\"form-input\" name=\"cancellation_policy\"> <br>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-lg-6 col-md-6 col-sm-6 col-xs-12\">\n");
      out.write("        <div class=\"part part-four\">\n");
      out.write("            <div class=\"title\">Property details</div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                Property Type: <br><input type=\"text\" class=\"form-input\" name=\"property_type\"> <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                Room Type: <br><input type=\"text\" class=\"form-input\" name=\"room_type\"> <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                Accommodates: <br><input type=\"text\" class=\"form-input\" name=\"accommodates\"> <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                Bathrooms: <br><input type=\"text\" class=\"form-input\" name=\"bathrooms\"> <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                Bedrooms: <br><input type=\"text\" class=\"form-input\" name=\"bedrooms\"> <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                Beds: <br><input type=\"text\" class=\"form-input\" name=\"beds\"> <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                Bed Type: <br><input type=\"text\" class=\"form-input\" name=\"bed_type\"> <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                Surface (square feet): <br><input type=\"text\" class=\"form-input\" name=\"square_feet\"> <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                Amenities: <br><textarea type=\"text\" class=\"form-input\" name=\"amenities\"></textarea> <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                Summary: <br><textarea type=\"text\" class=\"form-input\" name=\"summary\"></textarea> <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                Space Info: <br><textarea type=\"text\" class=\"form-input\" name=\"space\"></textarea> <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                Description: <br><textarea type=\"text\" class=\"form-input\" name=\"description\"></textarea> <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                Neighborhood Overview: <br><textarea type=\"text\" class=\"form-input\" name=\"neighborhood_overview\"></textarea> <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                Notes: <br><textarea type=\"text\" class=\"form-input\" name=\"notes\"></textarea> <br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                Transit: <br><textarea type=\"text\" class=\"form-input\" name=\"transit\"></textarea> <br>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12 message\"></div>\n");
      out.write("        <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\n");
      out.write("            <button type=\"button\" class=\"attention-button js-new-listing-submit\">Eisagwgi</button>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </form>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</div>");
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
}
