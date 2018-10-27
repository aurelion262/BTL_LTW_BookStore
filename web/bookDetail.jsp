<%-- 
    Document   : bookDetail.jsp
    Created on : Oct 21, 2018, 1:14:11 PM
    Author     : i1vag_000
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Account"%>
<%@page import="model.DAO"%>
<%@page import="model.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        Book b = new DAO().getBook(Integer.parseInt(request.getParameter("bookId")));
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=b.getName()%></title>
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
        <br>Hello, <%=((Account)session.getAttribute("account")).getUsername()%> (<a href="logout">Đăng xuất</a>/<a href="editAccount.jsp?id=<%=((Account)session.getAttribute("account")).getId()%>">Chỉnh sửa hồ sơ</a>)
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
        <br><a href="accountList">Danh sách tài khoản</a> / <a href="order.jsp">Danh sách đơn hàng</a> / <a href="log.jsp">Nhật ký hoạt động</a> / <a href="addBook.jsp">Thêm sách</a>
        <%
                }
            }
        %>
        
        <br>>> Tìm kiếm nhanh :
        <form method="POST" action="searchBook">
        <select id="slctSearchOption" name="searchOption" onchange="jsSearchOption(this.options[this.selectedIndex].value)">
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
        <div>
            <div style="float:left; width: 50%"><img src="<%=b.getImageurl()%>" style="height:auto; width: 100%"></div>
            <div width=50% >
                <div>Tên : <%=b.getName()%></div>
                <div>Tác giả : <%=b.getAuthor()%></div>
                <div>Thể loại : <%=b.getCategory()%></div>
                <div>Nhà xuất bản : <%=b.getPublisher()%></div>
                <div>Năm xuất bản : <%=b.getReleasedyear()%></div>
                <div>Mô tả : <%=b.getDescription()%></div>
                <div>Giá : <%=b.getFinalprice()%> (Tiết kiệm : <%=b.getDiscount()%>)</div>
                
                <div><a href="addToCart?id="><image src="image/cart.png"></a></div>
            </div>
        </div>
    </body>
</html>
