
<%@page import="java.util.ArrayList"%>
<%@page import="model.DAO"%>
<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <head>
        <link rel="stylesheet" type="text/css" href="header.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOMEPAGE</title>
        <script type="text/javascript" src="js.js"></script>
    </head>
        <%
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
//            Account sessionAccount = (Account)session.getAttribute("account");  
            DAO headerDAO = new DAO();
        %>
        
        <div id="header">
            <div id="logo">
			<a class="link" href="indexServlet">
			<img id="image" src="logo.png">
			</a>
            </div>
            <div id="functionpart">
			
				<div id="contactpart">
					<p id="email">Email: hieusachcu@gmail.com</p>
                                        <p id="sdt">Contact: 0966017654 / <a class="link" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')" href="feedBack.jsp">Góp ý</a></p>
				</div>
        <%--GENERAL NAVIGATION--%>
                        <div id="inforpart">
				<div id="enterpagepart">
					<%
                                            if(session.getAttribute("account")!=null)
                                            {
                                        %>
                                        Hello, <a class="link" href="editAccount.jsp?id=<%=((Account)session.getAttribute("account")).getId()%>"><%=((Account)session.getAttribute("account")).getUsername()%></a> (<a class="link" href="logout" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')">Đăng xuất</a>/<a class="link" href="cart" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')">Giỏ hàng</a>/<a class="link" href="orderHistory" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')">Tình trạng đơn hàng</a>/<a class="link" href="favoriteServlet" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')">Yêu thích</a>)
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
                                        <br><a class="link" href="admin.jsp" onmouseover="this.setAttribute('style','text-decoration:underline')" onmouseout="this.setAttribute('style','text-decoration:none')">>> Admin Panel</a>
                                        <%
                                                }
                                            }
                                        %>				
				</div>
			</div>
                        <div id="searchbar">
				<div id="frames">
				<form method="POST" action="searchBookServlet">
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
                                            ArrayList<String> authorList = headerDAO.getAuthor();
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
                                            ArrayList<String> categoryList = headerDAO.getCategory();
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
        <%headerDAO.close();%>
