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
        DAO dao = new DAO();    
        Book b = dao.getBook(Integer.parseInt(request.getParameter("bookId")));
    %>
    <head>
        <link rel="stylesheet" type="text/css" href="css_detail.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=b.getName()%></title>
        <script type="text/javascript" src="js.js"></script>
    </head>
    <body>
        <%@ include file = "header.jsp" %>
	<div id="body">
	<div id="imagedetailframe"><img src="<%=b.getImageurl()%>" id="imagedetail"></div>
        <div id="detailbook">
            <%
                Account sessionAccount = (Account)session.getAttribute("account");
                if(sessionAccount!=null&&sessionAccount.getRole().equals("ADMIN"))
                {
            %>
                    <p class="infors"><a class="link" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')" onclick="return confirm('Xác nhận xóa ?')" href="deleteBookServlet?bookId=<%=b.getId()%>&searchOption=<%=session.getAttribute("searchOption")%>&bookName=<%=session.getAttribute("bookName")%>&author=<%=session.getAttribute("author")%>&category=<%=session.getAttribute("category")%>&ceilingPrice=<%=session.getAttribute("ceilingPrice")%>&floorPrice=<%=session.getAttribute("floorPrice")%>">Xoá</a>/<a class="link" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')" href="editBook?id=<%=b.getId()%>">Sửa</a></p>
            <%
                }
            %>
                <p class="tensach"><%=b.getName()%><a href="addToFavoriteServlet?bookId=<%=b.getId()%>"><img src="icon/heart.png" style="height:30px; width: 30px"></a></p>

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
                        <form onsubmit="testRegex('quantity','iptQuantity'); return alertRegex();" method='POST' action='addToCartServlet?bookId=<%=b.getId()%>'>
                Số lượng : <input onkeypress="return isNumberKey(event)" min="1" id="iptQuantity" name="quantity" type="number" value="1" style="width: 30px">
                <input type="image" src="icon/cart.png">
                        </form>
                </div>                
                        </p>
        </div>
        <div id="desbook">
			<p class="tensach">Description</p>
			<p id="descontent"><%=b.getDescription()%></p>
	</div>
        </div>
        <%dao.close();%>
	<%@ include file = "footer.jsp" %>
    </body>
</html>
