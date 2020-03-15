<%@page import="java.util.Map"%>
<%@page import="com.bookmygame.pojo.GameBooking"%>
<%@page import="com.bookmygame.pojo.SportCenter"%>
<%@page import="java.util.List"%>
<%@page import="com.bookmygame.services.AdminServices"%>
<%@page import="com.bookmygame.services.impl.AdminServicesImpl"%>
<jsp:include page="adminHeader.jsp"/>

        <!-- PAGE CONTENT-->
        <div class="page-content--bgf7" style="height: 100%">

			<%
			AdminServices services = new AdminServicesImpl();
    		Map<String, Integer> countMap = services.getProvisionToActiveCountMap();
    		int activeMembers = 0;
    		int activeSportCenter = 0;
    		int bookings = 0;
    		if(countMap != null && !countMap.isEmpty()) {
    			activeMembers = countMap.get("customer");
    			activeSportCenter = countMap.get("sportCenter");
    			bookings = countMap.get("booking");
    		}
			%>
            <!-- STATISTIC-->
            <section class="statistic statistic2">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 col-lg-3">
                            <div class="statistic__item statistic__item--green">
                                <h2 class="number"><%= activeMembers %></h2>
                                <span class="desc">Active members</span>
                                <div class="icon">
                                    <i class="zmdi zmdi-account-o"></i>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-3">
                            <div class="statistic__item statistic__item--orange">
                                <h2 class="number"> <%=activeSportCenter %></h2>
                                <span class="desc">Active sports centers</span>
                                <div class="icon">
                                    <i class="zmdi zmdi-home"></i>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-3">
                            <div class="statistic__item statistic__item--blue">
                                <h2 class="number"><%=bookings %></h2>
                                <span class="desc">Bookings</span>
                                <div class="icon">
                                    <i class="zmdi zmdi-calendar-note"></i>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-3">
                            <div class="statistic__item statistic__item--red">
                                <h2 class="number"><%=8 %></h2>
                                <span class="desc">games</span>
                                <div class="icon">
                                    <i class="zmdi zmdi-bike"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- END STATISTIC-->
    	</div>


