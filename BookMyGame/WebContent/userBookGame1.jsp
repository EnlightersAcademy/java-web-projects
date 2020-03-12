<jsp:include page="userHeader.jsp"/>

<style>
	.gameImage{
		width: 200px;
	}
</style>

<%
	// Populate the sportsCenterId here
	int selectedCenterId = 1234;
%>

        <!-- PAGE CONTENT-->
        <div class="page-content--bgf7" style="height: 100%">
        
        	<br/>
        	
        	<div class="jumbotron" style="width: 90%; margin: auto; text-align: left;">
        		<div class="form-group row">
        			<div class="col-md-6">
        				<form class="form-inline">
        					<div class="form-group mb-2">
        						<label  style="font-weight: bold;">LOCATION: </label>
        					</div>
        					<div class="form-group mb-2" style="padding-left: 20px;">
						    	<!-- Populate the Selected Location HERE -->
						      	<input type="text" readonly class="form-control-plaintext" name="selectedLocation" value="<%= "Electronic City" %>">
					      </div>
					    </form>
        			</div>
        			<div class="col-md-6">
        				<form class="form-inline">
        					<div class="form-group mb-2">
        						<label  style="font-weight: bold;">SPORTS CENTER: </label>
        					</div>
        					<div class="form-group mb-2" style="padding-left: 20px;">
						    	<!-- Populate the Selected Sports Center HERE -->
						      	<input type="text" readonly class="form-control-plaintext" name="selectedCenter" value="<%= "Flying Feathers" %>">
					      </div>
					    </form>
        			</div>
				</div>
			</div>
			<br/>
			
			<!-- DATA TABLE-->
            <div class="table-responsive m-b-40" style="width: 90%; margin: auto;">
                <table class="table table-borderless table-data3">
                    <thead>
                        <tr>
                            <th></th>
                            <th>Game</th>
                            <th>Court/Lane/Board</th>
                            <th> </th>
                        </tr>
                    </thead>
                    <tbody>
                    	<form action="userBookGame2.jsp" method="post">
	                        <tr>
	                            <td>
									<img class="gameImage" src="images/games/badminton.jpg">
								</td>
	                            <td>
	                            	<!-- Populate the game HREF-->
	                            	<input type="text" readonly class="form-control-plaintext" name="selectedGame" value="<%= "Badminton" %>">
								</td>
	                            <td>
	                            	<!-- Populate the courts HREF-->
									<select name="court">
										<option>Court1</option>
										<option>Court2</option>
										<option>Court3</option>
										<option>Court4</option>
									</select>
								</td>
	                            <td>
	                            	<input type="hidden" name="selectedCenter" value="<%= selectedCenterId %>"> 
	                            	<button type="submit" class="btn btn-success mb-2">SELECT</button>
								</td>
	                        </tr>
                        </form>
                        <form action="userBookGame2.jsp" method="post">
	                        <tr>
	                            <td>
									<img class="gameImage" src="images/games/carrom.jpg">
								</td>
	                            <td>
	                            	<!-- Populate the game HREF-->
	                            	<input type="text" readonly class="form-control-plaintext" name="selectedGame" value="<%= "Carrom" %>">
								</td>
	                            <td>
	                            	<!-- Populate the courts HREF-->
									<select name="court">
										<option>Board1</option>
										<option>Board2</option>
									</select>
								</td>
	                            <td>
	                            	<input type="hidden" name="selectedCenter" value="<%= selectedCenterId %>">
	                            	<button type="submit" class="btn btn-success mb-2">SELECT</button>
								</td>
	                        </tr>
                        </form>
                    </tbody>
                </table>
            </div>
            <!-- END DATA TABLE-->
        
        	<br/><br/>
        </div>