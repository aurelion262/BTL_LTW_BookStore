<%-- 
    Document   : log.jsp
    Created on : Oct 21, 2018, 1:25:48 PM
    Author     : i1vag_000
--%>

<%@page import="control.DAO"%>
<%@page import="model.Log"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="js.js"></script>
    </head>
    <body>
        <%
            for(Log l : new DAO().getLog())
            {
                out.print("<br>" + l.getDate());
                out.print("<br>" + l.getLog());
                out.print("<br>--------------------------------------------");
            }
        %>
    </body>
</html>
