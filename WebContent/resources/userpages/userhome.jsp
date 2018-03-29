<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    
     <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <script src="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script><!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
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



    <!-- Header Carousel -->
    <header id="myCarousel" class="carousel slide">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <div class="item active">
                <div class="fill" style="background-image:url('${pageContext.request.contextPath}/resources/images/slider1.jpg');"></div>
                <div class="carousel-caption">
                    <h2>Caption 1</h2>
                </div>
            </div>
            <div class="item">
                <div class="fill" style="background-image:url('${pageContext.request.contextPath}/resources/images/slider2.jpg');"></div>
                <div class="carousel-caption">
                    <h2>Caption 2</h2>
                </div>
            </div>
            <div class="item">
                <div class="fill" style="background-image:url('${pageContext.request.contextPath}/resources/images/Slider3.jpg');"></div>
                <div class="carousel-caption">
                    <h2>Caption 3</h2>
                </div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="icon-next"></span>
        </a>
    </header>
    
    <div class="container">

        <!-- Marketing Icons Section -->
        <div class="row ">
        	<div class="row h1 page-header">
        	
        		<div class="col-md-7">
        			
        			Welcome to Shopping Mania
        			
        		</div>
        		<div class="col-md-4">
        			<form action="searchProduct.html" method="post">
        			<div class="input-group">
                        <input type="text" class="form-control" name="searchtext" placeholder="search your product here..">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="submit" ><i class="fa fa-search"></i></button>
                        </span>
                    </div>
                    </form>
        		</div>
        	</div>
            <!-- <div class="col-lg-12">
                <h1 class="page-header">
                    Welcome to Modern Business
                    
                </h1>
            </div> -->
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
                            <li><a href="aboutproduct.html?id=${product.id}"><i class="fa fa-2x fa-eye " ></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-2x fa-twitter-square"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            </c:forEach>
            <%-- <div class="col-md-4 text-center">
                <div class="thumbnail">
                    <img class="img-responsive" src="${pageContext.request.contextPath}/resources/images/banner1.png" alt="">
                    <div class="caption">
                        <h3>Panasonic<br>
                            <small>Waching machine</small>
                        </h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Iste saepe et quisquam nesciunt maxime.</p>
                        <ul class="list-inline">
                            <li><a href="#"><i class="fa fa-2x fa-facebook-square"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-2x fa-linkedin-square"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-2x fa-twitter-square"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-4 text-center">
                <div class="thumbnail">
                    <img class="img-responsive" src="${pageContext.request.contextPath}/resources/images/banner1.png" alt="">
                    <div class="caption">
                        <h3>SAMSUNG<br>
                            <small>SMART PHONES</small>
                        </h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Iste saepe et quisquam nesciunt maxime.</p>
                        <ul class="list-inline">
                            <li><a href="#"><i class="fa fa-2x fa-facebook-square"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-2x fa-linkedin-square"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-2x fa-twitter-square"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-4 text-center">
                <div class="thumbnail">
                    <img class="img-responsive" src="${pageContext.request.contextPath}/resources/images/banner1.png" alt="">
                    <div class="caption">
                        <h3>SAMSUNG<br>
                            <small>SMART PHONES</small>
                        </h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Iste saepe et quisquam nesciunt maxime.</p>
                        <ul class="list-inline">
                            <li><a href="#"><i class="fa fa-2x fa-facebook-square"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-2x fa-linkedin-square"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-2x fa-twitter-square"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-4 text-center">
                <div class="thumbnail">
                    <img class="img-responsive" src="${pageContext.request.contextPath}/resources/images/banner1.png" alt="">
                    <div class="caption">
                        <h3>SAMSUNG<br>
                            <small>SMART PHONES</small>
                        </h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Iste saepe et quisquam nesciunt maxime.</p>
                        <ul class="list-inline">
                            <li><a href="#"><i class="fa fa-2x fa-facebook-square"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-2x fa-linkedin-square"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-2x fa-twitter-square"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-4 text-center">
                <div class="thumbnail">
                    <img class="img-responsive" src="${pageContext.request.contextPath}/resources/images/banner1.png" alt="">
                    <div class="caption">
                        <h3>SAMSUNG<br>
                            <small>SMART PHONES</small>
                        </h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Iste saepe et quisquam nesciunt maxime.</p>
                        <ul class="list-inline">
                            <li><a href="#"><i class="fa fa-2x fa-facebook-square"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-2x fa-linkedin-square"></i></a>
                            </li>
                            <li><a href="#"><i class="fa fa-2x fa-twitter-square"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div> --%>
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

   

    <!-- Script to Activate the Carousel -->
    <script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>


</html>

