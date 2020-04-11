<%@page import="com.bookmygame.pojo.Sport"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.stream.Collector"%>
<%@page import="java.util.List"%>
<%@page import="com.bookmygame.pojo.SportCenter"%>
<%@page import="com.bookmygame.services.impl.AdminServicesImpl"%>
<%@page import="com.bookmygame.services.AdminServices"%>
<jsp:include page="adminHeader.jsp" />
<!DOCTYPE jsp:include PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<!-- PAGE CONTENT-->
<div class="page-content--bgf7" style="height: 100%">

	<br />
	<br />

	<!-- DATA TABLE-->
	<div class="table-responsive m-b-55" style="width: 95%; margin: auto;">
		<table class="table table-borderless table-data3">
			<thead>
				<tr>
					<th>ID</th>
					<th>Center Name</th>
					<th>Location</th>
					<th>Center Email Id</th>
					<th>Center Phone No</th>
					<th>Available Sports</th>
					<th>Center Address</th>
					<th>Active status</th>
					<th></th>
				</tr>
			</thead>
			<%
				AdminServices services = new AdminServicesImpl();
				List<SportCenter> sportCenters = services.getAllSportCenters();
			%>
			<tbody>

				<%
					for (SportCenter sp : sportCenters) {
				%>
				<!-- TWO ROWS ARE FOR ONE CENTER DATA -->
				<tr data-toggle="collapse" data-target="#<%=sp.getSportCenterId()%>"
					class="clickable">
					<td><%=sp.getSportCenterId()%></td>
					<td><%=sp.getName()%></td>
					<td><%=sp.getLocation().getLocationName()%></td>
					<td><%=sp.getSportCenterEmailId()%></td>
					<td><%=sp.getSportCenterPhNo()%></td>
					<%
						StringBuilder builder = new StringBuilder();
							if (sp.getSports() != null && !sp.getSports().isEmpty()) {
								for(Sport sport : sp.getSports()) {
									builder.append(sport.getName()).append(" ,");
								}
								builder.deleteCharAt(builder.length()-1);
							}
					%>
					<td><%=builder.toString()%></td>
					<td><%=sp.getAddress()%></td>

					<%
						if (sp.getIsActive() == 0) {
					%>
					<!-- Use class="denied" for making it GREEN -->
					<td class="denied">Disabled</td>
					<%
						} else {
					%>
					<td class="process">Active</td>
					<%
						}
					%>
					<td>
						<button class="btn btn-default btn-sm">
							<i class="fa fa-arrow-down"></i> More Details
						</button>
					</td>
				</tr>
				<tr>
					<td colspan="9">
						<div id="<%=sp.getSportCenterId()%>" class="collapse">
							<table class="table">

								<tr>
									<th>Owner Name</th>
									<th>Owner's Phone</th>
									<th>Owner's Email</th>
									<th>Identification Number</th>
									<th>Two Wheeler parking</th>
									<th>Four Wheeler parking</th>
								</tr>
								<tr>
									<td><%=sp.getOwnerName()%></td>
									<td><%=sp.getPhoneNo()%></td>
									<td><%=sp.getOwnerEmailId()%></td>
									<td><%=sp.getIdentificationId()%></td>
									<td><%=sp.getTwoWheelerparkingAvailability() != null ? "Yes" : "No"%></td>
									<td><%=sp.getFourWheelerParkingAvailability() != null ? "Yes" : "No"%></td>

								</tr>
							</table>
						</div>
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	<!-- END DATA TABLE-->

	<br /> <br /> <br /> <br /> <br /> <br />
</div>
