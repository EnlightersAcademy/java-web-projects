<jsp:include page="adminHeader.jsp"/>

<style>
	.detailsButton
	{
		position: absolute;
		right:    0;
		bottom:   0;
		margin-bottom: 10px;
		margin-right: 10px;
	}

	.footer {
	  position: fixed;
	  left: 0;
	  bottom: 0;
	  width: 100%;
	  color: gray;
	  text-align: center;
	}
</style>

<br/><br/>
			

			<section class="statistic">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                    	<div class="row">   
                    	                 	
                    		<div class="col-sm-6 col-lg-4">
                                <div class="overview-item overview-item--c3" style="height: 150px;">
                                    <div class="overview__inner">
                                        <div class="overview-box clearfix">
                                            <div class="icon">
                                                <i class="zmdi zmdi-accounts"></i>
                                            </div>
                                            <div class="text">
                                                <h2><%= 12 %></h2>	<!-- Total number of active users -->
                                                <span style="float: right;">Active Users</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="col-sm-6 col-lg-4">
                                <div class="overview-item overview-item--c1" style="height: 150px;">
                                    <div class="overview__inner">
                                        <div class="overview-box clearfix">
                                            <div class="icon">
                                                <i class="zmdi zmdi-label-heart"></i>
                                            </div>
                                            <div class="text">
                                                <h2><%= 4 %></h2>	<!-- Total number of married users -->
                                                <span style="float: right;">Married Users</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="col-sm-6 col-lg-4">
                                <div class="overview-item overview-item--c2" style="height: 150px;">
                                    <div class="overview__inner">
                                        <div class="overview-box clearfix">
                                            <div class="icon">
                                                <i class="zmdi zmdi-block"></i>
                                            </div>
                                            <div class="text">
                                                <h2><%= 5 %></h2>	<!-- Total number of inactive users -->
                                                <span style="float: right;">Inactive Users</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                    	</div>
                    	
                    	<div class="footer">
                    		<p>Match Makers &copy; 2020</p>
                    	</div>
                    </div>
                </div>
            </section>