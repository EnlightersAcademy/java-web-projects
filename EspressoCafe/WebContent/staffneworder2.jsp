<%@ include file="staffheader.jsp"%>


<%
	boolean customerExists = false;
%>

<div class="row" style="margin-top: 50px;">
	<div class="col col-md-2"></div>


<%
	if(customerExists)
	{
%>

	<div class="col col-md-8">
	
		<div class="card shadow-lg border-0 rounded-lg mt-5">
		    <div class="card-header">
		    	<h3 class="text-center font-weight-light my-4">
		    		<i class="fas fa-user-check"></i>
					Existing Customer
		    	</h3>
		   	</div>
		    <div class="card-body">
		        <form method="post" action="staffneworder3.jsp">
		             <div class="form-row">
		                 <div class="col-md-6">
		                     <div class="form-group">
		                         <label class="small mb-1" for="customername">Customer Name</label>
		                         <input class="form-control py-4" id="customername" type="text" placeholder="Enter Customer Name" />
		                     </div>
		                 </div>
		                 <div class="col-md-6">
		                     <div class="form-group">
		                         <label class="small mb-1" for="mobile">Mobile Number</label>
		                         <input class="form-control py-4" id="mobile" type="text" pattern="[0-9]{10}" placeholder="Enter Mobile Number" />
		                     </div>
		                 </div>
		             </div>
		             <div class="form-group">
		                 <label class="small mb-1" for="email">Email</label>
		                 <input class="form-control py-4" id="email" type="email" placeholder="Enter E-Mail Address" readonly />
		             </div>
		             
		             <div class="form-group mt-4 mb-0">
		             	<input type="submit" class="btn btn-success btn-block" value="Proceed For Order">
		             </div>
		         </form>
		    </div>
		</div>
		
	</div>

<%
	}
	else
	{
%>

	<div class="col col-md-8">
		<div class="card shadow-lg border-0 rounded-lg mt-5">
		    <div class="card-header">
		    	<h3 class="text-center font-weight-light my-4">
		    		<i class="fas fa-user-plus"></i>
					New Customer
		    	</h3>
		   	</div>
		    <div class="card-body">
		        <form>
		             <div class="form-row">
		                 <div class="col-md-6">
		                     <div class="form-group">
		                         <label class="small mb-1" for="customername">Customer Name</label>
		                         <input class="form-control py-4" id="customername" type="text" placeholder="Enter Customer Name" />
		                     </div>
		                 </div>
		                 <div class="col-md-6">
		                     <div class="form-group">
		                         <label class="small mb-1" for="mobile">Mobile Number</label>
		                         <input class="form-control py-4" id="mobile" type="text" pattern="[0-9]{10}" placeholder="Enter Mobile Number" />
		                     </div>
		                 </div>
		             </div>
		             <div class="form-group">
		                 <label class="small mb-1" for="email">Email</label>
		                 <input class="form-control py-4" id="email" type="email" placeholder="Enter E-Mail Address" />
		             </div>
		             
		             <div class="form-group mt-4 mb-0">
		             	<input type="submit" class="btn btn-success btn-block" value="Add New Customer">
		             </div>
		         </form>
		    </div>
		</div>
	
	</div>
	
<%
	}
%>

	<div class="col col-md-2"></div>
</div>



<%@ include file="stafffooter.jsp"%>