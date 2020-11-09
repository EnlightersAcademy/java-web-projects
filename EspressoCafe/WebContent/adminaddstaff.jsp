<%@ include file="adminheader.jsp"%>
<%@page import="com.espresso.util.EspressoUtil"%>


<%
	if(EspressoUtil.isResponseSuccess(request) != -1) {
		int status = EspressoUtil.isResponseSuccess(request);
		if( status == 0) {
			%>
			alert("Successfully added Staff details")
			<%
		} else if (status == 1){
			%>
			alert("Failed to add the new Staff details. Please retry again")
			<%
		} else if(status == 2) {
			%>
			alert("Staff with the provided Email Id already exist. Please verify the provided details")
			<%
		}
	}

%>

<div class="row" style="margin-top: 20px;">

	<div class="col-md-2"></div>
	
    <div class="col-md-8">
        <div class="card shadow-lg border-0 rounded-lg mt-5">
            <div class="card-header"><h3 class="text-center font-weight-light my-4"><i class="fas fa-user-plus"></i> Add New Staff</h3></div>
            <div class="card-body">
                <form method="post" action="staff">
                    <div class="form-row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="small mb-1" for="name">Name</label>
                                <input class="form-control" id="name" type="text" placeholder="Enter User Name" required />
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="small mb-1" for="mobile">Mobile</label>
                                <input class="form-control" id="mobile" type="text" pattern="[0-9]{10}" placeholder="Enter Mobile Number" required />
                            </div>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label class="small mb-1" for="email">Email <span style="color: red; font-size: x-small;">(Used for Login by the Staff)</span></label>
                        <input class="form-control" id="email" type="email" placeholder="Enter E-Mail Address" required />
                    </div>
                    
                    <div class="form-row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="small mb-1" for="gender">Gender</label>
                                <select class="form-control" id="gender" required>
							        <option selected>Select</option>
							        <option value="Male">Male</option>
							        <option value="Female">Female</option>
							        <option value="Other">Other</option>
							      </select>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
		                        <label class="small mb-1" for="email">Date of Birth</label>
		                        <input type="date" class="form-control" id="dob" placeholder="Enter Date of Birth" required>
		                    </div>
                        </div>
                    </div>
                    
                    
                    <div class="form-group">
                        <label class="small mb-1" for="address">Address</label>
                        <textarea rows="2" cols="50" class="form-control" id="address" placeholder="Enter Address" required></textarea>
                    </div>
                    <div class="form-row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="small mb-1" for="idtype">ID Type</label>
                                <select class="form-control" id="idtype" required>
							        <option selected>Select</option>
							        <option value="Aadhar Card">Aadhar Card</option>
							        <option value="Passport">Passport</option>
							        <option value="Driving License">Driving License</option>
							        <option value="Voter Id">Voter Id</option>
							      </select>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="small mb-1" for="idnumber">ID Number</label>
                                <input class="form-control" id="idnumber" type="text" placeholder="Enter ID Number" required />
                            </div>
                        </div>
                    </div>
                    <div class="form-group mt-4 mb-0">
                    	<input type="submit" class="btn btn-success btn-block" value="Add Staff" />
					</div>
                </form>
            </div>
        </div>
    </div>
    
    <div class="col-md-2"></div>
</div>



<%@ include file="adminfooter.jsp"%>