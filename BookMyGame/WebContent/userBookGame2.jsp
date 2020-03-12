<jsp:include page="userHeader.jsp" />

<%
	int selectedCenterId = 1234;
	String selectedGame = "Badminton";
	String selectedCourt = "Court1";
%>

<!-- PAGE CONTENT-->
<div class="page-content--bgf7" style="height: 100%">

	<br />

	<div class="jumbotron" style="width: 50%; margin: auto;">
		<h2 class="display-5">Book Game</h2>
		<br />

		<form action="" method="post">
			<div class="form-group">
				<label>Sports Center Name</label> <input type="text"
					name="centerName" class="au-input au-input--full" readonly value="<%=selectedCenterId %>">
			</div>
			<div class="form-group">
				<label>Game</label> <input type="text"
					name="selectedGame" class="au-input au-input--full" readonly value="<%=selectedGame %>">
			</div>
			<div class="form-group">
				<label>Court/Board/Lane</label> 
				<input type="text"
					name="selectedCourt" class="au-input au-input--full" readonly value="<%=selectedCourt %>">
			</div>
			<div class="form-group">
				<label>Select Date</label> <input class="au-input au-input--full"
					type="date" name="gameDate">
			</div>
			<div class="form-group">
				<label>Select Time</label> <select
					class="form-control au-input au-input--full" name="gameTime">
					<option value="9:00AM-10:00AM">9:00AM-10:00AM</option>
					<option value="10:00AM-11:00AM">10:00AM-11:00AM</option>
					<option value="11:00AM-12:00PM">11:00AM-12:00PM</option>
					<option value="12:00PM-1:00PM">12:00PM-1:00PM</option>
					<option value="1:00PM-2:00PM">1:00PM-2:00PM</option>
					<option value="2:00PM-3:00PM">2:00PM-3:00PM</option>
					<option value="3:00PM-4:00PM">3:00PM-4:00PM</option>
					<option value="4:00PM-5:00PM">4:00PM-5:00PM</option>
					<option value="5:00PM-6:00PM">5:00PM-6:00PM</option>
					<option value="6:00PM-7:00PM">6:00PM-7:00PM</option>
					<option value="7:00PM-8:00PM">7:00PM-8:00PM</option>
					<option value="8:00PM-9:00PM">8:00PM-9:00PM</option>
					<option value="9:00PM-10:00PM">9:00PM-10:00PM</option>
					<option value="10:00PM-11:00PM">10:00PM-11:00PM</option>
				</select>
			</div>
			
			<br />
			<button type="submit"
				class="au-btn au-btn--block au-btn--green m-b-20">Book Game</button>
		</form>
	</div>

	<br />
	<br />
</div>