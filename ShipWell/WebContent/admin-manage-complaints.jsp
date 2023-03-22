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
                        <h1 class="h3 mb-0 text-gray-800">Customer Complaints</h1>
                    </div>

                   
						<!-- PUT THE CONTENT HERE....!! -->
                    	<%
							for (int i = 1; i < 5; i++) {
						%>
	
	
						<div class="card shadow mb-4">
							<!-- Card Header - Accordion -->
							<a href="#collapseCardExample<%=i%>"
								class="d-block card-header py-3 collapsed" data-toggle="collapse"
								role="button" aria-expanded="false"
								aria-controls="collapseCardExample">
								<h6 class="m-0 font-weight-bold text-primary">
									Customer<%=i%> <span class="text-gray-500">against</span> Provider<%=i%></h6>
							</a>
							<!-- Card Content - Collapse -->
							<div class="collapse hide" id="collapseCardExample<%=i%>">
								<div class="card-body">
									The complete description of the complaint written by the customer against the provider should come here.
									<hr/>
									<% 
										if(i%2==0) //Replace this logic with check if the reply is already done by admin or not
										{
											//IF YES
									%>
										<form>
										  <div class="form-row">
										    <div class="col-10">
										      <input type="text" class="form-control" placeholder="Enter your reply here">
										    </div>
										    <div class="col">
										      <button class="btn btn-info btn-icon-split">
			                                        <span class="icon text-white-50">
			                                            <i class="fas fa-comment-dots"></i>
			                                        </span>
			                                        <span class="text">Reply</span>
			                                    </button>
										    </div>
										  </div>
										</form>
									<%
										}
										else
										{
									%>
										<span class="text-warning float-right">You have already replied to this complaint!</span>
									<%} %>
								</div>
							</div>
						</div>
	
						<%
							}
						%>

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