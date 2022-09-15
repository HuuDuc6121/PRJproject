<%-- 
    Document   : List
    Created on : Jul 6, 2022, 1:55:11 AM
    Author     : Admin
--%>
<%@page import="java.util.List"%>
<%@page import="model.Plant"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="mycss.css" type="text/css" />
    </head>
    <body>
        <%
        List<Plant> list = new ArrayList<Plant>();
        if(request.getAttribute("list") != null){
            list = (List<Plant>) request.getAttribute("list");
        }
        ServletContext context = getServletContext();
        String tmp = context.getInitParameter("countryName");
        %>
        <header>
            <%@include file="header.jsp" %>
        </header>
        <section>
            <p>The website is deploying in <%=tmp%></p>
            <table border="1">
                <tr>
                    <td>Product ID</td>
                    <td>Name</td>
                    <td>Price</td>
                    <td>Image</td>
                    <td>Detail</td>
                    <td>Action</td>
                </tr>
                <%
                for(Plant p : list){
                %>
                <tr>
                    <td><%=p.getId() %></td>
                    <td><%=p.getName() %></td>
                    <td><%=p.getPrice() %></td>
                    <td><img src="<%=p.getImgpath() %>" class="product"/></td>
                    <td><a href="getPlantServlet?pid=<%=p.getId() %>">View detail</a></td>
                    <td><a href="mainController?action=addtocart&pid=<%=p.getId() %>">Add to your cart</a></td>
                </tr>
                <%
                }
                %>
            </table>
        </section>
            <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>
