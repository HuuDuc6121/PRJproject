<%-- 
    Document   : header
    Created on : Jul 9, 2022, 3:51:59 PM
    Author     : Admin
--%>

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
        <header>
            <nav>
                <ul>
                    <li><a href=""><img src="images/logo.jpg" class="product"/></a> </li>
                    <li><a href="Index.jsp">Home</a></li>
                    <li><a href="registration.jsp">Register</a></li>
                    <li><a href="Login.jsp" >Login</a></li>
                    <li><a href="mainController?action=viewcart" >View Cart</a></li>
                    <li><form action="mainController" method="post" class="formsearch">
                            <input type="text" name="txtsearch" value="<%=(request.getParameter("txtsearch")==null)?"": request.getParameter("txtsearch") %>">
                            <select name="searchby">
                                <option value="byname">by name</option>
                                <option value="bycate">by category</option>
                            </select>
                            <input type="submit" value="search" name="action">
                        </form></li>
                </ul> 
            </nav>
        </header>
    </body>
</html>
