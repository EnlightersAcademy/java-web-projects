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
<div class="card col-lg-8" style="margin-left: 15%;" >

    <h5 class="card-header text-center py-4" style="background-color: #17a2b8; color: white;">
        <strong>Add new Opening</strong>
    </h5>
 <div class="container">
    <!--Card content-->
    <div class="card-body px-lg-5 ">
    
        <!-- Form -->
        <form class="text-center" style="color: #757575;" action="SaveUpdateJob" method="post">
								
						<input type="hidden" name="page" value="add"/>
          						<div class="form-group">
                                    <label>Job Title</label>
                                    <input required="required" class="au-input au-input--full" type="text" name="jobTitle" placeholder="Job title">
                                </div>
                                <div class="form-group">
                                    <label>Job Description</label>
                                    <textarea required="required" class="au-input au-input--full" name="jobDescription" placeholder="Job Description"></textarea>
                                </div>
                                <div class="form-group">
                                    <label>Salary</label>
                                    <input class="au-input au-input--full" type="text" name="salary" placeholder="Salary e.g. 5000-10000">
                                </div>
                                <div class="form-group">
                                    <label>Experience Required</label>
                                    <input required="required" class="au-input au-input--full" type="text" name="experienceRequired" placeholder="Experience Required">
                                </div>
                                <div class="form-group">
                                    <label>Job Skills</label>
                                    <input required="required" class="au-input au-input--full" type="text" name="jobSkills" placeholder="Skills Required e.g. c, java, web">
                                </div>

            <!-- Sign in button -->
            <input type="hidden" name="page" value="add"/>
            <button class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect" type="submit">Add Job</button>
        </form>
        <!-- Form -->

</div>
    </div>
    </div>

</div>
<!-- Material form subscription -->