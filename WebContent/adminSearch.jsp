<jsp:include page="adminHeader.jsp"/>

<br/><br/>
                            
                            <div class="card"  style="margin:auto; margin-top:70px; width: 60%">
                                    <div class="card-header">
                                        <i class="fa fa-user"></i>
                                        <strong class="card-title pl-2">Profile Search</strong>
                                    </div>
                                    <div class="card-body">
                                    
                                    	<form method="post" action="adminSearchResults.jsp">
	                                        <div class="mx-auto d-block">
		                                        <div class="form-group">
		                                            <label class=" form-control-label">Name</label>
		                                            <input type="text" name="username" placeholder="Enter User Name" class="form-control">
		                                        </div>
	                                            
	                                        </div>
	                                        
	                                        <br/>
	                                        <div class="card-text text-sm-center">
	                                            <button class="au-btn au-btn--block btn-info m-b-20" type="submit" style="width: 60%; margin: auto;">search</button>
	                                        </div>
                                        </form>
                                    </div>
                                </div>