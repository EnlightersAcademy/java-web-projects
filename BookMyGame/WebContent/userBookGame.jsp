<%@page import="com.bookmygame.pojo.Sport"%>
<%@page import="com.bookmygame.pojo.SportCenter"%>
<%@page import="java.util.List"%>
<%@page import="com.bookmygame.pojo.Location"%>
<%@page import="com.bookmygame.services.impl.CommonServicesImpl"%>
<%@page import="com.bookmygame.services.CommonServices"%>
<jsp:include page="userHeader.jsp" />

<!-- PAGE CONTENT-->
<div class="page-content--bgf7" style="height: 100%">

	<br />
	<%
        	String bookDone= request.getParameter("gameBook");
        	if(bookDone != null) {
        		if(bookDone.equals("success")){
        			out.println("<script>alert('Game booked successfully!')</script>");

        		} else {
        			out.println("<script>alert('Failed to book the game. Please try again')</script>");

        		}
        	}
        	if(request.getParameter("invalidLocation") != null) {
        		out.println("<script>alert('Please select a valid Location and try again')</script>");
        	}
        	CommonServices services = new CommonServicesImpl();
        	List<Location> locations = services.getAllLocations();
        	
        	String selectedLocationId = request.getParameter("selectedLocation");
        	List<SportCenter> centers = (List<SportCenter>)request.getAttribute("sportCenters");
        	%>
	<div class="jumbotron"
		style="width: 90%; margin: auto; text-align: center;">
		<form class="form-inline" action="customer-booking-centers"
			method="get" style="margin: auto;">
			<div class="col-md-8">
				Select Location: &nbsp;&nbsp;
				<!-- POLPULATE All LOCATIONS HERE -->
				<select class="custom-select" name="searchmemberid"
					style="min-width: 250px;">
					<% if(selectedLocationId == null) { %>
					<option value="null" selected>Select</option>
					<%} %>
					<%
						  	if(locations != null) {
						  		for(Location location : locations) {
						  			if(selectedLocationId != null && location.getLocationId() == Integer.parseInt(selectedLocationId)) {
						  				request.setAttribute("locationName", location.getLocationName());
						  				%>
					<option selected value=<%=location.getLocationId()%>><%= location.getLocationName()%></option>
					<%
						  			} else {
						  			%>
					<option value=<%=location.getLocationId()%>><%= location.getLocationName()%></option>
					<%
						  			}
						  		}
						  	}
						  %>

				</select>
			</div>
			<div class="col-auto">
				<button type="submit" class="btn btn-primary mb-2">Search
					Sports Centers</button>
			</div>
		</form>
	</div>
	<br />
	<hr />
	<br />

	<!-- BELOW SECTION SHOULD BE VISIBLE ONLY AFTER SEARCH! -->

	<div style="width: 90%; margin: auto; text-align: center;">
		<div class="form-group row">
			<label class="col-sm-2 col-form-label" style="font-weight: bold;">LOCATION:
			</label>
			<div class="col-sm-10">
				<!-- Populate the Selected Location HERE -->
				<input type="text" readonly class="form-control-plaintext"
					name="selectedLocation"
					value="<%= request.getAttribute("locationName") %>">
			</div>
		</div>
	</div>

	<!-- DATA TABLE-->
	<div class="table-responsive m-b-40" style="width: 90%; margin: auto;">
		<table class="table table-borderless table-data3">
			<thead>
				<tr>
					<th>Sports Center Name</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Address</th>
					<th>2-Wheeler Parking</th>
					<th>4-Wheeler Parking</th>
					<th>Games Offered</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<%
                    	if(centers != null) {
                    		for(SportCenter center: centers) {
                    		StringBuilder builder = new StringBuilder();
                    		for(Sport sport : center.getSports()) {
                    			if(sport.getName() != null && !"null".equals(sport.getName())) {
                    			builder.append(sport.getName()).append(", ");
                    			}
                    		}
                    %>
				<tr>
					<td><%=center.getName() %></td>
					<td><%=center.getPhoneNo() %></td>
					<td><%=center.getSportCenterEmailId() %></td>
					<td><%=center.getAddress() %></td>
					<td><%="on".equalsIgnoreCase(center.getTwoWheelerparkingAvailability()) ? "Yes" : "No"%></td>
					<td><%="on".equalsIgnoreCase(center.getFourWheelerParkingAvailability()) ? "Yes" : "No" %></td>
					<td><%=builder.toString() %></td>
					<td><a
						href="userBookGame1.jsp?centerId=<%=center.getSportCenterId() %>"
						class="btn btn-success mb-2">SELECT</a> <!-- Populate the sportsCenterId in HREF-->
					</td>
				</tr>

				<%}} %>
			</tbody>
		</table>
	</div>
	<!-- END DATA TABLE-->

	<br />
	<br />
</div>