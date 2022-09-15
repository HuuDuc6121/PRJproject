package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import dao.PlantDAO;
import model.Plant;
import java.util.ArrayList;

public final class Index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>index</title>\n");
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
      out.write("            ");
  
                PlantDAO dao = new PlantDAO();
                String txtsearch = request.getParameter("txtsearch");
                String searchby = request.getParameter("searchby");
                List<Plant> list;
                String[] tmp ={"out of stock","available"};
                if(txtsearch == null && searchby == null){
                    list = dao.getPlantbyName("");
                    list = dao.getPlantbyCateName("");
                }
                else{
                    list = dao.getPlantbyName(txtsearch);
                    list = dao.getPlantbyCateName(txtsearch);
                }
                if(list !=null && !list.isEmpty()){
                    for(Plant p : list){
            
      out.write("\n");
      out.write("            <table class=\"product\">\n");
      out.write("                <tr>\n");
      out.write("                    <td><img src=\"");
      out.print(p.getImgpath() );
      out.write("\" class=\"plantimg\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Product ID: ");
      out.print(p.getId() );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Product Name: ");
      out.print(p.getName() );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Price: ");
      out.print(p.getPrice() );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Status: ");
      out.print(tmp[p.getStatus()] );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Category: ");
      out.print(p.getCate().getName() );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><a href=\"mainController?action=addtocart&pid=");
      out.print(p.getId() );
      out.write("\">Add to cart</a></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            ");

                    }
                }
            
      out.write("\n");
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
