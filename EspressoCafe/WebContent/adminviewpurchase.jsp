<%@ include file="adminheader.jsp"%>

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
	    	for(int i=1; i<5; i++)
	    	{
	    %>
		    <tr>
		      <td><%="Coffee Beans" %></td>
		      <td><%="Robusta Coffee beans from Coorg." %></td>
		      <td><%="30-Oct-2020" %></td>
		      <td><%="30kgs" %></td>
		      <td><%=1800.0 %></td>
		    </tr>
	    <%
	    	}
	    %>
	    
	  </tbody>
	</table>

</div>



<%@ include file="adminfooter.jsp"%>