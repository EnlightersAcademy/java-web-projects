<jsp:include page="userHeader.jsp"/>

<style>
	.userPics{
		height: 200px;
	}
</style>

<br/><br/>

<section class="statistic">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                    
                    			<div class="card">
                                    <div class="card-header">
                                        <strong class="card-title">Upload Your Photos</strong>
                                    </div>
                                    <div class="card-body" style="text-align: center;">
                                        	<form action="">
                                        		<input type="file" name="photoFile" accept="image/png, image/jpeg">
												<button type="button" class="btn btn-primary">
                                            		<i class="fa fa-upload"></i>&nbsp; UPLOAD</button>
                                        	</form>
                                    </div>
                                </div>
                                
                                <br/>
                                <br/>
                                
                                <div class="card">
                                    <div class="card-header">
                                        <strong class="card-title">Gallery</strong>
                                    </div>
                                    <div class="card-body" style="text-align: center;">
                                    	<div class="col-md-12">
                                    		<div class="row">
                                    		
                                    			<%
                                    				int photoCount = 3;	//Get the count of photos here.
                                    				
                                    				if(photoCount ==0)
                                    				{
                                    			%>
	                                    			<div style="margin: auto;">
		                                        		<p class="card-text">No Photos Uploaded Yet.</p>
		                                        	</div>
	                                        	<%
                                    				}
                                    				else
                                    				{
	                                        	%>
	                                        	
		                                    		<!-- Loop and put all the photos of the user here -->
		                                        	<div class="col-md-3">
		                                        		<img class="userPics" src="<%= "images/photos/hr1.jpg"%>">
		                                        	</div>
		                                        	<!-- ----- -->
		                                        	
		                                        	<!-- Below code can be removed -->
		                                        	<div class="col-md-3">
		                                        		<img class="userPics" src="<%= "images/photos/hr2.jpg"%>">
		                                        	</div>
		                                        	<div class="col-md-3">
		                                        		<img class="userPics" src="<%= "images/photos/hr3.jpg"%>">
		                                        	</div>
		                                        	<div class="col-md-3">
		                                        		<img class="userPics" src="<%= "images/photos/hr4.jpg"%>">
		                                        	</div>
		                                        	<!-- ---- -->
	                                        	
	                                        	<%
                                    				}
	                                        	%>
                                        	</div>
                                    	</div>
                                    </div>
                                </div>
                                
                                
                    </div>
                </div>
</section>