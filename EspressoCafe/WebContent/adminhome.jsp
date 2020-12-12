<%@page import="java.util.ArrayList"%>
<%@page import="com.espresso.dto.Item"%>
<%@page import="com.espresso.dto.Customer"%>
<%@ include file="adminheader.jsp"%>
<%@page import="com.espresso.db.util.*" %>
<%@page import="com.espresso.dto.Staff"%>
<%@page import="java.util.List"%>
<%@page import="com.espresso.dto.CafeOrder"%>
<%@page import="com.espresso.db.util.*" %>
<%@page import="com.espresso.util.*" %>
<style>
	@font-face {
		  font-family: Poppins-Regular;
		  src: url('../../fonts/poppins/Poppins-Regular.ttf'); 
		}
	
	.titleText{
		font-family: Poppins-Regular;
		 font-size: 20px;
		 color: #555555;
		 line-height: 1.2;
		 text-transform: uppercase;
		 letter-spacing: 2px;
		 text-align: center;
		
		 width: 100%;
		 display: block;
	}
		
</style>
<%
	List<Customer> cus = DbUtil.getAllCustomers() != null? DbUtil.getAllCustomers() : new ArrayList<Customer>();
	List<Item> items = DbUtil.getAllItems() != null ? DbUtil.getAllItems() : new ArrayList<Item>();
	List<Staff> staffs = DbUtil.getAllActiveStaffs() !=null ? DbUtil.getAllActiveStaffs(): new ArrayList<Staff>();
	List<CafeOrder> orders = DbUtil.getAllOrders() != null? DbUtil.getAllOrders(): new ArrayList<CafeOrder>();
	
%>


<div class="container-fluid" style="vertical-align: middle; width: 50%; text-align:center; margin:auto; margin-top: 5em; margin-bottom: 50px;">
	<img src="assets/images/logo.png"><br/>
	<span class="titleText" style="font-size: x-large;">
						<b>Espresso Café</b>
					</span>
</div>

<div class="row">
    <div class="col-xl-3 col-md-6">
        <div class="card bg-info text-white mb-4">
            <div class="card-body" style="font-size: large;"><i class="fas fa-users"></i> Customers Registered</div>
            <div class="card-footer" style="text-align: right;">
<!--                 <a class="small text-white stretched-link" href="#">View Details</a> -->
                <div class="small text-white" style="font-size: xx-large;"><%=cus.size() %></div>
            </div>
        </div>
    </div>
    <div class="col-xl-3 col-md-6">
        <div class="card bg-info text-white mb-4">
            <div class="card-body" style="font-size: large;"><i class="fas fa-pizza-slice"></i> Items Added</div>
            <div class="card-footer" style="text-align: right;">
<!--                 <a class="small text-white stretched-link" href="#">View Details</a> -->
                <div class="small text-white" style="font-size: xx-large;"><%=items.size() %></div>
            </div>
        </div>
    </div>
    <div class="col-xl-3 col-md-6">
        <div class="card bg-info text-white mb-4">
            <div class="card-body" style="font-size: large;"><i class="fas fa-user-tie"></i> Active Staffs</div>
            <div class="card-footer" style="text-align: right;">
<!--                 <a class="small text-white stretched-link" href="#">View Details</a> -->
                <div class="small text-white" style="font-size: xx-large;"><%=staffs.size() %></div>
            </div>
        </div>
    </div>
    <div class="col-xl-3 col-md-6">
        <div class="card bg-info text-white mb-4">
            <div class="card-body" style="font-size: large;"><i class="fas fa-shopping-cart"></i> Total Orders</div>
            <div class="card-footer" style="text-align: right;">
<!--                 <a class="small text-white stretched-link" href="#">View Details</a> -->
                <div class="small text-white" style="font-size: xx-large;"><%=orders.size() %></div>
            </div>
        </div>
    </div>
</div>



<%@ include file="adminfooter.jsp"%>