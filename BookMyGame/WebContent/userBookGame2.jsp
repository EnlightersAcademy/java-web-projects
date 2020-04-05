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
	int customerId = (Integer) request.getSession().getAttribute("customerId");
	List<GameBooking> bookings = services.getAllBookings(selectedCenterId, selectedGame, date);
	SportCenter center = services.getSportCenterById(selectedCenterId);
	String courtName = request.getParameter("court");

	List<String> timings = Arrays.asList("5:00AM", "6:00AM", "7:00AM", "8:00AM", "9:00AM", "10:00AM", "11:00AM",
			"12:00PM", "1:00PM", "2:00PM", "3:00PM", "4:00PM", "5:00PM", "6:00PM", "7:00PM", "8:00PM", "9:00PM",
			"10:00PM");
%>

<!-- PAGE CONTENT-->
<div class="page-content--bgf7" style="height: 100%">

	<br />

	<div class="jumbotron" style="width: 80%; margin: auto;">
		<h2 class="display-5">Book Game</h2>

	</div>
		<br />
		<br />
	<div class="login-form" style="width: 80%; margin: auto;">
		<div class="form-group">
			<label>Sports Center Name</label> <input class="au-input au-input--full" type="text"
				name="centerName" class="au-input " readonly
				value="<%=center.getName()%>">
		</div>
		<div class="form-group">
			<label>Game</label> <input class="au-input au-input--full" type="text" name="selectedGame"
				class="au-input " readonly value="<%=selectedGame%>">
		</div>

		<div class="form-group">
			<label>Date</label> <input class="au-input au-input--full" type="text" name="selectedDate"
				class="au-input " readonly value="<%=date%>">
		</div>
	</div>

	<div class="table-responsive m-b-40" style="width: 80%; margin: auto;">
		<table class="table table-borderless table-data3">
			<thead>
				<tr>
					<th>Court/Table Name</th>
					<th>Available Timings</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<%
					Set<Sport> availableSports = center.getSports();
					Sport sport = null;
					for (Sport avaiSport : availableSports) {
						if (selectedGame.equalsIgnoreCase(avaiSport.getName())) {
							sport = avaiSport;
							break;
						}
					}

					List<String> avaiableTimings = new ArrayList<String>(timings);
					for (GameBooking booking : bookings) {
						if (courtName.equals(booking.getCourtOrBoardName())) {
							avaiableTimings.remove(booking.getTimeSlot());
						}
					}
				%>
				<tr>
					<form action="customer-game-booking" method="post">
						<td>
							<div class="form-group">
								<input type="text" name="selectedCourt" class="au-input "
									readonly value="<%=courtName%>">
							</div> <input type="hidden" value=<%=selectedCenterId%> name="centerId">
							<input type="hidden" value=<%=selectedGame%> name="gameName">
							<input type="hidden" value=<%=date%> name="date"> <input
							type="hidden" value=<%=customerId%> name="customerId">
						</td>
						<td>
							<div class="form-group">
								<select class="form-control au-input " name="gameTime">
									<%
										for (String slot : avaiableTimings) {
									%>
									<option value=<%=slot%>><%=slot%></option>
									<%
										}
									%>
								</select>
							</div>
						</td> <br />
						<td>
							<button type="submit" class="au-btn au-btn--block au-btn--green">Book
								Game</button>
						</td>
					</form>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<br />
<br />
</div>