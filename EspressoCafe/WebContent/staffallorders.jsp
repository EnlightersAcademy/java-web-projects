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
	Staff staff = (Staff)request.getSession().getAttribute("staff");
	List<CafeOrder> orders = DbUtil.getOrdersByStaffId(staff.getStaffId());
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
	    </tr>
	  </thead>
	  <tbody>
	    <%
	    	for(CafeOrder order: orders)
	    	    	{
	    %>
		    <tr>
		      <th><%=order.getId()%></th>
		      <td><%=order.getCustomer().getEmailId() %></td>
		      <td><%=order.getDateOfOrder() %></td>
		      <td>&#x20B9; <%=order.getTotalAmount()%></td>
		    </tr>
	    <%
	    	}
	    %>
	    
	  </tbody>
	</table>

</div>



<%@ include file="stafffooter.jsp"%>