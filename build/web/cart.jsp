<%-- 
    Document   : cart.jsp
    Created on : Oct 21, 2018, 1:22:26 PM
    Author     : i1vag_000
--%>

<%@page import="model.DAO"%>
<%@page import="model.Book"%>
<%@page import="model.BooksInCart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="viewcart.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=((Account)session.getAttribute("account")).getName()%>'s cart</title>
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
		<div id="listitem">
			<div class="contentlist">
				<div class="text1">
					<p id="giotext">Gio hang </p>
					<div id="gioimage">
						<img src="icon/gio.png">
					</div>
				</div>
                                <div class="ket">
							<hr size="1" color="black">
                                </div>
                                <div id="ngoai">
                                    <div id="trong">
                                <%
                                    int dex=0;
                                    long total=0;
                                    ArrayList<BooksInCart> cart = (ArrayList<BooksInCart>)request.getAttribute("cart");
                                    ArrayList<Book> books = (ArrayList<Book>)request.getAttribute("books");
                                    for(BooksInCart bic : cart)
                                    { 
                                %>                                
                                    
					<div class="block">
						<div id="cover">
                                                    <a href="bookDetail?bookId=<%=books.get(dex).getId()%>"><img src="<%=books.get(dex).getImageurl()%>" class="biasach"></a>
						</div>

						<div id="inforsach">
							<div class="inforline">Tên : <%=books.get(dex).getName()%></div>
                                                        <div class="inforline">Tác giả : <%=books.get(dex).getAuthor()%></div>
                                                        <div class="inforline">Số lượng : <%=bic.getQuantity()%></div>
							<div class="inforline">Đơn giá : <%=books.get(dex).getFinalprice()%> VNĐ</div>							
						</div>

						<div id="addmore">                                                    
                                                    <div class="delete_from_cart"><a class="link" href='removeFromCart?accountId=<%=bic.getAccountId()%>&bookId=<%=bic.getBookId()%>' onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')"><img src='icon/cancel.png' width=25 height=25 title="Xoá khỏi giỏ"></a></div>
                                                    <div class="total_price">Tổng: <span><%=bic.getQuantity()*books.get(dex).getFinalprice()%></span> VND</div>
						</div>
						<div class="ket">
							<hr size="1" color="black">
						</div>
					</div>
                                    
                                    <%
                                        total+=bic.getQuantity()*books.get(dex).getFinalprice();
                                        dex=dex+1;
                                        }
                                    %>
                                    </div> 
				</div>
			</div>
		</div>	

		<div id="totalprice">
			<div class="contentlist">
				<div id="part1">
					<div class="text1">
						<p>Thông tin đơn hàng</p>	
					</div>

					<div id="total">
						<p>Total: <%=total%> VND</p>
					</div>
					<div id="vat">
						<p>(Đã bao gồm VAT)</p>
					</div>
					<div>
					<input type="text" name="" placeholder="Mã giảm giá">
					<button>Áp dụng </button>
					<img src="icon/tick.png" id="tick">
					</div>
					<div id="giao">
						<img src="icon/giao.png">
					</div>
					<div>
						<p>Nhanh không phanh - nhận hàng trong ngày</p>
						<hr size="1px" color="black">

					</div>
				</div>

				<div id="order">
                                    <a href="createOrder"><img style="padding-bottom: 90px" src="icon/dat_hang.png"></a>
				</div>
			</div>
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
                
         
    </body>
</html>
