<jsp:include page="userHeader.jsp"/>

<br/><br/>

<section class="statistic">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                    
                    	<div class="card">
                                    <div class="card-header">
                                        <strong>Lifestyle</strong>
                                        <small> Details</small>
                                    </div>
                                    <div class="card-body card-block">
                                    	<form method="post" action="">
	                                        <div class="form-group">
	                                            <label class=" form-control-label">Hobbies</label>
	                                            <input type="text" name="hobbies" placeholder="List of Hobbies" class="form-control">
	                                        </div>
	                                        <div class="form-group">
	                                            <label class=" form-control-label">Smoking Habit</label>
	                                            <select name="smoking" class="form-control">
	                                            	<option>Never Smokes</option>
	                                            	<option>Occasionally Smokes</option>
	                                            	<option>Regularly Smokes</option>
	                                            </select>
	                                        </div>
	                                        <div class="form-group">
	                                            <label class=" form-control-label">Drinking Habit</label>
	                                            <select name="drinking" class="form-control">
	                                            	<option>Never Drinks</option>
	                                            	<option>Occasionally Drinks</option>
	                                            	<option>Regularly Drinks</option>
	                                            </select>
	                                        </div>
	                                        
	                                        <button class="au-btn au-btn--block au-btn--green m-b-20" style="width: 50%; margin: auto;" type="submit">UPDATE</button>	                                        
                                        </form>
                                    </div>
                                </div>
                    </div>
                </div>
</section>