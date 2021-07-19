<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 23.06.21
  Time: 01:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <h1>welcome to homework 5</h1>
        <h5>Please log in</h5>
        <form method = "POST">
            <label>Username</label>
            <input type = "text" id = "username"  name = "username"/>
            <br>
            <label>Password</label>
            <input type = "text"  id = "password"  name = "password"/>
            <br>
            <button type="submit">Login</button>
            <br>
            <a href="/register">Create new Account</a>
        </form>
    </body>
</html>
