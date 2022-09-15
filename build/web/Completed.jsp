<%-- 
    Document   : Completed
    Created on : Jul 9, 2022, 11:17:34 PM
    Author     : Admin
--%>

<%@page import="model.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.OrderDAO"%>
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
                    <%
                        OrderDAO dao = new OrderDAO();
                        ArrayList<Order> list = dao.getOrder(name);
                        String[] status = {"","Processing","Completed","Canceled"};
                        if(list!=null && !list.isEmpty()){
                            for(Order o : list){
                                if(o.getStatus()==2){
                    %>
                    <table class="order">
                        <tr>
                            <td>Order ID</td>
                            <td>Order Date</td>
                            <td>Ship Date</td>
                            <td>Order's Status</td>
                            <td>Action</td>
                        </tr>
                        <tr>
                            <td><%=o.getOrderID() %></td>
                            <td><%=o.getOrderDate() %></td>
                            <td><%=o.getShipDate() %></td>
                            <td>
                                <%=status[o.getStatus()] %>
                                <br/><% if(o.getStatus()==1) %><a href="#">Cancel Order</a>
                            </td>
                            <td><a href="OrderDetail.jsp?orderid=<%=o.getOrderID() %>">Detail</a></td>
                        </tr>
                    </table>
                    <%
                            }
                        }
                    }
                        else{
                    %>
                    <p>You don't have any order</p>
                    <%
                        }
                    %>
                </section>
                <footer>
                    <%@include file="footer.jsp" %>
                </footer>
        <%
        }
        %>
    </body>
</html>
