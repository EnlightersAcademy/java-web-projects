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
                        
                      
				%>
                
                    <div class="col-lg-10">
                   			
                   			 <form action="ChangePassword" method="post">
                                <div class="card">
                                    <div class="card-header" style="background-color: #0099FF; color: white;">
                                        <strong>Change Password</strong>
                                        
                                    </div>
                                    <div class="card-body card-block">
                                    
                                        <div class="form-group">
                                            <label for="company" class=" form-control-label">Current Password</label>
                                            <input type="password"  name ="oldpassword" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label for="company" class=" form-control-label">New Password</label>
                                            <input type="password"  name ="newpassword" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label for="company" class=" form-control-label">Confirm New Password</label>
                                            <input type="password"  name ="reenterpassword" class="form-control">
                                        </div>
                                        
                                    </div>
                                    <div class="card-footer">
                                     <input type="hidden" name="role" value="candidate"/>
                                        <button type="submit" class="btn btn-primary btn-sm">
                                            <i class="fa fa-dot-circle-o"></i> Update
                                        </button>
                                        <a href="CandidateHome" class="btn btn-danger btn-sm"> <i class="fa fa-ban"></i>Back</a>
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


