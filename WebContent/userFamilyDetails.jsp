<jsp:include page="userHeader.jsp"/>

<br/><br/>

<section class="statistic">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                    
                    	<div class="card">
                                    <div class="card-header">
                                        <strong>Family</strong>
                                        <small> Details</small>
                                    </div>
                                    <div class="card-body card-block">
                                    	<form method="post" action="">
	                                        <div class="form-group">
	                                            <label class=" form-control-label">Family Type</label>
	                                            <select name="familytype" class="form-control">
	                                            	<option value="Nuclear Family">Nuclear Family</option>
	                                            	<option value="Joint Family">Joint Family</option>
	                                            	<option value="Staying Single">Staying Single</option>
	                                            </select>
	                                        </div>
	                                        <div class="form-group">
	                                            <label class=" form-control-label">Siblings</label>
	                                            <input type="text" name="siblings" placeholder="Details About Siblings" class="form-control">
	                                        </div>
	                                        
	                                        <button class="au-btn au-btn--block au-btn--green m-b-20" style="width: 50%; margin: auto;" type="submit">UPDATE</button>	                                        
                                        </form>
                                    </div>
                                </div>
                    
                    </div>
                </div>
</section>