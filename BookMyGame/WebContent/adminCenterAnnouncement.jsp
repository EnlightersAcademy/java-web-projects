<%@page import="com.bookmygame.pojo.enums.AnnouncementType"%>
<%@page import="com.bookmygame.pojo.Announcement"%>
<jsp:include page="adminHeader.jsp" />

<!-- PAGE CONTENT-->
<div class="page-content--bgf7" style="height: 100%">

	<br /> <br />

	<div class="jumbotron" style="width: 80%; margin: auto;">
		<h2 class="display-5">New Announcement to Sports Centers</h2>
		<br />
		
		<%
				String result = request.getParameter("result");
				if(request != null) {
					if("fail".equals(result)) {
						out.println("<script>alert('Posting new announcement failed. Please try again')</script>");
					} else if("success".equals(result)){
						out.println("<script>alert('Announcement posted successfully!')</script>");
					}
				}

            %>

		<form action="admin-announcement?newAnno=true" method="post">
			<div class="form-group">
				<label>Content:</label>
				<textarea class="form-control" name="content" rows="3"></textarea>
				<input type="hidden" name="annou" value=<%=AnnouncementType.OWNER.ordinal()%>></input>
			</div>
			<button type="submit"
				class="au-btn au-btn--block au-btn--green m-b-20">Announce</button>
		</form>
	</div>
	<br /> <br />
</div>