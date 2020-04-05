<jsp:include page="userHeader.jsp"/>

<br/><br/>

<section class="statistic">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                    
                    	<div class="card">
                                    <div class="card-header">
                                        <strong>Basic</strong>
                                        <small> Details</small>
                                    </div>
                                    <div class="card-body card-block">
                                    	<form method="post" action="">
	                                        <div class="form-group">
	                                            <label class=" form-control-label">Email</label>
	                                            <input type="text" name="email" placeholder="Email ID" class="form-control" readonly>
	                                        </div>
	                                        <div class="form-group">
	                                            <label class=" form-control-label">Phone<span style="color: red;">*</span></label>
	                                            <input type="text" name="phone" placeholder="Phone Number" class="form-control" maxlength="10" required>
	                                        </div>
	                                        <div class="form-group">
	                                            <label class=" form-control-label">Age</label>
	                                            <input type="text" name="age" placeholder="Age" class="form-control" maxlength="3" required>
	                                        </div>
	                                        <div class="form-group">
	                                            <label class=" form-control-label">Height</label>
	                                            <input type="text" name="height" placeholder="Height in Feet" class="form-control">
	                                        </div>
	                                        <div class="form-group">
	                                            <label class=" form-control-label">Weight</label>
	                                            <input type="text" name="weight" placeholder="Weight in Kgs" class="form-control">
	                                        </div>
	                                        <div class="form-group">
	                                            <label class=" form-control-label">City<span style="color: red;">*</span></label>
	                                            <input type="text" name="city" placeholder="City of Residence" class="form-control" required>
	                                        </div>
	                                        <div class="form-group">
	                                            <label class=" form-control-label">Mother Tongue</label>
	                                            <input type="text" name="mothertongue" placeholder="Mother Tongue Language" class="form-control">
	                                        </div>
	                                        
	                                        <button class="au-btn au-btn--block au-btn--green m-b-20" style="width: 50%; margin: auto;" type="submit">UPDATE</button>	                                        
                                        </form>
                                    </div>
                                </div>
                    
                    </div>
                </div>
</section>