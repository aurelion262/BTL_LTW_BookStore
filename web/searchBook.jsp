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
                for(Book b : bookList)
                {
        %>
                <div class="abook">
                    <%
                        if((session.getAttribute("account")!=null)&&((Account)session.getAttribute("account")).getRole().equals("ADMIN"))
                        {
                    %>
                    <div style="float:right"><a class="link" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')" href="deleteBook?bookId=<%=b.getId()%>&searchOption=<%=session.getAttribute("searchOption")%>&bookName=<%=session.getAttribute("bookName")%>&author=<%=session.getAttribute("author")%>&category=<%=session.getAttribute("category")%>&ceilingPrice=<%=session.getAttribute("ceilingPrice")%>&floorPrice=<%=session.getAttribute("floorPrice")%>&turnBack=true">Xoá</a>/<a class="link" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')" href="editBook?id=<%=b.getId()%>">Sửa</a></div>        
                    <%
                        }
                    %>
                    <div style="float:left"><a class="link" href="bookDetail?bookId=<%=b.getId()%>"><image src="<%=b.getImageurl()%>" class="book"></image></a></div>
                    <div id="bookname"><a class="link" href="bookDetail?bookId=<%=b.getId()%>" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')"><%=b.getName()%></a><a href="addToFavorite?bookId=<%=b.getId()%>"><img src="icon/heart.png" style="height:30px; width: 30px"></a></div>
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
                    
                                    <a class="link" href="addToCart?bookId=<%=b.getId()%>&quantity=1" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')"><img src="icon/cart.png" width="75px" height="75px"></a>
                    
                </div>
        <%
                }
        %>
        </div>
        <%@ include file = "footer.jsp" %>
    </body>
</html>
