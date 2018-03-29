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
   
    <!-- Data table Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
   
    <!-- Data table Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/dist/js/sb-admin-2.js"></script>
      <script src="${pageContext.request.contextPath}/resources/js/viewalluser.js"></script>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
   <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
            		<br/>
                <div class="row">
                   <!--  Start designing your Html body from here -->
                   
                     <div class="col-md-12">
                           <div class="panel panel-primary">
                                  <div class="panel-heading">
                                         All Users Of Shoping Mania
                                  </div>
                                  <div class="panel-body">
                                         <div class="well">
                                                <div class="dataTable_wrapper">
                                                       <table class="table table-striped table-bordered table-hover" id="tabledata">
                                                              <thead>
                                                                                         <tr>
                                                                                                
																								<th style="background-color: #0FA0A7;">User Name</th>
																							    <th style="background-color: #0FA0A7;">First name</th>
																								<th style="background-color: #0FA0A7;">Last name</th>
																								<th style="background-color: #0FA0A7;">Contact Number</th>
																								<!-- <th>effectiveDate</th> -->
																									<!-- <th>endDate</th> -->
																								<th style="background-color: #0FA0A7;">Email Id</th>
																								
                                                                                         </tr>
                                                                                  </thead>
                                                       </table>
                                                </div>
                                         </div>
                                  </div>
                           </div>
                           </div>
                  
 
                </div>
                <!-- /.row -->
                	<div id="myModal" class="modal fade" role="dialog">
                                   <div class="modal-dialog">
                                                      
                                                           <!-- Modal content-->
                                                           <div class="modal-content">
	                                                             <div class="modal-header">
	                                                               <button type="button" class="close" data-dismiss="modal">&times;</button>
	                                                               <h4 class="modal-title">Select Action</h4>
	                                                             </div>
	                                                             <div class="modal-body">
			                                                             <div class="row">
			                                                                     <div class="col-xs-3"></div>
			                                                               <!-- <div class="col-xs-3">
			                                                                            <i class="fa fa-edit fa-5x"></i>
			                                                                            <a class="updateuser" href="">Update</a>
			                                                                     </div> -->
			                                                                     <div class="col-xs-2"></div>
			                                                                     <div class="col-xs-3">
			                                                                            <i class="fa  fa-times-circle fa-5x"></i>
			                                                                            <a class="deleteuser" href=""><br>Delete</a>
			                                                                     </div>
			                                                             </div>
	                                                             </div>
	                                                            
	                                                             <div class="modal-footer">
	                                                               <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	                                                             </div>
                                                           </div>
                              	 </div>
                      </div>
 					<!-- /.mymodal -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->
  
   
</body>
</html>