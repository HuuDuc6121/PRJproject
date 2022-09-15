package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class viewPlant_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      model.Plant plantObj = null;
      synchronized (request) {
        plantObj = (model.Plant) _jspx_page_context.getAttribute("plantObj", PageContext.REQUEST_SCOPE);
        if (plantObj == null){
          plantObj = new model.Plant();
          _jspx_page_context.setAttribute("plantObj", plantObj, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("        <table>\n");
      out.write("            <tr><td rowspan=\"8\"><img src=\"");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((model.Plant)_jspx_page_context.findAttribute("plantObj")).getImgpath())));
      out.write("\"></td></tr>\n");
      out.write("            <tr><td>ID: ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((model.Plant)_jspx_page_context.findAttribute("plantObj")).getId())));
      out.write("</td></tr>\n");
      out.write("            <tr><td>Product Name: ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((model.Plant)_jspx_page_context.findAttribute("plantObj")).getName())));
      out.write("</td></tr>\n");
      out.write("            <tr><td>Price: ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((model.Plant)_jspx_page_context.findAttribute("plantObj")).getPrice())));
      out.write("</td></tr>\n");
      out.write("            <tr><td>Description: ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((model.Plant)_jspx_page_context.findAttribute("plantObj")).getDescription())));
      out.write("</td></tr>\n");
      out.write("            <tr><td>Status: ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((model.Plant)_jspx_page_context.findAttribute("plantObj")).getStatus())));
      out.write("</td></tr>\n");
      out.write("            <tr><td>Cate ID: ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((model.Plant)_jspx_page_context.findAttribute("plantObj")).getCate())));
      out.write("</td></tr>\n");
      out.write("            <tr><td>Category: ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((model.Plant)_jspx_page_context.findAttribute("plantObj")).getCate())));
      out.write("</td></tr>\n");
      out.write("        </table>\n");
      out.write("        <!-- su dung EL -->\n");
      out.write("        <table>\n");
      out.write("            <tr><td rowspan=\"8\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${plantObj.imgpath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></td></tr>\n");
      out.write("        <tr><td>ID: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${plantObj.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\n");
      out.write("        <tr><td>Product Name: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${plantObj.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\n");
      out.write("        <tr><td>Price: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${plantObj.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\n");
      out.write("        <tr><td>Description: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${plantObj.description}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\n");
      out.write("        <tr><td>Status: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${plantObj.status}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\n");
      out.write("        <tr><td>Cate ID: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${plantObj.cate.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\n");
      out.write("        <tr><td>Category: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${plantObj.cate.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td></tr>\n");
      out.write("        </table>\n");
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
