<%@ include file="staffheader.jsp"%>

<div class="row" style="margin-top: 50px;">
	<div class="col col-md-4"></div>

	<div class="col col-md-4">
		<form class="form-signin" method="post" action="staffneworder2.jsp">
			<h3 class="mt-4" style="padding-bottom: 15px;">
				<i class="fas fa-mug-hot"></i>
				Place New Order
			</h3>

			<input
				type="email" id="customeremail" class="form-control"
				placeholder="Customer E-Mail Address" required autofocus>
			<br/>
			<button class="btn btn-lg btn-success btn-block" type="submit">SEARCH</button>
		</form>
	</div>

	<div class="col col-md-4"></div>
</div>



<%@ include file="stafffooter.jsp"%>