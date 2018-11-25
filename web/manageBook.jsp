<%-- 
    Document   : manageBook
    Created on : Nov 26, 2018, 3:17:11 AM
    Author     : ADMIN
--%>

<%@page import="model.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="searchBook.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý sách</title>
    </head>
    <body>
        <div style="width: 20%; float: left">
            <%@ include file = "adminSideBar.jsp" %>
        </div>
        <div style="width: 80%; float: left">
            <div style="font-family: Calibri;
                        clear: left;
                        width: 100%;
                        height: 700px;
                        background-color: #d0b795;
                        overflow: auto;
            ">
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
                    <div class="abook" style="width: 85%">
                        <%
                            if((session.getAttribute("account")!=null)&&((Account)session.getAttribute("account")).getRole().equals("ADMIN"))
                            {
                        %>
                        <div style="float:right"><a class="link" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')" onclick="return confirm('Xác nhận xóa ?')" href="deleteBookServlet?bookId=<%=b.getId()%>&searchOption=<%=session.getAttribute("searchOption")%>&bookName=<%=session.getAttribute("bookName")%>&author=<%=session.getAttribute("author")%>&category=<%=session.getAttribute("category")%>&ceilingPrice=<%=session.getAttribute("ceilingPrice")%>&floorPrice=<%=session.getAttribute("floorPrice")%>&turnBack=true">Xoá</a>/<a class="link" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')" href="editBook?id=<%=b.getId()%>">Sửa</a></div>        
                        <%
                            }
                        %>
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

                                        <form onsubmit="testRegex('quantity','iptQuantity'); return alertRegex();" method='POST' action='addToCartServlet?bookId=<%=b.getId()%>'>
                                Số lượng : <input onkeypress="return isNumberKey(event)" min="1" id="iptQuantity" name="quantity" type="number" value="1" style="width: 30px">
                                <input type="image" src="icon/cart.png">
                                        </form>

                    </div>
            <%
                    }
            %>
            </div>
        </div>
    </body>
</html>
