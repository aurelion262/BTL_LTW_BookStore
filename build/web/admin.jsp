<%-- 
    Document   : admin.jsp
    Created on : Nov 5, 2018, 6:24:22 AM
    Author     : Jichu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Admin</title>
	<link rel="stylesheet" type="text/css" href="csshomeadmin.css">
</head>
<body>
	<%@ include file = "header.jsp" %>   

	<div id="body">
		<div>
			<div id="bentrai">
				<div>
					<div class="linkad">
					<a href="addBook.jsp" class="link">Thêm sách</a>
					</div>
					<div class="linkad">
					<a href="accountList" class="link">Danh sách tài khoản</a>
					</div>
					<div class="linkad">
					<a href="" class="link">Danh sách đơn hàng</a>
					</div>

				</div>
			</div>

			<div id="benphai">
				<div>
					
					<div id="badivtrai">
						
						<div class="divtrai">
							<p>Tong dau sach</p>
							<p>1640</p>
						</div>
						<div class="divtrai">
							<p>Tong Order</p>
							<p>340</p>
						</div>
						<div class="divtrai">
							<p>Tong doanh thu</p>
							<p>100033203</p>
						</div>

					</div>

					<div id="badivphai">
						<div class="divphai">
							<p>Total Account</p>
							<p>140</p>
						</div>
						<div class="divphai">
							<p>Total Staff</p>
							<p>1640</p>
						</div>
						<div class="divphai">
							<p>Tong chi nhanh</p>
							<p>3</p>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<%@ include file = "footer.jsp" %>   
</body>
</html>
