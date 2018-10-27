<%-- 
    Document   : login.jsp
    Created on : Oct 17, 2018, 7:06:42 PM
    Author     : i1vag_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="register.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <script type="text/javascript" src="js.js"></script>
    </head>
    <body>
        <form method="POST" action="login">
        <div id="outsite">
            <div id="cover">
            <div id="registertext" class="centerHor">
                <div id="textre">Đăng nhập</div>
            </div>
		<div id="framefb">
                    <a href="index.jsp" class="centerHor" id="fbtext">Trở về trang chủ</a>
		</div>
		<div>Tài khoản</div>
		<input type="text" name="username" class="inputtext" placeholder="Tài khoản">
		<div>Mật khẩu</div>
		<input type="password" name="password" class="inputtext" placeholder="Mật khẩu">
                <div id="more">
                    <div id="forgetpass">
                        <a href="" class="linkmore">Quên mật khẩu</a>
                    </div>
                    
                    <div id="regisinlogin">
                        <a href="register.jsp" class="linkmore">Đăng ký</a>
                    </div>
                </div>
		<div class="centerHor">
                    <input type="submit" value="Đăng nhập"></input>
		</div>
            </div>
	</div>
        </form>
        <%if(request.getAttribute("message")!=null) out.print(request.getAttribute("message"));%>
    </body>
</html>
