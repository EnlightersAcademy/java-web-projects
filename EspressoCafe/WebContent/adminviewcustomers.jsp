<%@page import="java.util.List"%>
<%@page import="com.espresso.dto.Customer"%>
<%@page import="com.espresso.common.DbUtil"%>
<%@page import="java.util.Date"%>

<%@ include file="adminheader.jsp"%>



<%
List<Customer> customers = DbUtil.getAllCustomers();
%>
<link href="assets/datatable/datatable.bootstrap.css" rel="stylesheet" />

<div class="row" style="margin-top: 20px;">

	<h3 class="mt-4" style="margin-bottom: 30px;">
		<i class="fas fa-users"></i>
		Registered Customers
	</h3>
	<br/><br/>
	
	<div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead class="thead-dark">
                    <tr>
						<th scope="col">Customer Name</th>
						<th scope="col">Customer Email</th>
						<th scope="col">Customer Phone</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    	for(Customer cus: customers) {
				    	
				    %>
					    <tr>
					      <th><%=cus.getName() %></th>
					      <td><%=cus.getEmailId() %></td>
					      <td><%=cus.getPhoneNo() %></td>
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

