<%@page import="com.jobsonclick.models.Jobs"%>
<%@page import="java.util.List"%>
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
                
                   <div class="row m-t-30">
                            <div class="col-md-12">
                            	<div class="overview-wrap">
                                    <strong><%=(request.getParameter("type").equalsIgnoreCase("active"))?"Active Openings":"Expired Openings" %></strong>                 
                                </div>
                                
                                <!-- For Active Openings -->
                                <%
                                	List<Jobs> activeJobsList = (List<Jobs>)request.getAttribute("activeJobsList");
                                	List<Jobs> expiredJobsList = (List<Jobs>)request.getAttribute("expiredJobsList");
                                	
                                	
                                	if(request.getParameter("type").equalsIgnoreCase("active")){
                                		if(activeJobsList==null) {
                                			%>
                                       	<div class="table-responsive m-b-40" style="text-align: center; padding-top: 150px; color: #AEB6BF;">
                                       	<strong>No Jobs Available</strong>
                                       	</div>
                                       	<%	
                                       	}
                                       	else{
                                       	%>	
                                        <!-- DATA TABLE-->
                                                           
                                	
                                	 <div class="table-responsive m-b-40">
                                    <table class="table table-borderless table-data3">
                                        <thead>
                                            <tr>
                                                <th>JobId</th>
                                                <th>Date Of Posting</th>
                                                <th>Job Title</th>
                                                <th>Job Skills</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<%
                                        		
                                        		for(Jobs job:activeJobsList){
                                        			// Display only Active Jobs
                                       		 %>
                                            	<tr>
                                                	<td><a href="EditJob?type=<%=request.getParameter("type")%>&jobId=<%=job.getJobId() %>">JobId: <%=job.getJobId() %></a></td>
                                                	<td><%=job.getDateOfPosting()%></td>
                                                	<td><%=job.getJobTitle() %></td>
                                                	<td><%=job.getJobSkills() %></td>
                                                	<td><a href="DeactivateJob?type=active&jobId=<%=job.getJobId()%>"class="btn btn-outline-info">Deactivate Job</a></td>
                                           		</tr>
                                            <%
                                        	}
                                            %>
                                        </tbody>
                                    </table>
                                   
                                </div>	
                                   <!-- END DATA TABLE-->     	                                     	
                                	<%	
                                	}
                                	}                               	
                                	else if(request.getParameter("type").equalsIgnoreCase("expired")){
                                 		if(expiredJobsList==null) {
                               		 %>                               
                                 <!-- For Expired Openings -->                             
                                       
                                       	<div class="table-responsive m-b-40" style="text-align: center; padding-top: 150px; color: #AEB6BF;">
                                       	<strong>No Jobs Available</strong>
                                       	</div>
                                       	<%	
                                       	}
                                       	else{
                                       	%>	
                                        <!-- DATA TABLE-->
                             	
                                	 <div class="table-responsive m-b-40">
                                    <table class="table table-borderless table-data3">
                                        <thead>
                                            <tr>
                                                <th>JobId</th>
                                                <th>Date Of Posting</th>
                                                <th>Job Title</th>
                                                <th>Job Skills</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<%
                                        		
                                        		for(Jobs job:expiredJobsList){
                                        			// Display only Expired Jobs
                                       		 %>
                                            	<tr>
                                                	<td><a href="EditJob?type=expired&jobId=<%=job.getJobId() %>">JobId: <%=job.getJobId() %></a></td>
                                                	<td><%=job.getDateOfPosting()%></td>
                                                	<td><%=job.getJobTitle() %></td>
                                                	<td><%=job.getJobSkills() %></td>
                                           		</tr>
                                            <%
                                        	}
                                            %>
                                        </tbody>
                                    </table>
                                   
                                </div>	
                                   <!-- END DATA TABLE-->     	                                     	
                                	<%	
                                	}
                                	}
                                %>
                                                                                           
                            </div>
                        </div>
                </div>
            </div>
            <!-- END MAIN CONTENT-->
            <!-- END PAGE CONTAINER-->
        </div>

    </div>


