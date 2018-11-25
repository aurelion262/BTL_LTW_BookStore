<%-- 
    Document   : cart.jsp
    Created on : Oct 21, 2018, 1:22:26 PM
    Author     : i1vag_000
--%>

<%@page import="model.BooksInFavorite"%>
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
        <title><%=((Account)session.getAttribute("account")).getName()%>'s favorite list</title>
        <script type="text/javascript" src="js.js"></script>
    </head>
    <body>
        <%@ include file = "header.jsp" %>
             
        <div id="body">
		
			<div class="contentlist">
				<div class="text1">
					<p id="giotext">Danh sách yêu thích </p>
					<div id="gioimage">
						<img src="icon/heart.png" style="height: 70px; width: 70px">
					</div>
				</div>
                                <div class="ket">
							<hr size="1" color="black">
                                </div>
                                <div id="ngoai">
                                    <div id="trong">
                                <%
                                    int dex=0;                                    
                                    ArrayList<BooksInFavorite> bifList = (ArrayList<BooksInFavorite>)request.getAttribute("favoriteList");
                                    ArrayList<Book> books = (ArrayList<Book>)request.getAttribute("books");
                                    for(BooksInFavorite bif : bifList)
                                    { 
                                %>                                
                                    
					<div class="block">
						<div id="cover">
                                                    <a href="bookDetailServlet?bookId=<%=books.get(dex).getId()%>"><img src="<%=books.get(dex).getImageurl()%>" class="biasach"></a>
						</div>

						<div id="inforsach">
							<div class="inforline">Tên : <%=books.get(dex).getName()%></div>
                                                        <div class="inforline">Tác giả : <%=books.get(dex).getAuthor()%></div>
                                                        <div class="inforline">Thể loại : <%=books.get(dex).getCategory()%></div>
							<div class="inforline">Đơn giá : <%=books.get(dex).getFinalprice()%> VNĐ</div>	
                                                        <div class="inforline">
                                                        <form onsubmit="testRegex('quantity','iptQuantity'); return alertRegex();" method='POST' action='addToCartServlet?bookId=<%=books.get(dex).getId()%>'>
                                Số lượng : <input onkeypress="return isNumberKey(event)" min="1" id="iptQuantity" name="quantity" type="number" value="1" style="width: 30px">
                                <input type="image" style="width: 45px; height: 45px" src="icon/cart.png">
                                    <a href="removeFromFavorite?bookId=<%=books.get(dex).getId()%>"><img style="width: 35px; height: 35px; margin-bottom: 6px" src="icon/cancel.png"></a>
                                                        </form>
                                                        </div>
                                                </div>				
						<div class="ket">
							<hr size="1" color="black">
						</div>
					</div>
                                    
                                    <%                                        
                                        dex=dex+1;
                                        }
                                    %>
                                    </div> 
				</div>
			</div>
			
	</div>

	<%@ include file = "footer.jsp" %>
    </body>
</html>
