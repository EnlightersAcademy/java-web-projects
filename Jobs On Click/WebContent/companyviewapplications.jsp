<%@page import="com.jobsonclick.models.Application"%>
<%@page import="com.jobsonclick.models.Jobs"%>
<%@page import="java.util.List"%>
<jsp:include page="companyheader.jsp" />


<!-- MAIN CONTENT-->
<div class="main-content">
	<div class="section__content section__content--p30">

		<%
			String message = (String) request.getAttribute("message");
			if (request.getAttribute("message") != null) {
		%>
		<div class="alert alert-info" role="alert">
			<%=message%>
		</div>
		<%
			}
		%>

		<div class="row m-t-30">
			<div class="col-md-12">
				<!-- DATA TABLE-->

				<%
					List<Jobs> jobsList = (List<Jobs>) request.getAttribute("jobsList");
					if (request.getAttribute("jobsList") == null) {
				%>
				<div class="table-responsive m-b-40"
					style="text-align: center; padding-top: 150px; color: #AEB6BF;">
					<strong>There are no Active Jobs for Applications</strong>
				</div>
				<%
					} else {
						
						//List<Jobs> jobsList = (List<Jobs>) request.getAttribute("jobsList");
						
				%>
				<div class="table-responsive m-b-40">

					<div class="accordion md-accordion" id="accordionEx" role="tablist"
						aria-multiselectable="true">
						
						<%
							int i = 1;
							for(Jobs job: jobsList){
								
						%>
						
						<!-- Accordion card -->
						<div class="card">

							<!-- Card header -->
							<div class="card-header" role="tab" id="headingOne<%=i%>">
								<a data-toggle="collapse" data-parent="#accordionEx"
									href="#collapseOne<%=i%>" aria-expanded="true"
									aria-controls="collapseOne<%=i%>">
									<h5 class="mb-0">
										Job ID: <%=job.getJobId() %> - <%=job.getJobTitle() %> <i class="fas fa-angle-down rotate-icon"></i>
									</h5>
								</a>
							</div>

							<!-- Card body -->
							<div id="collapseOne<%=i%>" class="collapse" role="tabpanel"
								aria-labelledby="headingOne<%=i%>" data-parent="#accordionEx">
								<div class="card-body">
									<ul class="list-group">
									
										<%
											for(Application app: job.getApplications()){
										%>
										<li class="list-group-item list-group-item-action">
										<div class="row">
											<div class="col-md-3"><%=app.getCandidate().getCandidateName() %></div>
											<div class="col-md-3">Experience: <%=app.getCandidate().getCandidateExperience() %></div>
											
											<form action="DownloadResume" method="get" class="fileDownloadForm" id="imgForm">
											<div class="col-md-3"><input name="candidateId" value="<%=app.getCandidateId() %>" hidden="true"/><button type="submit" class="btn btn-outline-secondary btn-sm">
											<i class="fas fa-download"></i> Download Resume</button>
															
											</div></form>
											<form action="companyviewapplications.jsp" method="get"
        									id="nextPage"></form>
											
											<div class="col-md-3">
											<%
												if(app.getStatus().equalsIgnoreCase("new"))
												{
											%>
											<a 
											href="ApproveApplication?jobId=<%=job.getJobId()%>&candidateId=<%=app.getCandidateId()%>&candidateEmail=<%=app.getCandidate().getCandidateEmail()%>&jobTitle=<%=job.getJobTitle()%>" 
											class="btn btn-success btn-sm">Accept</a>
										    <a href="RejectApplication?jobId=<%=job.getJobId()%>&candidateId=<%=app.getCandidateId()%>" class="btn btn-danger btn-sm">Reject</a>
										    <%
										    	}
												else
												{
										    %>
										    	<button  type="button" class="btn btn-secondary btn-sm">
		                                            Accepted
		                                        </button>
	                                        <%
												}
	                                        %>
											</div>
										</div>
										
										</li>
										<%
											}
										%>
									</ul>
								</div>
							</div>

						</div>
						<!-- Accordion card -->
						<%
						}
						%>
					</div>
					<%
						}
					%>

					<!-- END DATA TABLE-->
				</div>
			</div>
		</div>
	</div>
	<!-- END MAIN CONTENT-->
	<!-- END PAGE CONTAINER-->
</div>

</div>

<script>
    $(document).on("submit", "form.fileDownloadForm", function(e) {

        $.fileDownload($(this).prop('action'), {
            successCallback : function(url) {
                $('form#nextPage').submit();
            },
            failCallback : function(responseHtml, url) {
                alert('File download failed!!!!');
            }
        });

        e.preventDefault();
    });
</script>
