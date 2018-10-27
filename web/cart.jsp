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
        <link rel="stylesheet" type="text/css" href="css_viewcart.css">
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
                                        Hello, <a class="link" href="editAccount.jsp?id=<%=((Account)session.getAttribute("account")).getId()%>"><%=((Account)session.getAttribute("account")).getUsername()%></a> (<a class="link" href="logout">Đăng xuất</a>/<a class="link" href="cart">Xem giỏ hàng</a>)
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
                                <%
                                    int dex=0;
                                    long total=0;
                                    ArrayList<BooksInCart> cart = (ArrayList<BooksInCart>)request.getAttribute("cart");
                                    ArrayList<Book> books = (ArrayList<Book>)request.getAttribute("books");
                                    for(BooksInCart bic : cart)
                                    { 
                                %>                                
				<div>                                        
					<div class="block">
						<div id="cover">
							<img src="<%=books.get(dex).getImageurl()%>" class="biasach">
						</div>

						<div id="inforsach">
							<p>Tên : <%=books.get(dex).getName()%></p>
                                                        <p>Tác giả : <%=books.get(dex).getAuthor()%></p>
                                                        <p>Số lượng : <%=bic.getQuantity()%></p>
							<p>Đơn giá : <%=books.get(dex).getFinalprice()%></p>							
						</div>

						<div id="addmore">							
							<a href='removeFromCart?accountId=<%=bic.getAccountId()%>&bookId=<%=bic.getBookId()%>'>Xóa khỏi giỏ</a>
							<p>Tổng <span><%=bic.getQuantity()*books.get(dex).getFinalprice()%></span>VND</p>
						</div>
						<div class="ket">
							<hr size="1" color="black">
						</div>
					</div>
				</div>                                                    
                                    <%
                                        total+=bic.getQuantity()*books.get(dex).getFinalprice();
                                        dex=dex+1;
                                        }
                                    %>   
			</div>
		</div>	

		<div id="totalprice">
			<div class="contentlist">
				<div id="part1">
					<div class="text1">
						<p>Thông tin đơn hàng</p>	
					</div>

					<div id="total">
						<p>Total: <%=total%></p>
					</div>
					<div id="vat">
						<p>(Đã bao gồm VAT)</p>
					</div>
					<div>
					<input type="text" name="" placeholder="Ma giam gia">
					<button>Ap dung </button>
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
					<button>Tien hanh dat hang</button>
					<button>Tiep tuc mua hang</button>
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
