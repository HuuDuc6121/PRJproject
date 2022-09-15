package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import model.Account;
import dao.AccountDAO;
import model.Account;

public final class Edit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header_loginedUser.jsp");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"mycss.css\" type=\"text/css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Account account = new Account();
            if(request.getSession().getAttribute("account") != null){
                account = (Account) request.getSession().getAttribute("account");
            }
            String name = (String) session.getAttribute("name");
            if(name == null){       
        
      out.write("\n");
      out.write("        <p style=\"color: red\" >You must login to view personal page</p>\n");
      out.write("        <p></p>\n");
      out.write("        ");

            }else{
        
      out.write("\n");
      out.write("        <header>\n");
      out.write("            ");
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
      out.write("    <body>       \n");
      out.write("        <header>\n");
      out.write("        <nav>\n");
      out.write("            <ul>             \n");
      out.write("                <li><a href=\"Index.jsp\">Home</a></li>\n");
      out.write("                <li><a href=\"Edit.jsp\">Change Profile</a></li>\n");
      out.write("                <li><a href=\"personalPage.jsp\">Orders</a></li>\n");
      out.write("                <li><a href=\"Completed.jsp\">Completed Orders</a></li>\n");
      out.write("                <li><a href=\"Canceled.jsp\">Canceled Orders</a></li>\n");
      out.write("                <li><a href=\"Processing.jsp\">Processing Orders</a></li>\n");
      out.write("                <li>from<input type=\"date\" name=\"from\"> to <input type=\"date\" name=\"to\">\n");
      out.write("                    <input type=\"submit\" value=\"search\">\n");
      out.write("                </li>       \n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("            </header>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        </header>\n");
      out.write("            <section>\n");
      out.write("                <h3>Welcome ");
      out.print(name );
      out.write(" come back </h3>\n");
      out.write("                <h3><a href=\"logout\" >Logout</a></h3>\n");
      out.write("            </section>\n");
      out.write("                <section> <!-- load all orders of the user at here -->\n");
      out.write("                    <h1>Change Profile</h1>\n");
      out.write("                    <form action=\"edit\" method=\"post\">\n");
      out.write("                        <table>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><input type=\"text\" name=\"id\" value=\"");
      out.print(account.getAccID() );
      out.write("\" hidden=\"true\"></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><input type=\"text\" name=\"email\" value=\"");
      out.print(account.getEmail() );
      out.write("\" hidden=\"true\"</td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><input type=\"text\" name=\"pass\" value=\"");
      out.print(account.getPassword() );
      out.write("\" hidden=\"true\"></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Full Name</td>\n");
      out.write("                                <td><input type=\"text\" name=\"name\" value=\"");
      out.print(account.getFullname() );
      out.write("\" ></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Phone</td>\n");
      out.write("                                <td><input type=\"text\" name=\"phone\" value=\"");
      out.print(account.getPhone() );
      out.write("\"></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><input type=\"text\" name=\"status\" value=\"");
      out.print(account.getStatus() );
      out.write("\" hidden=\"true\"></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><input type=\"text\" name=\"role\" value=\"");
      out.print(account.getRole() );
      out.write("\" hidden=\"true\"></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><input type=\"text\" name=\"token\" value=\"");
      out.print(account.getToken());
      out.write("\" hidden=\"true\"></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td><input type=\"submit\" value=\"Edit\"></td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                    </form>\n");
      out.write("                </section>\n");
      out.write("                <footer>\n");
      out.write("                    ");
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
      out.write("                </footer>\n");
      out.write("        ");

        }
        
      out.write("\n");
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
