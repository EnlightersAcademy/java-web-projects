<%@page import="com.bookmygame.pojo.Sport"%>
<%@page import="com.bookmygame.pojo.SportCenter"%>
<%@page import="com.bookmygame.services.SportCenterOwnerServices"%>
<%@page
	import="com.bookmygame.services.impl.SportCenterOwnerServicesImpl"%>
<jsp:include page="userHeader.jsp" />

<style>
.gameImage {
	width: 200px;
}
</style>

<%
	// Populate the sportsCenterId here
	int selectedCenterId = Integer.parseInt(request.getParameter("centerId"));
	SportCenterOwnerServices services = new SportCenterOwnerServicesImpl();
	SportCenter center = services.getSportCenterById(selectedCenterId);
	if (center == null) {
		center = new SportCenter();
	}
%>

<!-- PAGE CONTENT-->
<div class="page-content--bgf7" style="height: 100%">

	<br />

	<div class="jumbotron"
		style="width: 90%; margin: auto; text-align: left;">
		<div class="form-group row">
			<div class="col-md-6">
				<form class="form-inline">
					<div class="form-group mb-2">
						<label style="font-weight: bold;">LOCATION: </label>
					</div>
					<div class="form-group mb-2" style="padding-left: 20px;">
						<!-- Populate the Selected Location HERE -->
						<input type="text" readonly class="form-control-plaintext"
							name="selectedLocation"
							value="<%=center.getLocation().getLocationName()%>">
					</div>
				</form>
			</div>
			<div class="col-md-6">
				<form class="form-inline">
					<div class="form-group mb-2">
						<label style="font-weight: bold;">SPORTS CENTER: </label>
					</div>
					<div class="form-group mb-2" style="padding-left: 20px;">
						<!-- Populate the Selected Sports Center HERE -->
						<input type="text" readonly class="form-control-plaintext"
							name="selectedCenter" value="<%=center.getName()%>">
					</div>
				</form>
			</div>
		</div>
	</div>
	<br />

	<!-- DATA TABLE-->
	<div class="table-responsive m-b-40" style="width: 90%; margin: auto;">
		<table class="table table-borderless table-data3">
			<thead>
				<tr>
					<th></th>
					<th>Game</th>
					<th>No of tables/courts</th>
					<th>Date</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Sport sport : center.getSports()) {
				%>
				<tr>
					<form action="userBookGame2.jsp" method="post">
						<td><img class="gameImage" src="images/games/<%=sport.getImage()%>"></td>
						<td style="vertical-align: middle;">
							<!-- Populate the game HREF--> <input type="text" readonly
							class="form-control-plaintext" name="selectedGame"
							value="<%=sport.getName()%>">
						</td>
						<td style="vertical-align: middle;"><input type="text" readonly
							class="form-control-plaintext" name="count"
							value="<%=sport.getCourtOrBoardNames().size()%>"></td>
						<td style="vertical-align: middle;"><input type="date" name="gameDate" required> <input
							type="hidden" name="centerId" value=<%=selectedCenterId%>>
						</td>
						<td style="vertical-align: middle;">
							<!-- Populate the courts HREF--> <select name="court">
							<% for(String courtName : sport.getCourtOrBoardNames())  {%>
								<option><%=courtName %></option>
								<%} %>
						</select>
						</td>
						<td style="vertical-align: middle;"><input type="hidden" name="selectedCenter"
							value="<%=selectedCenterId%>">
							<button type="submit" class="btn btn-success mb-2">SELECT</button>
						</td>

					</form>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	<!-- END DATA TABLE-->

	<br /> <br />
</div>