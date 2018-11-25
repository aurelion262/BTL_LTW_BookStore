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
        <link rel="stylesheet" type="text/css" href="searchBook.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
        <script type="text/javascript" src="js.js"></script>
    </head>
    <body>
        <%@ include file = "header.jsp" %>
        <div id="body">
        <%
                ArrayList<Book> bookList = (ArrayList<Book>)request.getAttribute("bookList");
                if(bookList.isEmpty())
                {
        %>
        <br> Không tìm thấy kết quả nào phù hợp
        <%
                }
                else
                for(Book b : bookList)
                {
        %>
                <div class="abook">
                    <div style="float:left"><a class="link" href="bookDetailServlet?bookId=<%=b.getId()%>"><image src="<%=b.getImageurl()%>" class="book"></image></a></div>
                    <div id="bookname"><a class="link" href="bookDetailServlet?bookId=<%=b.getId()%>" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')"><%=b.getName()%></a><a href="addToFavoriteServlet?bookId=<%=b.getId()%>"><img src="icon/heart.png" style="height:30px; width: 30px"></a></div>
                    <div id="bookname">Tác giả : <%=b.getAuthor()%></div>
                    <div id="bookname">Thể loại : <%=b.getCategory()%></div>
                    <div id="bookname">Nhà xuất bản : <%=b.getPublisher()%></div>
                    <div id="bookname">Năm xuất bản : <%=b.getReleasedyear()%></div>
                        <div id="newprice">Giá : <%=b.getFinalprice()%><span> VND</span>
                                    <%
                                        if(b.getDiscount()!=0)
                                        {
                                    %>
                                    <font id="oldprice">(<%=(b.getFinalprice()+b.getDiscount())%><span> VND</span>)</font>
                                    <%
                                        }
                                    %>
                        </div>
                    <div id="bookname">
                                    <form onsubmit="testRegex('quantity','iptQuantity'); return alertRegex();" method='POST' action='addToCartServlet?bookId=<%=b.getId()%>'>
                                Số lượng : <input onkeypress="return isNumberKey(event)" min="1" id="iptQuantity" name="quantity" type="number" value="1" style="width: 30px">
                                <input type="image" style="width: 80px; height: 80px" src="icon/cart.png">
                                    </form>
                    </div>
                    
                </div>
        <%
                }
        %>
        </div>
        <%@ include file = "footer.jsp" %>
    </body>
</html>
