<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="com.bookmygame.pojo.Sport"%>
<%@page
	import="com.bookmygame.services.impl.SportCenterOwnerServicesImpl"%>
<%@page import="com.bookmygame.services.SportCenterOwnerServices"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.bookmygame.pojo.GameBooking"%>
<%@page import="com.bookmygame.pojo.SportCenter"%>
<%@page import="com.bookmygame.services.impl.AdminServicesImpl"%>
<%@page import="com.bookmygame.services.AdminServices"%>
<jsp:include page="userHeader.jsp" />

<%
	int selectedCenterId = Integer.parseInt(request.getParameter("centerId"));
	String selectedGame = request.getParameter("selectedGame");
	String date = request.getParameter("gameDate");
	SportCenterOwnerServices services = new SportCenterOwnerServicesImpl();
	int customerId = (Integer)request.getSession().getAttribute("customerId");
	List<GameBooking> bookings = services.getAllBookings(selectedCenterId, selectedGame, date);
	SportCenter center = services.getSportCenterById(selectedCenterId);

	List<String> timings = Arrays.asList("5:00AM", "6:00AM", "7:00AM", "8:00AM", "9:00AM", "10:00AM", "11:00AM",
			"12:00PM", "1:00PM", "2:00PM", "3:00PM", "4:00PM", "5:00PM", "6:00PM", "7:00PM", "8:00PM", "9:00PM",
			"10:00PM");
%>

<!-- PAGE CONTENT-->
<div class="page-content--bgf7" style="height: 100%">

	<br />

	<div class="jumbotron" style="width: 50%; margin: auto;">
		<h2 class="display-5">Book Game</h2>
		<br />
	</div>
	<div class="form-group mb-2">
		<label>Sports Center Name</label> <input type="text" name="centerName"
			class="au-input au-input--full" readonly
			value="<%=center.getName()%>">
	</div>
	<div class="form-group mb-2">
		<label>Game</label> <input type="text" name="selectedGame"
			class="au-input au-input--full" readonly value="<%=selectedGame%>">
	</div>

	<div>
		class="form-group mb-2"> <label>Date</label> <input type="text"
			name="selectedDate" class="au-input au-input--full" readonly
			value="<%=date%>">
	</div>

	<div class="table-responsive m-b-40" style="width: 90%; margin: auto;">
		<table class="table table-borderless table-data3">
			<thead>
				<tr>
					<th></th>
					<th>Court/Table Name</th>
					<th>Available Timings</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<%
			Set<Sport> availableSports = center.getSports();
			Sport sport = availableSports.stream().filter(sp -> sp.getName().equalsIgnoreCase(selectedGame)).findAny().get();
			for(String courtName: sport.getCourtOrBoardNames())  {
				List<String> avaiableTimings = new ArrayList<String>(timings);
				for(GameBooking booking: bookings) {
					if(courtName.equals(booking.getCourtOrBoardName())) {
						avaiableTimings.remove(booking.getTimeSlot());
					}
				}
			%>
				<form action="customer/game/booking" method="post">

					<div class="form-group">
						<label>Court/Board/Lane</label> <input type="text"
							name="selectedCourt" class="au-input au-input--full" readonly
							value="<%=courtName%>">
					</div>
					<input type="text" value=<%= selectedCenterId%> name="centerId" hidden="true">
					<input type="text" value=<%= selectedGame%> name="gameName" hidden="true">
					<input type="text" value=<%= date%> name="date" hidden="true">
					<input type="text" value=<%= customerId%> name="customerId" hidden="true">
					<div class="form-group">
						<label>Select Time</label> <select
							class="form-control au-input au-input--full" name="gameTime">
							<%for(String slot: avaiableTimings)  {%>
							<option value=<%=slot %>><%=slot %></option>
							<%} %>
						</select>
					</div>

					<br />
					<button type="submit"
						class="au-btn au-btn--block au-btn--green m-b-20">Book
						Game</button>
				</form>
				<%} %>
			</tbody>
		</table>
	</div>

</div>

<br />
<br />
</div>