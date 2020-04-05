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
</style>

<br/><br/>
			

			<section class="statistic">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                    	<h2 class="title-3 m-b-30">
                                        <i class="zmdi zmdi-search"></i>Search Results</h2>
                    	<br/>
                    	
                    	<%
                    		int searchResultsCount = 4;	//Get the count of search results here.
                    	
                    		if(searchResultsCount==0)
                    		{
                    	%>
                    		<div class="row">
                    			<p class="card-text" style="margin: auto;">No Matching Results Found!</p>
                    		</div>
                    	<%
                    		}
                    		else
                    		{
                    	%>
                        <div class="row">
                            
                            <!-- Populate the short-listed profiles here -->
                            
                            <div class="col-md-6 col-lg-6">
                                <div class="statistic__item">
                                	<div class="row"  style="height: 100%;">
	                                	<div class="col-md-3">
	                                		<img src="<%= "images/photos/hr3.jpg" %>">	<!-- Image -->
	                                	</div>
	                                	<div  class="col-md-9" style="height: 100%;">
	                                		<h2 class="number"> <%= "Hrithik R" %></h2> <!-- Name -->
		                                    <span class="desc">
		                                    	Profession : <%= "Actor" %> <br/>	<!-- Profession -->
		                                    	Age : <%= 32 %> <br/>	<!-- Age -->
		                                    	Location : <%= "Mumbai" %>	<!-- Location -->
		                                    </span>
		                                    
	                                	</div>
                                	</div>
                                	<!-- Populate the User ID in the href -->
                                	<a class="btn btn-success btn-sm detailsButton" style="color: white;" href="userViewProfileSearched.jsp?id<%=123%>">Details</a>	
                                </div>
                            </div>
                            
                            <div class="col-md-6 col-lg-6">
                                <div class="statistic__item">
                                	<div class="row"  style="height: 100%;">
	                                	<div class="col-md-3">
	                                		<img src="<%= "images/photos/hr3.jpg" %>">	<!-- Image -->
	                                	</div>
	                                	<div  class="col-md-9" style="height: 100%;">
	                                		<h2 class="number"> <%= "Hrithik R" %></h2> <!-- Name -->
		                                    <span class="desc">
		                                    	Profession : <%= "Actor" %> <br/>	<!-- Profession -->
		                                    	Age : <%= 32 %> <br/>	<!-- Age -->
		                                    	Location : <%= "Mumbai" %>	<!-- Location -->
		                                    </span>
		                                    
	                                	</div>
                                	</div>
                                	<!-- Populate the User ID in the href -->
                                	<a class="btn btn-success btn-sm detailsButton" style="color: white;" href="userViewProfileSearched.jsp?id<%=123%>">Details</a>	
                                </div>
                            </div>
                            
                        </div>
                        <%
                    		}
                        %>
                    </div>
                </div>
            </section>