<%@page import="com.jobsonclick.models.Candidate"%>
<jsp:include page="candidateheader.jsp" /> 

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
                        
                        Candidate candidate = (Candidate) session.getAttribute("candidate");
				%>
                
                    <div class="col-lg-10">
                   			
                   			 <form action="UpdateCandidateProfile" method="post" enctype="multipart/form-data">
                                <div class="card">
                                    <div class="card-header" style="background-color: #0099FF; color: white;">
                                        <strong>Update Profile</strong>
                                        
                                    </div>
                                    <div class="card-body card-block">
                                    
                                        <div class="form-group">
                                            <label for="company" class=" form-control-label">Candidate Name</label>
                                            <input type="text" value="<%=candidate.getCandidateName() %>"  placeholder="Enter your name" class="form-control" readonly>
                                        </div>
                                        <div class="form-group">
                                            <label for="vat" class=" form-control-label">Candidate Email Address</label>
                                            <input type="text" value="<%=candidate.getCandidateEmail() %>" readonly="readonly" placeholder="Email Address" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label for="vat" class=" form-control-label">Contact Number</label>
                                            <input type="text" value="<%=candidate.getCandidateContact()%>"  name="candidateContact" placeholder="Contact Number" class="form-control" required  maxlength="10" pattern="[0-9]{10,10}">
                                        </div>
                                       
                                        <div class="form-group">
                                            <label for="country" class=" form-control-label">Summary</label>
                                            <textarea name="candidateSummary" rows="9"  class="form-control" required><%=candidate.getCandidateSummary()%></textarea>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="vat" class=" form-control-label">Experience</label>
                                            <input type="text" value="<%=candidate.getCandidateExperience()%>"  name="candidateExperience" class="form-control" required>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="country" class=" form-control-label">Skills</label>
                                            <textarea name="candidateSkills" rows="2"  class="form-control" required><%=candidate.getCandidateSkills()%></textarea>
                                        </div>
                                        
                                        <div class="form-group">
                                    		<label>Update Profile Picture</label>
                                    		<input class="btn btn-outline-secondary au-btn--block" type="file" name="profile" id="profile">
                               			</div>
                               			<div class="form-group">
                                    		<label>Upload Resume</label>
                                    		<input class="btn btn-outline-secondary au-btn--block" type="file" name="resume" id="resume">
                               			</div>
                                    </div>
                                    <div class="card-footer">
                                        <button type="submit" class="btn btn-primary btn-sm">
                                            <i class="fa fa-dot-circle-o"></i> Update
                                        </button>
                                        <a href="CandidateHome" class="btn btn-danger btn-sm"> <i class="fa fa-ban"></i>Cancel</a>
                                    </div>
                                </div>
                                </form>
                            </div>
                </div>
            </div>
            <!-- END MAIN CONTENT-->
            <!-- END PAGE CONTAINER-->
        </div>

    </div>


