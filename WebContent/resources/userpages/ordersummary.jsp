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
    	$("#dot1").css({"background-color" : "#67A92C"});
    	$("#leftbutton").attr('disabled',true);
    	$(function(){
    		 $(".remove").click(function(){
    			 $(this).closest('tr').remove();
    			 var rowCount = $('.table tr').length;
    		if(rowCount==2)
    			{
    			$("#rightbutton").attr("disabled",true);    			
    			}
    	});
    	});
    	
    	
    });
    </script>
</head>
<!-- Page Content -->
    <div class="container">

        <!-- Page Heading/Breadcrumbs -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Order Summary
                    <small></small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="index.html">Home</a>
                    </li>
                    <li class="active">Order Summary</li>
                </ol>
            </div>
        </div>
        <!-- /.row -->

        <!-- Content Row -->
        <div class="row">
         <!--    <div class="col-lg-2"></div>  -->
             <div class="col-lg-12">
             	<div class="panel panel-primary">
                        <div class="panel-heading">
                            Your Items
                        </div>
                        <div class="panel-body">
	                        <div class="row bs-wizard" style="border-bottom:0;">
	                
					                <div class="col-xs-3 bs-wizard-step active " id="step1">
					                  <div class="text-center bs-wizard-stepnum">Step 1</div>
					                  <div class="progress"><div class="progress-bar"></div></div>
					                  <a href="#" class="bs-wizard-dot" id="dot1"></a>
					                  <div class="bs-wizard-info text-center" id="text1"><b>Order Summary of Your Purchase</b></div>
					                </div>
					                
					                <div class="col-xs-3 bs-wizard-step " id="step2"><!-- complete -->
					                  <div class="text-center bs-wizard-stepnum">Step 2</div>
					                  <div class="progress"><div class="progress-bar"></div></div>
					                  <a href="#" class="bs-wizard-dot" id="dot2"></a>
					                  <div class="bs-wizard-info text-center" id="text2">Bill Summary for Your Order</div>
					                </div>
					                
					                <div class="col-xs-3 bs-wizard-step " id="step3"><!-- complete -->
					                  <div class="text-center bs-wizard-stepnum">Step 3</div>
					                  <div class="progress"><div class="progress-bar"></div></div>
					                  <a href="#" class="bs-wizard-dot" id="dot3"></a>
					                  <div class="bs-wizard-info text-center" id="text3">Finish</div>
					                </div>
	           			 	</div>
	           			 	<br/>
	           			 	<!-- ./bs-wizard -->
							<div class="row">
								<div class="table-responsive">
								<form:form method="post" action="next1.html" modelAttribute="orderList">
	                                <table class="table">
	                                    <thead>
	                                        <tr>
	                                            <th>ID</th>
	                                            <th>Product Name</th>
	                                            <th>Quantity</th>
	                                            <th>Price</th>
	                                        </tr>
	                                    </thead>
	                                    <tbody>
	                                     <c:forEach items="${orderList.cartProductList}" var="p" varStatus="status">
	                                        <tr class="success">
	                                            <td>${status.count}</td>
	                                            <td><input type="hidden" name="cartProductList[${status.index}].productName" value="${p.productName}"/>${p.productName}</td>
	                                            <td><input  name="cartProductList[${status.index}].quantity" value="${p.quantity}"/></td>
	                                            <td><input type="hidden" name="cartProductList[${status.index}].price" value="${p.price}"/>${p.price}</td>
	                                            <td><input type="button" value ="Remove" class="remove"></td>
	                                        </tr>
	                                        </c:forEach>
	                                        <tr>
	                                        	<td></td>
	                                        	<td></td>
	                                        	<td></td>
		                                		
		                                			
		                                			<td><button type="submit" class="btn btn-primary btn-circle btn-lg" id="rightbutton">
		                               	 				<i class="fa fa-arrow-circle-right "></i>
		                                			</button>       <button type="submit" id="leftbutton"class="btn btn-primary btn-circle btn-lg">
		                               	 				<i class="fa fa-arrow-circle-left "></i>
		                                			</button></td>
	                                        </tr>
	                                    </tbody>
	                                </table>
                                
                               
	                                
	                                
		                                
		                           
                               
                                </form:form>
                            </div>
                            <!-- /.table-responsive -->
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