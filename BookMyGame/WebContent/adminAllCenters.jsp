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
	<div class="table-responsive m-b-40" style="width: 95%; margin: auto;">
		<table class="table table-borderless table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Center Name</th>
					<th>Location</th>
					<th>Center Email Id</th>
					<th>Center Phone No</th>
					<th>Available Sports</th>
				</tr>
			</thead>
			<%
			AdminServices services = new AdminServicesImpl();
			List<SportCenter> sportCenters = services.getAllActiveSportCenters();
			for(SportCenter sp: sportCenters) {
		%>
			<tbody>

				<!-- TWO ROWS ARE FOR ONE CENTER DATA -->
				<tr data-toggle="collapse" data-target="#<%=1234 %>"
					class="clickable">
					<td>1234</td>
					<td>Flying Feathers</td>
					<td>Electronic City</td>
					<td>sample@gmail.com</td>
					<td>9882020205</td>
					<td>
						<button class="btn btn-default btn-sm">
							<i class="fa fa-arrow-down"></i> More Details
						</button>
					</td>
				</tr>
				<tr>
					<td colspan="6">
						<div id="<%=1234 %>" class="collapse">
							<table class="table">

								<tr>
									<th>Owner Name</th>
									<th>Owner's Phone</th>
									<th>Owner's Email</th>
									<th>ID Type</th>
									<th>ID Number</th>
								</tr>
								<tr>
									<td>Raj</td>
									<td>9039393939</td>
									<td>raj@gmail.com</td>
									<td>PAN</td>
									<td>BHSD6767A</td>
								</tr>
							</table>
						</div>
					</td>
				</tr>
				<!-- CENTER DATA ENDS HERE -->

				<!-- TWO ROWS ARE FOR ONE CENTER DATA -->
				<tr data-toggle="collapse" data-target="#<%=1235 %>"
					class="clickable">
					<td>1235</td>
					<td>Flying Feathers</td>
					<td>Electronic City</td>
					<td>sample@gmail.com</td>
					<td>9882020205</td>
					<td>
						<button class="btn btn-default btn-sm">
							<i class="fa fa-arrow-down"></i> More Details
						</button>
					</td>
				</tr>
				<tr>
					<td colspan="6">
						<div id="<%=1235 %>" class="collapse">
							<table class="table">

								<tr>
									<th>Owner Name</th>
									<th>Owner's Phone</th>
									<th>Owner's Email</th>
									<th>ID Type</th>
									<th>ID Number</th>
								</tr>
								<tr>
									<td>Raj</td>
									<td>9039393939</td>
									<td>raj@gmail.com</td>
									<td>PAN</td>
									<td>BHSD6767A</td>
								</tr>
							</table>
						</div>
					</td>
				</tr>
				<!-- CENTER DATA ENDS HERE -->

				<!-- TWO ROWS ARE FOR ONE CENTER DATA -->
				<tr data-toggle="collapse" data-target="#<%=1236 %>"
					class="clickable">
					<td>1236</td>
					<td>Flying Feathers</td>
					<td>Electronic City</td>
					<td>sample@gmail.com</td>
					<td>9882020205</td>
					<td>
						<button class="btn btn-default btn-sm">
							<i class="fa fa-arrow-down"></i> More Details
						</button>
					</td>
				</tr>
				<tr>
					<td colspan="6">
						<div id="<%=1236 %>" class="collapse">
							<table class="table">

								<tr>
									<th>Owner Name</th>
									<th>Owner's Phone</th>
									<th>Owner's Email</th>
									<th>ID Type</th>
									<th>ID Number</th>
								</tr>
								<tr>
									<td>Raj</td>
									<td>9039393939</td>
									<td>raj@gmail.com</td>
									<td>PAN</td>
									<td>BHSD6767A</td>
								</tr>
							</table>
						</div>
					</td>
				</tr>
				<!-- CENTER DATA ENDS HERE -->
			</tbody>
		</table>
	</div>
	<!-- END DATA TABLE-->
	<%} %>
	<br />
	<br /> <br />
	<br /> <br />
	<br />
</div>
