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
                            		List<Jobs> jobsList = (List<Jobs>)request.getAttribute("jobList");
                            		if(jobsList.size() == 0){
                            		%>
                            
                            	 <div class="table-responsive m-b-40" style="text-align: center; padding-top: 150px; color: #AEB6BF;">
                                    <strong >No Jobs Found</strong>
                                </div>
                                <%
                            		}
                                else{
                                	%>
                                	<div class="overview-wrap">
                                    	<strong>Companies Found : <%=jobsList.size() %> </strong>
                                	</div>
                                	<br/>
                                	<!-- DATA TABLE-->
                                <div class="table-responsive m-b-40">
                                    <table class="table table-borderless table-data3">
                                        <thead>
                                            <tr>
                                                <th>JobId</th>
                                                <th>Job Title</th>
                                                <th>CompanyName</th>
                                                <th>Experience</th> 
                                                <th>Salary</th>
                                                <th>Status</th>                             
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<%
                                        		
                                        		for(Jobs job:jobsList){
                                       		 %>
                                            	
                                            	<tr>
                                                	<td><%=job.getJobId() %></td>
                                                	<td><%=job.getJobTitle() %></td>
                                                	<td><%=job.getCompany().getCompanyName()%></td>
                                                	<td><%=job.getExperienceRequired()%></td>
                                                	<td><%=job.getSalary()%></td>
                                                	<td><%=job.isExpired()?"Expired":"Active"%></td>
                                               
                                           		</tr>
                                            <%
                                        	}
                                            %>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- END DATA TABLE-->
                              <% }
                            	
                                %>
 
                         
                            </div>
                            </div>