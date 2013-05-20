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
    Welcome Unnamed        
            </div>  
            
             <!--  Login form - spring security -->
            
            <form action="<c:url value='j_spring_security_check' />" method='post'>
               <input type='text' name='j_username' class="loginInputForm"/>
               <input type='password' name='j_password' class="loginInputForm"/>
                <input name="submit" type="submit" value="Zaloguj" />
                <input name="reset" type="reset" />                
            </form>
            
            
           
          </div>
        </div>
      </div>