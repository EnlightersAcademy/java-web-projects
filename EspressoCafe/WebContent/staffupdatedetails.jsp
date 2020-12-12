<%@ include file="staffheader.jsp"%>

<%@page import="com.espresso.util.EspressoUtil"%>


<%
	if(EspressoUtil.isResponseSuccess(request) != -1) {
		int status = EspressoUtil.isResponseSuccess(request);
		if( status == 0) {
			%>
			<script>
			alert("Successfully updated personal details")
			</script>
			<%
		} else if (status == 1){
			%>
			<script>
			alert("Error while updating personal details. Please retry again")
			</script>
			<%
		} 
	}
	Staff updateStaff = (Staff)request.getSession().getAttribute("staff");

%> 
<div class="row" style="margin-top: 20px;">

	<div class="col-md-2"></div>
	
    <div class="col-md-8">
        <div class="card shadow-lg border-0 rounded-lg mt-5">
            <div class="card-header"><h3 class="text-center font-weight-light my-4"><i class="fas fa-user-circle"></i> Personal Details</h3></div>
            <div class="card-body">
                <form method="post" action="staff?update=true&staff=true">
                    <div class="form-row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="small mb-1" for="name">Name</label>
                                <input class="form-control" name="name" id="name" type="text" value="<%=updateStaff.getName() %>" placeholder="Enter User Name" required />
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="small mb-1" for="mobile">Mobile</label>
                                <input class="form-control" name="mobile" id="mobile" type="text" pattern="[0-9]{10}" value="<%=updateStaff.getPhoneNo() %>" placeholder="Enter Mobile Number" required />
                            </div>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label class="small mb-1" for="email">Email</label>
                        <input class="form-control" name="email" id="email" type="email" value="<%=updateStaff.getEmailId() %>" placeholder="Enter E-Mail Address" readonly />
                    </div>
                    
                    <div class="form-row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="small mb-1" for="gender">Gender</label>
                                <select
									class="form-control" name="gender" id="gender">
									<%
									switch(staff.getGender()) {
									
									case "Male":
										%> 
										<option value="Male" selected>Male</option>
										<option value="Female">Female</option>
										<option value="Other">Other</option>
										<% 
										break;
									case "Female":
										%> 
										<option value="Male" >Male</option>
										<option value="Female" selected>Female</option>
										<option value="Other">Other</option>
										<% 
										break;
									case "Other":
										%> 
										<option value="Male" >Male</option>
										<option value="Female">Female</option>
										<option value="Other" selected>Other</option>
										<% 
										break;
									}
									%>
								</select>
                                
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
		                        <label class="small mb-1" for="email">Date of Birth</label>
		                        <input type="date" class="form-control" name="dob" id="dob" value="<%=updateStaff.getDob() %>"placeholder="Enter Date of Birth" required>
		                    </div>
                        </div>
                    </div>
                    
                    
                    <div class="form-group">
                        <label class="small mb-1" for="address">Address</label>
                        <textarea rows="2" cols="50" class="form-control" name="address" id="address"  placeholder="Enter Address" required><%=updateStaff.getAddress() %></textarea>
                    </div>
                    <div class="form-row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="small mb-1" for="idtype">ID Type</label>
                                <input class="form-control" name="idtype" id="idtype" type="text" value=<%=updateStaff.getIdType()%> placeholder="Enter ID Type - Aadhaar, PAN, etc." readonly />
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="small mb-1" for="idnumber">ID Number</label>
                                <input class="form-control" name="idnumber" id="idnumber" value=<%=updateStaff.getIdentification() %> type="text" placeholder="Enter ID Number" readonly />
                            </div>
                        </div>
                    </div>
                    <div class="form-group mt-4 mb-0">
                    	<input type="submit" class="btn btn-success btn-block" value="Update Details" />
					</div>
                </form>
            </div>
        </div>
    </div>
    
    <div class="col-md-2"></div>

</div>



<%@ include file="stafffooter.jsp"%>