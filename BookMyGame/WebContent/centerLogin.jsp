<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

<!-- Title Page-->
<title>Book My Game</title>

<!-- Fontfaces CSS-->
<link href="css/font-face.css" rel="stylesheet" media="all">
<link href="vendor/font-awesome-4.7/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<link href="vendor/font-awesome-5/css/fontawesome-all.min.css"
	rel="stylesheet" media="all">
<link href="vendor/mdi-font/css/material-design-iconic-font.min.css"
	rel="stylesheet" media="all">

<!-- Bootstrap CSS-->
<link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet"
	media="all">

<!-- Vendor CSS-->
<link href="vendor/animsition/animsition.min.css" rel="stylesheet"
	media="all">
<link
	href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css"
	rel="stylesheet" media="all">
<link href="vendor/wow/animate.css" rel="stylesheet" media="all">
<link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet"
	media="all">
<link href="vendor/slick/slick.css" rel="stylesheet" media="all">
<link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
<link href="vendor/perfect-scrollbar/perfect-scrollbar.css"
	rel="stylesheet" media="all">

<!-- Main CSS-->
<link href="css/theme.css" rel="stylesheet" media="all">

<style>
body {
	background: url("images/mainbg.jpg") center no-repeat;
	background-size: cover;
}
</style>

<%
				String result = request.getParameter("request");
				if(request != null) {
					if("fail".equals(result)) {
						out.println("<script>alert('Login Failed due to invalid credentials. Please try again')</script>");
					}
				}
				
				String regRequest = request.getParameter("regRequest");
				if(request != null) {
					if("fail".equals(result)) {
						out.println("<script>alert('Sport Center registration Failed. Please try again')</script>");
					} else {
						out.println("<script>alert('Sport Center registered successfully!')</script>");
					}
				}
				if(request.getParameter("sessionExpired") != null) {
					out.println("<script>alert('User Session expired. Please login again')</script>");
				}
				if(request.getSession() != null && request.getSession().getAttribute("centerId") != null) {
					request.getSession().removeAttribute("centerId");
				}
%>
</head>

<body class="animsition">
	<div class="page-wrapper">
		<div class="page-content--bge5">
			<div class="container">
				<div class="login-wrap">
					<div class="login-content">
						<div class="login-logo">
							<a href="index.jsp"> <img src="images/icon/logo.png"
								alt="CoolAdmin">
							</a>
						</div>
						<div class="login-form">
							<form action="center/login" method="post">
								<div class="form-group">
									<label>Sports Center Email Address</label> <input
										class="au-input au-input--full" type="email" name="email"
										placeholder="Email">
								</div>
								<div class="form-group">
									<label>Password</label> <input class="au-input au-input--full"
										type="password" name="password" placeholder="Password">
								</div>
								<button class="au-btn au-btn--block au-btn--green m-b-20"
									type="submit">sign in</button>
							</form>
							<div class="register-link">
								<p>
									New Sports Center? <a href="centerRegister.jsp">Sign Up
										Here</a>
								</p>
							</div>
							<div class="register-link">
								<p style="border-top: solid #CFD8DC; padding-top: 5px;">
									<a href="index.jsp">HOME</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<!-- Jquery JS-->
	<script src="vendor/jquery-3.2.1.min.js"></script>
	<!-- Bootstrap JS-->
	<script src="vendor/bootstrap-4.1/popper.min.js"></script>
	<script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
	<!-- Vendor JS       -->
	<script src="vendor/slick/slick.min.js">
    </script>
	<script src="vendor/wow/wow.min.js"></script>
	<script src="vendor/animsition/animsition.min.js"></script>
	<script src="vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
    </script>
	<script src="vendor/counter-up/jquery.waypoints.min.js"></script>
	<script src="vendor/counter-up/jquery.counterup.min.js">
    </script>
	<script src="vendor/circle-progress/circle-progress.min.js"></script>
	<script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
	<script src="vendor/chartjs/Chart.bundle.min.js"></script>
	<script src="vendor/select2/select2.min.js">
    </script>

	<!-- Main JS-->
	<script src="js/main.js"></script>

</body>

</html>
<!-- end document-->