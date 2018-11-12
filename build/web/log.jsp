<%-- 
    Document   : log.jsp
    Created on : Oct 21, 2018, 1:25:48 PM
    Author     : i1vag_000
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.DAO"%>
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
        <%@ include file = "header.jsp" %>
        <%
            ArrayList<Log> logList = (ArrayList<Log>)request.getAttribute("logList");
        %>
        <center>
        <p>Nhật ký hoạt động : </p>
        <table style="text-align: center">
            <tr>
                <th>ID</th>
                <th>Date</th>
                <th>Account ID</th>
                <th>Action</th>
                <th>Object type</th>
                <th>Object ID</th>
                <th>Detail</th>
            </tr>
        <%
            for(Log l : logList)
            {
        %>
            <tr>
                <td><%=l.getId() %></td>
                <td><%=l.getDate()%></td>
                <td><%=l.getAccountId()%></td>
                <td><%=l.getAction()%></td>
                <td><%=l.getObjectType() %></td>
                <td><%=l.getObjectId() %></td>
                <td><%=l.getDetail()==null?"":l.getDetail()%></td>
            </tr>
        <%
            }
        %>
        </table>
        </center>
    </body>
</html>
