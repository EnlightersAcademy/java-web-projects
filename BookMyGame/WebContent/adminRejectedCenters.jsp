<%@page import="com.bookmygame.pojo.SportCenter"%>
<%@page import="java.util.List"%>
<%@page import="com.bookmygame.services.AdminServices"%>
<%@page import="com.bookmygame.services.impl.AdminServicesImpl"%>
<jsp:include page="adminHeader.jsp"/>

        <!-- PAGE CONTENT-->
        <div class="page-content--bgf7" style="height: 100%">
        	
        	<br/><br/>
        	<%
        		AdminServices services = new AdminServicesImpl();
        		List<SportCenter> centers = services.getAllRejectedSportCenters();
        	%>
        	<!-- DATA TABLE-->
            <div class="table-responsive m-b-40" style="width: 95%; margin: auto;">
                <table class="table table-borderless table-data3">
                    <thead>
				<tr>
					<th>ID</th>
					<th>Center Name</th>
					<th>Location</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Owner Name</th>
					<th>Owner Phone No</th>
					<th>Owner Id</th>
				</tr>
			</thead>
			<tbody>
				<%
                    	for(SportCenter sc : centers) {
                    %>
				<tr>
					<td><%=sc.getSportCenterId() %></td>
					<td><%=sc.getName() %></td>
					<td><%=sc.getLocation().getLocationName() %></td>
					<td><%=sc.getSportCenterEmailId() %></td>
					<td><%=sc.getSportCenterPhNo() %></td>
					<td><%=sc.getOwnerName() %></td>
					<td><%=sc.getPhoneNo() %></td>
					<td><%=sc.getIdentificationId() %></td>
				</tr>
				<%} %>
			</tbody>
                </table>
            </div>
            <!-- END DATA TABLE-->
            
            <br/><br/>
        </div>
    	