<%-- 
    Document   : Index
    Created on : Jul 5, 2022, 9:14:44 PM
    Author     : Admin
--%>

<%@page import="java.util.List"%>
<%@page import="dao.PlantDAO"%>
<%@page import="model.Plant"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>index</title>
        <link rel="stylesheet" href="mycss.css" type="text/css" />
    </head>
    <body>
        <header>
            <%@include file="header.jsp" %>
        </header>
        <section>
            <%  
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
            %>
            <table class="product">
                <tr>
                    <td><img src="<%=p.getImgpath() %>" class="plantimg"/></td>
                </tr>
                <tr>
                    <td>Product ID: <%=p.getId() %></td>
                </tr>
                <tr>
                    <td>Product Name: <%=p.getName() %></td>
                </tr>
                <tr>
                    <td>Price: <%=p.getPrice() %></td>
                </tr>
                <tr>
                    <td>Status: <%=tmp[p.getStatus()] %></td>
                </tr>
                <tr>
                    <td>Category: <%=p.getCate().getName() %></td>
                </tr>
                <tr>
                    <td><a href="mainController?action=addtocart&pid=<%=p.getId() %>">Add to cart</a></td>
                </tr>
            </table>
            <%
                    }
                }
            %>
        </section>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>
