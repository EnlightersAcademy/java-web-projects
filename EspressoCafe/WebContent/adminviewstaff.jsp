<%@ include file="adminheader.jsp"%>

<div class="row" style="margin-top: 20px;">

	<h3 class="mt-4" style="margin-bottom: 30px;">
		<i class="fas fa-user-tie"></i>
		All Staffs
	</h3>
	<br/><br/>
			
	<table class="table table-hover">
	  <thead class="thead-dark">
	    <tr>
	      <th scope="col">Staff ID</th>
	      <th scope="col">Name</th>
	      <th scope="col">Email</th>
	      <th scope="col">Phone</th>
	      <th scope="col">Status</th>
	      <th scope="col"></th>
	    </tr>
	  </thead>
	  <tbody>
	    <%
	    	for(int i=1; i<5; i++)
	    	{
	    		boolean isDisabled = false;
	    %>
		    <tr>
		      <th><%=i %></th>
		      <th><%="Raj" %></th>
		      <td><%="Abc@gmail.com" %></td>
		      <td><%="9005590055" %></td>
		      <td><%="Active" %></td>
		      <td>
		      	<% if(isDisabled){ %>
		      		<a class="btn btn-outline-success" href="#" role="button"><i class="fas fa-user-check"></i> Enable </a>
		      	<% }else{ %>
		      		<a class="btn btn-outline-danger" href="#" role="button"><i class="fas fa-user-slash"></i> Disable </a>
	      		<%} %>
		      	<span style="padding-right: 20px;">&nbsp;</span>
		      	<a class="btn btn-outline-warning" href="admineditstaff.jsp?id=<%=i %>" role="button"><i class="fas fa-edit"></i> Update Details</a>
		      </td>
		    </tr>
	    <%
	    	}
	    %>
	    
	  </tbody>
	</table>

</div>



<%@ include file="adminfooter.jsp"%>