<%-- 
    Document   : registration
    Created on : Jul 5, 2022, 11:11:18 PM
    Author     : Admin
--%>

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
            <form action="mainController" method="post" class="formregister">
                <h1>Register</h1>
                <table>
                    <tr><td>Email</td><td><input type="text" name="email" required="" value="<%= (request.getAttribute("email")==null)?"":request.getAttribute("email") %>" pattern="^(\\w)+@(a-zA-Z]+([.](\\w)+){1,2}"></td></tr>
                    <tr><td>Full Name</td><td><input type="text" name="fullname" required="" value="<%= (request.getAttribute("fullname")==null)?"":request.getAttribute("fullname") %>"></td></tr>
                    <tr><td>Password</td><td><input type="password" name="password" required=""></td></tr>
                    <tr><td>Phone</td><td><input type="text" name="phone" value="<%= (request.getAttribute("phone")==null)?"":request.getAttribute("phone") %>">
                            <%= (request.getAttribute("ERROR") == null)?"":request.getAttribute("ERROR") %></td>
                    </tr>
                    <tr><td colspan="2"><input type="submit" value="create" name="action"></td></tr>
                </table>
            </form>
        </section>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>
