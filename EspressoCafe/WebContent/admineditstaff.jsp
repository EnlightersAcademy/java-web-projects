<%@ include file="adminheader.jsp"%>

<div class="row" style="margin-top: 20px;">

	<div class="col-md-2"></div>
	
    <div class="col-md-8">
        <div class="card shadow-lg border-0 rounded-lg mt-5">
            <div class="card-header"><h3 class="text-center font-weight-light my-4"><i class="fas fa-user-edit"></i> Edit Staff Details</h3></div>
            <div class="card-body">
                <form method="post" action="">
                    <div class="form-row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="small mb-1" for="name">Name</label>
                                <input class="form-control" id="name" type="text" placeholder="Enter User Name" />
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="small mb-1" for="mobile">Mobile</label>
                                <input class="form-control" id="mobile" type="text" pattern="[0-9]{10}" placeholder="Enter Mobile Number" />
                            </div>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label class="small mb-1" for="email">Email</label>
                        <input class="form-control" id="email" type="email" placeholder="Enter E-Mail Address" readonly />
                    </div>
                    
                    <div class="form-row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="small mb-1" for="gender">Gender</label>
                                <select class="form-control" id="gender">
							        <option selected>Select</option>
							        <option value="1">Male</option>
							        <option value="2">Female</option>
							        <option value="3">Others</option>
							      </select>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
		                        <label class="small mb-1" for="email">Date of Birth</label>
		                        <input type="date" class="form-control" id="dob" placeholder="Enter Date of Birth">
		                    </div>
                        </div>
                    </div>
                    
                    
                    <div class="form-group">
                        <label class="small mb-1" for="address">Address</label>
                        <textarea rows="2" cols="50" class="form-control" id="address" placeholder="Enter Address"></textarea>
                    </div>
                    <div class="form-row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="small mb-1" for="idtype">ID Type</label>
                                <input class="form-control" id="idtype" type="text" placeholder="Enter ID Type - Aadhaar, PAN, etc." />
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="small mb-1" for="idnumber">ID Number</label>
                                <input class="form-control" id="idnumber" type="text" placeholder="Enter ID Number" />
                            </div>
                        </div>
                    </div>
                    <div class="form-group mt-4 mb-0">
                    	<input type="submit" class="btn btn-success btn-block" value="Update Staff Details" />
					</div>
                </form>
            </div>
        </div>
    </div>
    
    <div class="col-md-2"></div>
</div>



<%@ include file="adminfooter.jsp"%>