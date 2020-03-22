<%@page import="java.util.List"%>
<%@page import="com.bookmygame.pojo.GameBooking"%>
<%@page import="com.bookmygame.services.AdminServices"%>
<%@page import="com.bookmygame.services.impl.AdminServicesImpl"%>
<jsp:include page="centerHeader.jsp"/>

        <!-- PAGE CONTENT-->
        <div class="page-content--bgf7" style="height: 100%">
        
        	<br/>
			<%
			int sportCenterId = request.getSession().getAttribute("centerId") != null ? (Integer)request.getSession().getAttribute("centerId"): -1;
			if(sportCenterId < 0 ){
				response.sendRedirect("centerLogin.jsp?sessionExpired=true");
			}
				AdminServices services = new AdminServicesImpl();
				List<GameBooking> bookings = services.getAllBookingsOnSportCenter(sportCenterId);
			
			%>
			<!-- DATA TABLE-->
            <div class="table-responsive m-b-40" style="width: 95%; margin: auto;">
            
                <table class="table table-borderless table-data3">
                    <thead>
                        <tr>
                            <th>Booking ID</th>
                            <th>Member ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Game</th>
                            <th>Date</th>
                            <th>Time Slot</th>
                            <th>Court No.</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                    	if(bookings != null) {
                   
                    		
                    	for(GameBooking booking : bookings) {
                    %>
                        <tr>
                            <td><%=booking.getBookingId() %></td>
                            <td><%=booking.getCustomer().getId() %></td>
                            <td><%=booking.getCustomer().getName() %></td>
                            <td><%=booking.getCustomer().getEmailId() %></td>
                            <td><%=booking.getCustomer().getPhoneNo() %></td>
                            <td><%=booking.getSportName() %></td>
                            <td><%=booking.getTimeSlot() %></td>
                            <td><%=booking.getCourtOrBoardName() %></td>
                        </tr>
                        
                        <%} }%>
                    </tbody>
                    
                </table>
                
            </div>
            <!-- END DATA TABLE-->
        
        	<br/><br/>
        </div>