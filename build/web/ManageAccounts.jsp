<%-- 
    Document   : ManageAccounts
    Created on : Jul 13, 2022, 12:02:29 AM
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
        <form action="mainController" method="post">
            <input type="text" name="search">
            <input type="submit" value="searchAccount" name="action">
        </form>
        <h1></h1>
        <table class="order">
            <tr>
                <th>ID</th>
                <th>Email</th>
                <th>Full Name</th>
                <th>Status</th>
                <th>Phone</th>
                <th>Role</th>
                <th>Action</th>
            </tr>
        <c:forEach var="acc" items="${requestScope.accountList}">
        <tr>
            <th><c:out value="${acc.getAccID()}"></c:out></th>
            <th><c:out value="${acc.getEmail()}"></c:out></th>
            <th><c:out value="${acc.getFullname()}"></c:out></th>
            <th>
            <c:choose>
                <c:when test="${acc.getStatus() eq 1}"> Active</c:when>
                <c:otherwise>inActive</c:otherwise>
            </c:choose>
            </th>
            <th><c:out value="${acc.getPhone()}"></c:out></th>
            <th>
            <c:choose>
                <c:when test="${acc.getRole() eq 1}"> Admin</c:when>
                <c:otherwise>User</c:otherwise>
            </c:choose>
            </th>
            <th>
            <c:if test="${acc.getRole() eq 0}"><!-- only block/unblock account of the user-->
                <c:url var="mylink" value="mainController">
                    <c:param name="email" value="${acc.getEmail()}"></c:param>
                    <c:param name="status" value="${acc.getStatus()}"></c:param>
                    <c:param name="action" value="updateStatusAccount"></c:param>
                </c:url>
                <a href="${mylink}">Block/UnBlock</a>
            </c:if>
            </th>
        </tr>
        </c:forEach>
        </table>
    </body>
</html>
