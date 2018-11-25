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
        <link rel="stylesheet" type="text/css" href="css_dathang.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=((Account)session.getAttribute("account")).getName()%>'s order</title>
        <script type="text/javascript" src="js.js"></script>
    </head>
    <body>
        <%@ include file = "header.jsp" %>
        <%
            Account sessionAccount = (Account)session.getAttribute("account");
        %>
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
                                        <hr size="1" color="black">

					<div>
						<div>
                                                        <form method="POST" action="createOrder" id="orderDetail">
							<p>Họ và tên</p>
							<input name="clientName" type="text" class="input" value="<%=sessionAccount.getName()%>">
							<p>Số điện thoại</p>
							<input name="phoneNumber" type="text" class="input" value="<%=sessionAccount.getPhonenumber()%>">
							<p>Địa chỉ</p>                                                      
                                                        <textarea name="address" rows="4" cols="50" class="input" form="orderDetail"><%=sessionAccount.getAddress()%></textarea> 
                                                        <input name="totalPrice" type="text" value=<%=total%> hidden="true">
                                                        <div style="text-align: center;"><input style="margin-top: 15px;padding-left: 10px;padding-right: 10px;padding-bottom: 5px;padding-top: 5px" type="submit" value="Xác nhận"></div>
                                                        </form>
						</div>						
                                        </div>
                                                        
				</div>
			</div>
		</div>
	</div>

	<%@ include file = "footer.jsp" %>
    </body>
</html>
