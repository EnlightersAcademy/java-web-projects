<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Espresso Café - Admin Dashboard</title>
        <link href="assets/dashboard/css/styles.css" rel="stylesheet" />
        <script src="assets/dashboard/js/font-awesome.all.min.js" crossorigin="anonymous"></script>
    </head>
    
    <body class="sb-nav-fixed">
    	<%
    		String userName = "ADMIN";
    	%>
    
    
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand" href="adminhome.jsp">
            	<img src="assets/images/logo.png" style="width: 20%; vertical-align: middle;" />
            	ESPRESSO CAFÉ
            </a>
            <button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button>
            
            <h4 class="navbar-brand ml-auto mr-0 mr-md-3 my-2 my-md-0"><i class="fas fa-desktop"></i> Admin Dashboard</h4>
            
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                &nbsp;
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ml-auto ml-md-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
<!--                         <a class="dropdown-item" href="staffchangepassword.jsp">Change Password</a> -->
<!--                         <a class="dropdown-item" href="staffupdatedetails.jsp">Update Details</a> -->
<!--                         <div class="dropdown-divider"></div> -->
                        <a class="dropdown-item" href="index.jsp">Logout</a>
                    </div>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                        	<div class="sb-sidenav-menu-heading">Business</div>
                        	<a class="nav-link" href="adminprofitloss.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-line"></i></div>
                                View Profit/Loss
                            </a>
                            
                            <div class="sb-sidenav-menu-heading">Staff</div>
                            <a class="nav-link" href="adminaddstaff.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-user-plus"></i></div>
                                Add New Staff
                            </a>
                            <a class="nav-link" href="adminviewstaff.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-user-tie"></i></div>
                                View All Staffs
                            </a>
                            
                            <div class="sb-sidenav-menu-heading">Items</div>
                            <a class="nav-link" href="admincategory.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-tags"></i></div>
                                Item Categories
                            </a>
                            <a class="nav-link" href="adminadditem.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-coffee"></i></div>
                                Add New Item
                            </a>
                            <a class="nav-link" href="adminviewitem.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-list"></i></div>
                                View All Items
                            </a>
                            
                            <div class="sb-sidenav-menu-heading">Orders</div>
                            <a class="nav-link" href="adminvieworders.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-shopping-cart"></i></div>
                                View All Orders
                            </a>
                            <a class="nav-link" href="adminviewcustomers.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-users"></i></div>
                                View All Customers
                            </a>
                            
                            <div class="sb-sidenav-menu-heading">Raw Materials</div>
                            <a class="nav-link" href="adminaddpurchase.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-plus"></i></div>
                                Add New Entry
                            </a>
                            <a class="nav-link" href="adminviewpurchase.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-shopping-basket"></i></div>
                                View All Purchases
                            </a>
                            
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        <span style="color: white;"><%=userName %></span>
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                	<div class="container-fluid">
                	
                	