<%-- 
    Document   : forgetPassword.jsp
    Created on : Nov 5, 2018, 1:32:50 AM
    Author     : Jichu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tìm lại mật khẩu</title>
    </head>
    <body>
        <%@ include file = "header.jsp" %>
        <div style="height: 200px; padding-top: 50px">
        <form method="POST" action="forgetPasswordServlet">
            Nhập tên tài khoản của bạn : <input type="text" name="username"><input type="submit" value="Gửi">
        </form>
        <p style="font-style: italic">(Chúng tôi sẽ gửi email nhắc mật khẩu tới địa chỉ email bạn đã dùng để đăng ký tài khoản)</p>
        <%
            if(request.getAttribute("reply")!=null)
            {
        %>
        <p style="color: red; font-weight: bold"> <%=request.getAttribute("reply")%>
        <%
            }
        %>
        </div>
        <%@ include file = "footer.jsp" %>   
    </body>
</html>
