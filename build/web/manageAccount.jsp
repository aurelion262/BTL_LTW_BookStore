<%-- 
    Document   : accountList.jsp
    Created on : Oct 20, 2018, 6:24:29 PM
    Author     : i1vag_000
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.DAO"%>
<%@page import="model.Account"%>
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
        <center>
        <p>Danh sách tài khoản :</p>
        <table style="text-align: center;">
            <tr>
                <th>ID</th>
                <th>USERNAME</th>
                <th>ROLE</th>
                <th>NAME</th>
                <th>EMAIL</th>
                <th>ADDRESS</th>
                <th>PHONE NUMBER</th>
                <%
                    try {
                            if(((Account)(session.getAttribute("account"))).getRole().equals("ADMIN"))
                            { 
                %>
                <th>ACTION</th>
                <%}
                } catch (Exception e) {
                    e.printStackTrace();
                        }%>
            </tr>
        <%
          ArrayList<Account> accountList = (ArrayList<Account>)request.getAttribute("accountList");
          for(Account a : accountList){
              String urledit="editAccount.jsp?id=" + a.getId();
              String urlremove="removeAccountServlet?id=" + a.getId();
        %>
            <tr>
                <td><%= a.getId() %></td>
                <td><%= a.getUsername()%></td>
                <td><%= a.getRole()%></td>
                <td><%= a.getName()%></td>
                <td><%= a.getEmail()%></td>
                <td><%= a.getAddress()%></td>
                <td><%= a.getPhonenumber()%></td>
                <%
                    try {
                            if(((Account)session.getAttribute("account")).getRole().equals("ADMIN"))
                            { 
                %>
                <td><a href="<%=urledit%>">Sửa</a>/<a href="<%=urlremove%>">Xóa</a></td>
                <%}
                } catch (Exception e) {
                    e.printStackTrace();
                        }%>
            </tr>
        <%}%>
        </table>
        </center>
    </body>
</html>
