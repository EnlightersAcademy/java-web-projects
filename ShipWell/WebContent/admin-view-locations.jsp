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

<link href="assets/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

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
						<h1 class="h3 mb-0 text-gray-800">Locations where ShipWell
							Partners are Available</h1>
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
								State<%=i%></h6>
						</a>
						<!-- Card Content - Collapse -->
						<div class="collapse hide" id="collapseCardExample<%=i%>">
							<div class="card-body">
								<%
									for (int j = 1; j < 9; j++) {
								%>
								City Location
								<%=j%>,
								<%
									}
								%>
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
