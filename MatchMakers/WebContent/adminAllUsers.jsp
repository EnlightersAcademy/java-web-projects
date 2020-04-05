<jsp:include page="adminHeader.jsp"/>

<br/><br/>
                            
<section class="statistic">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                    
                    	<h3 class="title-3 m-b-30">
                                        <i class="fas fa-users"></i>Users</h3>
                    
                    	<div class="table-responsive table--no-card m-b-30">
                                    <table class="table table-borderless table-striped table-earning">
                                        <thead>
                                            <tr>
                                                <th>User ID</th>
                                                <th>User Name</th>
                                                <th>Email ID</th>
                                                <th>Phone</th>
                                                <th>Profile Status</th>
                                                <th class="text-right">Details &nbsp; &nbsp;</th>
                                                <th class="text-right">Approve &nbsp; &nbsp;</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1234</td>
                                                <td>Raj</td>
                                                <td>raj@gmail.com</td>
                                                <td>9885098850</td>
                                                <td>Active</td>
                                                <td class="text-right">
                                                	<form action="adminViewProfile.jsp" method="post">
                                                		<input type="hidden" name="userid" value="<%= 1234 %>">
                                                		<button type="submit" class="btn btn-outline-primary btn-sm"><i class="fa fa-info-circle"></i>&nbsp; Details</button>
                                                	</form>
                                                </td>
                                                <td class="text-right">
                                                	<form action="" method="get">
                                                		<input type="hidden" name="userid" value="<%= 1234 %>">
                                                		<!-- Button should be disabled if status is INACTIVE or MARRIED -->
                                                		<button type="submit" class="btn btn-danger btn-sm"><i class="fa fa-ban"></i>&nbsp; BLOCK</button>
                                                	</form>
                                                </td>
                                            </tr>
                                            
                                            
                                            <tr>
                                                <td>1234</td>
                                                <td>Raj</td>
                                                <td>raj@gmail.com</td>
                                                <td>9885098850</td>
                                                <td>Inactive</td>
                                                <td class="text-right">
                                                	<form action="adminViewProfile.jsp" method="post">
                                                		<input type="hidden" name="userid" value="<%= 1234 %>">
                                                		<button type="submit" class="btn btn-outline-primary btn-sm"><i class="fa fa-info-circle"></i>&nbsp; Details</button>
                                                	</form>
                                                </td>
                                                <td class="text-right">
                                                	<form action="" method="get">
                                                		<input type="hidden" name="userid" value="<%= 1234 %>">
                                                		<!-- Button should be disabled if status is INACTIVE or MARRIED -->
                                                		<button type="submit" class="btn btn-danger btn-sm" disabled><i class="fa fa-ban"></i>&nbsp; BLOCK</button>
                                                	</form>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>1234</td>
                                                <td>Raj</td>
                                                <td>raj@gmail.com</td>
                                                <td>9885098850</td>
                                                <td>Active</td>
                                                <td class="text-right">
                                                	<form action="adminViewProfile.jsp" method="post">
                                                		<input type="hidden" name="userid" value="<%= 1234 %>">
                                                		<button type="submit" class="btn btn-outline-primary btn-sm"><i class="fa fa-info-circle"></i>&nbsp; Details</button>
                                                	</form>
                                                </td>
                                                <td class="text-right">
                                                	<form action="" method="get">
                                                		<input type="hidden" name="userid" value="<%= 1234 %>">
                                                		<!-- Button should be disabled if status is INACTIVE or MARRIED -->
                                                		<button type="submit" class="btn btn-danger btn-sm"><i class="fa fa-ban"></i>&nbsp; BLOCK</button>
                                                	</form>
                                                </td>
                                            </tr>
                                            
                                            
                                        </tbody>
                                    </table>
                                </div>
                    
                    </div>
                </div>
</section>