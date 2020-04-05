<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="com.bookmygame.pojo.GameBooking"%>
<%@page import="com.bookmygame.services.impl.CustomerServicesImpl"%>
<%@page import="com.bookmygame.services.CustomerServices"%>
<jsp:include page="userHeader.jsp" />

<!-- PAGE CONTENT-->
<div class="page-content--bgf7" style="height: 100%">

	<br />
	<%
		int customerId = (Integer) request.getSession().getAttribute("customerId");
		CustomerServices services = new CustomerServicesImpl();
		List<GameBooking> bookings = services.getAllBookings(customerId);

		String bookDone = request.getParameter("gameCancel");
		if (bookDone != null) {
			if (bookDone.equals("success")) {
				out.println("<script>alert('Booking cancelled successfully!')</script>");

			} else if (bookDone.equals("fail")) {
				out.println("<script>alert('Failed to cancel the booking. Please try again')</script>");

			}
		}
	%>
	<!-- DATA TABLE-->
	<div class="table-responsive m-b-40" style="width: 95%; margin: auto;">

		<table class="table table-borderless table-data3">
			<thead>
				<tr>
					<th>Booking ID</th>
					<th>Center Name</th>
					<th>Game</th>
					<th>Court/Board Name</th>
					<th>Date</th>
					<th>Time</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<%
					if (bookings != null) {
						for (GameBooking booking : bookings) {
				%>
				<tr>
					<form action="cancel-booking" method="post">
						<input type="hidden" name=bookingId
							value=<%=booking.getBookingId()%>>
						<td><%=booking.getBookingId()%></td>
						<td><%=booking.getSportCenter().getName()%></td>
						<td><%=booking.getSportName()%></td>
						<td><%=booking.getCourtOrBoardName()%></td>
						<td><%=booking.getDateOfBooking()%></td>
						<td><%=booking.getTimeSlot()%></td>
						<td>
						<%
							Date date = new SimpleDateFormat("yyyy-MM-dd").parse(booking.getDateOfBooking());
									if (!date.before(new Date())) {
						%>
						
							<button type="submit" class="au-btn au-btn--small au-btn--green">Cancel
								Game</button>
						
						<%
							}
						%>
						</td>

					</form>
				</tr>
				<%
					}
					}
				%>
			</tbody>
		</table>

	</div>
	<!-- END DATA TABLE-->

	<br /> <br />
</div>