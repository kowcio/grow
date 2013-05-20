<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--  broken tag validation depends on the doctype, above works like a charm... -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<head>
	<title>Calc 3 Spring 3 MVC</title>
	   	  <link href="<c:url value="/resources/css/maincss.css"/>" rel="stylesheet" type="text/css" />

</head>
<body>


<div id="registerForm">
<a id="glowna" href="/Blog/"> Strona glowna </a>		<br />   


<h2>Register a user (abstract dao etc)</h2>

	<form:form method="post" action="/Blog/register/reguser" modelAttribute="user">
	
		<table border=1>	<tr>		
			<td>
			<form:label path="login">Login : </form:label>
			<form:input type="text" path="login"  name="login" value="${login}"/>
			</td>
			<td> 	
			<form:label path="passwd">Passwd : </form:label>
			<form:input type="text" path="passwd" name="passwd" value="${passwd}"/>						
			</td>
			</tr>
			<tr>	
			<td colspan="2" align="center">
						<input type="submit" value="Compute All"/>
					</td>	</tr>
					</table>
						ERRORS : 
					<div class="error"> ${allNotOK} </div>
					<form:errors path="login" 	cssClass="error"/><br />
					<form:errors path="passwd"	cssClass="error"/><br />		
</form:form>
</div>

<div id="registerResult">

Registered user : <br />
User login 	= ${user.login}  <br />
User passwd = ${user.passwd}<br /> 
<br />
					<div class="allOK"> ${allOK} </div>


</div>



</body>
</html>
