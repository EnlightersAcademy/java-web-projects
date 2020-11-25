<%@page import="java.util.List"%>
<%@page import="com.espresso.dto.PurchaseItem"%>
<%@page import="com.espresso.db.util.DbUtil"%>
<%@ include file="adminheader.jsp"%>
<%
	List<PurchaseItem> purchases = DbUtil.getAllPurchases();
%>
<div class="row" style="margin-top: 20px;">

	<h3 class="mt-4" style="margin-bottom: 30px;">
		<i class="fas fa-shopping-basket"></i>
		All Raw Material Purchases
	</h3>
	<br/><br/>
			
	<table class="table table-hover">
	  <thead class="thead-dark">
	    <tr>
	      <th scope="col">Name</th>
	      <th scope="col">Description</th>
	      <th scope="col">Purchase Date</th>
	      <th scope="col">Quantity</th>
	      <th scope="col">Total Cost</th>
	    </tr>
	  </thead>
	  <tbody>
	    <%
	    	for(PurchaseItem item : purchases)
	    	{
	    %>
		    <tr>
		      <td><%=item.getName() %></td>
		      <td><%=item.getDescription() %></td>
		      <td><%=item.getDate() %></td>
		      <td><%=item.getQuantity()%></td>
		      <td><%=item.getTotalCost()%></td>
		    </tr>
	    <%
	    	}
	    %>
	    
	  </tbody>
	</table>

</div>



<%@ include file="adminfooter.jsp"%>