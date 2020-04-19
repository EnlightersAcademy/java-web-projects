<%@page import="com.jobsonclick.models.Application"%>
<%@page import="java.util.List"%>
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
                
                   <div class="row m-t-30">
                            <div class="col-md-12">
                            	
                                <!-- DATA TABLE-->
                                
                                <%if(request.getAttribute("applicationList")==null) {
                                	%>
                                	 <div class="table-responsive m-b-40" style="text-align: center; padding-top: 150px; color: #AEB6BF;">
                                	<strong>No Jobs Applied yet!</strong>
                                	</div>
                                	<%	
                                	}
                                	else{
                                	%>
                                <div class="table-responsive m-b-40">
                                    <table class="table table-borderless table-data3">
                                        <thead>
                                            <tr>
                                                <th>JobId</th>
                                                <th>Company Name</th>
                                                <th>Status</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<%
                                        		List<Application> applicationList = (List<Application>)request.getAttribute("applicationList");
                                        		for(Application app : applicationList){
                                       		 %>
                                            	<tr>
                                                	<td>Job #<%=app.getJobId() %></td>
                                                	<td><%=app.getJob().getCompany().getCompanyName() %></td>
                                                	<td><%=app.getStatus().toUpperCase() %></td>
                                           		</tr>
                                            <%
                                  	      	}
                                            %>
                                        </tbody>
                                    </table>
                                    <%
                                	}
                                    %>
                                </div>
                                <!-- END DATA TABLE-->
                            </div>
                        </div>
                </div>
            </div>
            <!-- END MAIN CONTENT-->
            <!-- END PAGE CONTAINER-->
        </div>

    </div>


