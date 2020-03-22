<%@page import="java.util.Set"%>
<%@page import="com.bookmygame.pojo.Sport"%>
<%@page import="com.bookmygame.services.impl.CommonServicesImpl"%>
<%@page import="com.bookmygame.services.CommonServices"%>
<jsp:include page="centerHeader.jsp"/>

<style>
	.gameImage{
		width: 200px;
	}
</style>
        <!-- PAGE CONTENT-->
        <div class="page-content--bgf7" style="height: 100%">
        
        	<br/><br/>
        	
        	<!-- DATA TABLE-->
           <%
        		int sportCenterId = request.getSession().getAttribute("centerId") != null ? (Integer)request.getSession().getAttribute("centerId"): -1;
				if(sportCenterId < 0 ){
					response.sendRedirect("centerLogin.jsp?sessionExpired=true");
				}
        		CommonServices services = new CommonServicesImpl();
        		Set<Sport> sports = services.getAllSportsInSportCenter(sportCenterId);
        	
        	%>
        	 <div class="table-responsive m-b-40" style="width: 60%; margin: auto;">
                <table class="table table-borderless table-striped table-earning">
                    <thead>
                        <tr>
                        	<th>Game ID</th>
                            <th>Image</th>
                            <th>Game Title</th>
                            <th>Available Courts/Boards/Lanes</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                    	for(Sport sport : sports) {
                    %>
                        <tr>
                        	<td style="vertical-align: middle; text-align: center;"><%=sport.getId() %></td>
                            <td><img class="gameImage" src=<%=sport.getImage() %>></td>
                            <td style="vertical-align: middle;"><%= sport.getName() %></td>
                            <td style="vertical-align: middle; text-align: center;"><%= sport.getCourtOrBoardNames().size() %></td>
                        </tr>

                        <%} %>
                    </tbody>
                </table>
            </div>
            <!-- END DATA TABLE-->
        
        	<br/><br/>
        </div>