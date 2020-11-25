<%@page import="java.util.List"%>
<%@page import="com.espresso.dto.Staff"%>
<%@page import="com.espresso.db.util.DbUtil"%>
<%@ include file="adminheader.jsp"%>
<%@page import="com.espresso.util.EspressoUtil"%>

<%
	if(EspressoUtil.isResponseSuccess(request) != -1) {
		int status = EspressoUtil.isResponseSuccess(request);
		if( status == 0) {
			%>
			<script>
			alert("Successfully updated Staff status")
			</script>
			<%
		} else if (status == 1){
			%>
			<script>
			alert("Failed to update Staff status. Please retry again")
			</script>
			<%
		}  
	}

%>
<%
	List<Staff> staffs = DbUtil.getAllStaffs();
%>
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
	      <th scope="col">Address</th>
	      <th scope="col">Status</th>
	      <th scope="col"></th>
	    </tr>
	  </thead>
	  <tbody>
	    <%
	    	for(Staff staff: staffs)
	    	{
	    		boolean isActive = staff.isActive();
	    %>
	    <form action="staff" method="get">
		    <tr>
		      <th><%=staff.getStaffId() %></th>
		      <th><%=staff.getName() %></th>
		      <td><%=staff.getEmailId() %></td>
		      <td><%=staff.getPhoneNo() %></td>
		      <td><%=staff.getAddress() %></td>
		      <td><%= staff.isActive()? "Active" : "Blocked" %>
		      <td>
		      <input hidden="true" name="status" value=<%=isActive%>>
				<input hidden="true" name="id" value=<%=staff.getStaffId()%>>
		      	<% if(!isActive){ %>
		      		<input type="submit" class="btn btn-success btn-block"
							value="Activate Staff" />
		      	<% }else{ %>
		      		<input type="submit" class="btn btn-success btn-block"
							value="Deactivate Staff" />
	      		<%} %>
		      	<span style="padding-right: 20px;">&nbsp;</span>
		      	<a class="btn btn-outline-warning" href="admineditstaff.jsp?emailId=<%=staff.getEmailId() %>" role="button"><i class="fas fa-edit"></i> Update Details</a>
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