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
        <%@ include file = "header.jsp" %>
        <%
            Account sessionAccount = (Account)session.getAttribute("account");
        %>
        Hãy để lại góp ý của bạn với chúng tôi !
        <div>
        <form method="POST" action="feedbackServlet">
            <div>Để lại góp ý dưới tên : <input type="text" name="name" placeholder="Tên của bạn..." <% if(sessionAccount!=null) {%> value="<%=sessionAccount.getName()%>" disabled="true"<%}%>>
            <input type="text" name="accountId" <% if(sessionAccount!=null) {%> value="<%=sessionAccount.getId()%>"<%}%> hidden="true">
            <div><textarea rows="4" cols="50" name="feedback"></textarea></div>
        <input type="submit">
        </form>
        <%
            if(request.getAttribute("reply")!=null)
            {
        %>
        <br><%=request.getAttribute("reply")%>
        <%
            }
        %>
        </div>
        <%@ include file = "footer.jsp" %>
    </body>
</html>
