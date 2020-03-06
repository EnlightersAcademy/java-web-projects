<jsp:include page="centerHeader.jsp"/>

        <!-- PAGE CONTENT-->
        <div class="page-content--bgf7" style="height: 100%">
        
        	<br/>
        	
        	<div class="jumbotron" style="width: 50%; margin: auto;">
			  <h2 class="display-5">Add Game to Center</h2>
			  <br/>
			  
				<form action="" method="post">
				  <div class="form-group">
                      <label>Game</label>
                      <!-- Load all available Game Names here. Value can be Game ID -->
                      <!-- If needed, Games which are already added by this Center can be removed from this list -->
                      <select class="form-control au-input au-input--full" name="gamename">
                      	<option value="1">Badminton</option>
                      	<option value="1">Carrom</option>
                      	<option value="1">Bowling</option>
                      </select>
                  </div>
                  <div class="form-group">
                      <label>Number of Courts/Boards/Lanes Available</label>
                      <select class="custom-select au-input au-input--full" name="NoOfCourts">
                      	<option value="1">1</option>
                      	<option value="2">2</option>
                      	<option value="3">3</option>
                      	<option value="4">4</option>
                      	<option value="5">5</option>
                      </select>
                  </div>
                  <br/>
				  <button type="submit" class="au-btn au-btn--block au-btn--green m-b-20">Add Game</button>
				</form>
			</div>

        	<br/><br/>
        </div>