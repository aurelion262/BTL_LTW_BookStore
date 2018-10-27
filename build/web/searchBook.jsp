<%-- 
    Document   : searchBook.jsp
    Created on : Oct 21, 2018, 1:15:44 PM
    Author     : i1vag_000
--%>

<%@page import="model.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Book"%>
<%@page import="model.DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
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
        <br>>> Tìm kiếm nhanh :
        <form method="POST" action="searchBook">
        <select id="slctSearchOption" name="searchOption" onchange="jsSearchOption(document.getElementById('slctSearchOption').options[document.getElementById('slctSearchOption').selectedIndex].value)">
            <option value="name">Tên sách</option>
            <option value="author">Tác giả</option>
            <option value="category">Thể loại</option>
            <option value="finalPrice">Giá</option>
        </select>           
            <input type="text" id="iptBookName" name="bookName" placeholder="Nhập tên" value=''>
            <input type="text" id="iptFloorPrice" name="floorPrice" placeholder="Min" hidden="true" value=''>
            <input type="text" id="iptCeilingPrice" name="ceilingPrice" placeholder="Max" hidden="true" value=''>
            <input list="author" name="author" id="iptAuthor" placeholder="Nhập tác giả" hidden="true" value=''>
            <datalist id="author">
                <%
                    ArrayList<String> authorList = new DAO().getAuthor();
                    for(String s : authorList)
                    {
                %>
                <option value="<%=s%>">
                <%
                    }
                %>
            </datalist>
            <input list="category" name="category" id="iptCategory" placeholder="Nhập thể loại" hidden="true" value=''>
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
            <input type="submit" value="Tìm">
        </form>
        <%
                ArrayList<Book> bookList = (ArrayList<Book>)request.getAttribute("bookList");
                for(Book b : bookList)
                {
        %>
                <div class="book">
                    <div><a href="bookDetail?bookId=<%=b.getId()%>"><image src="<%=b.getImageurl()%>" width="200" height="300"></image></a></div>
                    <div><a href="bookDetail?bookId=<%=b.getId()%>"><%=b.getName()%></a></div>
                </div>
        <%
                }
        %>
    </body>
</html>
