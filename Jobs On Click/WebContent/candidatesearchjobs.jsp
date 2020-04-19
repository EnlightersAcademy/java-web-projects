<%@page import="java.util.List"%>
<%@page import="com.jobsonclick.models.Jobs"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="candidateheader.jsp" /> 

            <!-- MAIN CONTENT-->
     <div class="main-content">
      <div class="section__content section__content--p30">
                    <div class="container-fluid">
		<form class="form-header" action="SearchJobs" method="POST">
                                <input class="au-input au-input--xl" type="text" name="skills" placeholder="Search by Skills e.g. Java, Web, C++" />
                                <button class="au-btn--submit" type="submit">
                                    <i class="zmdi zmdi-search"></i>
                                </button>
                            </form>
                
                            	<% if(request.getParameter("searched").equals("true")){
                            		if(request.getAttribute("jobsList")==null){
                            		%>
                            
                            	 <div class="table-responsive m-b-40" style="text-align: center; padding-top: 150px; color: #AEB6BF;">
                                    <strong >No Jobs Found with matching skills</strong>
                                </div>
                                <%
                            		}
                                else{
                                	List<Jobs> jobsList = (List<Jobs>)request.getAttribute("jobsList");
                                	%>
                                	<div class="overview-wrap">
                                    	<strong>Total <%=jobsList.size() %> Jobs Found</strong>
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
                                                <th>Skills</th> 
                                                <th></th>                                 
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<%
                                        		
                                        		for(Jobs job:jobsList){
                                       		 %>
                                            	<form action="CandidateViewJob" method="get">
                                            	<tr>
                                                	<td><%=job.getJobId() %></td>
                                                	<td><%=job.getJobTitle() %></td>
                                                	<td><%=job.getCompany().getCompanyName()%></td>
                                                	<td><%=job.getJobSkills()%></td>
                                                	<td><input hidden="true" value="<%=job.getJobId() %>" name="jobId"/> <button style="float: right;" type="submit" class="btn btn-primary btn-sm" >View Details</button></td>
                                           		</tr></form>
                                            <%
                                        	}
                                            %>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- END DATA TABLE-->
                              <% }
                            	}
                                %>
 
                         
                            </div>
                            </div>