<%@page import="org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.DateFormatSymbols"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.espresso.dto.PurchaseItem"%>
<%@page import="com.espresso.db.util.DbUtil"%>
<%@page import="java.util.List"%>

<%@ include file="adminheader.jsp"%>


<div class="row" style="margin-top: 20px;">
	<h3 class="text-center font-weight-light my-4">
   		<i class="fas fa-chart-line"></i>
		Profit/Loss Analysis 
   	</h3>
</div>

<%

	boolean isSearchDone = true; 

	//Get the current year and last 5 years.
	//int currentYear = Calendar.getInstance().get(Calendar.YEAR);
	//String[] years = new String[]{ String.valueOf(currentYear),String.valueOf(currentYear-1),String.valueOf(currentYear-2),String.valueOf(currentYear-3),String.valueOf(currentYear-4) };
	
	//Get all the months of an year.
	//String[] months = new DateFormatSymbols().getMonths();
%>

<!-- <div class="row"> -->
	    	
<!-- 	<div class="col col-md-4"></div> -->

<!-- 	<div class="col col-md-4"> -->
	
<!-- 		<div class="card shadow-lg border-0 rounded-lg mt-5"> -->
<!-- 		    <div class="card-body"> -->
<!-- 		        <form class="form-signin" method="post" action=""> -->
		        		
<!-- 		        		<div class="form-row"> -->
<!-- 	                        <div class="col-md-6"> -->
<!-- 	                            <div class="form-group"> -->
<!-- 	                                <label class="small mb-1" for="year">Year</label> -->
<!-- 	                                <select class="form-control" name="year" id="year" required> -->
<%-- 	                                	<% --%>
<!-- // 	                                		for(int i=0; i<years.length; i++) -->
<!-- // 	                                		{ -->
<%-- 	                                	%> --%>
<%-- 								        		<option value="<%= years[i] %>"><%= years[i] %></option> --%>
<%-- 						        		<% 	} %>	 --%>
								        
<!-- 							      	</select>	 -->
<!-- 	                            </div> -->
<!-- 	                        </div> -->
<!-- 	                        <div class="col-md-6"> -->
<!-- 	                            <div class="form-group"> -->
<!-- 	                                <label class="small mb-1" for="month">Month</label> -->
<!-- 	                                <select class="form-control" name="month" id="month" required> -->
<%-- 	                                	<% --%>
<!-- // 	                                		for(int i=0; i<12; i++) -->
<!-- // 	                                		{ -->
<%-- 	                                	%> --%>
<%-- 								        		<option value="<%= months[i] %>"><%= months[i] %></option> --%>
<%-- 						        		<% 	} %>	 --%>
								        
<!-- 							      	</select>	 -->
<!-- 	                            </div> -->
<!-- 	                        </div> -->
<!-- 	                        <div class="col-md-6"> -->
<!-- 	                            <div class="form-group"> -->
<!-- 			                        <div class="custom-control custom-switch" style="margin-left: 10px;"> -->
<!-- 									  <input type="checkbox" class="custom-control-input" name="showyearly" id="showyearly"> -->
<!-- 									  <label class="custom-control-label" for="showyearly">Show Yearly Data</label> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->

<!-- 	                    </div>                         -->
<!-- 					<br/> -->
<!-- 					<button class="btn btn-lg btn-success btn-block" type="submit">Show Data</button> -->
<!-- 				</form> -->
<!-- 		    </div> -->
<!-- 		</div> -->
	
<!-- 	</div> -->

<!-- 	<div class="col col-md-4"></div> -->
<!-- </div> -->


<div class="row" style="margin-top: 80px;">
	    	
	<div class="col col-md-4"></div>
	
	<%
		if(!isSearchDone){
	%>
	
<!-- 	<div class="col col-md-4" style="text-align: center;">
		<h4>No Data Found!</h4>
	</div> -->
	<%
		}
		else{
	%>

	<div class="col col-md-4">
		<div class="card shadow-lg border-0 rounded-lg mt-5">
		    <div class="card-body">
				<table class="table table-bordered" style="margin-top: 20px;">
				  <thead class="thead-dark">
				    <tr>
				      <th scope="col">Total Sales Amount</th>
				      <th scope="col">Total Purchases Amount</th>
				      <th scope="col">Profit/Loss</th>
				    </tr>
				  </thead>
				  <tbody>
				  		<%
				  			double totalSales = DbUtil.getAllCompletedOrders().stream().mapToInt(item -> item.getTotalAmount()).sum();
				  			double totalPurchases = DbUtil.getAllPurchases().stream().mapToInt(item -> item.getTotalCost()).sum();
				  			
				  			double profitLoss = ((totalSales - totalPurchases)/totalSales)*100;
				  			System.out.println(profitLoss);
				  			String val =  new DecimalFormat("#.##").format(profitLoss);
				  			
				  			String cellColor = (profitLoss >=0) ? "#2ECC71":"#E74C3C";
				  		%>
			
					    <tr>
					      <td>&#x20B9; <%=totalSales %></td>
					      <td>&#x20B9; <%=totalPurchases %></td>
					      <td style="font-weight: bold; background-color: <%=cellColor%>;"><%=val %>%</td>
					    </tr>
				  </tbody>
				</table>
					<p style="text-align: right; font-size: small;">If % is positive, then its a Profit. Else a Loss! </p>
			</div>
		</div>
	</div>
	
	<%} %>

	<div class="col col-md-4"></div>
</div>


<%@ include file="adminfooter.jsp"%>

<script>
	$(function() {
	    $('#showyearly').click(function() {
	        var cb1 = $('#showyearly').is(':checked');
	        $('#month').prop('disabled', cb1);   
	    });
	});
</script>