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
	 $("#sbtn").click(function(){
		 var catagory = $("#cat1").val();
		 console.log("here1");
		 var err=0;
		 if( catagory==" " || catagory.length=0)
			 
			 $("#errcat").text("Enter Catagory");
		 console.log("here");
			 err++;
			 }
	 if(err!=0)
		 {
		 return false;
		 }
	 });
	 
	 $("#cat1").focus(function(){
		$("#errcat").text(""); 
	 });
 });
 
 </script>

<body>
 
   <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                
                   <!--  Start designing your Html body from here -->
                   <br/>
                   <br/>
                   
                   <div class="col-lg-3"></div>
                   <div class="col-lg-6">
                   <div class="panel panel-primary">
                        <div class="panel-heading">
                            Catagory
                        </div>
                        
                        <div class="panel-body">
                      <form:form role="form" action="/datamining/addcatagory.html" method="post" commandName="cat">
                      			<div class="row">
                      			<div class="col-lg-2">
                                </div>
                                <div class="col-lg-8">
                                <div class="form-group">
                                            
                                            <form:input class="form-control" placeholder="Description" id="cat1" path="description" />
                                            <font color='red'> <div id="errcat"></div></font>
                             	</div>
                                <!--/.form-group-->
                                </div>
                                <!--/.col-lg-4 -->
                                
                                </div>
                                <!--/.row  -->
                      			
                      			
                      			<div class="row">
                      			<div class="col-lg-4"></div>
                      			<div class="col-lg-2">
                      			
                      						<button type="submit" class="btn btn-primary" id="sbtn">Submit</button>
                      			</div>
                      			<!-- <div class="col-lg-2">			
                      						<button type="button" class="btn btn-primary">Cancle</button>
                      			</div> --> 
                      			</div>
                      </form:form>
					</div>
					<!--/.panel body  -->
				  </div>
                 <!--  panel panel-primary-->
             	</div>
             	<!--/.col-lg-4  -->
               
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->
   
   
</body>
</html>