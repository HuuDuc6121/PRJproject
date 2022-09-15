package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Set;
import java.util.HashMap;

public final class viewCart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"mycss.css\" type=\"text/css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>TODO supply a title</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"mycss.css\" type=\"text/css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <nav>\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"\"><img src=\"images/logo.jpg\"></a> </li>\n");
      out.write("                    <li><a href=\"Index.jsp\">Home</a></li>\n");
      out.write("                    <li><a href=\"registration.jsp\">Register</a></li>\n");
      out.write("                    <li><a href=\"Login.jsp\" >Login</a></li>\n");
      out.write("                    <li><a href=\"mainController?action=viewcart\" >View Cart</a></li>\n");
      out.write("                    <li><form action=\"mainController\" method=\"post\" class=\"formsearch\">\n");
      out.write("                            <input type=\"text\" name=\"txtsearch\" value=\"");
      out.print((request.getParameter("txtsearch")==null)?"": request.getParameter("txtsearch") );
      out.write("\">\n");
      out.write("                            <select name=\"searchby\">\n");
      out.write("                                <option value=\"byname\">by name</option>\n");
      out.write("                                <option value=\"bycate\">by category</option>\n");
      out.write("                            </select>\n");
      out.write("                            <input type=\"submit\" value=\"search\" name=\"action\">\n");
      out.write("                        </form></li>\n");
      out.write("                </ul> \n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        </header>\n");
      out.write("        <section>\n");
      out.write("            <table width=\"100%\" class=\"shopping\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>Product ID</td>\n");
      out.write("                    <td>Quantity</td>\n");
      out.write("                    <td>Action</td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    HashMap<String, Integer> cart = (HashMap) session.getAttribute("cart");
                    if(cart != null){
                        Set<String> pids = cart.keySet();
                        for(String pid : pids){
                            int quantity = cart.get(pid);
                            
      out.write("\n");
      out.write("                            <form action=\"mainController\" method=\"post\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <td><input type=\"hidden\" value=\"");
      out.print( pid );
      out.write("\" name=\"pid\"><a href=\"#\">");
      out.print(pid );
      out.write("</a></td>\n");
      out.write("                                    <td><input type=\"number\" value=\"");
      out.print(quantity );
      out.write("\" name=\"quantity\"></td>\n");
      out.write("                                    <td><input type=\"submit\" value=\"update\" name=\"action\"></td>\n");
      out.write("                                <input type=\"submit\" value=\"delete\" name=\"action\">\n");
      out.write("                                </tr>\n");
      out.write("                            </form>\n");
      out.write("                ");

                        }
                    }
else{
                
      out.write("\n");
      out.write("                <tr><td>Your cart is empty</td></tr>\n");
      out.write("                ");

                }
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>Total Money: </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </section>\n");
      out.write("        <footer>\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"mycss.css\" type=\"text/css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <p style=\"color:white; text-align: center;\">Copyright &copy; 2021</p>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        </footer>\n");
      out.write("    </body>\n");
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
}
