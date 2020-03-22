<%@page import="com.bookmygame.pojo.Announcement"%>
<%@page import="java.util.List"%>
<%@page import="com.bookmygame.services.impl.CommonServicesImpl"%>
<%@page import="com.bookmygame.services.CommonServices"%>
<jsp:include page="userHeader.jsp" />

<!-- PAGE CONTENT-->
<div class="page-content--bgf7" style="height: 100%">

	<%
 CommonServices services = new CommonServicesImpl();
List<Announcement> annoucs = services.getAllAnnoucements();
%>
	<!-- STATISTIC-->
	<section class="statistic statistic2">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-lg-6">
					<div class="statistic__item statistic__item--green">
						<h2 class="number">ANNOUNCEMENTS</h2>
						<br />
						<div class="desc">

							<table class="table table-borderless" style="color: white;">
								<tbody>
									<% for(Announcement ann: annoucs) { %>
									<tr>
										<td style="text-align: left;"><%=ann.getMessageDate() %></td>
										<td style="text-align: left;"><%=ann.getMessage() %></td>
									</tr>

								</tbody>
								<%} %>
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


