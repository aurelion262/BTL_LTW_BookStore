<%-- 
    Document   : cart.jsp
    Created on : Oct 21, 2018, 1:22:26 PM
    Author     : i1vag_000
--%>

<%@page import="model.Order"%>
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
        <title><%=((Account)session.getAttribute("account")).getName()%>'s cart</title>
        <script type="text/javascript" src="js.js"></script>
    </head>
    <body>
        <%@ include file = "header.jsp" %>
             
        <div id="body">
		
			<div class="contentlist">
				<div class="text1">
					<p id="giotext">Lịch sử đơn hàng </p>
					<div id="gioimage">
						<img src="icon/list.png" style="height: 70px; width: 70px">
					</div>
                                        <div style="float: right">
                                            <img style="height: 72px; width: 72px; margin-right: 40px;" src="icon/delivering.png" title="Đang vận chuyển">
                                            <img style="height: 72px; width: 72px; margin-right: 40px;" src="icon/paid.png" title="Thanh toán">
                                            <img style="height: 72px; width: 72px; margin-right: 40px;" src="icon/delivered.png" title="Nhận hàng">
                                        </div>
				</div>
                                <div class="ket">
							<hr size="1" color="black">
                                </div>
                                <div id="ngoai">
                                    <div id="trong">
                                <%
                                    ArrayList<Order> orderList = (ArrayList<Order>)request.getAttribute("orderList");
                                    for(Order o : orderList)
                                    { 
                                %>                                
                                    
					<div class="block">					

						<div style="float:left">
                                                        <div class="inforline">Tên người nhận : <%=o.getClientName()%></div>
                                                        <div class="inforline">Mã đơn hàng : <%=o.getId()%></div>
                                                        <div class="inforline">Ngày đặt : <%=o.getCreatedDate()%></div>
                                                        <div style="height: 48px; width: 70%" class="inforline">Địa chỉ đăng ký nhận hàng : <%=o.getAddress()%></div>
                                                        <div class="inforline">Tổng giá trị : <%=o.getTotalPrice()%> VND</div>
                                                        <div style="padding-bottom: 30px" class="inforline"><a style="font-style: italic" class="link" href="orderDetail?orderId=<%=o.getId()%>">(Xem chi tiết)</a>	</div>						
                                                </div>

						<div style="float:right">                                               
                                                    <div style="margin-right: 60px; margin-top: 30px" class="delete_from_cart">
                                                        <%
                                                            if(o.getIsDelivered()==0)
                                                            {
                                                        %>
                                                            <img src="icon/xmark.png">
                                                        <%
                                                            }
                                                            else
                                                            {
                                                        %>
                                                            <img src="icon/tick.png">
                                                        <%
                                                            }
                                                        %>
                                                    </div>
                                                    <div style="margin-right: 70px; margin-top: 30px" class="delete_from_cart">
                                                        <%
                                                            if(o.getIsPaid()==0)
                                                            {
                                                        %>
                                                            <img src="icon/xmark.png">
                                                        <%
                                                            }
                                                            else
                                                            {
                                                        %>
                                                            <img src="icon/tick.png">
                                                        <%
                                                            }
                                                        %>
                                                    </div>
                                                    <div style="margin-right: 70px; margin-top: 30px" class="delete_from_cart">
                                                        <%
                                                            if(o.getIsDelivering()==0)
                                                            {
                                                        %>
                                                            <img src="icon/xmark.png">
                                                        <%
                                                            }
                                                            else
                                                            {
                                                        %>
                                                            <img src="icon/tick.png">
                                                        <%
                                                            }
                                                        %>
                                                    </div>
                                                </div>
						<div class="ket">
							<hr size="1" color="black">
						</div>
					</div>
                                    
                                    <%                                        
                                        }
                                    %>
                                    </div> 
				</div>
			</div>
			
	</div>

	<%@ include file = "footer.jsp" %>
    </body>
</html>
