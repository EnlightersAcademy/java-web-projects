<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>ShipWell</title>

<!-- Custom fonts for this template-->
<link href="assets/vendor/fontawesome-free/css/all.css" rel="stylesheet"
	type="text/css">
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
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">Admin Dashboard</h1>
					</div>

					<div class="row">

						<!-- Earnings (Monthly) Card Example -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-primary text-uppercase mb-1">
												Total Providers</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800"><%=30%></div>
										</div>
										<div class="col-auto">
											<i class="fas fa-truck-fast fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- Earnings (Annual) Card Example -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-success shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-success text-uppercase mb-1">
												Total Customers</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800"><%=50%></div>
										</div>
										<div class="col-auto">
											<i class="fas fa-people-group fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- Tasks Card Example -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-info shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-info text-uppercase mb-1">
												Total Transactions</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800">
												&#8377;
												<%=3450%></div>
										</div>
										<div class="col-auto">
											<i class="fas fa-sack-dollar fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- Pending Requests Card Example -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-warning shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-warning text-uppercase mb-1">
												Total Complaints</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800"><%=12%></div>
										</div>
										<div class="col-auto">
											<i class="fas fa-comments fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="row">

						<!-- Illustrations -->
						<div class="card shadow mb-4">

							<div class="card-body">
								<div class="text-center">
									<img class="img-fluid px-3 px-sm-4 mt-3 mb-4"
										style="width: 25rem;" src="assets/img/adminhome.jpg" alt="...">
								</div>
								<p>Welcome Admin. Here you can control the whole ShipWell
									system. You have access to all providers and the customers
									data. Please keep company's guidelines in mind while handling the
									data!</p>
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