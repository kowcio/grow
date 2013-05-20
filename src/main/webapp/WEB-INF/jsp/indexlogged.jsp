<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--  broken tag validation depends on the doctype, above works like a charm... -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">


  <head>
 
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="host" value="${pageContext.request.serverName}"/>



    <!--  CSS JS JSP -->
<link href="<c:url value="/resources/css/all.css"/>" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/skrypty.js"/>"></script>
    
	
	

  </head>

  <body>


    <!-- Part 1: Wrap all page content here -->
    <div id="wrap">

      <!-- Fixed navbar -->
      <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
          <div class="container">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            
            
            
            
            
            
            <div id="greeting" class="brand">
    Welcome <sec:authentication property="principal.username" />        
            </div>  
            
            
            
            
            
            
            
            <a class="brand" href="http://127.0.0.1:8080/Blog"/>G.R.O.W. </a>
            <div class="nav-collapse collapse">
              <ul class="nav">
                <li class="active"><a href="/Blog">Home</a></li>
                <li><a href="/Blog/print">Print</a></li>
                <li><a href="/Blog/about">About</a></li>
                <li><a href="/Blog/contact">Contact</a></li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
     			  <ul class="dropdown-menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li class="divider"></li>
                    <li class="nav-header">Nav header</li>
                    <li><a href="#">Separated link</a></li>
                    <li><a href="#">One more separated link</a></li>
      			</li>
              </ul>
<li>
              <a href="<c:url value="/j_spring_security_logout" />" class="brand"> Logout  </a>
</li>
            </div><!--/.nav-collapse -->
          </div>
        </div>
      </div>







      <!-- Begin page content -->
      <div class="container">
       
	   <div class="page-header">
          <h2>Develope Your GROW and thrive ! </h2>
		  </div>

<p class="lead">Pin a fixed-height footer to the bottom of the viewport in desktop browsers with this custom HTML and CSS.
 A fixed navbar has been added within <code>#wrap</code> with <code>padding-top: 60px;</code> on the <code>.container</code>.</p>
  
	  
	  
	  
	  
	  <!--  HELP BUTTON S -->
	  
	  <a class="btn btn-large btn-info btn-help pull-right helpBtn" id="helpBtn"
	  data-content="Help for the given grow part." data-placement="top" data-toggle="popover" 
	  data-original-title="Basic info about the grow -> modal">
	   Help ?  
</a>
 
<script>  
$(function ()  
{ 
	$(".helpBtn").popover();  
});  
</script> 
	  
	  
	  <!--  Form with fields inside carousel -->
	  
	  
<form:form method="POST" action="${path}/growadd" modelAttribute="grow">
	  
	  
   <!-- Carousel   ================================================== -->
    <div id="myCarousel" class="carousel slide" data-interval="0" >
      <div class="carousel-inner">


        <div class="item active">
          <img src="resources/img/bg1.jpg" alt="">     
		  

		  <div class="container" id="G" ">
              <h1>GOAL  ..img..   Run Fas-->ter</h1>
              <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
			


            <form:textarea path="grow_g" class="growtext" rows="10" cols="150"/>


	
			<br />
  	  		<br /><br /><br />
		  </div>								
        </div>
		
        <div class="item">
          <img src="resources/img/bg2.jpg" alt="">
		  
          <div class="container" id="R" ">
              <h1>REALITY  ..img..   Run Fas-->ter</h1>
              <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
			
			
			         <form:textarea path="grow_r" class="growtext" rows="10" cols="150"/>
			
			
			
			<br />
			<br /><br /><br />
          </div>
        </div>
		
        <div class="item">
		
          <img src="resources/img/bg3.jpg" alt="">
          <div class="container"  id="O" ">
              <h1>OPTIONS  ..img..   Run Fas-->ter</h1>
              <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
			
		
		
		          <form:textarea path="grow_o" class="growtext" rows="10" cols="150"/>
		
		
			
			<br />
			<br /><br /><br />
          </div>
        </div>
		
				
        <div class="item">
		
          <img src="resources/img/bg4.jpg" alt="">
          <div class="container"  id="W" ">
              <h1>WILL TO DO  ..img..   Run Fas-->ter</h1>
              <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
			
			
			
			<form:textarea path="grow_w" class="growtext" rows="10" cols="150"/>
			
			
			<br />
			<br /><br /><br />
          </div>
        </div>
		
		
		
      </div> <!-- end carousel nner -->

	  

	  <!-- carousel indicators as a navbar --> 
	  <ol class="carousel-indicators">
	  
                  <li class="active" data-slide-to="0" data-target="#myCarousel">		
						<a class="btn btn-default btn-success" href="#"> GOAL </a>
				  </li>
                  <li data-slide-to="1" data-target="#myCarousel" class="">			
						<a class="btn btn-default btn-success" href="#"> Reality </a>
				  </li>
                  <li data-slide-to="2" data-target="#myCarousel" class="">			
						<a class="btn btn-default btn-success" href="#"> Options </a>
				  </li>
				  <li data-slide-to="3" data-target="#myCarousel" class="">			
						<a class="btn btn-default btn-success" href="#"> Will to do</a>
				  </li>
				  
      </ol>



<a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
<a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
</div><!-- /.carousel -->

	
	  		  <!-- control l buttons  under the caousel- save and help ++ -->
	  		  
<input type="submit" id="submit" class="btn btn-large btn-primary span5 offset3 saveBtn" value="Save1" />

	
	</form:form>                               
	  
	  </div>

      <div id="push"></div>
    </div>
	
	





<!-- FOOTER -->

    <div id="footer">
   
 <jsp:include page="/WEB-INF/jsp/footer/footer.jsp"></jsp:include>


    </div>


  </body>
</html>
