<%-- 
    Document   : Edit
    Created on : Jul 10, 2022, 12:25:48 AM
    Author     : Admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Account"%>
<%@page import="dao.AccountDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="mycss.css" type="text/css" />
    </head>
    <body>
        <%
            Account account = new Account();
            if(request.getSession().getAttribute("account") != null){
                account = (Account) request.getSession().getAttribute("account");
            }
            String name = (String) session.getAttribute("name");
            if(name == null){       
        %>
        <p style="color: red" >You must login to view personal page</p>
        <p></p>
        <%
            }else{
        %>
        <header>
            <%@include file="header_loginedUser.jsp" %>
        </header>
            <section>
                <h3>Welcome <%=name %> come back </h3>
                <h3><a href="logout" >Logout</a></h3>
            </section>
                <section> <!-- load all orders of the user at here -->
                    <h1>Change Profile</h1>
                    <form action="edit" method="post">
                        <table>
                            <tr>
                                <td><input type="text" name="id" value="<%=account.getAccID() %>" hidden="true"></td>
                            </tr>
                            <tr>
                                <td><input type="text" name="email" value="<%=account.getEmail() %>" hidden="true"</td>
                            </tr>
                            <tr>
                                <td><input type="text" name="pass" value="<%=account.getPassword() %>" hidden="true"></td>
                            </tr>
                            <tr>
                                <td>Full Name</td>
                                <td><input type="text" name="name" value="<%=account.getFullname() %>" ></td>
                            </tr>
                            <tr>
                                <td>Phone</td>
                                <td><input type="text" name="phone" value="<%=account.getPhone() %>"></td>
                            </tr>
                            <tr>
                                <td><input type="text" name="status" value="<%=account.getStatus() %>" hidden="true"></td>
                            </tr>
                            <tr>
                                <td><input type="text" name="role" value="<%=account.getRole() %>" hidden="true"></td>
                            </tr>
                            <tr>
                                <td><input type="text" name="token" value="<%=account.getToken()%>" hidden="true"></td>
                            </tr>
                            <tr>
                                <td><input type="submit" value="Edit"></td>
                            </tr>
                        </table>
                    </form>
                </section>
                <footer>
                    <%@include file="footer.jsp" %>
                </footer>
        <%
        }
        %>
    </body>
</html>
