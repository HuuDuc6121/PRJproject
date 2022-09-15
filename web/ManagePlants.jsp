<%-- 
    Document   : ManagePlants
    Created on : Jul 13, 2022, 2:05:59 AM
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
                <th>PID</th>
                <th>PName</th>
                <th>Price</th>
                <th>imgPath</th>
                <th>Description</th>
                <th>Status</th>
                <th>Cate ID</th>
            </tr>
        <c:forEach var="p" items="${requestScope.plantList}">
            <tr>
                <th><c:out value="${p.getId()}"></c:out></th>
                <th><c:out value="${p.getName()}"></c:out></th>
                <th><c:out value="${p.getPrice()}"></c:out></th>
                <th><img src="<c:out value="${p.getImgpath()}"></c:out>" class="product"/></th>
                <th><c:out value="${p.getDescription()}"></c:out></th>
                <th>
                    <c:choose>
                <c:when test="${p.getStatus() eq 1}"> Available</c:when>
                <c:otherwise>Out of stock</c:otherwise>
            </c:choose>
                </th>
                <th><c:out value="${p.getCate().getName()}"></c:out></th>
            </tr>
        </c:forEach>
        </table>
    </body>
</html>
