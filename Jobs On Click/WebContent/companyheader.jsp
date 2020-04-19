<%@page import="java.util.Base64"%>
<%@page import="com.jobsonclick.models.Company"%>
<%@page import="com.jobsonclick.dao.MessageDao"%>
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
    <title>Jobs On Click</title>

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
    
    <!--  Links for Message template -->
    <!--===============================================================================================-->
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->

</head>

<body class="animsition">
 		
    <div class="page-wrapper">
       
      
       <%	
       		Company company = session.getAttribute("company")==null? null : (Company)session.getAttribute("company");
       		if(company ==null)
       		{
       			response.sendRedirect("companylogin.jsp?sessionExpired=true");
       		}
       		MessageDao messageDao = new MessageDao();
       		int messageCount = messageDao.unreadMessagesCount(company.getCompanyEmail());  
       	 String base64Image = Base64.getEncoder().encodeToString(company.getLogo());
       %>
        <!-- MENU SIDEBAR-->
        <aside class="menu-sidebar d-none d-lg-block">
            <div class="logo">
                <a href="CompanyHome">
                   <img src="images/applogo2.jpg" alt="CoolAdmin" style="width: 190px; height: 75px;">
                </a>
            </div>
            <div class="menu-sidebar__content js-scrollbar1">
                <nav class="navbar-sidebar">
                    <ul class="list-unstyled navbar__list">
                        <li class="has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-envelope"></i>Messages</a>
                            <ul class="list-unstyled navbar__sub-list js-sub-list">
                                <li>
                                    <a href="ViewMessages?role=company&type=inbox">Inbox <span class ="badge badge-warning" ><%=messageCount %></span></a>
                                </li>
                                <li>
                                    <a href="ViewMessages?role=company&type=outbox">Sent Items</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="companysearchcandidates.jsp?searched=false">
                                <i class="fas fa-search"></i>Search Candidates</a>
                        </li>
                       <li class="has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-envelope"></i>View Openings</a>
                            <ul class="list-unstyled navbar__sub-list js-sub-list">
                                <li>
                                    <a href="ViewJobs?type=active">Active Openings</a>
                                </li>
                                <li>
                                    <a href="ViewJobs?type=expired">Expired Openings</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="companyaddjob.jsp">
                                <i class="far fa-check-square"></i>Add New Opening</a>
                        </li>
                        <li>
                            <a href="ViewApplications">
                                <i class="fas fa-tasks"></i>Applications Received</a>
                        </li>
                   
                    </ul>
                </nav>
            </div>
        </aside>
        <!-- END MENU SIDEBAR-->

        <!-- PAGE CONTAINER-->
        <div class="page-container">
            <!-- HEADER DESKTOP-->
            <header class="header-desktop">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="header-wrap">
                           <!-- <form class="form-header" action="" method="POST">
                                <input class="au-input au-input--xl" type="text" name="search" placeholder="Search for datas &amp; reports..." />
                                <button class="au-btn--submit" type="submit">
                                    <i class="zmdi zmdi-search"></i>
                                </button> 
                            </form>-->
                            <div class="account-wrap">
                             <div class="account-item clearfix js-item-menu">
                            <div class="image">
                               
                             </div>
                             </div>
                             </div>
                             <div style="height: 45px; width: 120px;">
                             	<img src="data:image/jpg;base64,<%=base64Image %>" height=100% />
                             </div>
                             
                            <div class="header-button">
                                
                                <div class="account-wrap">
                                    <div class="account-item clearfix js-item-menu">
                                        <div class="content">
                                            <a class="js-acc-btn" href="#">Account Settings</a>
                                        </div>
                                        <div class="account-dropdown js-dropdown">
                                            <div class="info clearfix">
                                                <div class="image" >
                                                   
                                                         <img src="data:image/jpg;base64,<%=base64Image %>" style="vertical-align: middle;" />
                                                   
                                                </div>
                                                <div class="content">
                                                    <h5 class="name">
                                                       <%=company.getCompanyName() %>
                                                    </h5>
                                                    <span class="email"><%=company.getCompanyEmail() %></span>
                                                </div>
                                            </div>
                                            <div class="account-dropdown__body">
                                                <div class="account-dropdown__item">
                                                    <a href="companyupdateprofile.jsp">
                                                        <i class="zmdi zmdi-account"></i>Update Profile</a>
                                                </div>
                                                <div class="account-dropdown__item">
                                                    <a href="companychangepassword.jsp">
                                                        <i class="zmdi zmdi-account"></i>Change Password</a>
                                                </div>
                                            </div>
                                            <div class="account-dropdown__footer">
                                                <a href="Logout">
                                                    <i class="zmdi zmdi-power"></i>Logout</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
            <!-- HEADER DESKTOP-->

 

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


	<script src="vendor/tilt/tilt.jquery.min.js"></script>
	<script >
		$('.js-tilt').tilt({
			scale: 1.1
		})
	</script>
    <!-- Main JS-->
    <script src="js/main.js"></script>

