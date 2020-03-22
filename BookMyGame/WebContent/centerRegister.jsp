<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <!-- Title Page-->
    <title>Book My Game - Register</title>

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

    <style>
        body {
            background: url("images/mainbg.jpg") center no-repeat;
            background-size: cover;
        }
    </style>

</head>

<body class="animsition">
    <div class="page-wrapper">
        <div class="page-content--bge5">
            <div class="container">
                <div class="login-wrap">
                    <div class="login-content">
                        <div class="login-logo">
                            <a href="index.jsp">
                                <img src="images/icon/logo.png" alt="CoolAdmin">
                            </a>
                        </div>
                        <div class="login-form">
                            <form action="center/register" method="post">
                            	<div class="form-group">
                                    <label>Sports Center Name</label>
                                    <input class="au-input au-input--full" type="text" name="name" required placeholder="Name">
                                </div>
                                <div class="form-group">
                                    <label>Location</label>
                                    <input class="au-input au-input--full" type="text" name="location" required placeholder="Location">
                                </div>
                                <div class="form-group">
                                    <label>Address</label>
                                    <textarea class="au-input au-input--full" rows="2" cols="50"  name="address" required placeholder="Complete Address">
                                    </textarea>
                                </div>
                                <div class="form-group">
                                    <label>Center Email ID</label>
                                    <input class="au-input au-input--full" type="email" required name="email"
                                        placeholder="Email">
                                </div>
                                <div class="form-group">
                                    <label>Login Password</label>
                                    <input class="au-input au-input--full" type="password" name="password"
                                        required placeholder="Password">
                                </div>
                                <div class="form-group">
                                    <label>Center Phone Number</label>
                                    <input class="au-input au-input--full" type="text" name="phone" maxlength="10" required placeholder="Phone">
                                </div>                                
                                <div class="form-inline form-group">
                                    <label for="twowheeleravailable">Two Wheeler Parking Available?</label> &nbsp;&nbsp;
                                    <label class="switch switch-3d switch-primary mr-3">
				                      <input type="checkbox" class="switch-input" name="twowheeleravailable" id="twowheeleravailable">
				                      <span class="switch-label"></span>
				                      <span class="switch-handle"></span>
				                    </label>
                                </div>
                                <div class="form-inline form-group">
                                    <label for="fourwheeleravailable">Four Wheeler Parking Available?</label> &nbsp;&nbsp;
                                    <label class="switch switch-3d switch-primary mr-3">
				                      <input type="checkbox" class="switch-input" name="fourwheeleravailable" id="fourwheeleravailable">
				                      <span class="switch-label"></span>
				                      <span class="switch-handle"></span>
				                    </label>
                                </div>
                                
                                <hr/>
                                
                                <div class="form-group">
                                    <label>Owner's Name</label>
                                    <input class="au-input au-input--full" type="text" name="ownername" required placeholder="Owner's Name">
                                </div>
                                <div class="form-group">
                                    <label>Owner's Email ID</label>
                                    <input class="au-input au-input--full" type="email" name="owneremail"
                                        required placeholder="Owner's Email">
                                </div>
                                <div class="form-group">
                                    <label>Owner's Phone Number</label>
                                    <input class="au-input au-input--full" type="text" name="ownerphone" maxlength="10" required placeholder="Owner's Phone">
                                </div>
                                <div class="form-group">
                                    <label>Owner's ID Number</label>
                                    <input class="au-input au-input--full" type="text" name="ownerid" required placeholder="Owner's ID Number">
                                </div>
                                <button class="au-btn au-btn--block au-btn--green m-b-20"
                                    type="submit">register</button>
                            </form>
                            <div class="register-link">
                                <p>
                                    Already have account?
                                    <a href="centerLogin.jsp">Sign In</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

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

</body>

</html>
<!-- end document-->