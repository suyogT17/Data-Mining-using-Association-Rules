<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
 
    <title>Admin Template</title>
 
      <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/modern-business.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
     <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
  
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
 
</head>
<body>
 
   <!-- Page Content -->
        <!-- <div id="page-wrapper">-->
            <div class="container">
            <div class="row">
            <div class="col-lg-12">
            
                <h1 class="page-header">Update
                    <small>User</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="home.html">Home</a>
                    </li>
                    <li class="active">update user</li>
                </ol>
            </div>
        </div>
        <!-- /.row -->
                <div class="row">
                	<br>
                	<div class="col-lg-1"></div>
                	<div class="col-lg-10">
                   <!--  Start designing your Html body from here -->
                   <div class="panel panel-primary">
                    <div class="panel-heading">	
                    Update User
                    </div>
                    
                    <div class="panel-body well well-lg">
                    <form:form action="updateusers.html" method="post" modelAttribute="user">
                    <form:hidden path="enabled"/>
                    <form:hidden path="accExpired"/>
                    <form:hidden path="credentialsExpired"/>
                    <form:hidden path="accountLocked"/>
                    <form:hidden path="Userid"/>
                    <div class="row">
                
                    	<div class="col-md-3"></div>
                    	<div class="col-md-3">
	                    	<div class="form-group">
	                    		   <label>User Name:</label>
				                  <form:input path="Username" type="text" class="form-control" readonly="true" id="username" />
				                  <font color='red'> <div id="errusername"></div></font>
	                        </div>
                       		<!-- /.form-group -->
                       
                       		<div class="form-group">
	                    		   <label>Last Name:</label>
				                  <form:input path="Lastname" type="text" class="form-control"  id="Lastname" />
				                  <font color='red'> <div id="errLastname"></div></font>
	                        </div>
                       		<!-- /.form-group -->
                       
                      		 <div class="form-group">
	                    		   <label>Email Id:</label>
				                  <form:input path="Emailid" type="text" class="form-control"  id="Emailid" />
				                  <font color='red'> <div id="errEmailid"></div></font>
	                        </div>
                      		 <!-- /.form-group -->
                       
                       		<div class="form-group">
	                    		   <label>Contact Number:</label>
				                  <form:input path="Contactnumber" type="text" class="form-control"  id="Contactnumber" />
				                  <font color='red'> <div id="errContactnumber"></div></font>
	                        </div>
                       		<!-- /.form-group -->
                    	</div>
                    	<div class="col-md-3">
                    			<div class="form-group">
	                    		   <label>First Name:</label>
				                  <form:input path="Firstname" type="text" class="form-control"  id="Firstname" />
				                  <font color='red'> <div id="errFirstname"></div></font>
	                       		 </div>
                       		<!-- /.form-group -->
                       		<div class="form-group">
	                    		   <label>Password:</label>
				                  <form:input path="Password" type="password" class="form-control"  id="Password" />
				                  <font color='red'> <div id="errPassword"></div></font>
	                       		 </div>
                       		<!-- /.form-group -->
                       		<!-- 
                       		<div class="form-group">
	                    		   <label>Creation Date:</label>
				                  <form:input path="Creationdate"  readonly="true" class="form-control"  id="Creationdate" />
				                  <font color='red'> <div id="errCreationdate"></div></font>
	                       		 </div>
	                       		  -->
                       		<!-- /.form-group -->
                    	</div>
                    	<div class="col-md-3"></div>
                    	
                    	</div>
                    	<!-- ./row -->
                    	<div class="row">
                    		<div class="col-md-3"></div>
                    		<div class="col-md-3">
                    				<button type="submit" class="btn btn-primary">Update</button>
                    		</div>
                    	</div>
                    </form:form>	
                    </div>
                 </div>
                	</div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->
   </div>
   
</body>
</html>