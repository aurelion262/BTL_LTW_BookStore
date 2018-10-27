<%-- 
    Document   : index.jsp
    Created on : Oct 14, 2018, 9:32:19 PM
    Author     : i1vag_000
--%>

<%@page import="model.Book"%>
<%@page import="model.DAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css_home.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOMEPAGE</title>
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
			<div id="inforpart">
				<div id="contactpart">
					<p id="email">Email: hieusachcu@gmail.com</p>
					<p id="sdt">Contact: 0966017654</p>
				</div>
        <%--GENERAL NAVIGATION--%>
				<div id="enterpagepart">
					<%
                                            if(session.getAttribute("account")!=null)
                                            {
                                        %>
                                        Hello, <%=((Account)session.getAttribute("account")).getUsername()%> (<a class="link" href="logout">Đăng xuất</a>/<a class="link" href="editAccount.jsp?id=<%=((Account)session.getAttribute("account")).getId()%>">Chỉnh sửa hồ sơ</a>)
                                        <%
                                            }
                                            else{
                                        %>
                                            <br><a class="link" href="register.jsp">Đăng ký</a>/<a class="link" href="login.jsp">Đăng nhập</a>
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
                                        <br><a class="link" href="accountList">Danh sách tài khoản</a> / <a class="link" href="order.jsp">Danh sách đơn hàng</a> / <a class="link" href="log.jsp">Nhật ký hoạt động</a> / <a class="link" href="addBook.jsp">Thêm sách</a>
                                        <%
                                                }
                                            }
                                        %>				
				</div>
			</div>
                        <div id="searchbar">
				<div id="frames">
				<form method="POST" action="searchBook">
                                <select id="slctSearchOption" name="searchOption" onchange="jsSearchOption(this.options[this.selectedIndex].value)">
                                    <option value="name">Tên sách</option>
                                    <option value="author">Tác giả</option>
                                    <option value="category">Thể loại</option>
                                    <option value="finalPrice">Giá</option>
                                </select>           
                                    <input type="text" id="iptBookName" name="bookName" placeholder="Nhập tên" value=''>
                                    <input type="number" id="iptFloorPrice" name="floorPrice" placeholder="Min" hidden="true" value=''>
                                    <input type="number" id="iptCeilingPrice" name="ceilingPrice" placeholder="Max" hidden="true" value=''>
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
                                </div>
                        </div>
            </div>
            <div id="body">
		<div id="topbody">
		<div id="text2">
                        <%
                            ArrayList<Book> saleOffList = (ArrayList<Book>)request.getAttribute("saleOffList");
                            if(saleOffList==null) response.sendRedirect("index");
                        %>
			<a href="" class="link"><p id="discounttext">Sale off Book</p></a>
			<hr size="1" color="black">
		</div>
                
		<div id="discount">
                    <%
                        try {

                    for(Book b : saleOffList)
                    {
                        
                    %>
			<div class="abook">
                            
				<a class="link" href="bookDetail?bookId=<%=b.getId()%>"><image src="<%=b.getImageurl()%>" class="book"></image></a>
				<div>
					<p id="bookname"><a class="link" href="bookDetail?bookId=<%=b.getId()%>"><%=b.getName()%></a></p>
				</div>
				<p id="newprice"><%=b.getFinalprice()%><span>VND</span> </p>
				<p id="oldprice"><%=(b.getFinalprice()+b.getDiscount())%><span>VND</span> </p>
                                <a href="addToCart"><img src="icon/cart.png" width="35px" height="35px">Add to cart</a>
			</div>
                    <%
                    }
                                                  
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                    %>
		</div>
		</div>
		<div id="botbody">
		<div id="bestsalling">
			
			<div id="text1">
				<a href="" class="link" ><p id="bestsallingtext">Best Salling Book</p></a>
				<hr size="1" color="black">
			</div>
                        <%
                            ArrayList<Book> bestSellingList = (ArrayList<Book>)request.getAttribute("bestSellingList");
                        %>
			<%
                            try {
                                    
                              
                            for(Book b : bestSellingList)
                            {
                                
                        %>
			<div class="abook">
                            
				<a class="link" href="bookDetail?bookId=<%=b.getId()%>"><image src="<%=b.getImageurl()%>" class="book"></image></a>
				<div>
					<p id="bookname"><a class="link" href="bookDetail?bookId=<%=b.getId()%>"><%=b.getName()%></a></p>
				</div>
				<p id="newprice"><%=b.getFinalprice()%><span>VND</span> </p>
				<p id="oldprice"><%=(b.getFinalprice()+b.getDiscount())%><span>VND</span> </p>
                                <a href="addToCart"><img src="icon/cart.png" width="35px" height="35px">Add to cart</a>
			</div>
                        <%
                            
                            }
                            } catch (Exception e) {
                                e.printStackTrace();
                                }
                        %>

		</div>
		</div>
	</div>

	<div id="footer">
		<div id="address">
			<p class="text3">Address</p>
			<p class="text4">Km10 Nguyen Trai, Ha Dong dist, Ha Noi city</p>
		</div>

		<div id="slogan">
			<p class="text3">Slogan</p>
			<p class="text4">Khong thieu sach nao ban can.</p>
		</div>

		<div id="payment">
			<p class="text3">Payment</p>
			<img src="method.PNG" id="payimage">
		</div>
	</div>
        <%--PAGE CONTENT--%>
    </body>
</html>
