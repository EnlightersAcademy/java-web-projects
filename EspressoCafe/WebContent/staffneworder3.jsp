<%@page import="com.espresso.dto.Customer"%>
<%@page import="com.espresso.db.util.DbUtil"%>
<%@ include file="staffheader.jsp"%>

<style>
        	.nav-pills-custom .nav-link {
			    color: #888;
			    background: #fff;
			    position: relative;
			}
			
			.nav-pills-custom .nav-link.active {
			    color: #212f3d;
			    background: #abb2b9;
			}
			
			
			/* Add indicator arrow for the active tab */
			@media (min-width: 992px) {
			    .nav-pills-custom .nav-link::before {
			        content: '';
			        display: block;
			        border-top: 8px solid transparent;
			        border-left: 10px solid #abb2b9;
			        border-bottom: 8px solid transparent;
			        position: absolute;
			        top: 50%;
			        right: -10px;
			        transform: translateY(-50%);
			        opacity: 0;
			    }
			}
			
			.nav-pills-custom .nav-link.active::before {
			    opacity: 1;
			}
        </style>
        
				<div class="row" style="margin: 50px;">
				

			            <div class="col-md-3">
			                <!-- Tabs nav -->
			                <div class="nav flex-column nav-pills nav-pills-custom" id="v-pills-tab" role="tablist" aria-orientation="vertical">
       							<!--Based on number of Categories -->
       							<%
       								for(int i=0; i<3; i++){
       							%>
			                    <a class="nav-link mb-3 p-3 shadow <%= (i==0)? "active" : "" %>" id="tab<%=i %>" data-toggle="pill" href="#details<%=i %>" role="tab" aria-controls="v-pills-home" aria-selected="true">
			                        <span class="font-weight-bold small text-uppercase">Hot Beverages</span></a>
			
			                    <%} %>
			                 </div>
			            </div>
			
			
			            <div class="col-md-8">
			                <!-- Tabs content -->
			                <div class="tab-content" id="v-pills-tabContent">
			                
       							<!--Based on number of Items in each Category -->
       							<%
       								for(int i=0; i<3; i++){
       							%>
			                    <div class="tab-pane fade shadow rounded bg-white show p-5 <%= (i==0)? "active" : "" %> " id="details<%=i %>" role="tabpanel" aria-labelledby="v-pills-home-tab">
			                        <table class="table table-hover">
									  <thead class="thead-dark">
									    <tr>
									      <th scope="col">Item Name</th>
									      <th scope="col">Quantity</th>
									      <th scope="col"></th>
									    </tr>
									  </thead>
									  <tbody>
									  		<form method="post">
											    <tr>
											      <td style="width: 70%;">Cuppacino<%=i %></td>
											      <td><input type="number" id="quanity" value="0" class="form-control" min="0" max="10" /></td>
											      <td><input type="submit" value=" ADD " class="btn btn-sm btn-success" > </td>
											    </tr>
										    </form>
										    <form method="post">
											    <tr>
											      <td>Espresso<%=i %></td>
											      <td><input type="number" id="quanity" value="0" class="form-control" min="0" max="10" /></td>
											      <td><input type="submit" value=" ADD " class="btn btn-sm btn-success" > </td>
											    </tr>
										    </form>
										    <form method="post">
											    <tr>
											      <td>Filter Coffee<%=i %></td>
											      <td><input type="number" id="quanity" value="0" class="form-control" min="0" max="10" /></td>
											      <td><input type="submit" value=" ADD " class="btn btn-sm btn-success" > </td>
											    </tr>
										    </form>
									  </tbody>
									</table>
			                    </div>
			                    <%} %>
			                    
			                </div>
			            </div>
			        </div>


					</div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                        	<div>
                                <span>Logged in at: </span>
                                <b><%=loggedInDateTime %></b>
                            </div>
                            <div class="text-muted">Copyright &copy; Espresso Café</div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="assets/vendor/jquery/jquery-3.2.1.min.js" crossorigin="anonymous"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="assets/dashboard/js/scripts.js"></script>
        <script>
        	$('#nav-tab a').on('click', function (e) {
        		  e.preventDefault()
        		  $(this).tab('show')
        		})
        	
        	$("form").on("submit", function(e) {
        		alert("Form Submitted. Need Servlet for Function!");
			    $.ajax({
			      type: $(this).attr('method'),
			      url: $(this).attr('action'),
			      data: $(this).serialize(),
			      success: function (dataFromServlet) {
			    	  $('#content').html(dataFromServlet);
			      }
			    });
    return false;
  });
       	</script>
    </body>
</html>
