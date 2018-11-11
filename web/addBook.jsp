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
        <%@ include file = "header.jsp" %>
        <%
            if(((Account)(session.getAttribute("account")))!=null&&((Account)(session.getAttribute("account"))).getRole().equals("ADMIN"))
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
                <input id="iptImage" type="file" accept="image/*" class="inputtext" placeholder="URL ảnh" onchange="jsUpdateImage(event,'showImage');jsSetAttribute('iptImageURL','value',jsImageURL1);document.getElementById('iptImageURL').value='image/'+jsImageURL;">
                <div><img width="400" height="250" id="showImage" hidden="true" ></div>
                <input type='text' id="iptImageURL" name="imageurl" class="inputtext" hidden='true'>
                <div>Giá cuối(VND)</div>
		<input id="asd" type="text" name="finalPrice" class="inputtext" placeholder="Giá cuối">
                <div>Chiếu khấu (VND)</div>
		<input type="text" name="discount" class="inputtext" placeholder="Giảm giá">
		<div style="padding: 14px" class="centerHor">
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
        <%@ include file = "footer.jsp" %>
    </body>
</html>
