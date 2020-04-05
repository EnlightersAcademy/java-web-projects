<%@page import="com.bookmygame.pojo.Sport"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="com.bookmygame.pojo.SportCenter"%>
<%@page import="java.util.List"%>
<%@page import="com.bookmygame.services.impl.AdminServicesImpl"%>
<%@page import="com.bookmygame.services.AdminServices"%>
<jsp:include page="adminHeader.jsp" />

<style>
.gameImage {
	width: 200px;
}
</style>
<!-- PAGE CONTENT-->
<div class="page-content--bgf7" style="height: 100%">

	<br /> <br />
	<%
		AdminServices services = new AdminServicesImpl();
		List<SportCenter> sportCenters = services.getAllSportCenters();
		Set<Sport> sports = new HashSet<Sport>();

		for (SportCenter center : sportCenters) {

			for (Sport sport : center.getSports()) {
				sports.add(sport);
			}
		}
	%>
	<!-- DATA TABLE-->
	<div class="table-responsive m-b-40" style="width: 50%; margin: auto;">
		<table class="table table-borderless table-striped table-earning">
			<thead>
				<tr>
					<th>Image</th>
					<th>Game Title</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Sport eachSport : sports) {
				%>
				<tr>
					<td><img class="gameImage" src="images/games/
						<%=eachSport.getImage()%>" /></td>
					<td style="vertical-align: middle;"><%=eachSport.getName()%></td>
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