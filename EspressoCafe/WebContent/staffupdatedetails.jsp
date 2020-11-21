<%@ include file="staffheader.jsp"%>

<div class="row" style="margin-top: 20px;">

	<div class="col-md-2"></div>
	
    <div class="col-md-8">
        <div class="card shadow-lg border-0 rounded-lg mt-5">
            <div class="card-header"><h3 class="text-center font-weight-light my-4"><i class="fas fa-user-circle"></i> Personal Details</h3></div>
            <div class="card-body">
                <form>
                    <div class="form-row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="small mb-1" for="name">Name</label>
                                <input class="form-control" name="name" id="name" type="text" placeholder="Enter User Name" required />
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="small mb-1" for="mobile">Mobile</label>
                                <input class="form-control" name="mobile" id="mobile" type="text" pattern="[0-9]{10}" placeholder="Enter Mobile Number" required />
                            </div>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label class="small mb-1" for="email">Email</label>
                        <input class="form-control" name="email" id="email" type="email" placeholder="Enter E-Mail Address" readonly />
                    </div>
                    
                    <div class="form-row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="small mb-1" for="gender">Gender</label>
                                <select class="form-control" name="gender" id="gender" required>
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
		                        <input type="date" class="form-control" name="dob" id="dob" placeholder="Enter Date of Birth" required>
		                    </div>
                        </div>
                    </div>
                    
                    
                    <div class="form-group">
                        <label class="small mb-1" for="address">Address</label>
                        <textarea rows="2" cols="50" class="form-control" name="address" id="address" placeholder="Enter Address" required></textarea>
                    </div>
                    <div class="form-row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="small mb-1" for="idtype">ID Type</label>
                                <input class="form-control" name="idtype" id="idtype" type="text" placeholder="Enter ID Type - Aadhaar, PAN, etc." required />
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="small mb-1" for="idnumber">ID Number</label>
                                <input class="form-control" name="idnumber" id="idnumber" type="text" placeholder="Enter ID Number" required />
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