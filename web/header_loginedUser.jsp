<%-- 
    Document   : header_loginedUser
    Created on : Jul 9, 2022, 4:27:45 PM
    Author     : Admin
--%>

<%@page import="model.Account"%>
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
        <nav>
            <ul>             
                <li><a href="Index.jsp">Home</a></li>
                <li><a href="Edit.jsp">Change Profile</a></li>
                <li><a href="personalPage.jsp">Orders</a></li>
                <li><a href="Completed.jsp">Completed Orders</a></li>
                <li><a href="Canceled.jsp">Canceled Orders</a></li>
                <li><a href="Processing.jsp">Processing Orders</a></li>
                <li>from<input type="date" name="from"> to <input type="date" name="to">
                    <input type="submit" value="search">
                </li>       
            </ul>
        </nav>
            </header>
    </body>
</html>
