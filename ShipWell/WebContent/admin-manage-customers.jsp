<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>ShipWell</title>

    <!-- Custom fonts for this template-->
    <link href="assets/vendor/fontawesome-free/css/all.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="assets/css/sb-admin-2.css" rel="stylesheet">
    
    <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />

	<link href="assets/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <jsp:include page="admin-sidebar.jsp"></jsp:include>
        
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                	<jsp:include page="admin-navbar.jsp"></jsp:include>
                <!-- End of Topbar -->

                <!-- PAGE CONTENT -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">All Registered Customers</h1>
                    </div>

                   
						<!-- PUT THE CONTENT HERE....!! -->
                    	<div class="card shadow mb-4">
	                        <!-- <div class="card-header py-3">
	                            <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
	                        </div> -->
	                        <div class="card-body">
	                            <div class="table-responsive">
	                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
	                                    <thead>
	                                        <tr>
	                                            <th>Customer ID</th>
	                                            <th>Name</th>
	                                            <th>Email ID</th>
	                                            <th>Contact Number</th>
	                                            <th>Action</th>
	                                        </tr>
	                                    </thead>
	                                    <tfoot>
	                                        <tr>
	                                            <th>Customer ID</th>
	                                            <th>Name</th>
	                                            <th>Email ID</th>
	                                            <th>Contact Number</th>
	                                            <th>Action</th>
	                                        </tr>
	                                    </tfoot>
	                                    <tbody>
	                                    	<% for(int i=1; i<40; i++){ %>
		                                        <tr>
		                                            <td>CUS<%=i %></td>
		                                            <td>Customer Name <%=i %></td>
		                                            <td>abcxyz@gmail.com</td>
		                                            <td>9885098850</td>
		                                            <td>
		                                            	<% 
		                                            		boolean isActive = i%2==0; //Replace this logic with isActive value from DB
		                                            		if(isActive)
		                                            		{
		                                            	%>
															<a href="#" class="btn btn-danger btn-icon-split">
						                                        <span class="icon text-white-50">
						                                            <i class="fas fa-lock"></i>
						                                        </span>
						                                        <span class="text">Block User &nbsp;&nbsp;&nbsp;&nbsp;</span>
						                                    </a>
						                                 <%
		                                            		}
		                                            		else
		                                            		{
						                                 %>
						                                 	<a href="#" class="btn btn-success btn-icon-split">
						                                        <span class="icon text-white-50">
						                                            <i class="fas fa-lock-open"></i>
						                                        </span>
						                                        <span class="text">Unblock User</span>
						                                    </a>
						                                 <%} %>
													</td>
		                                        </tr>
	                                        <%} %>
	                                    </tbody>
	                                </table>
	                            </div>
	                        </div>
	                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; ShipWell</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Footer -->
    <jsp:include page="footer.jsp"></jsp:include>

</body>

</html>