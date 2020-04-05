<%@page import="java.util.List"%>
<%@page import="com.bookmygame.pojo.Announcement"%>
<%@page import="java.util.Map"%>
<%@page import="com.bookmygame.services.SportCenterOwnerServices"%>
<%@page import="com.bookmygame.services.impl.SportCenterOwnerServicesImpl"%>
<jsp:include page="centerHeader.jsp"/>

        <!-- PAGE CONTENT-->
        <div class="page-content--bgf7" style="height: 100%">

			<%
			int sportCenterId = request.getSession().getAttribute("centerId") != null ? (Integer)request.getSession().getAttribute("centerId"): -1;
			if(sportCenterId < 0 ){
				response.sendRedirect("centerLogin.jsp?sessionExpired=true");
			}
    		
			SportCenterOwnerServices services = new SportCenterOwnerServicesImpl();
    		Map<String, Object> countMap = services.getProvisionToActiveCountMap(sportCenterId);
    		
    		long totalBookings = 0;
    		int totalGames = 0;
    		List<Announcement> announcements = null;
    		if(countMap != null && !countMap.isEmpty()) {
    			totalBookings = (Long)countMap.get("booking");
    			totalGames = (Integer)countMap.get("gamesCount");
    			announcements = (List<Announcement>)countMap.get("announcements");
    		}
			%>
			
            <!-- STATISTIC-->
            <section class="statistic statistic2">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 col-lg-3">
                            <div class="statistic__item statistic__item--green">
                            	<!-- TOTAL BOOKINGS DONE WITH THE CENTER -->
                                <h2 class="number"><%= totalBookings %></h2>
                                <span class="desc">total bookings</span>
                                <div class="icon">
                                    <i class="zmdi zmdi-calendar-note"></i>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-3">
                            <div class="statistic__item statistic__item--orange">
                            	<!-- TOTAL GAMES OFFERED BY THE CENTER -->
                                <h2 class="number"> <%=totalGames %></h2>
                                <span class="desc">total games</span>
                                <div class="icon">
                                    <i class="zmdi zmdi-bike"></i>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12 col-lg-6">
                            <div class="statistic__item statistic__item--blue">
                                <h2 class="number">ANNOUNCEMENTS</h2>
                                <br/>
                                <div class="desc">
                                
                                <table class="table table-borderless" style="color: white;">
				                    <tbody>
				                    <%
				                    	if(announcements != null) {
				                    		for(Announcement anno : announcements) {
				                    			
				                    %>
				                        <tr>
				                        	<td style="text-align: left;"><%=anno.getMessageDate().toString() %></td>
				                            <td style="text-align: left;"><%=anno.getMessage() %></td>
				                        </tr>
				                        <%}} %>
				                    </tbody>
				                </table>

								</div>
                                <div class="icon">
                                    <i class="zmdi zmdi-info"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- END STATISTIC-->
    	</div>


