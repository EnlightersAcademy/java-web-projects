<%@ include file="staffheader.jsp"%>

<%@page import="com.espresso.util.EspressoUtil"%>


<%
	if(EspressoUtil.isResponseSuccess(request) != -1) {
		int status = EspressoUtil.isResponseSuccess(request);
		if( status == 0) {
			%>
			<script>
				alert("Successfully changed password")
			</script>
			<%
		} else if (status == 1){
			%>
			<script>
				alert("Password update failed. Please retry again")
			</script>
			<%
		} else if(status == 3) {
			%>
			<script>
				alert("New password and Confirm password does not match. Please verify the provided details")
			</script>
			<%
		}
	}

%>


<div class="row" style="margin-top: 50px;">
	<div class="col col-md-4"></div>

	<div class="col col-md-4">
		
		<div class="card shadow-lg border-0 rounded-lg mt-5">
		    <div class="card-header">
		    	<h3 class="text-center font-weight-light my-4">
		    	<i class="fas fa-user-shield"></i>
				Change Password</h3>
		   	</div>
		    <div class="card-body">
		        <form class="form-signin" method="post" action="staff?pass=true">
					<input
						type="password" name="password1" id="password1" class="form-control"
						placeholder="Enter New Password" required autofocus>
						<br/>
						<input
						type="password" name="password2" id="password2" class="form-control"
						placeholder="Confirm New Password" required autofocus>
					<br/>
					<button class="btn btn-lg btn-success btn-block" type="submit">Update Password</button>
				</form>
		    </div>
		</div>
	
	</div>

	<div class="col col-md-4"></div>
</div>



<%@ include file="stafffooter.jsp"%>