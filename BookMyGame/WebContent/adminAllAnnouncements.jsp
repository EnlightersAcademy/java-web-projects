<%@page import="com.bookmygame.pojo.Announcement"%>
<%@page import="java.util.List"%>
<%@page import="com.bookmygame.services.impl.CommonServicesImpl"%>
<%@page import="com.bookmygame.services.CommonServices"%>
<jsp:include page="adminHeader.jsp"/>

<%
	CommonServices services = new CommonServicesImpl();
	List<Announcement> announcements = services.getAllAnnoucements();

	//TODO fetch based on the date of raising the announcement and display three columns in table
%>
        <!-- PAGE CONTENT-->
        <div class="page-content--bgf7" style="height: 100%">
        
        	<br/><br/>
        	
        	<!-- DATA TABLE-->
            <div class="table-responsive m-b-40" style="width: 80%; margin: auto;">
                <table class="table table-borderless table-data3">
                    <thead>
                        <tr>
                        	<th style="width: 20%">Date</th>
                            <th style="width: 20%">Announced To</th>
                            <th style="text-align: center;">Announcement</th>
                        </tr>
                    </thead>
                    <tbody>
                    <% 
                    	for(Announcement ann : announcements) {
                    %>
                        <tr>
                            <td><%=ann.getMessageDate().toString() %></td>
                            <td><%=ann.getAnnouncementType().getTypeName() %></td>
                            <td style="text-align: left;"><%= ann.getMessage() %></td>
                        </tr>
                        <%
                    	}
                        %>
                    </tbody>
                </table>
            </div>
            <!-- END DATA TABLE-->
        
        	<br/><br/>
        </div>