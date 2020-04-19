<%@page import="com.jobsonclick.models.Candidate"%>
<jsp:include page="companyheader.jsp" /> 

            <!-- MAIN CONTENT-->
            <div class="main-content">
                <div class="section__content section__content--p30">
                
                <% 
                       String message = (String)request.getAttribute("message");
                        if(request.getAttribute("message")!=null)
                        { %>
                        <div class="alert alert-info" role="alert">
							<%=message %>
						</div>
						<%	} 
				%>
                
                    <div class="col-lg-10">
                   			 
                   			 
                                <div class="card">
                                <form action="NewMessage" method="get" enctype="multipart/form-data">
                                    <div class="card-header" style="background-color: #0099FF; color: white;">
                                        <strong>Update Profile</strong>
                                        
                                    </div>
                                    <div class="card-body card-block">
                                    	<%
                                    		Candidate candidate = (Candidate)request.getAttribute("candidate");
                                    		request.setAttribute("messageTo", candidate.getCandidateEmail());
                                    	%>
                                        <div class="form-group">
                                            <label for="company" class=" form-control-label">Candidate Name</label>
                                            <input type="text" value="<%=candidate.getCandidateName() %>" placeholder="Enter your company name" class="form-control">
                                        </div>
                                        <input type="hidden" name = "role" value="company"/>
                                        <div class="form-group">
                                            <label for="vat" class=" form-control-label">Candidate Email Address</label>
                                            <input type="text" value="<%=candidate.getCandidateEmail() %>" name="messageTo" readonly="readonly" placeholder="DE1234567890" class="form-control">
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="vat" class=" form-control-label">Experience</label>
                                            <input type="text" value="<%=candidate.getCandidateExperience()%>" readonly="readonly"  placeholder="DE1234567890" class="form-control">
                                        </div>
                                       
                                        <div class="form-group">
                                            <label for="country" class=" form-control-label">Summary</label>
                                            <textarea rows="9"  class="form-control"><%=candidate.getCandidateSummary()%></textarea>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="country" class=" form-control-label">Skills</label>
                                            <textarea rows="2"  class="form-control"><%=candidate.getCandidateSkills()%></textarea>
                                        </div>
                                        
                                        
                                    </div>
                                    <div class="card-footer">
                                        <button type="submit" class="btn btn-primary btn-sm">
                                            <i class="fa fa-dot-circle-o"></i> Contact Candidate
                                        </button>
                                        <a href="companysearchcandidates.jsp?searched=false" class="btn btn-danger btn-sm"> <i class="fa fa-ban"></i>Cancel</a>
                                    </div>
                                     </form>
                                     <form action="DownloadResume" method="get" class="fileDownloadForm" id="imgForm">
											<div class="col-md-3"><input name="candidateId" value="<%=candidate.getCandidateId() %>" hidden="true"/><button type="submit" class="btn btn-outline-secondary btn-sm">
											<i class="fas fa-download"></i> Download Resume</button>
															
											</div>
									</form>
									<form action="companyviewapplications.jsp" method="get" id="nextPage"></form>
                                </div>
                               
                            </div>
                </div>
            </div>
            <!-- END MAIN CONTENT-->
            <!-- END PAGE CONTAINER-->
        </div>

    </div>


