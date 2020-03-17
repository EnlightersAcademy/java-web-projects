<jsp:include page="userHeader.jsp"/>

<br/><br/>

<section class="statistic">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                    
                    	<div class="card">
                                    <div class="card-header">
                                        <strong>Professional</strong>
                                        <small> Details</small>
                                    </div>
                                    <div class="card-body card-block">
                                    	<form method="post" action="">
	                                        <div class="form-group">
	                                            <label class=" form-control-label">Profession</label>
	                                            <input type="text" name="profession" placeholder="Profession" class="form-control">
	                                        </div>
	                                        <div class="form-group">
	                                            <label class=" form-control-label">Company</label>
	                                            <input type="text" name="company" placeholder="Company Working In" class="form-control">
	                                        </div>
	                                        <div class="form-group">
	                                            <label class=" form-control-label">Salary</label>
	                                            <input type="text" name="salary" placeholder="Salary in Rs." class="form-control">
	                                        </div>
	                                        <div class="form-group">
	                                            <label class=" form-control-label">Highest Qualification</label>
	                                            <input type="text" name="qualification" placeholder="Highest Qualification (Completed/Persuing)" class="form-control">
	                                        </div>
	                                        
	                                        <button class="au-btn au-btn--block au-btn--green m-b-20" style="width: 50%; margin: auto;" type="submit">UPDATE</button>	                                        
                                        </form>
                                    </div>
                                </div>
                    
                    </div>
                </div>
</section>