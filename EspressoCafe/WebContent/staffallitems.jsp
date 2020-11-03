<%@ include file="staffheader.jsp"%>

<div class="row" style="margin-top: 20px;">

	<h3 class="mt-4" style="margin-bottom: 30px;">
		<i class="fas fa-coffee"></i>
		All Available Items
	</h3>
	<br/><br/>
			
	<table class="table table-hover">
	  <thead class="thead-dark">
	    <tr>
	      <th scope="col">Category</th>
	      <th scope="col">Item Name</th>
	      <th scope="col">Description</th>
	      <th scope="col">Price</th>
	    </tr>
	  </thead>
	  <tbody>
	    <%
	    	for(int i=1; i<5; i++)
	    	{
	    %>
		    <tr>
		      <td><%="Hot Coffee" %></td>
		      <td><%="Cappuccino" %></td>
		      <td><%="Hot standard coffee." %></td>
		      <td>&#x20B9; <%=120 %></td>
		    </tr>
	    <%
	    	}
	    %>
	    
	  </tbody>
	</table>

</div>



<%@ include file="stafffooter.jsp"%>