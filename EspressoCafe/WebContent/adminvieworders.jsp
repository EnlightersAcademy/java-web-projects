<%@page import="com.espresso.dto.*"%>
<%@page import="java.util.List"%>
<%@page import="com.espresso.common.DbUtil"%>
<%@page import="java.util.Date"%>

<%@ include file="adminheader.jsp"%>

<link href="assets/datatable/datatable.bootstrap.css" rel="stylesheet" />

<div class="row" style="margin-top: 20px;">

	<h3 class="mt-4" style="margin-bottom: 30px;">
		<i class="fas fa-shopping-cart"></i>
		All Orders
	</h3>
	<br/><br/>
	
	<%
			List<CafeOrder> orders = DbUtil.getAllOrders();
			
		%>
	
	<div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead class="thead-dark">
                    <tr>
						<th scope="col">Order ID</th>
						<th scope="col">Customer Email</th>
						<th scope="col">Date of Order</th>
						<th scope="col">Total Amount</th>
						<th scope="col">Handled By</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    	for(CafeOrder order: orders)
                    		    	{
                    		int staffId = order.getStaffId();
                    		Staff orderStaff = DbUtil.getStaffByStaffId(staffId);
                    		
                    %>
					    <tr>
					      <th><%= order.getId() %></th>
					      <td><%= order.getCustomerEmailId() %></td>
					      <td><%= order.getDateOfOrder() %></td>
					      <td>&#x20B9; <%=order.getTotalAmount() %></td>
					      <td><%=orderStaff.getName() %></td>
					    </tr>
				    <%
				    	}
				    %>
                </tbody>
            </table>
        </div>
    </div>



<%@ include file="adminfooter.jsp"%>

<script src="assets/datatable/jquery.datatable.js" ></script>
<script src="assets/datatable/datatable.bootstrap.js" ></script>
<script src="assets/datatable/datatables-demo.js" ></script>

