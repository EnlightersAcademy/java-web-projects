<!DOCTYPE html>
<%@page import="com.espresso.util.EspressoUtil"%>
<html lang="en">

<head>
	<title>Espresso Café</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!--===============================================================================================-->
	<link rel="icon" type="image/png" href="assets/images/icons/favicon.ico" />
	<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="assets/login/css/util.css">
	<link rel="stylesheet" type="text/css" href="assets/login/css/main.css">
	<!--===============================================================================================-->
</head>
<%

	String expired = request.getParameter("exp");
	if(expired != null && "true".equals(expired)) {
		%>
		alert("User Session expired. Please login again")
		<% 
	}
%>
<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form" method="post" action="adminhome.jsp">
					<span class="login100-form-title p-b-34" style="margin-top: -100px;">
						<img src="assets/images/logo.png" />
					</span>
					<span class="login100-form-title p-b-34" style="font-size: x-large;">
						<b>Espresso Café</b>
					</span>

					<div class="wrap-input100 rs1-wrap-input100 validate-input m-b-20" data-validate="Type user name">
						<input id="username" class="input100" type="text" name="username" placeholder="User Name">
						<span class="focus-input100"></span>
					</div>
					<div class="wrap-input100 rs2-wrap-input100 validate-input m-b-20" data-validate="Type password">
						<input class="input100" type="password" id="password" name="password" placeholder="Password">
						<span class="focus-input100"></span>
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Sign in
						</button>
					</div>

					<div class="w-full text-center p-t-27 p-b-239">
						<span class="txt1">
							&nbsp;
							<!-- Forgot -->
						</span>

						&nbsp;
						<!-- <a href="#" class="txt2">
							User name / password?
						</a> -->
					</div>

					<div class="w-full text-center">
						&nbsp;
						<!-- <a href="#" class="txt3">
							Sign Up
						</a> -->
					</div>
				</form>

				<div class="login100-more" style="background-image: url('assets/images/bg-01.jpg');"></div>
			</div>
		</div>
	</div>



	<div id="dropDownSelect1"></div>

	<!--===============================================================================================-->
	<script src="assets/vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="assets/vendor/bootstrap/js/popper.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script>
		$(".selection-2").select2({
			minimumResultsForSearch: 20,
			dropdownParent: $('#dropDownSelect1')
		});
	</script>

	<script src="assets/login/js/main.js"></script>

</body>

</html>