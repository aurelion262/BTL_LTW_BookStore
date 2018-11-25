<%-- 
    Document   : admin
    Created on : Nov 23, 2018, 10:14:12 PM
    Author     : Jichu
--%>

<%@page import="model.Account"%>
<%@page import="model.DAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>Side Bar</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="admin-css.css">
        <script type="text/javascript" src="js.js"></script>
</head>
<body>
	
		
<% DAO adminDAO = new DAO(); %>
			<div class="bar" style="text-align: center">
				<div class="side-bar">
					<div class="manage-book">                                                
						<div class="title-book">
							<p>Quản lý sách</p>
						</div>
                                                <br>
                                                <form method="POST" action="searchBookServlet?adminCP=true">
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
                                                            ArrayList<String> authorList = adminDAO.getAuthor();
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
                                                            ArrayList<String> categoryList = adminDAO.getCategory();
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
                                                <br>
						<div class="content-book">
							<a href="addBook.jsp" class="link-book">Thêm sách</a>							
						</div>
                                                <br>
					</div>

					<div class="manage-account">
						

						<div class="title-account">
							<p>Quản lý tài khoản nhân viên</p>
						</div>
						<br>
						<div class="content-book">
							<a href="addAccount.jsp?adminCP=true" class="link-account">Thêm tài khoản cho nhân viên</a>							
							<br>
                                                        <br>
							<a href="manageAccount?adminCP=true" class="link-account">Danh sách tài khoản nhân viên</a>							
							<br>
                                                        <br>
						</div>
					</div>

					<div class="manage-order">
						

						<div class="title-order">
							<p>Quản lý đơn đặt hàng</p>
						</div>
						<br>
						<div class="content-book">
							<a href="orderList?adminCP=true" class="link-order">Xem danh sách đơn hàng</a>
							<br>
                                                        <br>
						</div>
					</div>

					<div class="manage-home">
						

						<div class="title-other">
                                                    <p>Khác</p>
						</div>
                                                <br>
                                                <div class="content-book">
							<a href="viewLog?adminCP=true" class="link-other">Xem ghi chú hoạt động</a>							
							<br>
                                                        <br>
							<a href="" class="link-other">Phản hồi của khách hàng</a>							
							<br>
                                                        <br>
                                                        <br>
                                                        <br>
                                                        <br>
                                                        <br>
                                                        <p style="font-style: italic">(<%=((Account)session.getAttribute("account")).getUsername()%>)</p>
                                                        <p><a href="indexServlet"><< Trang chủ</a></p>
						</div>
					</div>
				</div>
			</div>
<% adminDAO.close(); %>

</body>
</html>