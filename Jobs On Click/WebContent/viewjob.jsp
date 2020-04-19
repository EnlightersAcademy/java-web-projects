<%@page import="com.jobsonclick.models.Jobs"%>
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
				%>
                
                    <div class="col-lg-10">
                   			 
                   			 <%
                                 Jobs job = (Jobs)request.getAttribute("job");
                             %>
                   			 
                                <div class="card">
                                <form action="CandidateApplyJob" method="post" >
                                    <div class="card-header" style="background-color: #0099FF; color: white;">
                                        <strong>Job Id: <%=job.getJobId() %>  <span style="float: right;">Job Posted On: <%=job.getDateOfPosting()%></span></strong>
                                        
                                    </div>
                                    <div class="card-body card-block">
                                    	
                                        <div class="form-group">
                                            <label for="company" class=" form-control-label">Job Title</label>
                                            <input type="text" value="<%= job.getJobTitle()%>" readonly="readonly"  placeholder="Enter your company name" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label for="vat" class=" form-control-label">Company Name</label>
                                            <input type="text" readonly="readonly" value="<%=job.getCompany().getCompanyName() %>" readonly="readonly"  placeholder="DE1234567890" class="form-control">
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="vat" class=" form-control-label">Salary in INR</label>
                                            <input type="text" readonly="readonly" value="<%= job.getSalary()%>" readonly="readonly"  placeholder="DE1234567890" class="form-control">
                                        </div>
                                       
                                        <div class="form-group">
                                            <label for="country" class=" form-control-label">Description</label>
                                            <textarea  readonly="readonly" rows="9"  class="form-control"><%= job.getJobDescription()%></textarea>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="country" class=" form-control-label">Skills Required</label>
                                            <textarea  readonly="readonly" rows="2"  class="form-control"><%= job.getJobSkills()%></textarea>
                                        </div>
                                        
                                        
                                        
                                    </div>
                                    <div class="card-footer">
                                    <%
                                    	boolean alreadyApplied = (boolean)request.getAttribute("alreadyApplied");
										System.out.println(request.getAttribute("alreadyApplied"));
                                    	if(alreadyApplied){
                                    	%>
                                    	<button  type="button" class="btn btn-secondary btn-sm">
                                            <i class="fa fa-dot-circle-o"> Applied</i> 
                                        </button>
                                    	<%	
                                    	}
                                    	else{
                                    		%>
                                    		<input type="hidden" name="jobId" value="<%=job.getJobId() %>"/>
                                    	<button type="submit" class="btn btn-primary btn-sm">
                                            <i class="fa fa-dot-circle-o"> Apply</i> 
                                        </button>
                                    	<%	
                                    	}
                                    %>
                                        
                       
                                    </div>
                                     </form>

                                </div>
                               
                            </div>
                </div>
            </div>
            <!-- END MAIN CONTENT-->
            <!-- END PAGE CONTAINER-->
        </div>

    </div>


