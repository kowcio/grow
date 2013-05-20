<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


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