<%@page import="com.espresso.db.util.DbUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.espresso.dto.Category"%>
<%@ include file="adminheader.jsp"%>
<%@page import="com.espresso.util.EspressoUtil"%>


<%
	if(EspressoUtil.isResponseSuccess(request) != -1) {
		int status = EspressoUtil.isResponseSuccess(request);
		if( status == 0) {
			%>
			<script>
			alert("Successfully added the new Category details")
			</script>
			<%
		} else if (status == 1){
			%>
			<script>
			alert("Failed to add the Category details. Please retry again")
			</script>
			<%
		} else if(status == 2) {
			%>
			<script>
			alert("Category with the provided name already exist. Please verify the input details")
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
		    		<i class="fas fa-tag"></i>
					Add New Category
		    	</h3>
		   	</div>
		    <div class="card-body">
		        <form class="form-signin" method="post" action="category">
					<input
						type="text" name="categoryname" id="categoryname" class="form-control"
						placeholder="Category Name" required autofocus>
					<br/>
					<button class="btn btn-lg btn-success btn-block" type="submit">Add Category</button>
				</form>
		    </div>
		</div>
	
	</div>

	<div class="col col-md-4"></div>
</div>
<%
	List<Category> categories = DbUtil.getAllCategories();
%>

<div class="row" style="margin-top: 50px;">

	<h3 class="mt-4" style="margin-bottom: 30px;">
		<i class="fas fa-tags"></i>
		Existing Categories
	</h3>
	<br/><br/>
			
	<table class="table table-hover">
	  <thead class="thead-dark">
	    <tr>
	      <th scope="col">Category</th>
	      <th scope="col">Number of Items Under This Category</th>
	    </tr>
	  </thead>
	  <tbody>
	    <%
	    	for(Category cat: categories)
	    	{
	    %>
		    <tr>
		      <td><%=cat.getCategoryName() %></td>
		      <td><%=cat.getItems().size() %></td>
		    </tr>
	    <%
	    	}
	    %>
	    
	  </tbody>
	</table>

</div>


<%@ include file="adminfooter.jsp"%>