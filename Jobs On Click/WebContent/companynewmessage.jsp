<%@page import="com.jobsonclick.models.Message"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="companyheader.jsp" /> 

            <!-- MAIN CONTENT-->
     <div class="main-content">
		<div class="contact1">
		<div class="container-contact1">
			<div class="contact1-pic js-tilt" data-tilt>
				<img src="images/img-01.png" alt="IMG">
			</div>
			<%
				String messageFrom = request.getAttribute("messageFrom")==null?"":(String)request.getAttribute("messageFrom");
				String messageTo = request.getAttribute("messageTo")==null?"":(String)request.getAttribute("messageTo");
				String subject = request.getAttribute("subject")==null?"":(String)request.getAttribute("subject");
			%>
			<form action="SendMessage" method="post" class="contact1-form validate-form">
			<span class="contact1-form-title">
					Send message to candidate
			</span>
				<div class="wrap-input1 validate-input input-group">
					<div class="input-group-prepend">
    					<span class="input-group-text" id="basic-addon1">From</span>
 					</div>
					<input class="input1 form-control" type="text" name="messageFrom" value="<%=messageFrom%>" readonly="readonly">
					<span class="shadow-input1"></span>
				</div>

				<div class="wrap-input1 validate-input input-group" data-validate = "Valid email is required: ex@abc.xyz">
					<div class="input-group-prepend">
    					<span class="input-group-text" id="basic-addon1">To</span>
 					</div>
					<input class="input1 form-control" type="text" name="messageTo" value="<%=messageTo%>" readonly="readonly" >
					<span class="shadow-input1"></span>
				</div>

				<div class="wrap-input1 validate-input input-group" data-validate = "Subject is required">
					<div class="input-group-prepend">
    					<span class="input-group-text" id="basic-addon1">Subject</span>
 					</div>
					<!-- <input class="input1" type="text" name="subject" value="JObId: 1234 Web Development Openingsfgsgfsgsgdsgdsgsdgsdgs" readonly="readonly">-->
					<textarea class="input1 form-control" name="subject" rows="2" style="min-height: 0px;"><%=subject%></textarea>
					<span class="shadow-input1"></span>
				</div>

				<div class="wrap-input1 validate-input" data-validate = "Message is required">
					<textarea class="input1" name="body"></textarea>
					<span class="shadow-input1"></span>
				</div>

				<div class="container-contact1-form-btn">
					<input type="hidden" name="role" value="company" />
					<input type="hidden" name="type" value="outbox" />
					<button type="submit" class="contact1-form-btn">
						<span>
							Send Message
							<i class="fa fa-reply" aria-hidden="true"></i>
						</span>
					</button>
				</div>
			</form>
		</div>
	</div>