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
        <link rel="stylesheet" type="text/css" href="css_detail.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=b.getName()%></title>
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
	<div id="imagedetailframe"><img src="<%=b.getImageurl()%>" id="imagedetail"></div>
        <div id="detailbook">
		<p class="tensach"><%=b.getName()%></p>

		<div class="infors">
				<p id="tacgia">Tác giả: <span><%=b.getAuthor()%></span></p>	
		</div>
                <div class="infors">
			<p id="nhaxb">Thể loại: <span><%=b.getCategory()%></span></p>	
		</div>
		<div class="infors">
			<p id="nhaxb">Nhà xuất bản: <span><%=b.getPublisher()%></span></p>	
		</div>
		<div class="infors">
			<p id="namxb">Năm xuất bản: <span><%=b.getReleasedyear()%></span></p>				
		</div>
		<div class="infors">
			<p id="giadau">Giá: <span><%=b.getFinalprice()+b.getDiscount()%></span>VND</p>
		</div>
		<div class="infors">
			<p id="giahientai">Giá: <span><%=b.getFinalprice()%></span>VND</p>	
		</div>
                <div class="infors">
			<p id="nhaxb">
		<form method='POST' action='addToCart?bookId=<%=b.getId()%>'>
                Số lượng : <input id="iptQuantity" name="quantity" type="number" value="1" style="width: 30px">
                <input type="image" src="icon/cart.png">
                </div>
                </form>
                        </p>
        </div>
        <div id="desbook">
			<p class="tensach">Description</p>
			<p id="descontent"><%=b.getDescription()%></p>
	</div>
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
			<p class="text4">Let's us help you find that!</p>
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
    </body>
</html>
