<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
 
    <title>Tech Know Admin Template</title>
 
    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
 
    <!-- MetisMenu CSS -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
 
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/dist/css/sb-admin-2.css" rel="stylesheet">
 
    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
     <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/bower_components/jquery/dist/jquery.min.js"></script>
 
    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
 
    <!-- Metis Menu Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/bower_components/metisMenu/dist/metisMenu.min.js"></script>
 
    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/dist/js/sb-admin-2.js"></script>
 
 
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
 
</head>
<script>
     $(document).ready(function(){
    	 $("#submitbtn").click(function(){
    		 var name=$("#name").val();
    		 var description=$("#description").val();
    		 var price=$("#price").val();
    		 var productimage=$("#productimage").val();
    		 var discount=$("#discount").val();
    		 var quantity=$("#quantity").val();
    		 var brand=$("#brand").val();
    		
    		 var err=0;
    		 if(name==" " || name.length==0)
    		 {
    		 $("#errname").text("Enter the Product Name: ");
    		 err++;
    		 }
    		 
    		 if(description==" " || description.length==0)
			 {
			 $("#errdescription").text("Enter the Product Description: ");
			 err++;
			 }
    		 
    		 if(price==" " || price.length==0)
			 {
			 $("#errprice").text("Enter the Product Price: ");
			 err++;
			 }
    		 
    		 
    		 
    		 if(discount==" " || discount.length==0)
			 {
			 $("#errdiscount").text("Enter the Discount: ");
			 err++;
			 }
    		 
    		 
    		 
    		 if(quantity==" " || quantity.length==0)
			 {
			 $("#errquantity").text("Enter the Product Quantity: ");
			 err++;
			 }
    		 
    		 if(brand==" " || brand.length==0)
			 {
			 $("#errbrand").text("Enter the Product Brand: ");
			 err++;
			 }
    		 
    		
    		 
    		 
    		 if(err!=0)
    		 {
    		 return false;
    	     }
    	 });
    	 $("#name").focus(function(){
 			$("#errname").text(""); 
 		 });
 		 
 		 $("#description").focus(function(){
  			$("#errdescription").text(""); 
  		 });
 		 
 		 $("#price").focus(function(){
  			$("#errprice").text(""); 
  		 });
 		 
 		 $("#productimage").focus(function(){
  			$("#errproductimage").text(""); 
  		 });
 		 
 		 $("#discount").focus(function(){
  			$("#errdiscount").text(""); 
  		 });
 		 
 		 $("#quantity").focus(function(){
  			$("#errquantity").text(""); 
  		 });
 		 
 		 $("#brand").focus(function(){
  			$("#errbrand").text(""); 
  		 });
 		 
 		
     });
     </script> 
<body>
 
   <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                   <!--  Start designing your Html body from here -->
                    <br/>
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                         Add Product
                		</div>
                		<div class="panel-body">
                			<form:form role="form" action="addproduct1.html" modelAttribute="product" enctype="multipart/form-data" methclass="form-horizontal" method="post">
                					<div class="col-md-2"></div>
                					
	                				<div class="col-md-4">
	                					<div class="form-group">
			                        		<label>Product Name:</label>
			                            	<form:input  path="name" class="form-control"  id="name"/>
			                            	<font color='red'> <div id="errname"></div></font>
										</div>
										<div class="form-group">
			                        		<label>Description:</label>
			                            	<form:input  path="description" class="form-control"  id="description"/>
			                            	<font color='red'> <div id="errdescription"></div></font>
										</div>
										<div class="form-group">
			                        		<label>Price:</label>
			                            	<form:input  path="price" class="form-control"  id="price"/>
			                            	<font color='red'> <div id="errprice"></div></font>
										</div>
										<div class="form-group">
			                        		<label>Image File:</label>
			                            	<input type="file" class="form-control" name="imagefile" id="productimage"/>
			                            	<font color='red'> <div id="errproductimage"></div></font>
										</div>
										<div class="form-group">
			                        		<label>Discount:</label>
			                            	<form:input  path="discount" class="form-control"  id="discount"/>
			                            	<font color='red'> <div id="errdiscount"></div></font>
										</div>
                					</div>
                					<!-- ./col-lg-4 -->
                					<div class="col-md-1"></div>
                					<div class="col-md-4">
                							<div class="form-group">
	                							<label>Quantity:</label>
				                            	<form:input  path="quantity" class="form-control"  id="quantity"/>
				                            	<font color='red'> <div id="errquantity"></div></font>
			                            	</div>
			                            	
			                            	<div class="form-group">
	                							<label>Brand:</label>
				                            	<form:input  path="brand" class="form-control"  id="brand"/>
				                            	<font color='red'> <div id="errbrand"></div></font>
			                            	</div>
			                            	
			                            	<div class="form-group">
	                							<label>Currently Available:</label>
	                							<div class="radio">
                                                <label>
                                                    <form:radiobutton path="availability"  value="true"/>Yes
                                                </label>
                                            	</div>
				                            	
				                            	<div class="radio">
                                                <label>
                                                    <form:radiobutton path="availability" value="false" />NO
                                                </label>
                                            	</div>
			                            	</div>
			                            	
			                           <div class="form-group">
	                							<label>Select Catagory:</label>
				                            	<form:select path="categoryId" >
				                            	<form:option value="NONE" label="--- Select ---" />
				                            	<c:forEach items="${catagorylist}" var="c">
				                            	<form:option value="${c.cid }">${c.description}</form:option>
				                            	</c:forEach>
				                            	</form:select>
				                            	<font color='red'> <div id="errcat"></div></font>
			                           </div> 
			                         
			                            <button type="submit" id="submitbtn">SUBMIT</button>
                					</div>
                					
                					
                			
                			</form:form>
                		</div>

                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->
   
   
</body>
</html>