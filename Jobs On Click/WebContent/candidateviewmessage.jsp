<%@page import="com.jobsonclick.models.Message"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="candidateheader.jsp" /> 

            <!-- MAIN CONTENT-->
     <div class="main-content">
		<div class="contact1">
		<div class="container-contact1">
			<div class="contact1-pic js-tilt" data-tilt>
				<img src="images/img-01.png" alt="IMG">
			</div>
			<%
				Message message = (Message)request.getAttribute("message");
			%>
			<form action="ReplyMessage" method="get" class="contact1-form validate-form">
			<span class="contact1-form-title">
					<%=request.getParameter("type").equalsIgnoreCase("inbox")?"Inbox Messages":"Sent Messages" %>
			</span>
				
				<div class="wrap-input1 validate-input input-group">
					<div class="input-group-prepend">
    					<span class="input-group-text" id="basic-addon1">From</span>
 					</div>
					<input class="input1 form-control" type="text" value="<%=message.getMessageFrom() %>" readonly="readonly">
					
				</div>

				<div class="wrap-input1 validate-input input-group" data-validate = "Valid email is required: ex@abc.xyz">
				<div class="input-group-prepend">
    					<span class="input-group-text" id="basic-addon1">To</span>
 					</div>
					<input class="input1 form-control" type="text"  value="<%=message.getMessageTo() %>" readonly="readonly" >
					
				</div>

				<div class="wrap-input1 validate-input input-group" data-validate = "Subject is required">
				<div class="input-group-prepend">
    					<span class="input-group-text" id="basic-addon1">Subject</span>
 					</div>
					<!-- <input class="input1" type="text" name="subject" value="JObId: 1234 Web Development Openingsfgsgfsgsgdsgdsgsdgsdgs" readonly="readonly">-->
					<textarea class="input1 form-control"  readonly="readonly" rows="2" style="min-height: 0px;"><%=message.getSubject() %></textarea>
					
				</div>

				<div class="wrap-input1 validate-input input-group" data-validate = "Message is required">
			
					<textarea class="input1 form-control" readonly="readonly"><%=message.getBody() %></textarea>
					
				</div>

				<div class="container-contact1-form-btn">
					<% if(request.getParameter("type").equalsIgnoreCase("inbox")) {%>
					<input type="hidden" name="role" value="candidate"/>
					<input type="hidden" name="messageId" value="<%=message.getMessageId()%>"/>
					<button type="submit" class="contact1-form-btn">
						<span>
							Reply
							<i class="fa fa-reply" aria-hidden="true"></i>
						</span>
					</button>
					<%
					}
					%>
					<a href="ViewMessages?type=<%=request.getParameter("type")%>&role=candidate" class="contact1-form-btn">
						<span>
							Go Back
							<i class="fa fa-undo" aria-hidden="true"></i>
						</span>
					</a>
				</div>
			</form>
		</div>
	</div>