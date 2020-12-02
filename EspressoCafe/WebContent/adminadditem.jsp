<%@page import="java.util.List"%>
<%@page import="com.espresso.dto.Category"%>
<%@page import="com.espresso.db.util.DbUtil"%>
<%@page import="com.espresso.util.EspressoUtil"%>
<%@ include file="adminheader.jsp"%>

<%
	List<Category> categories = DbUtil.getAllCategories();
%>

<%
	if(EspressoUtil.isResponseSuccess(request) != -1) {
		int status = EspressoUtil.isResponseSuccess(request);
		if( status == 0) {
			%>
			<script>
			alert("Successfully added the item")
			</script>
			<%
		} else if (status == 1){
			%>
			<script>
			alert("Failed to add the item. Please retry again")
			</script>
			<%
		}  else if(status == 2) {
			%>
			<script>
			alert("Item with the provided name already exist. Please verify the input details")
			</script>
			<%
		}
	}

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
		        <form class="form-signin" method="post" action="items" enctype="multipart/form-data">

                         <div class="form-group">
                             <label class="small mb-1" for="category">Category</label>
                             <select class="form-control" name="category" id="category" required>
						        <option selected>Select</option>
						        <%
						        	for(Category cat: categories)
						        	{
						        %>
						        		<option value="<%=cat.getCategoryName()%>"><%=cat.getCategoryName() %></option>
						        <%
						        	}
						        %>
						      </select>
                         </div>
                     
                         <div class="form-group">
                             <label class="small mb-1" for="name">Item Name</label>
                             <input class="form-control" name ="name" id="name" type="text" pattern="[a-zA-Z\s]*" placeholder="Item Name" required />
                         </div>
                         
                         <div class="form-group">
                             <label class="small mb-1" for="description">Description</label>
                             <input class="form-control" name="description" id="description" type="text" placeholder="Item Description" required />
                         </div>
                         
                         <div class="form-group">
                             <label class="small mb-1" for="price">Price</label>
                             <input class="form-control" name="price" id="price" type="text" placeholder="Price in &#x20B9;" pattern="[0-9]{1,}" required />
                         </div>
                         
                         <div class="form-group">
                             <label class="small mb-1" for="price">Picture</label>
                             <input class="form-control" name="picture" id="picture" type="file" required accept="image/x-jpg,image/jpeg" style="height: auto;" />
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