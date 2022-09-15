<%-- 
    Document   : personalPage
    Created on : Jul 9, 2022, 4:32:15 PM
    Author     : Admin
--%>

<%@page import="dao.AccountDAO"%>
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
            AccountDAO adao = new AccountDAO();
            String name = (String) session.getAttribute("name");
            String email = (String) session.getAttribute("email");
            Cookie[] c = request.getCookies();
            boolean login = false;
            if(name == null){
                String token = "";
                for(Cookie aCookie : c){
                    if(aCookie.getName().equals("selector")){
                        token = aCookie.getValue();
                        Account acc = adao.getAccount(token);
                        if(acc != null){
                            name = acc.getFullname();
                            email = acc.getEmail();
                            login = true;
                        }
                    }
                }
            }
            else{
                login = true;
            }
            //show content if login = true
            if(login){
        %>
        <header>
            <%@include file="header_loginedUser.jsp" %>
        </header>
            <section>
                <h3>Welcome <%=name %> come back </h3>
                <h3><a href="logout">Logout</a></h3>
            </section>
                <section> <!-- load all orders of the user at here -->
                    <%
                        OrderDAO dao = new OrderDAO();
                        ArrayList<Order> list = dao.getOrder(name);
                        String[] status = {"","Processing","Completed","Canceled"};
                        if(list!=null && !list.isEmpty()){
                            for(Order o : list){
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
                                <br/><% if(o.getStatus()==1) {
                                %><a href="canceled?orderid=<%=o.getOrderID() %>">Cancel Order</a>
                                <%
                                    }
                                    else if(o.getStatus()==3){
                                %>
                                <a href="processing?orderid=<%=o.getOrderID() %>">Order Again</a>
                                <%
                                    }
                                %>
                            </td>
                            <td><a href="OrderDetail.jsp?orderid=<%=o.getOrderID() %>">Detail</a></td>
                        </tr>
                    </table>
                    <%
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
