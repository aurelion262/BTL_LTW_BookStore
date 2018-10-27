<%-- 
    Document   : feedBack.jsp
    Created on : Oct 21, 2018, 1:21:41 PM
    Author     : i1vag_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="js.js"></script>
    </head>
    <body>
        Hãy để lại góp ý của bạn với chúng tôi :
        <form method="POST" action="feedback">
        <input type="text" name="feedback">
        <input type="submit">
        </form>
    </body>
</html>
