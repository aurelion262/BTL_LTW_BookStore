<%-- 
    Document   : cart.jsp
    Created on : Oct 21, 2018, 1:22:26 PM
    Author     : i1vag_000
--%>

<%@page import="model.Order"%>
<%@page import="model.BooksInOrder"%>
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
        <title>Chi tiết đơn hàng</title>
        <script type="text/javascript" src="js.js"></script>
    </head>
    <body>
        <%@ include file = "header.jsp" %>
             
        <div id="body">
		<div id="listitem">
			<div class="contentlist">
				<div class="text1">
					<p id="giotext">Thông tin đơn hàng </p>
					<div id="gioimage">
						<img src="icon/list.png" style="height: 70px; width: 70px">
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
                                    Order o = (Order)request.getAttribute("order");
                                    ArrayList<BooksInOrder> bioList = (ArrayList<BooksInOrder>)request.getAttribute("bioList");
                                    ArrayList<Book> books = (ArrayList<Book>)request.getAttribute("books");
                                    for(BooksInOrder bio : bioList)
                                    { 
                                %>                                
                                    
					<div class="block">
						<div id="cover">
                                                    <a href="bookDetailServlet?bookId=<%=books.get(dex).getId()%>"><img src="<%=books.get(dex).getImageurl()%>" class="biasach"></a>
						</div>

						<div id="inforsach">
							<div class="inforline">Tên : <%=books.get(dex).getName()%></div>
                                                        <div class="inforline">Tác giả : <%=books.get(dex).getAuthor()%></div>
                                                        <div class="inforline">Số lượng : <%=bio.getQuantity()%></div>
							<div class="inforline">Đơn giá : <%=books.get(dex).getFinalprice()%> VNĐ</div>							
						</div>

						<div id="addmore">                                                  
                                                    <div class="total_price">Tổng: <span><%=bio.getQuantity()*books.get(dex).getFinalprice()%></span> VND</div>
						</div>
						<div class="ket">
							<hr size="1" color="black">
						</div>
					</div>
                                    
                                    <%
                                        total+=bio.getQuantity()*books.get(dex).getFinalprice();
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
							
                                                        <div class="inforline">Mã đơn hàng : <%=o.getId()%></div>
                                                        <div class="inforline">Ngày đặt : <%=o.getCreatedDate()%></div>
                                                        <div class="inforline">Tên người nhận : <%=o.getClientName()%></div>
                                                        <div class="inforline">SĐT : <%=o.getPhoneNumber()%></div>
                                                        <div style="height: 48px" class="inforline">Địa chỉ đăng ký nhận hàng : <%=o.getAddress()%></div>
                                                        <div class="inforline">Tổng giá trị : <%=o.getTotalPrice()%> VND</div>
                                                                                                                                                           
						</div>						
                                        </div>
				</div>

				
			</div>
		</div>
	</div>

	<%@ include file = "footer.jsp" %>
    </body>
</html>
