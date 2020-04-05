<jsp:include page="userHeader.jsp"/>

<style>
	.detailsButton
	{
		position: absolute;
		right:    0;
		bottom:   0;
		margin-bottom: 10px;
		margin-right: 10px;
	}
	.detailsLabel
	{
		color: #5499C7;
	}
	.desc
	{
		color: black;
	}
</style>

<br/><br/>

			<section class="statistic">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                    	<a href="userSearchResults.jsp" class="btn btn-warning btn-sm" style="float: right;">
                                            BACK &nbsp; <i class="fa fa-reply"></i></a>
                                            
                                            
                    	<h2 class="title-3 m-b-30" style="color: #4272d7; font-size: 30px;">
                                        <i class="zmdi zmdi-account"></i><%= "Hrithik R" %>&nbsp;&nbsp;	<!-- Populate the Name here -->
                                        </h2>
                                        
	           			<form action="" method="post">
	                            	<input type="hidden" value="<%= 1234 %>">	<!-- Populate the User ID here for submission -->
	                             <button type="submit" class="btn btn-outline-danger btn-sm">
	                                 <i class="fa fa-heart"></i> Add to Shortlist</button>
	                            </form>
                       	<br/>
                       	
                        <div class="row">
                        
                            <div class="col-md-12 col-lg-12">
                                <div class="statistic__item">
                                	<div class="row"  style="height: 100%;">
	                                	<div class="col-md-3">
	                                		<img src="<%= "images/photos/hr1.jpg" %>">	<!-- Image -->
	                                	</div>
	                                	<div class="col-md-3">
	                                		<img src="<%= "images/photos/hr2.jpg" %>">	<!-- Image -->
	                                	</div>
	                                	<div class="col-md-3">
	                                		<img src="<%= "images/photos/hr3.jpg" %>">	<!-- Image -->
	                                	</div>	
	                                	<div class="col-md-3">
	                                		<img src="<%= "images/photos/hr4.jpg" %>">	<!-- Image -->
	                                	</div>	                                	
                                	</div>
                                </div>
                            </div>
                            
                            <div class="col-md-12 col-lg-12">
                                <div class="statistic__item">
	                                	<div style="height: 100%;">
	                                		<h3 class="number">Basic Details</h3> <br/>
		                                    <span class="desc" style="color: #37474F;">
		                                    	<b class="detailsLabel">Email :</b> <%= "abc@gmail.com" %><br/>
		                                    	<b class="detailsLabel">Phone :</b> <%= "9885098850" %><br/>
		                                    	<b class="detailsLabel">Age :</b> <%= 32 %><br/>
		                                    	<b class="detailsLabel">Height :</b> <%= "6.2" %>ft<br/>
		                                    	<b class="detailsLabel">Weight :</b> <%= "72" %>kgs<br/>
		                                    	<b class="detailsLabel">City :</b> <%= "Mumbai" %><br/>
		                                    	<b class="detailsLabel">Mother Tongue :</b> <%= "Marathi" %><br/>
		                                    </span>
	                                	</div>
                                </div>
                            </div>
                            
                            <div class="col-md-12 col-lg-12">
                                <div class="statistic__item">
	                                	<div style="height: 100%;">
	                                		<h3 class="number">Professional Details</h3> <br/>
		                                    <span class="desc" style="color: #37474F;">
		                                    	<b class="detailsLabel">Profession :</b> <%= "Software Developer" %><br/>
		                                    	<b class="detailsLabel">Company :</b> <%= "Google" %><br/>
		                                    	<b class="detailsLabel">Salary :</b> <%= 2300000 %><br/>
		                                    	<b class="detailsLabel">Highest Qualification :</b> <%= "M.Tech" %>ft<br/>
		                                    </span>
	                                	</div>
                                </div>
                            </div>
                            
                            <div class="col-md-12 col-lg-12">
                                <div class="statistic__item">
	                                	<div style="height: 100%;">
	                                		<h3 class="number">Family Details</h3> <br/>
		                                    <span class="desc" style="color: #37474F;">
		                                    	<b class="detailsLabel">Family Type :</b> <%= "Nuclear" %><br/>
		                                    	<b class="detailsLabel">Siblings :</b> <%= "1 Brother" %><br/>
		                                    </span>
	                                	</div>
                                </div>
                            </div>
                            
                            <div class="col-md-12 col-lg-12">
                                <div class="statistic__item">
	                                	<div style="height: 100%;">
	                                		<h3 class="number">Lifestyle Details</h3> <br/>
		                                    <span class="desc" style="color: #37474F;">
		                                    	<b class="detailsLabel">Hobbies :</b> <%= "Photography, Reading" %><br/>
		                                    	<b class="detailsLabel">Drink ? :</b> <%= "Ocassional" %><br/>
		                                    	<b class="detailsLabel">Smoke ? :</b> <%= "Never" %><br/>
		                                    </span>
	                                	</div>
                                </div>
                            </div>
                            
                            <div class="col-md-12 col-lg-12">
                                <div class="statistic__item">
	                                	<div style="height: 100%;">
	                                		<h3 class="number">Religion Details</h3> <br/>
		                                    <span class="desc" style="color: #37474F;">
		                                    	<b class="detailsLabel">Religion :</b> <%= "Hindu" %><br/>
		                                    	<b class="detailsLabel">Star :</b> <%= "Ashwini" %><br/>
		                                    </span>
	                                	</div>
                                </div>
                            </div>
                            
                            
                        </div>
                    </div>
                </div>
            </section>