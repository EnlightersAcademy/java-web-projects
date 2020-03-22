<%@page import="java.util.List"%>
<%@page import="com.bookmygame.pojo.GameBooking"%>
<%@page import="com.bookmygame.services.impl.CustomerServicesImpl"%>
<%@page import="com.bookmygame.services.CustomerServices"%>
<jsp:include page="userHeader.jsp"/>

        <!-- PAGE CONTENT-->
        <div class="page-content--bgf7" style="height: 100%">
        
        	<br/>
			<%
			int customerId = (Integer)request.getSession().getAttribute("customerId");
			CustomerServices services = new CustomerServicesImpl();
			List<GameBooking> bookings = services.getAllBookings(customerId);
			
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
                        </tr>
                    </thead>
                    <tbody>
                    <% if(bookings != null) {
                    	for(GameBooking booking : bookings) {
                    
                    %>
                        <tr>
                            <td><%=booking.getBookingId() %></td>
                            <td><%=booking.getSportCenter().getName() %></td>
                            <td><%=booking.getSportName() %></td>
                            <td><%=booking.getCourtOrBoardName() %></td>
                            <td><%=booking.getDateOfBooking() %></td>
                            <td><%=booking.getTimeSlot() %></td>
                        </tr>
                     
                        <%}} %>
                    </tbody>
                </table>
                
            </div>
            <!-- END DATA TABLE-->
        
        	<br/><br/>
        </div>