<%@page import="java.util.List"%>
<%@page import="com.espresso.dto.CafeOrder"%>
<%@page import="com.espresso.common.DbUtil"%>
<%@ include file="staffheader.jsp"%>

<%
List<CafeOrder> orders = DbUtil.getOngoingOrdersByStaffId(staff.getStaffId());
%>
<div class="row" style="margin-top: 20px;">

	<h3 class="mt-4" style="margin-bottom: 30px;">
		<i class="fas fa-flag"></i>
		Ongoing Orders
	</h3>
	<br/><br/>
			
	<table class="table table-hover">
	  <thead class="thead-dark">
	    <tr>
	      <th scope="col">Order ID</th>
	      <th scope="col">Customer Email</th>
	      <th scope="col">Total Amount</th>
	      <th scope="col"></th>
	    </tr>
	  </thead>
	  <tbody>
	    <%
	    	for(CafeOrder order: orders)
	    	{

	    %>
		    <tr>
		      <th><%=order.getId() %></th>
		      <td><%=order.getCustomerEmailId() %></td>
		      <td>&#x20B9; <%=order.getTotalAmount() %></td>
		      <td class="text-center">
		      	<a class="btn btn-outline-warning" href="itemorder?customerEmail=<%=order.getCustomerEmailId()%>" role="button"><i class="fas fa-edit"></i> Update Order</a>
		      		&nbsp;&nbsp;
		      	<a class="btn btn-outline-success" href="stafforderpayment.jsp?customerEmail=<%=order.getCustomerEmailId() %>" role="button"><i class="fas fa-paper-plane"></i> Complete Order</a>
		      </td>
		    </tr>
	    <%
	    	}
	    %>
	    
	  </tbody>
	</table>

</div>



<%@ include file="stafffooter.jsp"%>
