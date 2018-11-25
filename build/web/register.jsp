<%-- 
    Document   : register.jsp
    Created on : Oct 14, 2018, 9:32:45 PM
    Author     : i1vag_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="register.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <script type="text/javascript" src="js.js"></script>
    </head>
    <body>
        
        <%
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            String name = (String)request.getAttribute("name"),
                   username = (String)request.getAttribute("username"),
                   password = (String)request.getAttribute("password"),
                   repassword = (String)request.getAttribute("repassword"),
                   email = (String)request.getAttribute("email"),
                   address = (String)request.getAttribute("address"),
                   phonenumber = (String)request.getAttribute("phonenumber"),
                   creditcard = (String)request.getAttribute("creditcard");
        %>
        <form method="POST" action="registerServlet" onsubmit="return registerInputCheck()">
        <div id="outsite">
        <div id="cover">
            <div id="registertext" class="centerHor">
                <div id="textre">Đăng ký</div>
            </div>
		<div id="framefb">
                    <a href="indexServlet" class="centerHor" id="fbtext">Trở về trang chủ</a>
		</div>
		<div>Họ và tên</div>
		<input type="text" name="name" class="inputtext" placeholder="Tên người dùng..."
                       <% if(name!=null) { %> value="<%=name%>" <%}%>>
		<div>Tài khoản (*)</div>
		<input id='iptUsername' type="text" name="username" class="inputtext" placeholder="Tên tài khoản"
                       <% if(username!=null) { %> value="<%=username%>" <%}%>>
		<div>Mật khẩu (*)</div>
		<input id='iptPassword' type="password" name="password" class="inputtext" placeholder="Mật khẩu"
                       <% if(password!=null) { %> value="<%=password%>" <%}%>>
		<div>Nhập lại mật khẩu (*)</div>
		<input id='iptRepassword' type="password" name="repassword" class="inputtext" placeholder="Nhập lại mật khẩu"
                       <% if(repassword!=null) { %> value="<%=repassword%>" <%}%>>
                <div>Email (*)</div>
		<input id='iptEmail' type="text" name="email" class="inputtext" placeholder="Địa chỉ email"                       
                       <% if(email!=null) { %> value="<%=email%>" <%}%>>
                <div>Số điện thoại (*)</div>
		<input id='iptPhoneNumber' type="text" name="phonenumber" class="inputtext" placeholder="SĐT"
                       <% if(phonenumber!=null) { %> value="<%=phonenumber%>" <%}%>>
                <div>Địa chỉ</div>
		<input type="text" name="address" class="inputtext" placeholder="Địa chỉ nơi ở"
                       <% if(address!=null) { %> value="<%=address%>" <%}%>>
		<div style="padding: 13px" class="centerHor">
                    <input type="submit" value="Đăng ký" ></input>
		</div>
            </div>
        </div>
        </form>
        <% 
            String message = (String)request.getAttribute("message");
            if(message!=null){ %>
                <p><%=message%></p>
        <%}%>
        
    </body>
</html>
