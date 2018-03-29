<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

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
	    	     				$("#shopcart ul").append('<li><a href="ordersummary.html">Place Order</a></li>');
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


<body>

   
    <!-- Page Content -->
    <div class="container">

        <!-- Page Heading/Breadcrumbs -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Product
                    <small>Details</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="home.html">Home</a>
                    </li>
                    <li class="active">About</li>
                </ol>
            </div>
        </div>
        <!-- /.row -->

        <!-- Intro Content -->
        <div class="row">
            <div class="col-md-6">
                <img class="img-responsive" src="${pageContext.request.contextPath}/resources/images/${product.productImage}" alt="">
            </div>
            <div class="col-md-6">
                <h2>About ${product.name }</h2>
                <p>Brand : ${product.brand }</p>
                <p>Price :${product.price }</p>
                <p>Description :${product.description }</p>
            </div>
        </div>
        <!-- /.row -->

       

        <!-- Our Customers -->
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">User also search for:</h2>
            </div>
            <c:forEach items="${productlist }" var="prod">
            	 <div class="col-md-2 col-sm-4 col-xs-6">
               <a href="aboutproduct.html?id=${prod.id}"> <img class="img-responsive customer-img" src="${pageContext.request.contextPath}/resources/images/${prod.productImage}" alt=""></a>
 				<center> <li><a href="#"><i class="fa fa-2x fa-shopping-cart cart" id="${prod.id}"></i></a></li></center>           
            </div>
            </c:forEach>
           
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

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
