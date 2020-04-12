<%@page import="com.bookmygame.pojo.SportCenter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.bookmygame.pojo.Announcement"%>
<%@page import="java.util.Map"%>
<%@page import="com.bookmygame.services.SportCenterOwnerServices"%>
<%@page import="com.bookmygame.services.impl.SportCenterOwnerServicesImpl"%>
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
    <title>Book My Game - Sports Center</title>

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

    <!-- Main CSS-->
    <link href="css/theme.css" rel="stylesheet" media="all">

</head>

<body class="animsition">
	
	<%
			int sportCenterId = request.getSession().getAttribute("centerId") != null ? (Integer)request.getSession().getAttribute("centerId"): -1;
			if(sportCenterId < 0 ){
				response.sendRedirect("centerLogin.jsp?sessionExpired=true");
			}
			
			SportCenterOwnerServices services = new SportCenterOwnerServicesImpl();
            SportCenter center = services.getSportCenterById(sportCenterId);
            if(center == null) {
            	response.sendRedirect("centerLogin.jsp?sessionExpired=true");
            }
            
            String centerName = center.getName();
         %>

    <div class="page-wrapper">
        <!-- HEADER DESKTOP-->
        <header class="header-desktop3 d-none d-lg-block">
            <div class="section__content section__content--p35">
                <div class="header3-wrap">
                    <div class="header__logo">
                        <a href="centerHome.jsp">
                            <img src="images/icon/logo.png" alt="BookMyGame" />
                        </a>
                    </div>
                    <div class="header__navbar">
                        <ul class="list-unstyled">
                        	<li>
                                <a href="centerHome.jsp">
                                    <i class="fas fa-home"></i>
                                    <span class="bot-line"></span>Home</a>
                            </li>
                            <li class="has-sub">
                                <a href="#">
                                    <i class="fas fa-futbol-o"></i>Games
                                    <span class="bot-line"></span>
                                </a>
                                <ul class="header3-sub-list list-unstyled">
                                	<li>
                                        <a href="centerAddGame.jsp">Add New Game</a>
                                    </li>
                                    <li>
                                        <a href="centerViewAllGames.jsp">View All Games</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="has-sub">
                                <a href="#">
                                    <i class="fas fa-book"></i>Bookings
                                    <span class="bot-line"></span>
                                </a>
                                <ul class="header3-sub-list list-unstyled">
                                	<li>
                                        <a href="centerViewBookings.jsp">View All Bookings</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="has-sub">
                                <a href="#">
                                    <i class="fas fa-bullhorn"></i>Announcements
                                    <span class="bot-line"></span>
                                </a>
                                <ul class="header3-sub-list list-unstyled">
                                	<li>
                                        <a href="centerOfferAnnouncement.jsp">New Offer Announcement</a>
                                    </li>
                                </ul>
                            </li>
                            
                        </ul>
                    </div>
                    <div class="header__tool">
                        <div class="account-wrap">
                            <div class="account-item account-item--style2 clearfix js-item-menu">
                                <div class="image">
                                    <img src="images/icon/center.png" alt="Admin" />
                                </div>
                                <div class="content">
                                    <a class="js-acc-btn" href="#"><%= centerName %> </a>
                                </div>
                                <div class="account-dropdown js-dropdown">
                                    <div class="info clearfix">
                                        <div class="image">
                                                <img src="images/icon/center.png" alt="Admin" />
                                        </div>
                                        <div class="content">
                                            <h5 class="name" style="padding-top: 15px;">
                                                <%= centerName %>
                                            </h5>
                                        </div>
                                    </div>
                                    <div class="account-dropdown__body">
                                       <div class="account-dropdown__item">
                                           <a href="centerAccount.jsp">
                                               <i class="zmdi zmdi-account"></i>Account</a>
                                       </div>
                                        <!-- <div class="account-dropdown__item">
                                            <a href="#">
                                                <i class="zmdi zmdi-settings"></i>Setting</a>
                                        </div>
                                        <div class="account-dropdown__item">
                                            <a href="#">
                                                <i class="zmdi zmdi-money-box"></i>Billing</a>
                                        </div>-->
                                    </div>
                                    <div class="account-dropdown__footer">
                                        <a href="centerLogin.jsp">
                                            <i class="zmdi zmdi-power"></i>Logout</a>
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

    <!-- Main JS-->
    <script src="js/main.js"></script>