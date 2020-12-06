<%@page import="com.espresso.dto.Staff"%>
<%@page import="java.util.List"%>
<%@page import="com.espresso.dto.CafeOrder"%>
<%@page import="java.util.Date"%>
<%@ include file="staffheader.jsp"%>
<%@page import="com.espresso.db.util.*" %>
<%@page import="com.espresso.util.*" %>
<%
	if (!EspressoUtil.isValidSession(request)) {
	response.sendRedirect("index.jsp?exp=true");
}
%>
<%
	if(EspressoUtil.isResponseSuccess(request) != -1) {
		int status = EspressoUtil.isResponseSuccess(request);
		if( status == 0) {
			%>
			<script>
			alert("Payment completed successfully")
			</script>
			<%
		} else if (status == 1){
			%>
			<script>
			alert("Payment failed")
			</script>
			<%
		}
	}

%>
<%
	Staff staffOrderPage = (Staff)request.getSession().getAttribute("staff");
	List<CafeOrder> orders = DbUtil.getAllOrdersByStaffId(staffOrderPage.getStaffId());
%>

<div class="row" style="margin-top: 20px;">

	<h3 class="mt-4" style="margin-bottom: 30px;">
		<i class="fas fa-list"></i>
		Orders Handled By Me
	</h3>
	<br/><br/>
			
	<table class="table table-hover">
	  <thead class="thead-dark">
	    <tr>
	      <th scope="col">Order ID</th>
	      <th scope="col">Customer Email</th>
	      <th scope="col">Date of Order</th>
	      <th scope="col">Total Amount</th>
	      <th scope="col">Status</th>
	    </tr>
	  </thead>
	  <tbody>
	    <%
	    	for(CafeOrder order: orders)
	    	    	{
	    %>
		    <tr>
		      <th><%=order.getId()%></th>
		      <td><%=order.getCustomerEmailId() %></td>
		      <td><%=order.getDateOfOrder() %></td>
		      <td>&#x20B9; <%=order.getTotalAmount()%></td>
		      <td><%=order.getStatus() == 2? "Ongoing": "Completed" %></td>
		    </tr>
	    <%
	    	}
	    %>
	    
	  </tbody>
	</table>

</div>



<%@ include file="stafffooter.jsp"%>