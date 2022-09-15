<%-- 
    Document   : viewPlant
    Created on : Jul 12, 2022, 8:07:02 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <%@include file="header.jsp" %>
        </header>
        <!--<jsp:useBean id="plantObj" class="model.Plant" scope="request"/>
        <table>
            <tr><td rowspan="8"><img src="<jsp:getProperty name="plantObj" property="imgpath"></jsp:getProperty>"></td></tr>
            <tr><td>ID: <jsp:getProperty name="plantObj" property="id"></jsp:getProperty></td></tr>
            <tr><td>Product Name: <jsp:getProperty name="plantObj" property="name"></jsp:getProperty></td></tr>
            <tr><td>Price: <jsp:getProperty name="plantObj" property="price"></jsp:getProperty></td></tr>
            <tr><td>Description: <jsp:getProperty name="plantObj" property="description"></jsp:getProperty></td></tr>
            <tr><td>Status: <jsp:getProperty name="plantObj" property="status"></jsp:getProperty></td></tr>
            <tr><td>Cate ID: <jsp:getProperty name="plantObj" property="cate"></jsp:getProperty></td></tr>
            <tr><td>Category: <jsp:getProperty name="plantObj" property="cate"></jsp:getProperty></td></tr>
        </table>-->
        <!-- su dung EL -->
        <table>
            <tr><td rowspan="8"><img src="${plantObj.imgpath}"></td></tr>
        <tr><td>ID: ${plantObj.id}</td></tr>
        <tr><td>Product Name: ${plantObj.name}</td></tr>
        <tr><td>Price: ${plantObj.price}</td></tr>
        <tr><td>Description: ${plantObj.description}</td></tr>
        <tr><td>Status: ${plantObj.status}</td></tr>
        <tr><td>Cate ID: ${plantObj.cate.id}</td></tr>
        <tr><td>Category: ${plantObj.cate.name}</td></tr>
        </table>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>
