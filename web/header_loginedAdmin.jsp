<%-- 
    Document   : header_loginedAdmin
    Created on : Jul 12, 2022, 8:57:24 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="mycss.css" type="text/css" />
    </head>
    <body>
        
        <header>
            <ul>
                <li><a href="Index.jsp">Home</a></li>
                <li><a href="AdminIndex.jsp">Admin</a></li>
                <li><a href="mainController?action=manageAccounts">Manage Accounts</a></li>
                <li><a href="mainController?action=manageOrders">Manage Orders</a></li>
                <li><a href="mainController?action=managePlants">Manage Plants</a></li>
                <li><a href="mainController?action=manageCategories">Manage Categories</a></li>
                <li>Welcome ${sessionScope.name} | <a href="logout">Logout</a></li>
            </ul>
        </header>
    </body>
</html>
