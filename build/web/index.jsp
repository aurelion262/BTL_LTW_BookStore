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
        <%@ include file = "header.jsp" %>                           
            <div id="body">
		
		<div id="text2">
                        <%
                            ArrayList<Book> saleOffList = (ArrayList<Book>)request.getAttribute("saleOffList");
                            if(saleOffList==null) response.sendRedirect("index");
                        %>
			<a href="" class="link"><div id="discounttext">Đang khuyến mãi</div></a>
			
		</div>
                
		<div id="discount">
                    <%
                        try {

                    for(Book b : saleOffList)
                    {
                        
                    %>
			<div class="abook">
                            
                            <a class="link" href="bookDetail?bookId=<%=b.getId()%>"><image src="<%=b.getImageurl()%>" class="book"></image></a>
				
                            <div id="bookname"><a class="link" href="bookDetail?bookId=<%=b.getId()%>" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')"><%=b.getName()%></a><a href="addToFavorite?bookId=<%=b.getId()%>"><img src="icon/heart.png" style="height:30px; width: 30px"></a></div>
                                <div style="float:right">
                                    <a class="link" href="addToCart?bookId=<%=b.getId()%>&quantity=1" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')"><img src="icon/cart.png" width="65px" height="65px"></a>
                                </div>
                                <div style="float:right;padding-top: 8px">
                                    <div id="newprice"><%=b.getFinalprice()%><span> VND</span></div>
                                    <div id="oldprice"><%=(b.getFinalprice()+b.getDiscount())%><span> VND</span></div>
                                </div>
                                
			</div>
                    <%
                    }
                                                  
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                    %>
		</div>
		
		
		<div id="bestsalling">
			
			<div id="text1">
				<a href="" class="link" ><div id="bestsallingtext">Bán chạy nhất</div></a>
				
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
				
					<div id="bookname"><a class="link" href="bookDetail?bookId=<%=b.getId()%>" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')"><%=b.getName()%></a><a href="addToFavorite?bookId=<%=b.getId()%>"><img src="icon/heart.png" style="height:30px; width: 30px"></a></div>
				
				<div style="float:right">
                                    <a class="link" href="addToCart?bookId=<%=b.getId()%>&quantity=1" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')"><img src="icon/cart.png" width="65px" height="65px"></a>
                                </div>
                                <div style="float:right;padding-top: 8px">
                                    <div id="newprice"><%=b.getFinalprice()%><span> VND</span></div>
                                    <%
                                        if(b.getDiscount()!=0)
                                        {
                                    %>
                                        <div id="oldprice"><%=(b.getFinalprice()+b.getDiscount())%><span> VND</span></div>
                                    <%
                                        }
                                    %>
                                </div>
                        </div>
                        <%
                            
                            }
                            } catch (Exception e) {
                                e.printStackTrace();
                                }
                        %>

		</div>
		
	</div>

        <%@ include file = "footer.jsp" %>
    </body>
</html>
