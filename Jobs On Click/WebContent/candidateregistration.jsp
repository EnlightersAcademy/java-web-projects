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
    <title>Register</title>

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
            background: url("images/loginimage.jpg") center no-repeat;
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
                                <img src="images/applogo2.jpg" alt="CoolAdmin" style="width: 270px;height: 120px;">
                            </a>
                            <div><strong>Candidate Registration</strong></div>
                             <% 
			                       String message = (String)request.getAttribute("message");
			                        if(request.getAttribute("message")!=null)
			                        { %>
			                        <div class="alert alert-danger" role="alert">
										<%=message %>
									</div>
									<%	} 
							%>
                        </div>
                        <div class="login-form">
                            <form action="RegisterCandidate" method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label>Candidate Name</label>
                                    <input required="required" class="au-input au-input--full" type="text" name="candidateName" placeholder="Name">
                                </div>
                                <div class="form-group">
                                    <label>Candidate Email Address</label>
                                    <input required="required" class="au-input au-input--full" type="email" name="candidateEmail" placeholder="Email Address">
                                </div>
                                <div class="form-group">
                                    <label>Password</label>
                                    <input required="required" class="au-input au-input--full" type="password" name="candidatePassword" placeholder="Password">
                                </div>
                                <div class="form-group">
                                    <label>Candidate Summary</label>
                                    <input required="required" class="au-input au-input--full" type="text" name="candidateSummary" placeholder="Candidate Summary">
                                </div>
                                <div class="form-group">
                                    <label>Candidate Experience</label>
                                    <input required="required" class="au-input au-input--full" type="text" name=candidateExperience placeholder="E.g 2 Years 3 Months">
                                </div>
                                <div class="form-group">
                                    <label>Candidate Skills</label>
                                    <input required="required" class="au-input au-input--full" type="text" name="candidateSkills" placeholder="E.g Networking, Java, Python">
                                </div>
                                <div class="form-group">
                                    <label>Candidate Contact Number</label>
                                    <input class="au-input au-input--full" type="text" name="candidateContact" placeholder="Candidate Contact" required maxlength="10" pattern="[0-9]{10,10}">
                                </div>
                                <div class="form-group">
                                    <label>Upload Resume</label>
                                    <input required="required" class="btn btn-info au-btn--block" type="file" name="resume" id="resume">
                                </div>
                                <div class="form-group">
                                    <label>Upload Photo</label>
                                    <input class="btn btn-info au-btn--block" type="file" name="profile" id="profile">
                                </div>
                                <button class="au-btn au-btn--block au-btn--green m-b-20" type="submit">register</button>
                                
                            </form>
                            <div class="register-link">
                                <p>
                                    Already have account?
                                    <a href="index.jsp">Sign In</a>
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