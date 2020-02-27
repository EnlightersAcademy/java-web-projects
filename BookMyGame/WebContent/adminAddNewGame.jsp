<jsp:include page="adminHeader.jsp"/>

        <!-- PAGE CONTENT-->
        <div class="page-content--bgf7" style="height: 100%">
        
        	<br/>
        	
        	<div class="jumbotron" style="width: 80%; margin: auto;">
			  <h2 class="display-5">Add New Game</h2>
			  <br/>
			  
				<form action="" method="post">
				  <div class="form-group">
                      <label>Name</label>
                      <input class="au-input au-input--full" type="text" name="gamename" placeholder="Name Of Game">
                  </div>
                  <div class="form-group">
                      <label>Image</label>
                      <input type="file" name="gameimage" class="form-control-file">
                  </div>
                  <br/>
				  <button type="submit" class="au-btn au-btn--block au-btn--green m-b-20">ADD</button>
				</form>
			</div>

        	
        
        	<br/><br/>
        </div>