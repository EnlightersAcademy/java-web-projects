<%@page import="com.jobsonclick.models.Message"%>
<%@page import="java.util.List"%>
<jsp:include page="candidateheader.jsp" /> 

            <!-- MAIN CONTENT-->
            <div class="main-content">
                <div class="section__content section__content--p30">
                
                <% 
                       String message = (String)request.getAttribute("message");
                        if(request.getAttribute("message")!=null)
                        { %>
                        <div class="alert alert-info" role="alert">
							<%=message %>
						</div>
						<%	} 
				%>
                
                   <div class="row m-t-30">
                            <div class="col-md-12">
                            	<div class="overview-wrap">
                                    <strong><%=(request.getParameter("type").equalsIgnoreCase("inbox"))?"Inbox Messages":"Sent Messages" %></strong>                 
                                </div>
                                
                                <!--Inbox DATA TABLE-->
                                
                                <%	
                                List<Message> messageList = (List<Message>)request.getAttribute("messageList");
                                	if(request.getParameter("type").equalsIgnoreCase("inbox")){
                                %>
                                
                                <%if(request.getAttribute("messageList")==null || messageList.size()==0) {
                                	%>
                                	 <div class="table-responsive m-b-40" style="text-align: center; padding-top: 150px; color: #AEB6BF;">
                                	<strong>No messages available</strong>
                                	</div>
                                	<%	
                                	}
                                	else{
                                		
                                	%>
                                <div class="table-responsive m-b-40">
                                    <table class="table table-borderless table-data3">
                                        <thead>
                                            <tr>
                                                <th>From</th>
                                                <th>Date</th>
                                                <th>Subject</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<%
                                        		
                                        		for(Message msg: messageList){
                                        			if(msg.isStatus()){
                                        				%>
                                        				<tr style="font-weight: bold;">
                                        					<td><a href="ViewMessage?type=<%=request.getParameter("type")%>&role=candidate&messageId=<%=msg.getMessageId()%>"><%=msg.getMessageFrom() %></a></td>
                                                			<td><%=msg.getDate()%></td>
                                                			<td><%=msg.getSubject() %></td>
                                           				</tr>
                                        				<%
                                        			}
                                        			else{
                                        			
                                       			 %>
                                            	<tr>
                                                	<td><a href="ViewMessage?type=<%=request.getParameter("type")%>&role=candidate&messageId=<%=msg.getMessageId()%>"><%=msg.getMessageFrom() %></a></td>
                                                	<td><%=msg.getDate()%></td>
                                                	<td><%=msg.getSubject() %></td>
                                           		</tr>
                                            <%
                                        			}
                                        	}
                                            %>
                                        </tbody>
                                    </table>
                                    <%
                                	}
                                    %>
                                </div>
                                <!-- END DATA TABLE-->
                                <%
                                	}
                                	else{
                                %>
                                
                                <!-- Outbox DATA TABLE-->
                                
                                <%if(request.getAttribute("messageList")==null || messageList.size()==0) {
                                	%>
                                	 <div class="table-responsive m-b-40" style="text-align: center; padding-top: 150px; color: #AEB6BF;">
                                	<strong>No messages available</strong>
                                	</div>
                                	<%	
                                	}
                                	else{
                                		
                                	%>
                                <div class="table-responsive m-b-40">
                                    <table class="table table-borderless table-data3">
                                        <thead>
                                            <tr>
                                                <th>From</th>
                                                <th>Date</th>
                                                <th>Subject</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<%
                                        		
                                        		for(Message msg: messageList){
                                       		 %>
                                            	<tr>
                                                	<td><a href="ViewMessage?type=<%=request.getParameter("type")%>&role=candidate&messageId=<%=msg.getMessageId()%>"><%=msg.getMessageFrom() %></a></td>
                                                	<td><%=msg.getDate()%></td>
                                                	<td><%=msg.getSubject() %></td>
                                           		</tr>
                                            <%
                                        	}
                                            %>
                                        </tbody>
                                    </table>
                                    <%
                                	}
                                    %>
                                </div>
                                <!-- END DATA TABLE-->
                                <%
                                	}
                                %>
                            </div>
                        </div>
                </div>
            </div>
            <!-- END MAIN CONTENT-->
            <!-- END PAGE CONTAINER-->
        </div>

    </div>


