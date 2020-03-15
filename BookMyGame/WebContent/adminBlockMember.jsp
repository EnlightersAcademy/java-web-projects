<%@page import="java.util.List"%>
<%@page import="com.bookmygame.pojo.Customer"%>
<%@page import="com.bookmygame.services.AdminServices"%>
<%@page import="com.bookmygame.services.impl.AdminServicesImpl"%>
<jsp:include page="adminHeader.jsp" />

<!-- PAGE CONTENT-->
<div class="page-content--bgf7" style="height: 100%">
	<%
				String result = request.getParameter("request");
				if(request != null) {
					if("fail".equals(result)) {
						out.println("<script>alert('Attempt to block the customer failed. Please try again')</script>");
					} else {
						out.println("<script>alert('Customer blocked successfully!')</script>");
					}
				}
            	AdminServices services = new AdminServicesImpl();
            	List<Customer> activeCustomers = services.getAllCustomerDetails();
            %>
	<br />
	<br />

	<!-- DATA TABLE-->
	<div class="table-responsive m-b-40" style="width: 80%; margin: auto;">
		<table class="table table-borderless table-striped table-earning ">
			<thead>
				<tr>
					<th>Customer Id</th>
					<th>Name</th>
					<th>Gender</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Identification detail</th>
				</tr>
			</thead>
			<tbody>
				<%
                    	for(Customer customer : activeCustomers) {
                    %>
				<tr>
					<td><%=customer.getId() %></td>
					<td><%=customer.getName() %></td>
					<td><%=customer.getSex() %></td>
					<td><%=customer.getEmailId() %></td>
					<td><%=customer.getPhoneNo() %></td>
					<td><%=customer.getIdentificationId() %></td>
					<td>
						<!-- Populate the Member ID into this field --> <a
						class="btn btn-danger btn-sm"
						href="admin/customer?id=<%= customer.getId() %>&blockCustomer=true"> <i
							class="fa fa-ban"></i> Block
					</a>
					</td>
				</tr>

			</tbody>
			<%} %>
		</table>
	</div>
	<!-- END DATA TABLE-->

	<br />
	<br />
</div>
