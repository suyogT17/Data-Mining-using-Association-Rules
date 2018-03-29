<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Modern Business - Start Bootstrap Template</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/modern-business.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
     <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/wizard.css" rel="stylesheet">
    
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
    <script>
    $(document).ready(function(){
    	$("#dot3").css({"background-color" : "#67A92C"});
    	$("#leftbutton").attr('disabled',true);
    	
    	
    });
    </script>
</head>
<!-- Page Content -->
    <div class="container">

        <!-- Page Heading/Breadcrumbs -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">My Profile
                    <small></small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="home.html">Home</a>
                    </li>
                    <li class="active">My profile</li>
                </ol>
            </div>
        </div>
        <!-- /.row -->

        <!-- Content Row -->
        <div class="row">
            <div class="col-lg-2"></div>
             <div class="col-lg-10">
             	<div class="panel panel-primary">
                        <div class="panel-heading">
                            Details
                        </div>
                        <div class="panel-body">
	                        <div class="row">
	                        	<div class="col-md-4">
	                        		<div class="form-group">
	                        		<label> User Name:</label> <i class="form-control-static">${userprofile.username }</i>
	                        		</div>
	                        		
	                        		<div class="form-group">
	                        		<label> First Name:</label> <i class="form-control-static">${userprofile.firstname }</i>
	                        		</div>
	                        	</div>
	                        	
	                        	<div class="col-md-4">
	                        		<div class="form-group">
	                        		<label> Email Id:</label> <i class="form-control-static">${userprofile.emailid }</i>
	                        		</div>
	                        		
	                        		<div class="form-group">
	                        		<label> Contact Number:</label> <i class="form-control-static">${userprofile.contactnumber }</i>
	                        		</div>
	                        	</div>
	                        	
	                        	<div class="col-md-4">
	                        		<div class="form-group">
	                        		<label> AddressLine1:</label> <i class="form-control-static">${userprofile.addressline1 }</i>
	                        		</div>
	                        		
	                        		<div class="form-group">
	                        		<label> AddressLine2:</label> <i class="form-control-static">${userprofile.addressline2 }</i>
	                        		</div>
	                        	</div>
	                        	
	                        </div>
	           			 
                        </div>
                        
                    </div>   
            </div>
        </div>
        <!-- /.row -->

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Your Website 2016</p>
                </div>
            </div>
        </footer>

    </div>
    </html>