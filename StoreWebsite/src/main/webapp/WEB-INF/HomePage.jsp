<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 24.06.21
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Entity.Product" %>
<%@ page import="java.util.Set" %>
<%@ page import="Repository.Database" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Student Store</h1>
<h4>items available</h4>
<ul>
    <%Database dao = (Database)request.getServletContext().getAttribute("database"); %>
    <%for(Product prod : dao.getAll()){%>
        <li><a href="product-info?productId=<%= prod.getProductId() %>"><%= prod.getName() %></a></li>
    <%}%>
</ul>
</body>
</html>
