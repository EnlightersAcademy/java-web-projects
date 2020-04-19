<%@page import="com.jobsonclick.models.Jobs"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="companyheader.jsp" /> 

            <!-- MAIN CONTENT-->
     <div class="main-content">
        
                <% 
                       String message = (String)request.getAttribute("message");
                        if(request.getAttribute("message")!=null)
                        { %>
                        <div class="alert alert-info" role="alert">
							<%=message %>
						</div>
						<%	} 
				%>
     
     <!-- Material form subscription -->
<div class="card">
<%
	String type = request.getParameter("type");
	Jobs job = (Jobs) request.getAttribute("job");
	
%>

    <h5 class="card-header text-center py-4" style="background-color: #17a2b8; color: white;">
        <strong>Job ID: <%=job.getJobId() %></strong>
    </h5>
 <div class="container">
    <!--Card content-->
    <div class="card-body px-lg-5">
    	
    	<%
    		if(request.getParameter("type").equalsIgnoreCase("active")){
    	%>
    	
        <!-- Active Jobs Form -->
        <form class="text-center" style="color: #757575;" action="SaveUpdateJob" method="post">

						
          						<div class="form-group">
                                    <label>Job Title</label>
                                    <input required="required" value = "<%=job.getJobTitle() %>" class="au-input au-input--full" type="text" name="jobTitle" placeholder="Title">
                                </div>
                                <div class="form-group">
                                    <label>Job Description</label>
                                    <textarea required="required"  class="au-input au-input--full" name="jobDescription" placeholder="Job Description"><%=job.getJobDescription() %></textarea>
                                </div>
                                <div class="form-group">
                                    <label>Salary in INR</label>
                                    <input value = "<%=job.getSalary()%>"  class="au-input au-input--full" type="text" name="salary" placeholder="E.g 30000-40000">
                                </div>
                                <div class="form-group">
                                    <label>Experience Required</label>
                                    <input required="required" value = "<%=job.getExperienceRequired()%>"  class="au-input au-input--full" type="text" name="experienceRequired" placeholder="E.g. 3-5">
                                </div>
                                <div class="form-group">
                                    <label>Job Skills</label>
                                    <input required="required" value = "<%=job.getJobSkills()%>"  class="au-input au-input--full" type="text" name="jobSkills" placeholder="Skills Required like C, Java, Web">
                                </div>

            <!-- Sign in button -->
            <input type="hidden" name="page" value="edit"/>
            <input type="hidden" name="jobId" value="<%=job.getJobId()%>"/>
            <button class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect" type="submit">Update</button>
            <a class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect" href="ViewJobs?type=<%=request.getParameter("type")%>">Back</a>
        </form>
        <!-- Form -->
        
        <%
    		}
    		else{
    	%>	
    	 <!--  Expired Jobs Form -->
        <form class="text-center" style="color: #757575;">

						
          						<div class="form-group">
                                    <label>Job Title</label>
                                    <input readonly="readonly" value = "<%=job.getJobTitle() %>" class="au-input au-input--full" type="text" name="jobTitle" placeholder="Title">
                                </div>
                                <div class="form-group">
                                    <label>Job Description</label>
                                    <textarea readonly="readonly" class="au-input au-input--full" name="jobDescription" placeholder="Job Description"><%=job.getJobDescription() %></textarea>
                                </div>
                                <div class="form-group">
                                    <label>Salary in INR</label>
                                    <input readonly="readonly" value = "<%=job.getSalary()%>"  class="au-input au-input--full" type="text" name="salary" placeholder="E.g 30000-40000">
                                </div>
                                <div class="form-group">
                                    <label>Experience Required</label>
                                    <input readonly="readonly" value = "<%=job.getExperienceRequired()%>"  class="au-input au-input--full" type="text" name="experienceRequired" placeholder="E.g. 3-5">
                                </div>
                                <div class="form-group">
                                    <label>Job Skills</label>
                                    <input readonly="readonly" value = "<%=job.getJobSkills()%>"  class="au-input au-input--full" type="text" name="jobSkills" placeholder="Skills Required like C, Java, Web">
                                </div>

            <!-- Sign in button -->
            <a class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect" href="ViewJobs?type=<%=request.getParameter("type")%>">Back</a>
        </form>
        <!-- Form -->
    			
    	<%
    		}
        %>

</div>
    </div>
    </div>

</div>
<!-- Material form subscription -->