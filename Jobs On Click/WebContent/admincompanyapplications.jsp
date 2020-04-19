<%@page import="java.util.Base64"%>
<%@page import="com.jobsonclick.models.Company"%>
<%@page import="java.util.List"%>
<%@page import="com.jobsonclick.models.Jobs"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="adminheader.jsp" /> 

            <!-- MAIN CONTENT-->
     <div class="main-content">
      <div class="section__content section__content--p30">
                    <div class="container-fluid">
	
                
                            	<% 
                            		if(request.getAttribute("companyList")==null){
                            		%>
                            
                            	 <div class="table-responsive m-b-40" style="text-align: center; padding-top: 150px; color: #AEB6BF;">
                                    <strong >No Company Registration Requests</strong>
                                </div>
                                <%
                            		}
                                else{
                                	List<Company> companyList = (List<Company>)request.getAttribute("companyList");
                                	%>
                                	<div class="overview-wrap">
                                    	<strong>Total <%=companyList.size() %> Companies Requests Found!</strong>
                                	</div>
                                	<br/>
                                	<!-- DATA TABLE-->
                                <div class="table-responsive m-b-40">

					<div class="accordion md-accordion" id="accordionEx" role="tablist"
						aria-multiselectable="true">
						
						<%
							
							int i =1;
							
							for(Company company : companyList){
				                String base64Image = Base64.getEncoder().encodeToString(company.getLogo()); //Base64.getEncoder().encodeToString(imageBytes);
							%>
							
						<!-- Accordion card -->
						<div class="card">

							<!-- Card header -->
							<div class="card-header" role="tab" id="headingOne<%=i %>">
								<a style="float: right;" data-toggle="collapse" data-parent="#accordionEx"
									href="#collapseOne<%=i %>" aria-expanded="true"
									aria-controls="collapseOne<%=i %>">
									<i  class="fas fa-angle-down rotate-icon"></i>
									
								</a>
								<h5 class="mb-0">
										Company ID: <%=company.getCompanyId() %> - <%=company.getCompanyName() %> 
										<span>
											<a href="ApproveCompany?companyId=<%=company.getCompanyId() %>" class="btn btn-success btn-sm">Approve</a>
											<a href="RejectCompany?companyId=<%=company.getCompanyId() %>" class="btn btn-danger btn-sm">Reject</a>
										</span>
										
									</h5>
							</div>

							<!-- Card body -->
							<div id="collapseOne<%=i %>" class="collapse" role="tabpanel"
								aria-labelledby="headingOne<%=i %>" data-parent="#accordionEx">
								<div class="card-body">
									<div class="mx-auto d-block">
                                            <img class="mx-auto d-block" width="150px;" height="150px;" src="data:image/jpg;base64,<%=base64Image %>" alt="Card image cap">
                                            <h5 class="text-sm-center mt-2 mb-1"><%=company.getCompanyName() %></h5>
                                            <div class="location text-sm-center"> <%=company.getCompanyDescription() %></div>
                                            <div class="location text-sm-center"><i>Email Id: <%=company.getCompanyEmail()%></i></div>
                                        </div>
								</div>
							</div>

						</div>
						<!-- Accordion card -->	
						<%	
							i++;
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