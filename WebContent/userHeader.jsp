<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Match Makers</title>

    <!-- Fontfaces CSS-->
    <link href="css/font-face.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">
    <link href="vendor/vector-map/jqvmap.min.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/theme.css" rel="stylesheet" media="all">

</head>

<body class="animsition">

<%
	String userProfilePic = "images/icon/user.png";	//Get the user's profile pic
	String userName = "User Name";
%>
    <div class="page-wrapper">
        <!-- MENU SIDEBAR-->
        <aside class="menu-sidebar2">
            <div class="logo">
                <a href="userHome.jsp">
                    <img src="images/icon/logo-white.png" alt="Cool Admin" />
                </a>
            </div>
            <div class="menu-sidebar2__content js-scrollbar1">
                <div class="account2">
                    <div class="image img-cir img-120">
                        <img src="<%=userProfilePic %>" />
                    </div>
                    <h4 class="name"><%= userName %></h4>
                    <a href="index.jsp">Sign out</a>
                </div>
                <nav class="navbar-sidebar2">
                    <ul class="list-unstyled navbar__list">
                    	<li>
                            <a href="userHome.jsp">
                                <i class="fas fa-home"></i>Home</a>
                        </li>
                        <li class="has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-user"></i>Personal Details
                                <span class="arrow">
                                    <i class="fas fa-angle-down"></i>
                                </span>
                            </a>
                            <ul class="list-unstyled navbar__sub-list js-sub-list">
                            	<li style="margin-left: 50px;">
                                    <a href="userBasicDetails.jsp">
                                        Basic Details</a>
                                </li>
                                <li style="margin-left: 50px;">
                                    <a href="userJobDetails.jsp">
                                        Professional Details</a>
                                </li>
                                <li style="margin-left: 50px;">
                                    <a href="userFamilyDetails.jsp">
                                        Family Details</a>
                                </li>
                                <li style="margin-left: 50px;">
                                    <a href="userLifestyleDetails.jsp">
                                        Lifestyle Details</a>
                                </li>
                                <li style="margin-left: 50px;">
                                    <a href="userReligionDetails.jsp">
                                        Religion Details</a>
                                </li>
                            </ul>
                        </li>
                        <!-- <li>
                            <a href="inbox.html">
                                <i class="fas fa-chart-bar"></i>Inbox</a>
                            <span class="inbox-num">3</span>
                        </li> -->
                        <li>
                            <a href="userPhotoGallery.jsp">
                                <i class="fas fa-picture-o"></i>Photo Gallery</a>
                        </li>
                        <li>
                            <a href="userAccountVerification.jsp">
                                <i class="fas fa-check-circle"></i>Account Verification</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </aside>
        <!-- END MENU SIDEBAR-->

        <!-- PAGE CONTAINER-->
        <div class="page-container2">
            <!-- HEADER DESKTOP-->
            <header class="header-desktop2">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="header-wrap2">
                            <div class="logo d-block d-lg-none">
                                <a href="userHome.jsp">
                                    <img src="images/icon/logo-white.png" alt="Match Makers" />
                                </a>
                            </div>
                            <div class="header-button2">
                                <div class="header-button-item">
                                    <a href="userSearch.jsp" style="color: white;"><i class="zmdi zmdi-search"></i></a>
                                </div>
                                <div class="header-button-item has-noti js-item-menu">
                                    <i class="zmdi zmdi-alert-polygon"></i>
                                    <div class="notifi-dropdown js-dropdown">
                                        <div class="notifi__title">
                                            <p>Offers from Match Makers</p>
                                        </div>
                                        
                                        <!-- Populate all Admin Offers Here. Better to populate only LATEST TWO. -->
                                        <div class="notifi__item">
                                            <div class="bg-c3 img-cir img-40">
                                                <i class="zmdi zmdi-notifications"></i>
                                            </div>
                                            <div class="content">
                                                <p>This is a sample Offer. Contact Customer Care.</p>
                                            </div>
                                        </div>
                                        <div class="notifi__item">
                                            <div class="bg-c3 img-cir img-40">
                                                <i class="zmdi zmdi-notifications"></i>
                                            </div>
                                            <div class="content">
                                                <p>This is a sample Offer. Contact Customer Care.</p>
                                            </div>
                                        </div>
                                        
                                        
                                    </div>
                                </div>
                                <div class="header-button-item js-item-menu">
                                    <i class="zmdi zmdi-settings"></i>
                                    <div class="notifi-dropdown js-dropdown">
		                                   <div class="account-dropdown__body">
		                                    <div class="account-dropdown__item">
		                                        <a href="userChangePassword.jsp">
		                                            <i class="zmdi zmdi-account"></i>Change Password</a>
		                                    </div>
		                                    <div class="account-dropdown__item">
		                                        <a href="userChangeProfile.jsp">
		                                            <i class="zmdi zmdi-widgets"></i>Change Profile Status</a>
		                                    </div>
		                                </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
            
            <!-- END HEADER DESKTOP-->

            

    <!-- Jquery JS-->
    <script src="vendor/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap JS-->
    <script src="vendor/bootstrap-4.1/popper.min.js"></script>
    <script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
    <!-- Vendor JS       -->
    <script src="vendor/slick/slick.min.js">
    </script>
    <script src="vendor/wow/wow.min.js"></script>
    <script src="vendor/animsition/animsition.min.js"></script>
    <script src="vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
    </script>
    <script src="vendor/counter-up/jquery.waypoints.min.js"></script>
    <script src="vendor/counter-up/jquery.counterup.min.js">
    </script>
    <script src="vendor/circle-progress/circle-progress.min.js"></script>
    <script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
    <script src="vendor/chartjs/Chart.bundle.min.js"></script>
    <script src="vendor/select2/select2.min.js">
    </script>
    <script src="vendor/vector-map/jquery.vmap.js"></script>
    <script src="vendor/vector-map/jquery.vmap.min.js"></script>
    <script src="vendor/vector-map/jquery.vmap.sampledata.js"></script>
    <script src="vendor/vector-map/jquery.vmap.world.js"></script>

    <!-- Main JS-->
    <script src="js/main.js"></script>

