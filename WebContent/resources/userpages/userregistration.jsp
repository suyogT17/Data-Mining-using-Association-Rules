<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
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
    	$("#form2").hide();
    	$("#form3").hide();
    	$("#message").hide();
    	$("#verifybtn").hide();
    	$("#submit").attr("disabled",true);
    	/* form1 -> form2 */
    	$("#frm1leftbtn").attr("disabled",true);
    	$("#frm1rightbtn").click(function(){
    		var username =$("#username").val();
    		var password=$("#password").val();
    		var emailid=$("#emailid").val();
    		var firstname=$("#firstname").val();
    		var lastname=$("#lastname").val();
    		var contactnumber=$("#contactnumber").val();
    		var err=0;
    		if(username == " " || username.length==0)
    		{
    			$("#errusername").text("Enter username");
    			err++;
    		}
    		
    		
    		if(password == " " || password.length==0)
    		{
    			$("#errpassword").text("Enter password");
    			err++;
    		}
    		
    		
    		if(password.length<8 && password.length>0)
    		{
    			$("#errpassword").text("Password Atleast contain 8 characters");
    			err++;
    		}
    		
    		
    		if(emailid == " " || emailid.length==0)
    		{
    			$("#erremailid").text("Enter email address");
    			err++;
    		}
    		
    		
    		if(firstname == " " || firstname.length==0)
    		{
    			$("#errfirstname").text("Enter First Name");
    			err++;
    		}
    		
    	
    		if(lastname== " " || lastname.length==0)
    		{
    			$("#errlastname").text("Enter Last Name");
    			err++;
    		}
    		
    		
    		if(contactnumber == " " || contactnumber.length==0)
    		{
    			$("#errcontactnumber").text("Enter Contact Number");
    			err++;
    			
    		}
    		
    		if(contactnumber.length>10)
    			{
    			$("#errcontactnumber").text("Enter valid Contact Number");
    			err++;
    			}
    		if(err!=0)
    			{
    			return false;
    			}
    		
    		$("#form1").hide(1000);
    		$("#form2").show(1500);
    		$("#btn1").css({"background-color" : "#44A0A0"});
    		$("#btn2").css({"background-color" : "#337ab7"});
    		
    		
    		
    	});
    	
    	/* form2 -> form3 */
    	$("#frm2rightbtn").click(function(){
    		
    		var addressline1 =$("#addressline1").val();
    		var street =$("#street").val();
    		var city=$("#city").val();
    		var pinno =$("#pinno").val();
    		var addressline2 =$("#addressline2").val();
    		var landmark =$("#landmark").val();
    		var state =$("#state").val();
    		var country =$("#country").val();
    		var err=0;
    		if(addressline1==" "||addressline1.length==0)
    		{
    			$("#erraddressline1").text(" Enter Address");
    			err++;
    		}
    		console.log("error count"+err);
    		if(street == " " || street.length==0)
    		{
    			$("#errstreet").text("Enter Street");
    			err++;
    		}
    		
    		
    		if(city == " " || city.length==0)
    		{
    			$("#errcity").text("Enter city");
    			err++;
    		}
    		
    		
    		if(pinno==" " || pinno.length==0)
    		{
    			$("#errpinno").text("Enter pinno:");
    			err++;
    		}
    		
    		if(pinno.length>6)
    		{
    			$("#errpinno").text("Pinno is Invalid");
    			err++;
    		}
    		
    		
    		if(addressline2 == " " || addressline2.length==0)
    		{
    			$("#erraddressline2").text("Enter Address");
    			err++;
    		}
    		
    		
    		if(landmark == " " || landmark.length==0)
    		{
    			$("#errlandmark").text("Enter Landmark");
    			err++;
    		}
    		
    	
    		if(state== " " || state.length==0)
    		{
    			$("#errstate").text("Enter State");
    			err++;
    		}
    		
    		
    		if(country == " " || country.length==0)
    		{
    			$("#errcountry").text("Enter Country");
    			err++;
    			
    		}
    		if(err!=0)
    		{
    		return false;
    		}
    		
    		$("#form2").hide(1000);
    		$("#form3").show(1500);
    		$("#btn2").css({"background-color" : "#44A0A0"});
    		$("#btn3").css({"background-color" : "#337ab7"});
    	});
    	
    	/* form2 -> form1 */
    	$("#frm2leftbtn").click(function(){
    		$("#form2").hide(1000);
    		$("#form1").show(1500);
    		$("#btn1").css({"background-color" : "#337ab7"});
    		$("#btn2").css({"background-color" : "#dddddd"});
    		$("#btn3").css({"background-color" : "#dddddd"});
    	});
    	
    	/* form3 -> form2 */
    	$("#frm3leftbtn").click(function(){
    		$("#form3").hide(1000);
    		$("#form2").show(1500);
    		$("#btn2").css({"background-color" : "#337ab7"});
    		$("#btn3").css({"background-color" : "#dddddd"});
    	});
    	
    	$("#verificationbtn").click(function(){
    		var userid = $("#username").val();
    		var email = $("#emailid").val();
    		console.log("userid"+userid);
    		$.ajax({
    			type:"post",
    			url:"generateverificationcode.do",
    			data:{
    				username:userid,
    				emailId:email
    			},
    			datatype:"json",
    			success:function(data)
    			{
    				if(data=="ok")
    					{
	    					$("#verificationbtn").hide();
	    					$("#verifybtn").show();
    					}
    			}
    		});
    		
    		
    	});
    	
    	
    	//verify the code enter by user
    	$("#verifybtn").click(function(){
    		var code = $("#verificationcode").val();
    		var username = $("#username").val();
    		console.log("username"+username);
    		$.ajax({
    			type:"post",
    			url:"verfycode.do",
    			data:{
    				username:username,
    				code:code
    			},
    			datatype:"json",
    			success:function(data){
    				if(data =="success")
    					{
    					console.log("success");
    						$("#submit").attr("disabled",false);
    						console.log("success1");
    					}
    				else{
    					$("#message").show();
    				}
    			}
    		});
    		
    		
    	});
    	$("#codevalidationmessage").click(function(){
    		console.log("Method called");
    		$("#message").hide();
    		$(".alert").hide();
    	});
    	
    	 
    	 //for removing validation message
   	 //form1
   	$("#username").focus(function(){
   	$("#errusername").text("");
   	});
   	 
   	 $("#password").focus(function(){
   		$("#errpassword").text(""); 
   	 });
   	 
   	 $("#emailid").focus(function(){
    		$("#erremailid").text(""); 
    	 });
   	 
   	 $("#firstname").focus(function(){
    		$("#errfirstname").text(""); 
    	 });
   	 $("#lastname").focus(function(){
    		$("#errlastname").text(""); 
    	 });
   	 $("#contactnumber").focus(function(){
    		$("#errcontactnumber").text(""); 
    	 });
   	 
   	 //for removing validation message
   	 //form2
   	 
   	 $("#addressline1").focus(function(){
   		 $("#erraddressline1").text("");
   	 });
   	 $("#street").focus(function(){
   	  	 $("#errstreet").text("");
   	 });
   	    	 
   	 $("#city").focus(function(){
   	     $("#errcity").text(""); 
   	 });
   	    	 
   	 $("#pinno").focus(function(){
   	     $("#errpinno").text(""); 
   	 });
   	    	 
   	 $("#addressline2").focus(function(){
   	     $("#erraddressline2").text(""); 
   	 });
   	 $("#landmark").focus(function(){
   	     $("#errlandmark").text(""); 
   	 });
   	 $("#state").focus(function(){
   	     $("#errstate").text(""); 
   	 });
   	 $("#country").focus(function(){
   		$("#errcountry").text(""); 
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
                <h1 class="page-header">
                    <small>User Registration</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="login.html">Login </a>
                    </li>
                    <li class="active">User Registration</li>
                </ol>
            </div>
        </div>
        <!-- /.row -->

        <!-- Content Row -->
        <div class="row">
            <div class="col-lg-12">
               <div class="panel panel-primary">
               		<div class="panel-heading">
               			Fill Registration Details
               		</div>
               		
               		<div class="panel-body well">
               			<div class="row">
               				<div class="col-md-4">
               					<button type="button" id="btn1" class="btn btn-primary btn-lg btn-block" style="background-color: #337ab7;">1. Personal Details</button>
               				</div>
               				<div class="col-md-4">
               					<button type="button" id="btn2" class="btn btn-primary btn-lg btn-block" style="background-color: #dddddd;">2. Address Details</button>
               				</div>
               				<div class="col-md-4">
               					<button type="button" id="btn3" class="btn btn-primary btn-lg btn-block" style="background-color: #dddddd;">3. Verification</button>
               				</div>
               			</div>
               			<!-- ./row -->
               			<hr>	
               			<form:form role="form" id="registration form" action="processregistrant.html" method="post" modelAttribute="userregistratindto">
               				<div class="row" id="form1">
	               				<div class="col-md-2"></div>
	               				<div class="col-md-4">
	               					<div class="form-group">
	                                      <form:input path="username" type="text" class="form-control" placeholder="Enter UserName" id="username"/>
	                                      <font color='red'> <div id="errusername"></div></font>
									</div>
									<div class="form-group">
	                                      <form:input path="password" type="password" class="form-control" placeholder="Your Password" id="password"/>
	                                      <font color='red'> <div id="errpassword"></div></font>
									</div>
									<div class="form-group">
	                                      <form:input path="emailid" type="text" class="form-control" placeholder="Email Address" id="emailid"/>
	                                      <font color='red'> <div id="erremailid"></div></font>
									</div>
	               				</div>
	               				<!-- /. col-lg-4 -->
	               				
	               				<div class="col-md-4">
	               					<div class="form-group">
	                                      <form:input path="firstname" type="text" class="form-control" placeholder="First Name" id="firstname"/>
	                                      <font color='red'> <div id="errfirstname"></div></font>
									</div>
									<div class="form-group">
	                                      <form:input path="lastname" type="text" class="form-control" placeholder="Last Name" id="lastname"/>
	                                      <font color='red'> <div id="errlastname"></div></font>
									</div>
									<div class="form-group">
	                                      <form:input path="contactnumber" type="text" class="form-control" placeholder="Mobile Number" id="contactnumber"/>
	                                      <font color='red'> <div id="errcontactnumber"></div></font>
									</div>
	               				</div>
	               				<div class="col-md-2"></div>
	               				<div class="row">
	               					<div class="col-md-5"></div>
	               					<div class="col-md-4">
	               						<button type="button" class="btn btn-primary btn-circle btn-xl" id="frm1rightbtn">
	               							<i class="fa  fa-arrow-circle-right"></i>
                           				 </button>
                           				 
                           				 <button type="button" class="btn btn-primary btn-circle btn-xl" id="frm1leftbtn">
	               							<i class="fa  fa-arrow-circle-left"></i>
                           				 </button>
	               					</div>
	               				</div>
	               			</div>
	               			<!-- ./end of form1 -->
	               			
	               			<div class="row" id="form2">
	               				<div class="col-md-2"></div>
	               				<div class="col-md-4">
	               					<div class="form-group">
	                                      <form:input path="addressline1" type="text" class="form-control" placeholder="Address Line1" id="addressline1"/>
	                                      <font color='red'> <div id="erraddressline1"></div></font>
									</div>
									
									<div class="form-group">
	                                      <form:input path="street" type="text" class="form-control" placeholder="Street" id="street"/>
	                                      <font color='red'> <div id="errstreet"></div></font>
									</div>
									<div class="form-group">
	                                      <form:input path="city" type="text" class="form-control" placeholder="City" id="city"/>
	                                      <font color='red'> <div id="errcity"></div></font>
									</div>
									<div class="form-group">
	                                      <form:input path="pinno" type="text" class="form-control" placeholder="pin no" id="pinno"/>
	                                      <font color='red'> <div id="errpinno"></div></font>
									</div>
	               				</div>
	               				<!-- /. col-lg-4 -->
	               				
	               				<div class="col-md-4">
	               					<div class="form-group">
	                                      <form:input path="addressline2" type="text" class="form-control" placeholder="Address Line2" id="addressline2"/>
	                                      <font color='red'> <div id="erraddressline2"></div></font>
									</div>
									<div class="form-group">
	                                      <form:input path="landmark" type="text" class="form-control" placeholder="Landmark" id="landmark"/>
	                                      <font color='red'> <div id="errlandmark"></div></font>
									</div>
									<div class="form-group">
	                                      <form:input path="state" type="text" class="form-control" placeholder="State" id="state"/>
	                                      <font color='red'> <div id="errstate"></div></font>
									</div>
									<div class="form-group">
	                                      <form:input path="country" type="text" class="form-control" placeholder="Country" id="country"/>
	                                      <font color='red'> <div id="errcountry"></div></font>
									</div>
	               				</div>
	               				<div class="col-md-2"></div>
	               				<div class="row">
	               					<div class="col-md-5"></div>
	               					<div class="col-md-4">
	               						<button type="button" class="btn btn-primary btn-circle btn-xl" id="frm2rightbtn">
	               							<i class="fa  fa-arrow-circle-right"></i>
                           				 </button>
                           				 
                           				 <button type="button" class="btn btn-primary btn-circle btn-xl" id="frm2leftbtn">
	               							<i class="fa  fa-arrow-circle-left"></i>
                           				 </button>
	               					</div>
	               				</div>
	               			</div>
	               			<!-- ./end of form2 -->
	               			
	               			<div class="row" id="form3">
	               				<div class="col-md-4"></div>
	               				<div class="col-md-4">
	               					<div class="form-group" id="message">
			               				<div class="alert alert-danger alert-dismissable">
		                                	<button type="button" class="close" id="codevalidationmessage" data-dismiss="alert" aria-hidden="true">×</button>
		                                		Please Enter Valid Code 
		                            	</div>
		                            </div>
	               					<div class="form-group">
	                                      <input type="text" class="form-control" placeholder="Enter Verification Code" id="verificationcode"/>
	                                      
									</div>
									
									
									<div class="form-group">
	                                      <button type="button" id="verificationbtn" class="btn btn-outline btn-success btn-lg btn-block">Get Verification code</button>
									</div>
									
									<div class="form-group">
	                                      <button type="button" id="verifybtn" class="btn btn-outline btn-success btn-lg btn-block">Verify</button>
									</div>
									
									<button type="button" class="btn btn-primary btn-circle btn-xl" id="frm3leftbtn">
	               							<i class="fa  fa-arrow-circle-left"></i>
                           				 </button>
                           				
                           			<button type ="submit" id="submit" class="btn btn-primary">submit</button>
                           					               				</div>
	               				<!-- /. col-lg-4 -->
	               				
	               				<div class="col-md-4">
	               					
	               				</div>
	               				
	               				<div class="row">
	               					<div class="col-md-5"></div>
	               					<div class="col-md-4">
	               						
                           				 
                           				 
	               					</div>
	               				</div>
	               			</div>
	               			<!-- ./end of form3 -->
	               			
	               			</form:form>
               			
               		</div>
               </div>
               <!-- /. panel --> 
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
    <!-- /.container -->

   
</body>

</html>
