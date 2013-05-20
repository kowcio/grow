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
    <title>Sticky footer &middot; Twitter Bootstrap</title>


    <!--  CSS JS JSP -->
<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/zmienionycss.css"/>" rel="stylesheet" type="text/css" />

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
            
            
            
            <!--  Login form - spring security -->
            
            <form action="<c:url value='j_spring_security_check' />" method='post'>
               <input type='text' name='j_username' value='login' class="loginInputForm"/>
               <input type='password' name='j_password' values='pass'  class="loginInputForm"/>
                <input name="submit" type="submit" value="Zaloguj" />
                <input name="reset" type="reset" />                
            </form>
        
    
    
            
            <a class="brand" href="#">Project name</a>
            <div class="nav-collapse collapse">
              <ul class="nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
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
                  </ul>
				  
                </li>
              </ul>
            </div><!--/.nav-collapse -->
          </div>
        </div>
      </div>

      <!-- Begin page content -->
      <div class="container">
       
	   <div class="page-header">
          <h2>Develope Your GROW and thrive ! </h2>
		  </div>

		  <p class="lead">Pin a fixed-height footer to the bottom of the viewport in desktop browsers with this custom HTML and CSS. A fixed navbar has been added within <code>#wrap</code> with <code>padding-top: 60px;</code> on the <code>.container</code>.</p>
  
	  
	  
	  
	  <!-- NAVBAR for the GROW chart generation (off until will work with carousel)
	  
<div class="navbar" id="grownav">
    <div class="navbar-inner">
    <a class="brand" href="#">G.R.O.W.</a>
		<ul class="nav">
			<li class="active">
				<a href="#G">G</a></li>
			<li><a href="#R">R</a></li>
			<li><a href="#O">O</a></li>
			<li><a href="#W">W</a></li>
		</ul>
</div></div>
-->
   <!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide" data-interval="0" >
	
      <div class="carousel-inner">
	  
        <div class="item active">
          <img src="resources/img/bg1.jpg" alt="">     
		  

		  <div class="container" id="G" ">
              <h1>GOAL  ..img..   Run Fas-->ter</h1>
              <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
			<textarea class="growtext" rows="10" cols="150"></textarea>			
			<br />
  	  		<br /><br /><br />
		  </div>								
        </div>
		
        <div class="item">
          <img src="resources/img/bg2.jpg" alt="">
		  
          <div class="container" id="R" ">
              <h1>REALITY  ..img..   Run Fas-->ter</h1>
              <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
			<textarea class="growtext" rows="10" cols="150"></textarea>			
			<br />
			<br /><br /><br />
          </div>
        </div>
		
        <div class="item">
		
          <img src="resources/img/bg3.jpg" alt="">
          <div class="container"  id="O" ">
              <h1>OPTIONS  ..img..   Run Fas-->ter</h1>
              <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
			<textarea class="growtext" rows="10" cols="150"></textarea>			
			<br />
			<br /><br /><br />
          </div>
        </div>
		
				
        <div class="item">
		
          <img src="resources/img/bg4.jpg" alt="">
          <div class="container"  id="W" ">
              <h1>WILL TO DO  ..img..   Run Fas-->ter</h1>
              <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
			<textarea class="growtext" rows="10" cols="150"></textarea>			
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
							<a class="btn btn-large btn-primary offset3 span5" href="#">Zapisz</a>
								
								<a class="btn btn-large btn-info btn-help pull-right" id="example" title="Zapisz" data-content="Help for the given grow part." data-placement="right" 
								data-toggle="popover" href="#" data-original-title="Basic info about the grow -> modal">	Help ?	
								</a>
								
								<a href="#" id="example1" class="btn btn-success" rel="popover">hover for popover</a>  
								
								<script>	$(function (){ $("#example").popover();	});	 </script>
<script>								


		
		</script>

						

	  
	  </div>

      <div id="push"></div>
    </div>
	
	





<!-- FOOTER -->

    <div id="footer">
      <div class="container">
        <p class="muted credit">Example courtesy <a href="http://martinbean.co.uk">Martin Bean</a> and <a href="http://ryanfait.com/sticky-footer/">Ryan Fait</a>.</p>
      </div>
    </div>


  </body>
</html>
