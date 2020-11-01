<%@ include file="staffheader.jsp"%>

<div class="row" style="margin-top: 50px;">
	<div class="col col-md-4"></div>

	<div class="col col-md-4">
		<form class="form-signin" method="post" action="staffneworder2.jsp">
			<h3 class="mt-4" style="padding-bottom: 15px;">
				<i class="fas fa-user-shield"></i>
				Change Password
			</h3>

			<input
				type="password" id="password1" class="form-control"
				placeholder="Enter New Password" required autofocus>
				<br/>
				<input
				type="password" id="password2" class="form-control"
				placeholder="Confirm New Password" required autofocus>
			<br/>
			<button class="btn btn-lg btn-success btn-block" type="submit">Update Password</button>
		</form>
	</div>

	<div class="col col-md-4"></div>
</div>



<%@ include file="stafffooter.jsp"%>