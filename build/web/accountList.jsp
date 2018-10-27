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
        <%--GENERAL NAVIGATION--%>
        <a href="index.jsp">>>Trang chủ</a>
        <%
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
        %>
        <%
            if(session.getAttribute("account")!=null)
            {
        %>
        <br>Hello, <%=((Account)session.getAttribute("account")).getUsername()%> (<a href="logout.jsp">Đăng xuất</a>/<a href="editAccount.jsp?id=<%=((Account)session.getAttribute("account")).getId()%>">Chỉnh sửa hồ sơ</a>)
        <%
            }
            else{
        %>
            <br><a href="register.jsp">Đăng ký</a>/<a href="login.jsp">Đăng nhập</a>
        <%
            }
        %>
        
        
        <%--ADMIN NAVIGATION--%>
        <%
            if(session.getAttribute("account")!=null)
            {
                if(((Account)session.getAttribute("account")).getRole().equals("ADMIN"))
                {
        %>
        <br><a href="accountList.jsp">Danh sách tài khoản</a> / <a href="order.jsp">Danh sách đơn hàng</a> / <a href="log.jsp">Nhật ký hoạt động</a> / <a href="addBook.jsp">Thêm sách</a>
        <%
                }
            }
        %>
        
        
        <%--PAGE CONTENT--%>
        <p>Danh sách tài khoản :</p>
        <table>
            <tr>
                <th>ID</th>
                <th>USERNAME</th>
                <th>PASSWORD</th>
                <th>ROLE</th>
                <th>NAME</th>
                <th>EMAIL</th>
                <th>ADDRESS</th>
                <th>PHONE NUMBER</th>
                <th>CREDIT CARD</th>
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
              String urlremove="removeAccount?id=" + a.getId();
        %>
            <tr>
                <td><%= a.getId() %></td>
                <td><%= a.getUsername()%></td>
                <td><%= a.getPassword()%></td>
                <td><%= a.getRole()%></td>
                <td><%= a.getName()%></td>
                <td><%= a.getEmail()%></td>
                <td><%= a.getAddress()%></td>
                <td><%= a.getPhonenumber()%></td>
                <td><%= a.getCreditcard()%></td>
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
    </body>
</html>
