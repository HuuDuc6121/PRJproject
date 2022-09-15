<%-- 
    Document   : ManageOrders
    Created on : Jul 13, 2022, 1:42:44 AM
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
                <th>Order ID</th>
                <th>Order Date</th>
                <th>Ship Date</th>
                <th>Status</th>
                <th>Account ID</th>
            </tr>
        <c:forEach var="o" items="${requestScope.orderList}">
            <tr>
                <th><c:out value="${o.getOrderID()}"></c:out></th>
                <th><c:out value="${o.getOrderDate()}"></c:out></th>
                <th><c:out value="${o.getShipDate()}"></c:out></th>
                <th>
                    <c:choose>
                <c:when test="${o.getStatus() eq 1}"> Processing</c:when>
                    </c:choose>
                <c:choose>
                <c:when test="${o.getStatus() eq 2}"> Completed</c:when>
                    </c:choose>
                <c:choose>
                <c:when test="${o.getStatus() eq 3}"> Canceled</c:when>
                    </c:choose>
                </th>
                <th><c:out value="${o.getAccID()}"></c:out></th>
            </tr>
        </c:forEach>
        </table>
    </body>
</html>
