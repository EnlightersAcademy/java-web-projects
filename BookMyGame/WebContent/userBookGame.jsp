<jsp:include page="userHeader.jsp"/>

        <!-- PAGE CONTENT-->
        <div class="page-content--bgf7" style="height: 100%">
        
        	<br/>
        	
        	<div class="jumbotron" style="width: 90%; margin: auto; text-align: center;">
				<form class="form-inline" style="margin: auto;">
				  	<div class="col-md-8">
				  		Select Location: &nbsp;&nbsp;
				  		<!-- POLPULATE All LOCATIONS HERE -->
				      	<select class="custom-select" name="searchmemberid" style="min-width: 250px;">
						  <option selected>Select</option>
						  <option value="Electronic City">Electronic City</option>
						  <option value="HSR Layout">HSR Layout</option>
						  <option value="Koramangala">Koramangala</option>
						</select>	
				    </div>
					 <div class="col-auto">
					 	<button type="submit" class="btn btn-primary mb-2"> Search Sports Centers </button>
					 </div>
				</form>								
			</div>
			<br/>
			<hr/>
			<br/>
			
			<!-- BELOW SECTION SHOULD BE VISIBLE ONLY AFTER SEARCH! -->

        	<div style="width: 90%; margin: auto; text-align: center;">
			  	<div class="form-group row">
				    <label class="col-sm-2 col-form-label" style="font-weight: bold;">LOCATION: </label>
				    <div class="col-sm-10">
				    	<!-- Populate the Selected Location HERE -->
				      <input type="text" readonly class="form-control-plaintext" name="selectedLocation" value="<%= "Electronic City" %>">
				    </div>
				  </div>		
			</div>
			
			<!-- DATA TABLE-->
            <div class="table-responsive m-b-40" style="width: 90%; margin: auto;">
                <table class="table table-borderless table-data3">
                    <thead>
                        <tr>
                            <th>Sports Center Name</th>
                            <th>Phone</th>
                            <th>Email</th>
                            <th>2-Wheeler Parking</th>
                            <th>4-Wheeler Parking</th>
                            <th>Games Offered</th>
                            <th> </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Flying Feathers</td>
                            <td>8989455546</td>
                            <td>ff@gmail.com</td>
                            <td>Yes</td>
                            <td>No</td>
                            <td>Badminton,Carrom,Bowling,TT</td>
                            <td>
                            	<a href="userBookGame1.jsp?centerId=<%=123 %>" class="btn btn-success mb-2">SELECT</a>	<!-- Populate the sportsCenterId in HREF-->
							</td>
                        </tr>
                        <tr>
                            <td>Flying Wings</td>
                            <td>8989455546</td>
                            <td>ff@gmail.com</td>
                            <td>Yes</td>
                            <td>No</td>
                            <td>Badminton,Carrom,Bowling,TT</td>
                            <td>
                            	<a href="userBookGame1.jsp?centerId=<%=456 %>" class="btn btn-success mb-2">SELECT</a>
							</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!-- END DATA TABLE-->
        
        	<br/><br/>
        </div>