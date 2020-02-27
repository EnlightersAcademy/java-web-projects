<jsp:include page="adminHeader.jsp"/>

        <!-- PAGE CONTENT-->
        <div class="page-content--bgf7" style="height: 100%">
        
        	<br/>
        	
        	<div class="jumbotron" style="width: 80%; margin: auto; text-align: center;">
				<form class="form-inline" style="margin: auto;">
				  	<div class="col-md-8">
				  		Select Sports Center ID: &nbsp;&nbsp;
				      	<select class="custom-select" name="searchmemberid" style="width: 200px;">
						  <option selected>Select</option>
						  <option value="1">1234</option>
						  <option value="2">1235</option>
						  <option value="3">1236</option>
						</select>	
				    </div>
					 <div class="col-auto">
					 	<button type="submit" class="btn btn-primary mb-2"> Search Center </button>
					 </div>
				</form>								
			</div>
			<br/>
			<hr/>
			<br/>
			
			<!-- BELOW SECTION SHOULD BE VISIBLE ONLY AFTER SEARCH! -->

        	<div style="width: 80%; margin: auto; text-align: center;">
			  	<div class="form-group row">
				    <label class="col-sm-2 col-form-label" style="font-weight: bold;">Center ID: </label>
				    <div class="col-sm-10">
				      <input type="text" readonly class="form-control-plaintext" name="memberid" value="<%=1234 %>">
				    </div>
				  </div>		
			</div>
			
			<!-- DATA TABLE-->
            <div class="table-responsive m-b-40" style="width: 80%; margin: auto;">
                <table class="table table-borderless table-data3">
                    <thead>
                        <tr>
                            <th>Booking ID</th>
                            <th>Member ID</th>
                            <th>Court/Board</th>
                            <th>Date</th>
                            <th>Time Slot</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1234</td>
                            <td>565</td>
                            <td>Badminton</td>
                            <td>20-03-2020</td>
                            <td>20:00 - 21:00</td>
                        </tr>
                        <tr>
                            <td>1234</td>
                            <td>565</td>
                            <td>Badminton</td>
                            <td>20-03-2020</td>
                            <td>20:00 - 21:00</td>
                        </tr>
                        <tr>
                            <td>1234</td>
                            <td>565</td>
                            <td>Badminton</td>
                            <td>20-03-2020</td>
                            <td>20:00 - 21:00</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!-- END DATA TABLE-->
        
        	<br/><br/>
        </div>