<%@ include file="adminheader.jsp"%>
<%@page import="com.espresso.util.EspressoUtil"%>

<%
	if(EspressoUtil.isResponseSuccess(request) != -1) {
		int status = EspressoUtil.isResponseSuccess(request);
		if( status == 0) {
			%>
			<script>
			alert("Successfully added the purchase entry")
			</script>
			<%
		} else if (status == 1){
			%>
			<script>
			alert("Failed to add the purchase entry. Please retry again")
			</script>
			<%
		}
	}

%>
<div class="row" style="margin-top: 20px;">
	<div class="col col-md-4"></div>

	<div class="col col-md-4">
	
		<div class="card shadow-lg border-0 rounded-lg mt-5">
		    <div class="card-header">
		    	<h3 class="text-center font-weight-light my-4">
		    		<i class="fas fa-seedling"></i>
					New Raw Material Purchase
		    	</h3>
		   	</div>
		    <div class="card-body">
		        <form class="form-signin" method="post" action="purchases">

                         <div class="form-group">
                             <label class="small mb-1" for="name">Material Name</label>
                             <input class="form-control" name="name" id="name" type="text" placeholder="Name" required />
                         </div>
                         
                         <div class="form-group">
                             <label class="small mb-1" for="description">Description</label>
                             <input class="form-control" name="description" id="description" type="text" placeholder="Description" required />
                         </div>
                         
                         <div class="form-group">
                             <label class="small mb-1" for="purchasedate">Purchase Date</label>
                             <input class="form-control" name="purchasedate" id="purchasedate" type="date" placeholder="Purchase Date" required />
                         </div>
                         
                         <div class="form-group">
                             <label class="small mb-1" for="quantity">Quantity</label>
                             <input class="form-control" name="quantity" id="quantity" type="text" placeholder="Total Quantity" required />
                         </div>
                         
                         <div class="form-group">
                             <label class="small mb-1" for="price">Total Cost</label>
                             <input class="form-control" name="price" id="price" type="text" placeholder="Cost in &#x20B9;" pattern="[0-9]{1,}" required />
                         </div>
                        
					<br/>
					<button class="btn btn-lg btn-success btn-block" type="submit">Add New Entry</button>
				</form>
		    </div>
		</div>
	
	</div>

	<div class="col col-md-4"></div>
</div>



<%@ include file="adminfooter.jsp"%>