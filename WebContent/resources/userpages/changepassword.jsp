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
    	$("#mismatch").hide();
    	$("#success").hide();
    	
    	$("#submitbtn").click(function(){
    		var password =$("#password").val();
    		var repassword = $("#repassword").val();
    		if(password =="" ||password.length==0)
    			{
					 $("#errpassword").text("Please Enter the Password");
					 return false;
    			}
    		if(repassword =="" ||repassword.length==0)
			{
				 $("#errrepassword").text("Please Enter the Password");
				 return false;
			}
    		if(password==repassword)
    			{
    				$.ajax({
    					type :"post",
    					url :"updatepassword",
    					data :{
    						password: password,
    					},
						datatype:"json",
						success:function(data){
							if(data=="success")
								{
									$("#success").show();
									$("input:password").val("");
								}
						}
    					
    				});
    			}
    		else
    			{
    				$("#mismatch").show();
    				$("input:password").val("")
    			}
    	});
    	
    	$("input").focus(function(){
    		$("#mismatch").hide();
    		$("#success").hide();
    		$("#label").text("");
    		$("#errrepassword").text("");
    		 $("#errpassword").text("");
    		
    	});
    	
    	$("#password").keypress(function(){
    		var password = $("#password").val();
    		var n = password.length;
    		if(n>0 && n<=4)
    			{
					$("#label").text("weak Size"); 
					
    			}
    		else if(n>4 && n<=7)
    			{
    			$("#label").text("Medium Size"); 			
    			}
    		else
    			{
    			$("#label").text("Strong");   
    			}
    	});
    	
    	
    });
    </script>
</head>
<!-- Page Content -->
    <div class="container">

        <!-- Page Heading/Breadcrumbs -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Change Password
                    <small></small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="home.html">Home</a>
                    </li>
                    <li class="active">ChangePassword</li>
                </ol>
            </div>
        </div>
        <!-- /.row -->

        <!-- Content Row -->
      <div class="col-lg-12">
        <div class="row">
            <div class="col-md-4"></div>
             <div class="col-md-4">
             	<div class="panel panel-primary">
                        <div class="panel-heading">
                           Chanage Password
                        </div>
                        <div class="panel-body">
                        	<div class="form-group" id="mismatch">
		                        <div class="alert alert-danger" >
		 								Password do not match.                               
								</div>
							</div>
							<div class="form-group" id="success">
		                        <div class="alert alert-success" >
		 								Password Updated successfully.                               
								</div>
							</div>	
	                        <div class="form-group">
	                        	<label>Enter New Password:</label>
	                            <input  type="password" class="form-control"  id="password"/>
	                            <span id ="label" class="label label-success"></span>
	                            <font color='red'> <div id="errpassword"></div></font>
							</div>
							
							<div class="form-group">
	                        	<label>Re enter New Password:</label>
	                            <input  type="password" class="form-control"  id="repassword"/>
	                            <font color='red'> <div id="errrepassword"></div></font>
							</div>
							
							<button type="button" class="btn btn-primary btn-circle btn-xl" id="submitbtn">Submit</button>
							
                        </div>
                        
                    </div>   
            </div>
        </div>
        <!-- /.row -->
        <hr/>
      </div>
	<!-- /.col-lg-12 -->	
        

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