<%@page import="com.espresso.dto.Item"%>
<%@page import="com.espresso.db.util.DbUtil"%>

<%@page import="java.util.List"%>
<%@ include file="staffheader.jsp"%>

<%
	List<Item> items = DbUtil.getAllItems();
%>
<%@page import="com.espresso.util.*" %>
<%
if (!EspressoUtil.isValidSession(request)) {
	response.sendRedirect("index.jsp?exp=true");
}
%>
<div class="row" style="margin-top: 20px;">

	<div class="row col-md-12" style="margin-bottom: 30px;">
		<h3 class="mt-4" >
			<i class="fas fa-cart-arrow-down"></i>
			Order Payment
		</h3>
	</div>
	
	<div class="row col-md-12" style="margin-bottom: 30px;">
		<div class="card text-white w-50" style="background-color: #a9cce3;">
		  <div class="card-body text-white">
		    <table class="table border" style="margin-bottom:0;">
		    	<tr>
		    		<td>Customer Name : </td>
		    		<th><%= "Name of the Customer" %></th>
		    		<td>&nbsp;</td>
		    		<td>Customer Email : </td>
		    		<th><%= "Email of the Customer" %></th>
		    	</tr>
		    </table>
		  </div>
		</div>
	</div>
	
	<div class="row col-md-12">		
		<table class="table table-hover">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col"></th>
		      <th scope="col">Item Name</th>
		      <th scope="col">Price</th>
		      <th scope="col">Quantity</th>
		      <th scope="col">Amount</th>
		    </tr>
		  </thead>
		  <tbody>
		    <%
		    	for(int i=0; i<3; i++)
		    	{
		    %>
			    <tr>
			      <td><img style="width: 200px;" alt="" src="" > </td>
			      <td><%=i %></td>
			      <td><%="itemPrice" %></td>
			      <td><%="itemQuantity" %></td>
			      <td><%="price x quanitity"%></td>
			    </tr>
		    <%
		    	}
		    %>
		  </tbody>
		  <tfoot class="table-secondary">
		  	<tr>
		  		<th colspan="4">Total Amount </th>
		  		<th><%="Total Amount" %></th>
		  	</tr>
		  </tfoot>		  
		</table>
	</div>
	
	<div class="row col-md-12">
		<div class="col-md-12 text-right">
			<form action="" method="post">
				<button type="button" class="btn btn-success btn-lg">
		        				<i class="fa fa-paper-plane" style="margin-right: 10px;"></i>
							  Make Payment & Complete Order
							</button>
			</form>
		</div>
	</div>

</div>



<%@ include file="stafffooter.jsp"%>