<jsp:include page="userHeader.jsp"/>

<br/><br/>

<section class="statistic">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                    
                    	<div class="card">
                                    <div class="card-header">
                                        <strong>Change Password</strong>
                                    </div>
                                    <div class="card-body card-block">
                                    	<form method="post" action="">
	                                        <div class="form-group">
	                                            <label class=" form-control-label">Current Password</label>
	                                            <input type="password" name="currentpassword" placeholder="Enter Your Current Password" class="form-control">
	                                        </div>
	                                        <div class="form-group">
	                                            <label class=" form-control-label">New Password</label>
	                                            <input type="password" name="newpassword" placeholder="Enter Your New Password" class="form-control">
	                                        </div>
	                                        
	                                        <button class="au-btn au-btn--block au-btn--green m-b-20" style="width: 50%; margin: auto;" type="submit">UPDATE</button>	                                        
                                        </form>
                                    </div>
                                </div>
                    
                    </div>
                </div>
</section>