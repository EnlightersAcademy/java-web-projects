<%@page import="java.util.List"%>
<%@page import="com.bookmygame.services.AdminServices"%>
<%@page import="com.bookmygame.services.impl.AdminServicesImpl"%>
<%@page import="com.bookmygame.pojo.Customer"%>
<jsp:include page="adminHeader.jsp" />

<!-- PAGE CONTENT-->
<div class="page-content--bgf7" style="height: 100%">

	<br /> <br />

	<!-- DATA TABLE-->
	<div class="table-responsive m-b-40" style="width: 80%; margin: auto;">
		<table class="table table-borderless table-data3">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Gender</th>

					<th>Email</th>
					<th>Phone</th>
					<th>Status</th>
				</tr>
			</thead>
			<%
			AdminServices services = new AdminServicesImpl();
			List<Customer> customers = services.getAllCustomerDetails();
			for(Customer c: customers) {
		%>
			<tbody>
				<tr data-toggle="collapse" data-target="#<%=c.getId() %>"
					class="clickable">
					<td><%= c.getId()%></td>
					<td><%= c.getName()%></td>
					<td><%= c.getSex()%></td>


					<td><%= c.getEmailId()%></td>
					<td><%= c.getPhoneNo()%></td>
					<%if(c.getIsActive() == 0) { %>
					<!-- Use class="denied" for making it GREEN -->
					<td class="denied">Disabled</td>
					<% } else {%>
					<td class="process">Active</td>
					<% } %>
					<td>
						<button class="btn btn-default btn-sm">
							<i class="fa fa-arrow-down"></i> More Details
						</button>
					</td>
				</tr>
				<tr>
					<td colspan="6">
						<div id="<%=c.getId() %>" class="collapse">
							<table class="table">

								<tr>
									<th>Identification Id</th>
									<th>Address</th>
									<th>Location</th>
	
								</tr>
								<tr>
									<td><%=c.getIdentificationId()%></td>
									<td><%=c.getAddress()%></td>
									<td><%=c.getLocation() %></td>
								</tr>
							</table>
						</div>
					</td>
				</tr>
			</tbody>
			<%} %>
		</table>
	</div>
	<!-- END DATA TABLE-->

	<br /> <br />
</div>