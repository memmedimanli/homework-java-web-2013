<%-- 
    Document   : main
    Created on : Oct 26, 2013, 6:45:03 PM
    Author     : memmedimanli
--%>

<%@page import="java.net.InetAddress"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
    </head>
    <body>
        <%
//            if(session.getAttribute("username") != null &&
//                    session.getAttribute("loginTime") != null) {
            %>
            <h1>Hello ${sessionScope.username}!</h1>
             
            <%
                
                InetAddress ipAddress = InetAddress.getByName(request.getHeader("X-FORWARDED-FOR"));
                out.println("IP address is " + ipAddress + "<br />");
               
                out.println("Session id = " + session.getId() + "<br/>");
                out.println("Session create time = " + new Date(session.getCreationTime())  + "<br/>");
                out.println("Session last active time = " + new Date(session.getLastAccessedTime()) + "<br/>");
                out.println("Is new = " + (session.isNew() ? "true" : "false") + "<br/>");
                out.println("Timeout (seconds) period = " + session.getMaxInactiveInterval() + "<br/>");
                
                out.println("<h2>Session attributes </h2>");
                Enumeration<String> attributes = session.getAttributeNames();
                while(attributes.hasMoreElements()) {
                    String name = attributes.nextElement();
                    Object value = session.getAttribute(name);
                    out.println(name + " = " + value + "<br/>");
                }
                
                out.println("<a href='logout'>Logout</a>");
//            } else {
//                response.sendRedirect("index.jsp");
//            }
        %>
        
        
        
    </body>
</html>
