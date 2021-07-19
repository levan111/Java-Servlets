<%@ page import="Entity.Product" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %><%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 24.06.21
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%!Product prod; %>
    <%prod = (Product)request.getAttribute("product"); %>
    <% request.setAttribute("image",prod.getImagefile()); %>
    <% request.setAttribute("productId",prod.getProductId()); %>;
    <% out.println("<h1>" + prod.getName() + "</h1>"); %>
    <img src = "store-images/${image}"></br>
<%--    <% out.println("<img src = \"store-images/" + prod.getImagefile() + "\" alt = \"product\"></br>");%>--%>
    <form action = "/mycart" method="get">
        <input name = "productId" type = "hidden" value = ${productId}>
        <%out.println("<label>$" + prod.getPrice() + "</label>");%>
        <button type = "submit">Add to Cart</button>
    </form>
</body>
</html>
