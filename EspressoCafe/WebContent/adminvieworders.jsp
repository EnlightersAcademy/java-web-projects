<%@page import="java.util.Date"%>

<%@ include file="adminheader.jsp"%>

<link href="assets/datatable/datatable.bootstrap.css" rel="stylesheet" />

<div class="row" style="margin-top: 20px;">

	<h3 class="mt-4" style="margin-bottom: 30px;">
		<i class="fas fa-shopping-cart"></i>
		All Orders
	</h3>
	<br/><br/>
	
	<div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead class="thead-dark">
                    <tr>
						<th scope="col">Order ID</th>
						<th scope="col">Customer Email</th>
						<th scope="col">Date of Order</th>
						<th scope="col">Total Amount</th>
						<th scope="col">Handled By</th>
                    </tr>
                </thead>
                <tbody>
                    <%
				    	for(int i=1; i<25; i++)
				    	{
				    %>
					    <tr>
					      <th><%=i %></th>
					      <td><%="Abc@gmail.com" %></td>
					      <td><%= i +"-Oct-2020" %></td>
					      <td>&#x20B9; <%=850 + 2*i %></td>
					      <td><%="[Staff Name]" %></td>
					    </tr>
				    <%
				    	}
				    %>
                </tbody>
            </table>
        </div>
    </div>



<%@ include file="adminfooter.jsp"%>

<script src="assets/datatable/jquery.datatable.js" ></script>
<script src="assets/datatable/datatable.bootstrap.js" ></script>
<script src="assets/datatable/datatables-demo.js" ></script>

