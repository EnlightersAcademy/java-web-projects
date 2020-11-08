<%@ include file="adminheader.jsp"%>

<%
	String[] categories = new String[]{"Hot Coffee", "Cold Coffee", "Burger", "Pizza"};
%>

<div class="row" style="margin-top: 20px;">
	<div class="col col-md-4"></div>

	<div class="col col-md-4">
	
		<div class="card shadow-lg border-0 rounded-lg mt-5">
		    <div class="card-header">
		    	<h3 class="text-center font-weight-light my-4">
		    		<i class="fas fa-coffee"></i>
					Add New Item
		    	</h3>
		   	</div>
		    <div class="card-body">
		        <form class="form-signin" method="post" action="">

                         <div class="form-group">
                             <label class="small mb-1" for="category">Category</label>
                             <select class="form-control" id="category" required>
						        <option selected>Select</option>
						        <%
						        	for(int i=0; i< categories.length; i++)
						        	{
						        %>
						        		<option value="<%=categories[i]%>"><%=categories[i] %></option>
						        <%
						        	}
						        %>
						      </select>
                         </div>
                     
                         <div class="form-group">
                             <label class="small mb-1" for="name">Item Name</label>
                             <input class="form-control" id="name" type="text" placeholder="Item Name" required />
                         </div>
                         
                         <div class="form-group">
                             <label class="small mb-1" for="description">Description</label>
                             <input class="form-control" id="description" type="text" placeholder="Item Description" required />
                         </div>
                         
                         <div class="form-group">
                             <label class="small mb-1" for="price">Price</label>
                             <input class="form-control" id="price" type="text" placeholder="Price in &#x20B9;" pattern="[0-9]{1,}" required />
                         </div>
                         
                         <div class="form-group">
                             <label class="small mb-1" for="price">Picture</label>
                             <input class="form-control" id="price" type="file" required accept="image/x-jpg,image/jpeg" style="height: auto;" />
                         </div>
                        
					<br/>
					<button class="btn btn-lg btn-success btn-block" type="submit">Add Item</button>
				</form>
		    </div>
		</div>
	
	</div>

	<div class="col col-md-4"></div>
</div>



<%@ include file="adminfooter.jsp"%>