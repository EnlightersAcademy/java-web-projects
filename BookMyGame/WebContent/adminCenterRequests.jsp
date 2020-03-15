<%@page import="com.bookmygame.pojo.SportCenter"%>
<%@page import="java.util.List"%>
<%@page import="com.bookmygame.services.AdminServices"%>
<%@page import="com.bookmygame.services.impl.AdminServicesImpl"%>
<jsp:include page="adminHeader.jsp" />

<!-- PAGE CONTENT-->
<div class="page-content--bgf7" style="height: 100%">

	<br /> <br />

	<%
				String result = request.getParameter("request");
				if(request != null) {
					if("fail".equals(result)) {
						out.println("<script>alert('Attempt to approve/reject the sport center failed. Please try again')</script>");
					} else {
						out.println("<script>alert('Sport Center approved/rejected successfully!')</script>");
					}
				}
            	AdminServices services = new AdminServicesImpl();
            	List<SportCenter> toApproveSCs = services.getAllSportCentersToApprove();
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
					<th>Owner Id</th>
				</tr>
			</thead>
			<tbody>
				<%
				if(toApproveSCs != null && !toApproveSCs.isEmpty()) {
				
				for(SportCenter center : toApproveSCs) {
			%>
				<tr>
					<td><%=center.getSportCenterId() %></td>
					<td><%=center.getName() %></td>
					<td><%=center.getLocation().getLocationName() %></td>
					<td><%=center.getSportCenterEmailId() %></td>
					<td><%=center.getSportCenterPhNo() %></td>
					<td><%=center.getOwnerName()%></td>
					<td><%=center.getIdentificationId() %></td>

					<td>
						<!-- Populate the Member ID into this field --> <a
						class="btn btn-success btn-sm" href="admin/center?toApprove=true&id=<%= center.getSportCenterId()	 %>">
							<i class="fa fa-thumbs-up"></i> Approve
					</a> <a class="btn btn-danger btn-sm"
						href="admin/center?toApprove=false&id=<%= center.getSportCenterId() %>"> <i class="fa fa-ban"></i>
							Reject
					</a>
					</td>
				</tr>
				<% }}%>
			</tbody>
		</table>
	</div>
	<!-- END DATA TABLE-->

	<br /> <br />
</div>
