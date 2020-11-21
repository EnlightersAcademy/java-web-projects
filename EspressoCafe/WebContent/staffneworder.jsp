<%@ include file="staffheader.jsp"%>

<div class="row" style="margin-top: 50px;">
	<div class="col col-md-4"></div>

	<div class="col col-md-4">
	
		<div class="card shadow-lg border-0 rounded-lg mt-5">
		    <div class="card-header">
		    	<h3 class="text-center font-weight-light my-4">
		    		<i class="fas fa-mug-hot"></i>
					Place New Order
		    	</h3>
		   	</div>
		    <div class="card-body">
		        <form class="form-signin" method="post" action="staffneworder2.jsp">
					<input
						type="email" name="customeremail" id="customeremail" class="form-control"
						placeholder="Customer E-Mail Address" required autofocus>
					<br/>
					<button class="btn btn-lg btn-success btn-block" type="submit">SEARCH</button>
				</form>
		    </div>
		</div>
	
	</div>

	<div class="col col-md-4"></div>
</div>



<%@ include file="stafffooter.jsp"%>