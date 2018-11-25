<%-- 
    Document   : addBook.jsp
    Created on : Oct 21, 2018, 1:16:14 PM
    Author     : i1vag_000
--%>

<%@page import="model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.DAO"%>
<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="register.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sửa Sách - <%=((Book)request.getAttribute("book")).getName()%></title>
        <script type="text/javascript" src="js.js"></script>
    </head>
    <body>
        <%@ include file = "header.jsp" %>
        
        <%
            Book b = (Book)request.getAttribute("book");
        %>
        <form method="POST" action="editBookServlet">
        <div id="outsite">
        <div id="cover">
            <div id="registertext" class="centerHor">
                <div id="textre">Cập nhật sách</div>
            </div>
                <input type="text" name="id" class="inputtext" hidden="true" value="<%=b.getId()%>">
		<div>Tên sách</div>
		<input type="text" name="name" class="inputtext" placeholder="Tên sách" value="<%=b.getName()%>">
		<div>Tác giả</div>
		<input type="text" name="author" class="inputtext" placeholder="Tác giả" value="<%=b.getAuthor()%>">
		<div>Thể loại</div>
		<input list="category" name="category" id="iptCategory" class="inputtext" placeholder="Thể loại" value="<%=b.getCategory()%>">
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
		<input type="text" name="publisher" class="inputtext" placeholder="Nhà xuất bản" value="<%=b.getPublisher()%>">
                <div>Mô tả</div>
		<input type="text" name="description" class="inputtext" placeholder="Mô tả" value="<%=b.getDescription()%>">
                <div>Năm xuất bản</div>
		<input type="text" name="releasedYear" class="inputtext" placeholder="Năm xuất bản" value="<%=b.getReleasedyear()%>">
                <div>URL ảnh</div>
                <input id="iptImage" type="file" accept="image/*" class="inputtext" placeholder="URL ảnh" onchange="jsUpdateImage(event,'showImage');jsSetAttribute('iptImageURL','value',jsImageURL1);document.getElementById('iptImageURL').value='image/'+jsImageURL;">
                <div><img width="400" height="250" id="showImage" src="<%=b.getImageurl()%>"></div>
                <input type='text' id="iptImageURL" name="imageurl" class="inputtext" hidden='true' value="<%=b.getImageurl()%>">
                <div>Giá cuối(VND)</div>
		<input id="asd" type="text" name="finalPrice" class="inputtext" placeholder="Giá cuối" value="<%=b.getFinalprice()%>">
                <div>Chiết khấu (VND)</div>
		<input type="text" name="discount" class="inputtext" placeholder="Giảm giá" value="<%=b.getDiscount()%>">
		<div style="padding: 14px" class="centerHor">
                    <input type="submit" value="Cập nhật" ></input>
		</div>
            </div>
        </div>
        </form>
        <% 
            String message = (String)request.getAttribute("message");
            if(message!=null){ %>
                <p><%=message%></p>
        <%}%>
        
        <%@ include file = "footer.jsp" %>
    </body>
</html>
