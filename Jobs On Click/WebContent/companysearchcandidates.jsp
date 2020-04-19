<%@page import="com.jobsonclick.models.Candidate"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="companyheader.jsp" /> 

            <!-- MAIN CONTENT-->
     <div class="main-content">
      <div class="section__content section__content--p30">
                    <div class="container-fluid">
		<form class="form-header" action="SearchCandidates" method="POST">
                                <input class="au-input au-input--xl" type="text" name="skills" placeholder="Search by Skills e.g. Java, Web, C++" />
                                <button class="au-btn--submit" type="submit">
                                    <i class="zmdi zmdi-search"></i>
                                </button>
                            </form>
                
                            	<% if(request.getParameter("searched").equals("true")){
                            		if(request.getAttribute("candidateList")==null){
                            		%>
                            
                            	 <div class="table-responsive m-b-40" style="text-align: center; padding-top: 150px; color: #AEB6BF;">
                                    <strong >No Candidates Found with matching skills</strong>
                                </div>
                                <%
                            		}
                                else{
                                	List<Candidate> candidateList = (List<Candidate>)request.getAttribute("candidateList");
                                	%>
                                	<div class="overview-wrap">
                                    	<strong>Total <%=candidateList.size() %> Candidates Found</strong>
                                	</div>
                                	<!-- DATA TABLE-->
                                <div class="table-responsive m-b-40">
                                    <table class="table table-borderless table-data3">
                                        <thead>
                                            <tr>
                                                <th>Name</th>
                                                <th>Skills</th>
                                                <th>Experience</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<%
                                        		
                                        		for(Candidate candidate : candidateList){
                                       		 %>
                                            	<form action="ViewCandidate" method="get">
                                            	<tr>
                                                	<td><%=candidate.getCandidateName() %></td>
                                                	<td><%= candidate.getCandidateSkills()%></td>
                                                	<td><%=candidate.getCandidateExperience() %> years </td>
                                                	<td><input hidden="true" value="<%=candidate.getCandidateId() %>" name="candidateId"/> <button style="float: right;" type="submit" class="btn btn-primary btn-sm" >View Details</button></td>
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