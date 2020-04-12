<%@page import="com.bookmygame.pojo.Customer"%>
<%@page import="com.bookmygame.services.impl.CustomerServicesImpl"%>
<%@page import="com.bookmygame.services.CustomerServices"%>
<jsp:include page="userHeader.jsp"/>

        <!-- PAGE CONTENT-->
        <div class="page-content--bgf7" style="height: 100%">

			<br/><br/>
        	
        	<div class="jumbotron" style="width: 50%; margin: auto;">
        		<h2 class="display-5">Update Account Details</h2>
			  	<br/>
	            <div class="login-form">
	            <%
	            int customerId = (Integer)request.getSession().getAttribute("customerId");
	            CustomerServices services = new CustomerServicesImpl();
	            Customer customer = services.getCustomerById(customerId);
	            if(customer == null) {
	            	response.sendRedirect("index.jsp?sessionExpired=true");
	            }
	            if(request.getParameter("result") != null) {
	            	if(request.getParameter("result") .equals("fail")) {
	            		out.println("<script>alert('Customer details update Failed. Please try again')</script>");
	            	} else if(request.getParameter("result") .equals("success")) {
	            		out.println("<script>alert('Details updated Successfully')</script>");
	            	}
	            }
	            %>
	            	<!-- All the Data should be populated in these fields. Few fields we can keep readonly.  -->
	                            <form action="customer-update" method="post">
	                            	<div class="form-group">
	                                    <label>Name</label>
	                                    <input class="au-input au-input--full" type="text" name="name" readonly value="<%=customer.getName() %>">
	                                </div>
	                                <div class="form-group">
	                                    <label>Date of Birth</label>
	                                    <input class="au-input au-input--full" type="text" name="dob" readonly value =<%=customer.getDob() %>>
	                                </div>
	                                <div class="form-group">
	                                    <label>Gender</label>
	                                    <input class="au-input au-input--full" type="text" name="gender" readonly value=<%=customer.getSex() %>>
	                                </div>
	                                <div class="form-group">
	                                    <label>Address</label>
	                                    <textarea class="au-input au-input--full" rows="2" cols="50"  name="address" placeholder="Address"><%=customer.getAddress()%></textarea>
	                                    
	                                </div>
	                                <div class="form-group">
	                                    <label>Location</label>
	                                    <input class="au-input au-input--full" type="text" name="location" required value ="<%=customer.getLocation() %>" placeholder="Location">
	                                </div>
	                                <div class="form-group">
	                                    <label>Email Address</label>
	                                    <input class="au-input au-input--full" type="email" name="email" value =<%=customer.getEmailId()%> readonly>
	                                </div>
	                                <div class="form-group">
	                                    <label>Password</label>
	                                    <input class="au-input au-input--full" type="password" name="password"
	                                        required value =<%=customer.getPassword() %> placeholder="Password">
	                                </div>
	                                <div class="form-group">
	                                    <label>Phone Number</label>
	                                    <input class="au-input au-input--full" type="text" name="phone" maxlength="10" required pattern="[0-9]{10,10}" value =<%=customer.getPhoneNo()%> placeholder="Phone">
	                                </div>
	                                <div class="form-group">
	                                    <label>ID Number (Any Govt. Issued ID Card)</label>
	                                    <input class="au-input au-input--full" type="text" name="identityNumber" required value =<%=customer.getIdentificationId() %> placeholder="ID Number">
                                	</div>
	                                <button class="au-btn au-btn--block au-btn--green m-b-20"
	                                    type="submit">Update</button>
	                            </form>
                   </div>
            </div>
    	</div>
