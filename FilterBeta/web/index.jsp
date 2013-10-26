<%-- 
    Document   : index
    Created on : Oct 26, 2013, 6:43:10 PM
    Author     : memmedimanli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Please, enter your username and password</h1>
        
        <%
            if(session.getAttribute("errorMessage") != null) {
                out.println("<p>" + session.getAttribute("errorMessage") + "</p>");
            }
        %>
        <form method="post" action="login">
            Username: <input type="text" name="username"><br/>
            Password: <input type="password" name="pass"><br/>
                      <input type="hidden" name="password">
               <input type="submit" value="Login">
        </form>
        
    </body>
</html>
