<%@page import="java.util.List"%>
<%@page import="com.espresso.dto.Item"%>
<%@page import="com.espresso.db.util.DbUtil"%>
<%@ include file="adminheader.jsp"%>

<%
	List<Item> items = DbUtil.getAllItems();
%>
<div class="row" style="margin-top: 20px;">

	<h3 class="mt-4" style="margin-bottom: 30px;">
		<i class="fas fa-mug-hot"></i>
		All Items
	</h3>
	<br/><br/>
			
	<table class="table table-hover">
	  <thead class="thead-dark">
	    <tr>
	      <th scope="col"></th>
	      <th scope="col">Item Name</th>
	      <th scope="col">Category</th>
	      <th scope="col">Description</th>
	      <th scope="col">Price</th>
	      <th scope="col">Availability</th>
	      <th scope="col"></th>
	    </tr>
	  </thead>
	  <tbody>
	    <%
	    	for(Item item: items)
	    	{
	    		boolean isAvailable = item.isAvailable();
	    %>
		    <tr>
		      <td><img style="width: 200px;" alt="" src="<%=item.getPhoto() %>" > </td>
		      <td><%=item.getItemName() %></td>
		      <td><%=item.getCategory().getCategoryName() %></td>
		      <td><%=item.getDescription() %></td>
		      <td>&#x20B9; <%=item.getPrice() %></td>
		      <td><%=(isAvailable)?"Available":"Not Available" %></td>
		      <td>
		      	<% if(isAvailable){ %>
		      		<a class="btn btn-outline-danger" href="#" role="button"><i class="fas fa-times-circle"></i> Mark Unavailable </a>
		      	<% }else{ %>
		      		<a class="btn btn-outline-success" href="#" role="button"><i class="fas fa-check-circle"></i> Mark Available </a>
	      		<%} %>
		      </td>
		    </tr>
	    <%
	    	}
	    %>
	    
	  </tbody>
	</table>

</div>



<%@ include file="adminfooter.jsp"%>