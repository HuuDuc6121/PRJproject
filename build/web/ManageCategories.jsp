<%-- 
    Document   : ManageCategories
    Created on : Jul 13, 2022, 2:24:35 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="mycss.css" type="text/css" />
    </head>
    <body>
        <c:import url="header_loginedAdmin.jsp"></c:import>
        <h1></h1>
        <table class="order">
            <tr>
                <th>Cate ID</th>
                <th>Cate Name</th>
            </tr>
        <c:forEach var="c" items="${requestScope.cateList}">
            <tr>
            <th><c:out value="${c.getId()}"></c:out></th>
            <th><c:out value="${c.getName()}"></c:out></th>
            </tr>
        </c:forEach>
        </table>
    </body>
</html>
