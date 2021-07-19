<%@ page import="Entity.Cart" %>
<%@ page import="Entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 25.06.21
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%
Cart myCart = (Cart)request.getSession().getAttribute("mycart");
%>
<form action = "/mycart" method="post">
<h1>Shopping Cart</h1>
<ul>
        <% for(Product p : myCart.getProducts()){
        out.println("<label>"+ p.getName() + "," + p.getPrice() + "</label>");
        out.println("<li><input type=\"number\" value= \"" + myCart.getProduct(p) + "\" name = \"" + p.getProductId() + "\"></li>");
        }
        %>
</ul>
    <label> Total: $ <%=myCart.totalSum()%></label></br>
    <button type = "submit">Update Cart</button></br>
    <a href = "/">Continue shopping</a>
</form>
</body>
</html>
