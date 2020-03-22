<jsp:include page="userHeader.jsp"/>

        <!-- PAGE CONTENT-->
        <div class="page-content--bgf7" style="height: 100%">

			<br/><br/>
        	
        	<div class="jumbotron" style="width: 50%; margin: auto;">
        		<h2 class="display-5">Update Account Details</h2>
			  	<br/>
	            <div class="login-form">
	            
	            	<!-- All the Data should be populated in these fields. Few fields we can keep readonly.  -->
	                            <form action="customer/update" method="post">
	                            	<div class="form-group">
	                                    <label>Name</label>
	                                    <input class="au-input au-input--full" type="text" name="name" readonly>
	                                </div>
	                                <div class="form-group">
	                                    <label>Date of Birth</label>
	                                    <input class="au-input au-input--full" type="text" name="dob" readonly>
	                                </div>
	                                <div class="form-group">
	                                    <label>Gender</label>
	                                    <input class="au-input au-input--full" type="text" name="gender" readonly>
	                                </div>
	                                <div class="form-group">
	                                    <label>Address</label>
	                                    <textarea class="au-input au-input--full" rows="2" cols="50"  name="address" required placeholder="Complete Address"></textarea>
	                                </div>
	                                <div class="form-group">
	                                    <label>Email Address</label>
	                                    <input class="au-input au-input--full" type="email" name="email" readonly>
	                                </div>
	                                <div class="form-group">
	                                    <label>Password</label>
	                                    <input class="au-input au-input--full" type="password" name="password"
	                                        required placeholder="Password">
	                                </div>
	                                <div class="form-group">
	                                    <label>Phone Number</label>
	                                    <input class="au-input au-input--full" type="text" name="phone" maxlength="10" required placeholder="Phone">
	                                </div>
	                                <div class="form-group">
	                                    <label>ID Number (Any Govt. Issued ID Card)</label>
	                                    <input class="au-input au-input--full" type="text" name="identityNumber" required placeholder="ID Number">
                                	</div>
	                                <button class="au-btn au-btn--block au-btn--green m-b-20"
	                                    type="submit">Update</button>
	                            </form>
                   </div>
            </div>
    	</div>
