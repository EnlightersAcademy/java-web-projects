<jsp:include page="userHeader.jsp"/>

<br/><br/>
                            
                            <div class="card"  style="margin:auto; margin-top:70px; width: 40%">
                                    <div class="card-header">
                                        <i class="fa fa-user"></i>
                                        <strong class="card-title pl-2">Profile Search</strong>
                                    </div>
                                    <div class="card-body">
                                    
                                    	<form method="post" action="userSearchResults.jsp">
	                                        <div class="mx-auto d-block">
	                                            <p style="text-align: right; color: #F1948A;">* Leave the fields blank, which you don't want to search.</p>
	                                        
		                                        <div class="form-group">
		                                            <label class=" form-control-label">Gender</label>
		                                            <select name="gender" class="form-control">
		                                            	<option>Male</option>
		                                            	<option>Female</option>
		                                            </select>
		                                        </div>
		                                        <div class="form-group">
		                                            <label class=" form-control-label">City</label>
		                                            <input type="text" name="city" placeholder="Enter Preferred City" class="form-control">
		                                        </div>
		                                        <div class="form-group">
		                                            <label class=" form-control-label">Maximum Age</label>
		                                            <input type="text" name="age" placeholder="Enter Maximum Age" class="form-control">
		                                        </div>
		                                        <div class="form-group">
		                                            <label class=" form-control-label">Religion</label>
		                                            <input type="text" name="religion" placeholder="Enter Preferred Religion" class="form-control">
		                                        </div>
		                                        <div class="form-group">
		                                            <label class=" form-control-label">Mother Tongue</label>
		                                            <input type="text" name="mothertongue" placeholder="Enter Preferred Language" class="form-control">
		                                        </div>
	                                            
	                                        </div>
	                                        
	                                        <hr>
	                                        <div class="card-text text-sm-center">
	                                            <button class="au-btn au-btn--block btn-info m-b-20" type="submit" style="width: 60%; margin: auto;">search</button>
	                                        </div>
                                        </form>
                                    </div>
                                </div>