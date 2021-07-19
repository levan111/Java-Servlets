<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 23.06.21
  Time: 02:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <h1>create new account</h1>
        <h3>Please enter proposed name and password</h3>
        <form method = "POST">
            <label>Username</label>
            <input type = "text" id = "username"  name = "username"/>
            <br>
            <label>Password</label>
            <input type = "text"  id = "password"  name = "password"/>
            <button type="submit">Create</button>
            <br>
            <a href="/register">Create new Account</a>
        </form>
    </body>
</html>
