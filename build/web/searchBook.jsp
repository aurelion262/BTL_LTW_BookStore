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
        <%
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            
        %>
        
        <div id="header">
            <div id="logo">
			<a class="link" href="index">
			<img id="image" src="logo.png">
			</a>
            </div>
            <div id="functionpart">
			
				<div id="contactpart">
					<p id="email">Email: hieusachcu@gmail.com</p>
					<p id="sdt">Contact: 0966017654</p>
				</div>
        <%--GENERAL NAVIGATION--%>
                        <div id="inforpart">
				<div id="enterpagepart">
					<%
                                            if(session.getAttribute("account")!=null)
                                            {
                                        %>
                                        Hello, <a class="link" href="editAccount.jsp?id=<%=((Account)session.getAttribute("account")).getId()%>"><%=((Account)session.getAttribute("account")).getUsername()%></a> (<a class="link" href="logout" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')">Đăng xuất</a>/<a class="link" href="cart" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')">Xem giỏ hàng</a>)
                                        <%
                                            }
                                            else{
                                        %>
                                            <br><a class="link" href="register.jsp" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')">Đăng ký</a>/<a class="link" href="login.jsp" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')">Đăng nhập</a>
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
                                        <br><a class="link" href="accountList" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')">Danh sách tài khoản</a> / <a class="link" href="order.jsp" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')">Danh sách đơn hàng</a> / <a class="link" href="log.jsp" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')">Nhật ký hoạt động</a> / <a class="link" href="addBook.jsp" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')">Thêm sách</a>
                                        <%
                                                }
                                            }
                                        %>				
				</div>
			</div>
                        <div id="searchbar">
				<div id="frames">
				<form method="POST" action="searchBook">
                                <select style="font-family: comic sans ms" id="slctSearchOption" name="searchOption" onchange="jsSearchOption(this.options[this.selectedIndex].value)">
                                    <option style="font-family: comic sans ms" value="name">Tên sách</option>
                                    <option style="font-family: comic sans ms" value="author">Tác giả</option>
                                    <option style="font-family: comic sans ms" value="category">Thể loại</option>
                                    <option style="font-family: comic sans ms" value="finalPrice">Giá</option>
                                </select>           
                                    <input style="font-family: comic sans ms" type="text" id="iptBookName" name="bookName" placeholder="Nhập tên" value=''>
                                    <input style="font-family: comic sans ms" type="number" id="iptFloorPrice" name="floorPrice" placeholder="Min" hidden="true" value=''>
                                    <input style="font-family: comic sans ms" type="number" id="iptCeilingPrice" name="ceilingPrice" placeholder="Max" hidden="true" value=''>
                                    <input style="font-family: comic sans ms" list="author" name="author" id="iptAuthor" placeholder="Nhập tác giả" hidden="true" value=''>
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
                                    <input style="font-family: comic sans ms" list="category" name="category" id="iptCategory" placeholder="Nhập thể loại" hidden="true" value=''>
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
                                    <input style="font-family: comic sans ms" type="submit" value="Tìm">
                                </form>
                                </div>
                        </div>
            </div>
        </div>
        <div id="body">
        <%
                ArrayList<Book> bookList = (ArrayList<Book>)request.getAttribute("bookList");
                for(Book b : bookList)
                {
        %>
                <div class="abook">
                    <div style="float:right"><form method="POST" action="deleteBook?bookId=<%=b.getId()%>&searchOption=<%=session.getAttribute("searchOption")%>&bookName=<%=session.getAttribute("bookName")%>&author=<%=session.getAttribute("author")%>&category=<%=session.getAttribute("category")%>&ceilingPrice=<%=session.getAttribute("ceilingPrice")%>&floorPrice=<%=session.getAttribute("floorPrice")%>"><input type='submit' value='Xóa sách này'></form></div>        
                    <div style="float:left"><a class="link" href="bookDetail?bookId=<%=b.getId()%>"><image src="<%=b.getImageurl()%>" class="book"></image></a></div>
                    <div id="bookname"><a class="link" href="bookDetail?bookId=<%=b.getId()%>" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')"><%=b.getName()%></a></div>
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
        <div id="footer">
		<div id="address">
			<p class="text3">Address</p>
			<p class="text4">Cs1:Km10 Nguyen Trai, Ha Dong dist, Ha Noi city</p>
			<p class="text4">Cs2:152 Nguyen Khuyen, 1st dist, Ho Chi Minh city</p>
			<p class="text4">Cs3:45 Le Loi, Hoan Kiem dist, Ha Noi city</p>

		</div>

		<div id="slogan">
			<p class="text3">Slogan</p>
			<p class="text4">Whenever you wanna find a book </p>
			<p class="text4">Let us help you find it!</p>
			<div id="soci">
			<a href="https://www.facebook.com/" > <img src="icon/fb.png"> </a>
			<a href="https://www.instagram.com/"> <img src="icon/ig.png"></a>
			</div>
		</div>

		<div id="payment">
			<p class="text3">Payment</p>
			<img src="method.PNG" id="payimage">
		</div>
	</div> 
        <%--PAGE CONTENT--%>
    </body>
</html>
