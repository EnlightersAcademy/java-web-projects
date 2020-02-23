<jsp:include page="adminHeader.jsp"/>

        <!-- PAGE CONTENT-->
        <div class="page-content--bgf7" style="height: 100%">
        	
        	<br/><br/>
        	
        	<!-- DATA TABLE-->
            <div class="table-responsive m-b-40" style="width: 95%; margin: auto;">
                <table class="table table-borderless table-data3">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Center Name</th>
                            <th>Location</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1234</td>
                            <td>Flying Feathers</td>
                            <td>Electronic City</td>                            
                            <td>sample@gmail.com</td>
                            <td>9882020205</td>
                            <td>
                           		<!-- Populate the Member ID into this field -->
                           		<a class="btn btn-success btn-sm" href="ApproveCenter?id=<%= 1234 %>">
                                            <i class="fa fa-thumbs-up"></i> Approve
                                        </a>
                                <a class="btn btn-danger btn-sm" href="RejectCenter?id=<%= 1234 %>">
                                            <i class="fa fa-ban"></i> Reject
                                        </a>
                            </td>
                        </tr>
                        <tr>
                            <td>1234</td>
                            <td>Flying Feathers</td>
                            <td>Electronic City</td>                            
                            <td>sample@gmail.com</td>
                            <td>9882020205</td>
                            <td>
                           		<!-- Populate the Member ID into this field -->
                           		<a class="btn btn-success btn-sm" href="ApproveCenter?id=<%= 1234 %>">
                                            <i class="fa fa-thumbs-up"></i> Approve
                                        </a>
                                <a class="btn btn-danger btn-sm" href="RejectCenter?id=<%= 1234 %>">
                                            <i class="fa fa-ban"></i> Reject
                                        </a>
                            </td>
                        </tr>
                        <tr>
                            <td>1234</td>
                            <td>Flying Feathers</td>
                            <td>Electronic City</td>                            
                            <td>sample@gmail.com</td>
                            <td>9882020205</td>
                            <td>
                           		<!-- Populate the Member ID into this field -->
                           		<a class="btn btn-success btn-sm" href="ApproveCenter?id=<%= 1234 %>">
                                            <i class="fa fa-thumbs-up"></i> Approve
                                        </a>
                                <a class="btn btn-danger btn-sm" href="RejectCenter?id=<%= 1234 %>">
                                            <i class="fa fa-ban"></i> Reject
                                        </a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!-- END DATA TABLE-->
            
            <br/><br/>
        </div>
    	