<jsp:include page="adminHeader.jsp"/>

        <!-- PAGE CONTENT-->
        <div class="page-content--bgf7" style="height: 100%">
        	
        	<br/><br/>
        	
        	<!-- DATA TABLE-->
            <div class="table-responsive m-b-40" style="width: 80%; margin: auto;">
                <table class="table table-borderless table-striped table-earning ">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Gender</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th> </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1234</td>
                            <td>Sample Name</td>
                            <td>Male</td>                            
                            <td>sample@gmail.com</td>
                            <td>9882020205</td>
                            <td>
                           		<!-- Populate the Member ID into this field -->
                           		<a class="btn btn-danger btn-sm" href="BlockUser?id=<%= 1234 %>">
                                            <i class="fa fa-ban"></i> Block
                                        </a>
                            </td>
                        </tr>
                        <tr>
                            <td>1234</td>
                            <td>Sample Name</td>
                            <td>Male</td>
                            <td>sample@gmail.com</td>
                            <td>9882020205</td>
                            <td>
                           		<!-- Populate the Member ID into this field -->
                           		<a class="btn btn-danger btn-sm" href="BlockUser?id=<%= 1234 %>">
                                            <i class="fa fa-ban"></i> Block
                                        </a>
                            </td>
                        </tr>
                        <tr>
                            <td>1234</td>
                            <td>Sample Name</td>
                            <td>Male</td>
                            <td>sample@gmail.com</td>
                            <td>9882020205</td>
                            <td>
                           		<!-- Populate the Member ID into this field -->
                           		<a class="btn btn-danger btn-sm" href="BlockUser?id=<%= 1234 %>">
                                            <i class="fa fa-ban"></i> Block
                                        </a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!-- END DATA TABLE-->
            
            <br/><br/>
        </div>
    	