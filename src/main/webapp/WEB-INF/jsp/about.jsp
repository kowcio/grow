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
    
        
 
 <sec:authorize access="isAuthenticated()" var="isAuthenticated" />
<c:if test="${not isAuthenticated}">    
 <jsp:include page="/WEB-INF/jsp/header/header4all.jsp"></jsp:include>
 </c:if>

<c:if test="${isAuthenticated}">
 <jsp:include page="/WEB-INF/jsp/header/header4logged.jsp"></jsp:include>

 </c:if>
 
 
 <sec:authorize access="isAuthenticated()" var="isAuthenticated" />
<c:if test="${not isAuthenticated}">
 <jsp:include page="/WEB-INF/jsp/main/main4all.jsp"></jsp:include>
</c:if>

<c:if test="${isAuthenticated}">
 <jsp:include page="/WEB-INF/jsp/main/main4logged.jsp"></jsp:include>
</c:if>

</div>

 <jsp:include page="/WEB-INF/jsp/footer/footer.jsp"></jsp:include>







  </body>
  
  
  
  
  
  
</html>
