<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
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
    
    <!-- Bootstrap datepicker CSS -->
    <link href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/bootstrap-datepicker.css" rel="stylesheet">
    

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
    
     <!-- Bootstrap Datepicker JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/js/bootstrap-datepicker.js"></script>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script>
    $(document).ready(function(){
    	$(function(){
    		
    		
    	    $(".cart").click(function(){
    	    	var id =$(this).attr("id");
    	    	
    	    	
    	    	
    	    	console.log("clicked  worked"+$(this).attr("id"));
    	    	 $.ajax({
    	     		type : "post",
    	     		url  :"${pageContext.request.contextPath}/addproducttocart.html",
    	     		data:{
    	     			productId:id,
        				
        			},
        			datatype:"json",
    	     		success: function(data){
    	     			$('#'+id).hide();
    	     			if($("ul#cartul").has( "li" ).length>0)
        	    		{
    	     				$("#shopcart ul").prepend('<li><a href="'+id+'">'+data+'</a></li>');
        	     	    	var count = Number($(".badge").text());
        	     	    	count =count+1;
        	     	    	$(".badge").text(count);
        	    		}
    	     			else
    	     				{
	    	     				$("#shopcart ul").append('<li><a href="'+id+'">'+data+'</a></li>');
	    	     				$("#shopcart ul").append('<div class="divider"></div>');
	    	     				$("#shopcart ul").append('<li class="lead"><a href="getproduct.html">Place Order</a></li>');
	        	     	    	var count = Number($(".badge").text());
	        	     	    	count =count+1;
	        	     	    	$(".badge").text(count);
    	     				}
    	     			
    	     		}
    	     	});  
    	    	
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
                <h1 class="page-header">
                    <small>Your Product</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="home.html">Home</a>
                    </li>
                    <li class="active">Your Products</li>
                </ol>
            </div>
        </div>
        <!-- /.row -->

        <!-- Content Row -->
        <div class="row">
            <!-- Sidebar Column -->
            <!-- <div class="col-md-3">
                <div class="list-group">
                <c:forEach items="${menulist}" var="menu">
                    <a href="index.html" class="list-group-item">${menu}</a>
                  </c:forEach>  
                </div>
            </div> -->
            <!-- Content Column -->
            <!-- <div class="col-md-9"> -->
                <h2>Products</h2>
                <hr/>
                <div class="row">
                	<c:forEach var="product" items="${productList}">
			            <div class="col-md-4 text-center">
			                <div class="thumbnail">
			                    <img class="img-responsive" src="${pageContext.request.contextPath}/resources/images/${product.productImage}" alt="">
			                    <div class="caption">
			                        <h3>${product.description}<br>
			                            <small>${product.name}</small>
			                        </h3>
			                        <p>${product.description}</p>
			                        <ul class="list-inline">
			                            <li><a href="#"><i class="fa fa-2x fa-shopping-cart cart" id="${product.id}"></i></a>
			                            </li>
			                            <li><a href="aboutproduct.html?id=${product.id}"><i class="fa fa-2x fa-eye "></i></a>
			                            </li>
			                            <li><a href="#"><i class="fa fa-2x fa-twitter-square"></i></a>
			                            </li>
			                        </ul>
			                    </div>
			                </div>
			            </div>
            		</c:forEach>
                </div>
            <!-- </div> -->
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
    <!-- /.container -->




</html>
    