<%@page import="java.util.Set"%>
<%@page import="com.bookmygame.pojo.Sport"%>
<%@page import="com.bookmygame.pojo.SportCenter"%>
<%@page import="com.bookmygame.services.impl.CommonServicesImpl"%>
<%@page import="com.bookmygame.services.CommonServices"%>
<%@page
	import="com.bookmygame.services.impl.SportCenterOwnerServicesImpl"%>
<%@page import="com.bookmygame.services.SportCenterOwnerServices"%>
<jsp:include page="centerHeader.jsp" />

<!-- PAGE CONTENT-->
<div class="page-content--bgf7" style="height: 100%">

	<br />
	<%
		int sportCenterId = request.getSession().getAttribute("centerId") != null
				? (Integer) request.getSession().getAttribute("centerId")
				: -1;
		if (sportCenterId < 0) {
			response.sendRedirect("centerLogin.jsp?sessionExpired=true");
		}
		if (request.getParameter("result") != null) {
			if ("success".equals(request.getParameter("result"))) {
				out.println("<script>alert('Successfully added the new Game to Center')</script>");
			} else if ("fail".equals(request.getParameter("result"))) {
				out.println("<script>alert('Error adding the new Game to Center. Please try again')</script>");
			}
		}
	%>
	<div class="jumbotron" style="width: 50%; margin: auto;">
		<h2 class="display-5">Add New Game</h2>
		<br />

		<form action="center-update-sports" method="post">
			<div class="form-group">
				<label>Sport Name</label> <input class="au-input au-input--full"
					type="text" name="gamename" placeholder="Name Of Game" required>
			</div>
			<div class="form-group">
				<label>Image</label> <input type="file" name="gameimage"
					class="form-control-file" required>
			</div>
			<div class="form-group">
				<label>Names of Courts/Boards/Lanes Available (Separate
					using comma)</label> <input type="text" name="NoOfCourts"
					class="au-input au-input--full"
					placeholder="Names of Courts/Boards/Lanes" required>
			</div>
			<br />
			<button type="submit"
				class="au-btn au-btn--block au-btn--green m-b-20">Add New
				Game</button>
		</form>
	</div>

	<br /> <br />
</div>