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
        <%            
            if(((Account)(session.getAttribute("account")))!=null&&((Account)(session.getAttribute("account"))).getRole().equals("ADMIN"))
            {
        %>
        <div style="width: 20%; float: left">
            <%@ include file = "adminSideBar.jsp" %>
        </div>
        <div style="width: 80%; float: left">
        <form method="POST" action="addBookServlet" onsubmit="addBookInputCheck(); return alertRegex();">
        <div id="outsite">
        <div id="cover">
            <div id="registertext" class="centerHor">
                <div id="textre">Thêm sách</div>
            </div>
		<div>Tên sách</div>
		<input id="iptName" type="text" name="name" class="inputtext" placeholder="Tên sách">
		<div>Tác giả</div>
		<input list="author" id="iptAuthorr" type="text" name="author" class="inputtext" placeholder="Tác giả">
                <datalist id="author">
                    <%
                        for(String s : authorList)
                        {
                    %>
                    <option value="<%=s%>">
                    <%
                        }
                    %>
                </datalist>
		<div>Thể loại</div>
		<input list="category" name="category" id="iptCategoryy" class="inputtext" placeholder="Thể loại" value="Chưa cập nhật">
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
		<input id="iptPublisher" type="text" name="publisher" class="inputtext" placeholder="Nhà xuất bản">
                <div>Mô tả</div>
		<input id="iptDescription" type="text" name="description" class="inputtext" placeholder="Mô tả">
                <div>Năm xuất bản</div>
		<input id="iptReleasedYear" type="number" min="0" name="releasedYear" class="inputtext" placeholder="Năm xuất bản" onkeypress="return isNumberKey(event)">
                <div>URL ảnh</div>
                <input id="iptImage" type="file" accept="image/*" class="inputtext" placeholder="URL ảnh" onchange="jsUpdateImage(event,'showImage');jsSetAttribute('iptImageURL','value',jsImageURL1);document.getElementById('iptImageURL').value='image/'+jsImageURL;">
                <div><img width="400" height="250" id="showImage" hidden="true" ></div>
                <input type='text' id="iptImageURL" name="imageurl" class="inputtext" hidden='true'>
                <div>Giá cuối(VND)</div>
		<input id="iptFinalPrice" type="number" min="0" name="finalPrice" class="inputtext" placeholder="Giá cuối" onkeypress="return isNumberKey(event)" value="0">
                <div>Chiếu khấu (VND)</div>
		<input id="iptDiscount" type="number" min="0" name="discount" class="inputtext" placeholder="Giảm giá" onkeypress="return isNumberKey(event)" value="0">
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
        </div>
        <%}
        else
        {
            response.sendRedirect("indexServlet");
        }%>
    </body>
</html>
