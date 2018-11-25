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
        <%@ include file = "header.jsp" %>
             
        <div id="body">
		<div id="listitem">
			<div class="contentlist">
				<div class="text1">
					<p id="giotext">Giỏ hàng </p>
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
                                                    <a href="bookDetailServlet?bookId=<%=books.get(dex).getId()%>"><img src="<%=books.get(dex).getImageurl()%>" class="biasach"></a>
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
					
					<div id="giao">
						<img src="icon/giao.png">
					</div>
					<div>
						<p>Nhanh không phanh - nhận hàng trong ngày</p>
						<hr size="1px" color="black">

					</div>
				</div>

				<div id="order">
                                    <a href="order" <% if (cart.isEmpty()) {%> onclick="alert('Giỏ hàng rỗng'); return false;" <% } %>><img style="padding-bottom: 90px" src="icon/dat_hang.png"></a>
				</div>
			</div>
		</div>
	</div>

	<%@ include file = "footer.jsp" %>
    </body>
</html>
