<%-- 
    Document   : admin
    Created on : Nov 23, 2018, 10:14:12 PM
    Author     : Jichu
--%>

<%@page import="model.Account"%>
<%@page import="model.DAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
<body>
    <% if(((Account)session.getAttribute("account")).getRole().equals("ADMIN"))
        {
    %>

        <div style="width: 20%; float: left">
            <%@ include file = "adminSideBar.jsp" %>
        </div>
        <div style="width: 80%; float: left">
            
        </div>
    <%
        }
        else response.sendRedirect("indexServlet");
    %>
    
</body>
</html>