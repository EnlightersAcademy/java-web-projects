<%@page import="com.bookmygame.pojo.Customer"%>
<%@page import="com.bookmygame.pojo.GameBooking"%>
<%@page import="com.bookmygame.services.AdminServices"%>
<%@page import="com.bookmygame.services.impl.AdminServicesImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.bookmygame.pojo.SportCenter"%>
<jsp:include page="adminHeader.jsp" />

<!-- PAGE CONTENT-->
<div class="page-content--bgf7" style="height: 100%">

	<br />
	<%
        		List<GameBooking> bookings = null;
        		if(request.getAttribute("customerBookings") != null) {
        			bookings = (List<GameBooking>)request.getAttribute("customerBookings");
        		} 
        		AdminServices services = new AdminServicesImpl();
        		List<Customer> customers = services.getAllCustomerDetails();
        		
        	%>

	<div class="jumbotron"
		style="width: 80%; margin: auto; text-align: center;">
		<form class="form-inline" action="admin/booking?byCustomer=true" method="get" "margin: auto;">
			<div class="col-md-8">
				Select Member ID: &nbsp;&nbsp; <select class="custom-select"
					name="searchmemberid" style="width: 200px;">
					<%
				      		int selectedCustomer = -1;
				      		if(bookings != null) {
				      			selectedCustomer = (Integer)request.getAttribute("selectedMemberId");
				      		}
				      		if(selectedCustomer < 0) {
				      			
				     %>

					<option value="null" selected>Select</option>
					<%
				      		}
						  	for(Customer customer : customers) {
						  		
						  	if(customer.getId() == selectedCustomer) {
						  		
					%>
					<option value=<%=selectedCustomer %> selected><%= selectedCustomer %>
						(
						<%=customer.getName() %>)
					</option>
					<% 
						  		continue;
						  	}
				    %>
					<option value=<%=customer.getId() %>><%=customer.getId() %>
						(<%=customer.getName() %>)
					</option>
					<%		
						  	}
					%>
				</select>
			</div>
			<div class="col-auto">
				<button type="submit" class="btn btn-primary mb-2">Search
					Member</button>
			</div>
		</form>
	</div>
	<br />
	<hr />
	<br />

	<!-- BELOW SECTION SHOULD BE VISIBLE ONLY AFTER SEARCH! -->
	<% if(bookings != null) { %>
	<div style="width: 80%; margin: auto; text-align: center;">
		<div class="form-group row">
			<label class="col-sm-2 col-form-label" style="font-weight: bold;">Member
				ID: </label>
			<div class="col-sm-10">
				<input type="text" readonly class="form-control-plaintext"
					name="memberid" value="<%=selectedCustomer %>">
			</div>
		</div>
	</div>

	<!-- DATA TABLE-->
	<div class="table-responsive m-b-40" style="width: 80%; margin: auto;">
		<table class="table table-borderless table-data3">
			<thead>
				<tr>
					<th>Booking ID</th>
					<th>Center Name</th>
					<th>Center Location</th>
					<th>Customer Name</th>
					<th>Date Of Booking</th>
					<th>Time Slot</th>
					<th>Court Or Board Name</th>
				</tr>
			</thead>
			<tbody>
				<%
				for(GameBooking booking: bookings) {
			%>
				<tr>
					<td><%=booking.getBookingId() %></td>
					<td><%=booking.getSportCenter().getName() %></td>
					<td><%=booking.getSportCenter().getLocation().getLocationName() %></td>
					<td><%=booking.getCustomer().getName() %></td>
					<td><%=booking.getDateOfBooking().toString()%></td>
					<td><%=booking.getTimeSlot()%></td>
					<td><%=booking.getCourtOrBoardName()%></td>
				</tr>
				<% } %>
			</tbody>
		</table>
	</div>
	<% } %>
	<!-- END DATA TABLE-->

	<br />
	<br />
</div>