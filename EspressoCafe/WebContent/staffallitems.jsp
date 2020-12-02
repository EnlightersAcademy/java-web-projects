<%@page import="com.espresso.dto.Item"%>
<%@page import="com.espresso.db.util.DbUtil"%>
<%@page import="java.util.Base64"%>
<%@page import="java.util.List"%>
<%@ include file="staffheader.jsp"%>

<%
	List<Item> items = DbUtil.getAllAvailableItems();
%>
<%@page import="com.espresso.util.*" %>
<%
if (!EspressoUtil.isValidSession(request)) {
	response.sendRedirect("index.jsp?exp=true");
}
%>
<div class="row" style="margin-top: 20px;">

	<h3 class="mt-4" style="margin-bottom: 30px;">
		<i class="fas fa-coffee"></i>
		All Available Items
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
	    </tr>
	  </thead>
	  <tbody>
	    <%
	    	for(Item item: items)
	    	{
	    %>
		    <tr>
		    <%
				String base64Image = Base64.getEncoder().encodeToString(item.getPhoto());
				%>
		      <td><img style="width: 200px;" alt="" src="data:image/jpg;base64,<%=base64Image %>" > </td>
		      <td><%=item.getItemName() %></td>
		      <td><%=item.getCategory().getCategoryName()%></td>
		      <td><%=item.getDescription() %></td>
		      <td>&#x20B9; <%=item.getPrice()%></td>
		    </tr>
	    <%
	    	}
	    %>
	    
	  </tbody>
	</table>

</div>



<%@ include file="stafffooter.jsp"%>