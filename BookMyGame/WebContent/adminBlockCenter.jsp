<%@page import="java.util.List"%>
<%@page import="com.bookmygame.pojo.SportCenter"%>
<%@page import="com.bookmygame.services.AdminServices"%>
<%@page import="com.bookmygame.services.impl.AdminServicesImpl"%>
<jsp:include page="adminHeader.jsp" />

<!-- PAGE CONTENT-->
<div class="page-content--bgf7" style="height: 100%">

	<br />
	<br />

	<!-- DATA TABLE-->
	<div class="table-responsive m-b-40" style="width: 95%; margin: auto;">
		<%
				String result = request.getParameter("request");
				if(request != null) {
					if("fail".equals(result)) {
						out.println("<script>alert('Attempt to block the sport center failed. Please try again')</script>");
					} else {
						out.println("<script>alert('Sport Center blocked successfully!')</script>");
					}
				}
            	AdminServices services = new AdminServicesImpl();
            	List<SportCenter> activeSCs = services.getAllActiveSportCenters();
            %>
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
                    	for(SportCenter sc : activeSCs) {
                    %>
				<tr>
					<td><%=sc.getSportCenterId() %></td>
					<td><%=sc.getName() %></td>
					<td><%=sc.getLocation().getLocationName() %></td>
					<td><%=sc.getSportCenterEmailId() %></td>
					<td><%=sc.getSportCenterPhNo() %></td>
					<td><%=sc.getOwnerName() %></td>
					<td><%=sc.getIdentificationId() %></td>
					<td>
						<!-- Populate the Member ID into this field --> <a
						class="btn btn-danger btn-sm"
						href="admin/center?id=<%= sc.getSportCenterId() %>&blockCenter=true"> <i
							class="fa fa-ban"></i> Block
					</a>
					</td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>
	<!-- END DATA TABLE-->

	<br />
	<br />
</div>
