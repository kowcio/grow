<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--  broken tag validation depends on the doctype, above works like a charm... -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<c:set var="path" value="${pageContext.request.contextPath}" />
<c:set var="host" value="${pageContext.request.serverName}" />

<!--  CSS JS JSP -->
<link href="<c:url value="/resources/css/all.css"/>" rel="stylesheet"
	type="text/css" />

<script type="text/javascript"	src="<c:url value="/resources/js/jquery.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/js/bootstrap.js"/>"></script>

<script type="text/javascript"	src="<c:url value="/resources/js/jspdf.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/js/jspdf.plugin.from_html.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/js/jspdf.plugin.standard_fonts_metrics.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/js/jspdf.plugin.javascript.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/js/jspdf.plugin.sillysvgrenderer.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/js/jspdf.plugin.split_text_to_size.js"/>"></script>

<script type="text/javascript"  src="<c:url value="/resources/js/jquery.cookie.js"/>"></script>
<script type="text/javascript"  src="<c:url value="/resources/js/skrypty.js"/>"></script>

<style type="text/css">
h1 {
	margin-top: 0%;
	margin-bottom: 0px;
}

body {
	margin: 0px;
	padding: 0px;
}
</style>


<script>


///////////////////////////////
///////////////////////////////
//      Getting the cookie and making the print chart.
///////////////////////////////
///////////////////////////////

$(document).ready(function(){
    var cookieDomain    =   "";
    var cookieName      =   "grow_cookie1";
    var cookiePath      =   "/";
    var cookieVar = {               //define cookei with data for the chart
            grow_g : "goal step",
            grow_r : "reality step",
            grow_o : "options step",
            grow_w : "will step",
    } ;
    $.cookie.json = true;

    var c = $.cookie(cookieName);
    if(typeof c == 'undefined'){
        console.log("we have no cookie");
        //set the cookie 
        $.cookie(cookieName, cookieVar  , {
               expires : 1,          //expires in 365 days
               path    : cookiePath,   //The value of the path attribute of the cookie 
                                       //(default:path page created the cookie  "/" for root/all pages).
               domain  : cookieDomain, //The value of the domain attribute of the cookie
                                       //"" or null for localhost
               secure  : false          //If set to true the secure attribute of the cookie
                                       //will be set and the cookie transmission will be https
            });
        //load the initial data
        loadGrowFromCookie( cookieVar );
        //show the alert
        $("#richAlert").html("Loaded new Grow");
        $("#richAlert").fadeIn(2000);
        $("#richAlert").fadeOut(2000);

    }
    else{
        console.log("we have a cookie already");
        loadGrowFromCookie( $.cookie(cookieName ) );
        $("#richAlert").html("Welcome back ! ");
        $("#richAlert").fadeIn(2000);
        $("#richAlert").fadeOut(2000);
    }
    
    function loadGrowFromCookie(j ){        //loadGrowFromCookie( $.cookie(cookieName) );
        console.log ( "cookie = "+ JSON.stringify(j) );
        $("#grow_g").text(j.grow_g);
        $("#grow_r").text(j.grow_r);
        $("#grow_o").text(j.grow_o);
        $("#grow_w").text(j.grow_w); 
    }
    
});


</script>


</head>
<body>
	<div id="print_page">
		<div class="page-header text-center">
			<h2>Develop Your GROW and thrive !</h2>
		</div>
		<p class="lead">
			Description variable from DB ?
			<code>G.R.O.W.</code>
		</p>


			<table class="printTable">
				<tr>
					<td>
						<div class="item" id="g1print">
							<h1 class="text-center">GOAL</h1>
							<div class="growtext_print" id="grow_g">grow_g</div>
						</div>
					</td>
					<td>
						<div class="item" id="g2print">
							<h1 class="text-center">REALITY</h1>
                            <div class="growtext_print" id="grow_r">grow_r</div>
							
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="item" id="g3print">
							<h1 class="text-center">OPTIONS</h1>
							<div class="growtext_print" id="grow_o">grow_o</div>
						</div>
					</td>
					<td>
						<div class="item" id="g4print">
							<h1 class="text-center">WILL TO DO</h1>
							<div class="growtext_print"  id="grow_w">grow_w</div>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<hr />
						<p class="text-left challengeName">Progress :</p>
						<table class="challengeTable">
							<tr>
								<!--  30 day progress td`s -->
								<%
									for (int i = 1; i < 31; i++)
											out.println("<td>&nbsp;</td>");
								%>
							</tr>
						</table>

						<p class="text-right challengeName">... / ...</p> <br />
					<br />
					<br />
					</td>
				</tr>
				<tr>
					<td>
						<!-- 

          --> <script>
											//  szerokosc 210 mm
											//  wysokosc 355
											function genPDF() {
												var doc = new jsPDF(
														'landscape', 'mm', 'a4');
												doc
														.fromHTML(
																$('body')
																		.get(0),
																5,
																5,
																{
																	'width' : 500,
																	'elementHandlers' : true
																});

												doc.output('dataurl');
											}
										</script>

					</td>
				</tr>
			</table>










	</div>
</body>
</html>