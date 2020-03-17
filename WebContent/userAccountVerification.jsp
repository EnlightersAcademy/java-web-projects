<jsp:include page="userHeader.jsp"/>

<br/><br/>

<%
	boolean accountVerified = false;	//Get the status of account verification from DB.
	boolean alreadyRequested = false;	//Check if request is already raised.
%>

<section class="statistic">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                    
                    			<div class="card">
                                    <div class="card-header">
                                        <i class="fa fa-check-circle" style="color: #1E88E5;"></i>
                                        <strong class="card-title pl-2">Account Verification State : <span style="color: #8E24AA;"><%= accountVerified? " Verified" : " Not Verified"  %></span></strong>
                                    </div>
                                    <div class="card-body">
                                        <div class="mx-auto d-block" style="margin: auto; text-align: center;">
                                        	
                                        	<%
                                        		if(accountVerified)
                                        		{
                                        	%>
                                            		<h4>Account Already Verified.</h4>
                                            <%
                                        		}
                                        		else
                                        		{
                                        			if(alreadyRequested)
                                        			{
                                            %>
                                            			<h4>Account Verification Request Already Sent.</h4>
                                            <%
                                        			}
                                        			else
                                        			{
                                            %>
                                            			<form action="">
			                                            	<button type="button" class="btn btn-warning">
			                                            		<i class="fa fa-check-circle"></i>&nbsp; Request Profile Verification</button>
			                                            </form>
                                            <%
                                        			}
                                        		}
                                            %>
                                        </div>
                                        <hr>
                                        <div class="card-text text-sm-center">
                                            <p class="card-text" style="color: #CFD8DC;">
                                            	Verified Accounts have higher chances of getting matches, as it will be a Match Makers' approved profile!
                                        	</p>
                                        </div>
                                    </div>
                                </div>
                                
                                
                    </div>
                </div>
</section>