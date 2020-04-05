<%@page import="com.bookmygame.services.impl.SportCenterOwnerServicesImpl"%>
<%@page import="com.bookmygame.services.SportCenterOwnerServices"%>
<%@page import="com.bookmygame.servlets.SportCenterServlet"%>
<%@page import="com.bookmygame.pojo.SportCenter"%>
<jsp:include page="centerHeader.jsp" />

<!-- PAGE CONTENT-->
<div class="page-content--bgf7" style="height: 100%">

	<br />
	<br />

	<div class="jumbotron" style="width: 50%; margin: auto;">
		<h2 class="display-5">Update Account Details</h2>
		<br />

		<div class="login-form">

			<%
	            int centerId = (Integer)request.getSession().getAttribute("centerId");
	            SportCenterOwnerServices services = new SportCenterOwnerServicesImpl();
	            SportCenter center = services.getSportCenterById(centerId);
	            if(center == null) {
	            	response.sendRedirect("centerLogin.jsp?sessionExpired=true");
	            }
	            if(request.getParameter("result") != null) {
	            	if(request.getParameter("result") .equals("fail")) {
	            		out.println("<script>alert('Center details update Failed. Please try again')</script>");
	            	} else if(request.getParameter("result") .equals("success")) {
	            		out.println("<script>alert('Details updated Successfully')</script>");
	            	}
	            }
	            %>

			<form action="center-update" method="post">
				<div class="form-group">
					<label>Sports Center Name</label> <input
						class="au-input au-input--full" type="text" name="name" readonly value=<%=center.getName() %>>
				</div>
				<div class="form-group">
					<label>Location</label> <input class="au-input au-input--full"
						type="text" name="location" readonly value=<%=center.getLocation().getLocationName() %>>
				</div>
				<div class="form-group">
					<label>Address</label>
					<textarea class="au-input au-input--full" rows="2" cols="50"
						name="address" required placeholder="Complete Address"><%=center.getAddress() %>
                             </textarea>
				</div>
				<div class="form-group">
					<label>Center Email ID</label> <input
						class="au-input au-input--full" type="email" name="email" required value=<%=center.getSportCenterEmailId() %>>
				</div>
				<div class="form-group">
					<label>Login Password</label> <input
						class="au-input au-input--full" type="password" name="password"
						placeholder="Password" required value=<%=center.getPassword()%>>
				</div>
				<div class="form-group">
					<label>Center Phone Number</label> <input
						class="au-input au-input--full" type="text" name="phone"
						maxlength="10" required placeholder="Phone" value=<%=center.getPhoneNo() %>>
				</div>
				<div class="form-inline form-group">
					<label for="twowheeleravailable">Two Wheeler Parking
						Available?</label> &nbsp;&nbsp; <label
						class="switch switch-3d switch-primary mr-3"> <input
						type="checkbox" class="switch-input" name="twowheeleravailable"
						id="twowheeleravailable"  <%if(center.getTwoWheelerparkingAvailability() != null) {%>checked="checked" <%} %>> <span
						class="switch-label"></span> <span class="switch-handle"></span>
					</label>
				</div>
				<div class="form-inline form-group">
					<label for="fourwheeleravailable">Four Wheeler Parking
						Available?</label> &nbsp;&nbsp; <label
						class="switch switch-3d switch-primary mr-3"> <input
						type="checkbox" class="switch-input" name="fourwheeleravailable"
						id="fourwheeleravailable" <%if(center.getFourWheelerParkingAvailability() != null) {%>checked="checked" <%} %>> <span
						class="switch-label"></span> <span class="switch-handle"></span>
					</label>
				</div>

				<hr />

				<div class="form-group">
					<label>Owner's Name</label> <input class="au-input au-input--full"
						type="text" name="ownername" required placeholder="Owner's Name" value=<%=center.getOwnerName() %>>
				</div>
				<div class="form-group">
					<label>Owner's Email ID</label> <input
						class="au-input au-input--full" type="email" name="owneremail"
						required placeholder="Owner's Email" value=<%=center.getOwnerEmailId() %>>
				</div>
				<div class="form-group">
					<label>Owner's Phone Number</label> <input
						class="au-input au-input--full" type="text" name="ownerphone"
						maxlength="10" required placeholder="Owner's Phone" value=<%=center.getPhoneNo() %>>
				</div>
				<div class="form-group">
					<label>Owner's ID Number</label> <input
						class="au-input au-input--full" type="text" name="ownerid"
						required placeholder="Owner's ID Number" value=<%=center.getIdentificationId() %>>
				</div>
				<button class="au-btn au-btn--block au-btn--green m-b-20"
					type="submit">Update Details</button>
			</form>
		</div>
	</div>

	<br />
	<br />
</div>