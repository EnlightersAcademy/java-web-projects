<%@page import="com.jobsonclick.models.Company"%>
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
                        
                        Company company = (Company) session.getAttribute("company");
				%>
                
                    <div class="col-lg-10">
                   			 
                   			 <form action="UpdateCompanyProfile" method="post" enctype="multipart/form-data">
                                <div class="card">
                                    <div class="card-header" style="background-color: #0099FF; color: white;">
                                        <strong>Update Profile</strong>
                                        
                                    </div>
                                    <div class="card-body card-block">
                                    
                                        <div class="form-group">
                                            <label for="company" class=" form-control-label">Company Name</label>
                                            <input type="text" value="<%=company.getCompanyName()%>" name ="companyName" placeholder="Enter your company name" class="form-control" readonly>
                                        </div>
                                        <div class="form-group">
                                            <label for="vat" class=" form-control-label">Company Email Address</label>
                                            <input type="text" value="<%=company.getCompanyEmail()%>" readonly="readonly" placeholder="DE1234567890" class="form-control">
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="country" class=" form-control-label">Company Description</label>
                                            <textarea name="companyDescription" rows="9" required  class="form-control"><%=company.getCompanyDescription() %></textarea>
                                        </div>
                                        
                                        <div class="form-group">
                                    		<label>Update Company Logo</label>
                                    		<input class="btn btn-outline-secondary au-btn--block" type="file" name="logo" id="logo">
                               			</div>
                                    </div>
                                    <div class="card-footer">
                                        <button type="submit" class="btn btn-primary btn-sm">
                                            <i class="fa fa-dot-circle-o"></i> Update
                                        </button>
                                        <a href="CompanyHome" class="btn btn-danger btn-sm"> <i class="fa fa-ban"></i>Cancel</a>
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


