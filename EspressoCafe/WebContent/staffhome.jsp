<%@ include file="staffheader.jsp"%>

<style>
	@font-face {
		  font-family: Poppins-Regular;
		  src: url('../../fonts/poppins/Poppins-Regular.ttf'); 
		}
	
	.titleText{
		font-family: Poppins-Regular;
		 font-size: 20px;
		 color: #555555;
		 line-height: 1.2;
		 text-transform: uppercase;
		 letter-spacing: 2px;
		 text-align: center;
		
		 width: 100%;
		 display: block;
	}
		
</style>


<div class="container-fluid" style="vertical-align: middle; width: 50%; text-align:center; margin:auto; margin-top: 5em;">
	<img src="assets/images/logo.png"><br/>
	<span class="titleText" style="font-size: x-large;">
						<b>Espresso Café</b>
					</span>
	
	<div class="row titleText" style="text-align: center; margin-top: 50px;">
		<h5>Welcome <%=userName %></h5>
	</div>
</div>



<%@ include file="stafffooter.jsp"%>