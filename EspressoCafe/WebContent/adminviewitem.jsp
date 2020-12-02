<%@page import="java.util.List"%>
<%@page import="com.espresso.dto.Item"%>
<%@page import="com.espresso.db.util.DbUtil"%>
<%@ include file="adminheader.jsp"%>
<%@page import="java.util.Base64"%>
<%@page import="com.espresso.util.EspressoUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	if(EspressoUtil.isResponseSuccess(request) != -1) {
		int status = EspressoUtil.isResponseSuccess(request);
		if( status == 0) {
			%>
<script>
			alert("Successfully updated item status")
			</script>
<%
		} else if (status == 1){
			%>
<script>
			alert("Failed to update item status. Please retry again")
			</script>
<%
		}  
	}

%>


<%
	List<Item> items = DbUtil.getAllItems();
%>
<div class="row" style="margin-top: 20px;">

	<h3 class="mt-4" style="margin-bottom: 30px;">
		<i class="fas fa-mug-hot"></i> All Items
	</h3>
	<br /> <br />

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
			<form action="items" method="get">
			<tr>
				<%
				String base64Image = Base64.getEncoder().encodeToString(item.getPhoto());
				%>
				<td><img style="width: 200px;" alt=""
					src="data:image/jpg;base64,<%=base64Image %>"></td>
				<td><%=item.getItemName() %></td>
				<td><%=item.getCategory().getCategoryName() %></td>
				<td><%=item.getDescription() %></td>
				<td>&#x20B9; <%=item.getPrice() %></td>
				<td><%=(isAvailable)?"Available":"Not Available" %></td>
				<td>
				<input hidden="true" name="status" value=<%=isAvailable%>>
				<input hidden="true" name="id" value=<%=item.getItemId()%>>
					<% if(isAvailable){ 
		      	
		      	%> <input type="submit" class="btn btn-success btn-block"
							value="Mark Unavailable" />  <% }else{ %> <input type="submit" class="btn btn-success btn-block"
							value="Mark Available" /> <%} %>
				</td>
				
			</tr>
		</form>
			<%
	    	}
	    %>

		</tbody>
	</table>

</div>



<%@ include file="adminfooter.jsp"%>