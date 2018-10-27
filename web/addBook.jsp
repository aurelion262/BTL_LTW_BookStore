<%-- 
    Document   : addBook.jsp
    Created on : Oct 21, 2018, 1:16:14 PM
    Author     : i1vag_000
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.DAO"%>
<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="register.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm Sách</title>
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
        <%
            if(((Account)(session.getAttribute("account"))).getRole().equals("ADMIN"))
            {
        %>
        <form method="POST" action="addBook">
        <div id="outsite">
        <div id="cover">
            <div id="registertext" class="centerHor">
                <div id="textre">Thêm sách</div>
            </div>
		<div>Tên sách</div>
		<input type="text" name="name" class="inputtext" placeholder="Tên sách">
		<div>Tác giả</div>
		<input type="text" name="author" class="inputtext" placeholder="Tác giả">
		<div>Thể loại</div>
		<input list="category" name="category" id="iptCategory" class="inputtext" placeholder="Thể loại">
                <datalist id="category">
                    <%
                        ArrayList<String> categoryList = new DAO().getCategory();
                        for(String s : categoryList)
                        {
                    %>
                    <option value="<%=s%>">
                    <%
                        }
                    %>
                </datalist>
		<div>Nhà xuất bản</div>
		<input type="text" name="publisher" class="inputtext" placeholder="Nhà xuất bản">
                <div>Mô tả</div>
		<input type="text" name="description" class="inputtext" placeholder="Mô tả">
                <div>Năm xuất bản</div>
		<input type="text" name="releasedYear" class="inputtext" placeholder="Năm xuất bản">
                <div>URL ảnh</div>
                <input type="file" id="iptImageURL" name="imageurl" class="inputtext" placeholder="URL ảnh" onchange="jsUpdateImage(event,'showImage')">
                <div><img width="400" height="250" id="showImage" hidden="true" accept="image/*"></div>
                <div>Giá cuối(VND)</div>
		<input id="asd" type="text" name="finalPrice" class="inputtext" placeholder="Giá cuối">
                <div>Đã giảm giá (VND)</div>
		<input type="text" name="discount" class="inputtext" placeholder="Giảm giá">
		<div class="centerHor">
                    <input type="submit" value="Thêm sách" ></input>
		</div>
            </div>
        </div>
        </form>
        <% 
            String message = (String)request.getAttribute("message");
            if(message!=null){ %>
                <p><%=message%></p>
        <%}%>
        <%}
        else
        {
            response.sendRedirect("index.jsp");
        }%>
    </body>
</html>
