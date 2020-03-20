<jsp:include page="userHeader.jsp"/>

<br/><br/>

<%
	String currentProfileStatus = "Active";	//Get the status. Status can be Active / Inactive / Married 
%>

<section class="statistic">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                    
                    	<div class="card">
                                    <div class="card-header">
                                        <strong>Change Profile Status</strong>
                                    </div>
                                    <div class="card-body card-block">
                                    	<form method="post" action="">
	                                        <div class="form-group" style="text-align: center;">
	                                            <label class=" form-control-label">Current Status : </label>
	                                            <label class=" form-control-label" style="color: #2E86C1; font-weight: bolder;">
	                                            <%= currentProfileStatus %></label>
	                                        </div>
	                                        <br/><br/>
	                                        <div class="form-group">
	                                            <label class=" form-control-label">Change Status To</label>
	                                            <select class="form-control" name="newstatus">
	                                            	<%
	                                            		if(currentProfileStatus != "Active")
	                                            		{
	                                            	%>
	                                            	<option value="Active">Active - I am looking for a match actively.</option>
	                                            	<%
	                                            		}	                                            	
	                                            		if(currentProfileStatus != "Inactive")
	                                            		{
	                                            	%>
	                                            	<option value="Inactive">Inactive - I am not looking for a match anymore.</option>
	                                            	<%
	                                            		}
	                                            		if(currentProfileStatus != "Married")
	                                            		{
	                                            	%>
	                                            	<option value="Married">Married - Yay! I got married.</option>
	                                            	<%
	                                            		}
	                                            	%>
	                                            </select>
	                                        </div>
	                                        
	                                        <button class="au-btn au-btn--block au-btn--green m-b-20" style="width: 50%; margin: auto;" type="submit">UPDATE STATUS</button>	                                        
                                        </form>
                                    </div>
                                </div>
                    
                    </div>
                </div>
</section>