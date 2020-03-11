<jsp:include page="userHeader.jsp"/>

        <!-- PAGE CONTENT-->
        <div class="page-content--bgf7" style="height: 100%">
        
        	<br/>
			
			<!-- DATA TABLE-->
            <div class="table-responsive m-b-40" style="width: 95%; margin: auto;">
            
                <table class="table table-borderless table-data3">
                    <thead>
                        <tr>
                            <th>Booking ID</th>
                            <th>Location</th>
                            <th>Center</th>
                            <th>Game</th>
                            <th>Court</th>
                            <th>Date</th>
                            <th>Time</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1234</td>
                            <td>Electronic City</td>
                            <td>Flying Fathers</td>
                            <td>Badminton</td>
                            <td>Court3</td>
                            <td>20-03-2020</td>
                            <td>06:00PM-07:PM</td>
                            <td>Completed</td>	<!-- Loads the status -->
                        </tr>
                        <tr>
                            <td>1234</td>
                            <td>Electronic City</td>
                            <td>Flying Fathers</td>
                            <td>Badminton</td>
                            <td>Court3</td>
                            <td>21-03-2020</td>
                            <td>06:00PM-07:PM</td>
                            <td>
                            <!-- If the booking is active Cancel option should be visible -->
                            		<form method="post" action="">
                            			<button type="submit" class="btn btn-danger btn-sm">Cancel</button>
                            		</form>
							</td>
                        </tr>
                        <tr>
                            <td>1234</td>
                            <td>Electronic City</td>
                            <td>Flying Fathers</td>
                            <td>Badminton</td>
                            <td>Court3</td>
                            <td>22-03-2020</td>
                            <td>06:00PM-07:PM</td>
                            <td>Cancelled</td>
                        </tr>
                        <tr>
                            <td>1234</td>
                            <td>Electronic City</td>
                            <td>Flying Fathers</td>
                            <td>Badminton</td>
                            <td>Court3</td>
                            <td>23-03-2020</td>
                            <td>06:00PM-07:PM</td>
                            <td>
                            <!-- If the booking is active Cancel option should be visible -->
                            		<form method="post" action="">
                            			<button type="submit" class="btn btn-danger btn-sm">Cancel</button>
                            		</form>
							</td>
                        </tr>
                    </tbody>
                </table>
                
            </div>
            <!-- END DATA TABLE-->
        
        	<br/><br/>
        </div>