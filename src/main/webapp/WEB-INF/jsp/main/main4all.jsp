<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--  broken tag validation depends on the doctype, above works like a charm... -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<c:set var="path" value="${pageContext.request.contextPath}"/>


      <!-- Begin page content -->
      <div class="container main4all">
    
      
       <div class="page-header">
          <h2>Develope Your GROW and thrive ! </h2>
          </div>

<p class="lead">Pin a fixed-height footer to the bottom of the viewport in desktop browsers with this custom HTML and CSS.
 A fixed navbar has been added within <code>#wrap</code> with <code>padding-top: 60px;</code> on the <code>.container</code>.</p>
  
      
<div id="sideBtns" class="sideBtns">      
<!--  check out how to make it happen ? NAV MENU !!  -->
      <!--  HELP BUTTONS -->      
      <a class="btn btn-large btn-info btn-help"   id="helpBtnMainMain" data-placement="left" data-toggle="popover" data-container= "body">  Grow help  </a><br /><br />
      <a class="btn btn-large btn-info btn-help helpBtnG" id="helpBtnG" data-placement="left" data-toggle="popover" data-container= "body">  G  </a><br /><br />
      <a class="btn btn-large btn-info btn-help helpBtnR" id="helpBtnR" data-placement="left" data-toggle="popover" data-container= "body">  R  </a><br /><br />
      <a class="btn btn-large btn-info btn-help helpBtnO" id="helpBtnO" data-placement="left" data-toggle="popover" data-container= "body">  O  </a><br /><br />
      <a class="btn btn-large btn-info btn-help helpBtnW" id="helpBtnW" data-placement="left" data-toggle="popover" data-container= "body">  W  </a><br /><br />

<script>
//draggable test - TO DO




//popovers for help
$(document).ready(function(){
	$('#helpBtnMainMain').popover({ 
      html : true,
      content: $('.grow_desc').html(),
      title : 'Grow general help',  
      template: 
      '<div id="popHelpNoLogin" class="popover popHelpNoLogin ui-widget-content">'+
      '<div class="popover-inner">'+
      '<h3 class="popover-title"></h3>'+
      '<div class="popover-content"><p></p></div></div></div>'      
    });    }); 
    
$(document).ready(function(){
      $('#helpBtnG').popover({ 
        html :  true,
        content: $('.goal_help').html(),
       title :$('#goal_help_title').html(),
       template: '<div id="popHelpNoLogin" class="popover popHelpNoLogin">'+
		'<div class="popover-inner">'+
		'<h3 class="popover-title"></h3>'+
		'<div class="popover-content"><p></p></div></div></div>'      
      });   }); 

$(document).ready(function(){
    $('#helpBtnR').popover({ 
      html :  true,
      content: $('.reality_help').html(),
     title :$('#reality_help_title').html(),
     template: '<div id="popHelpNoLogin" class="popover popHelpNoLogin">'+
      '<div class="popover-inner">'+
      '<h3 class="popover-title"></h3>'+
      '<div class="popover-content"><p></p></div></div></div>'      
    });   }); 

$(document).ready(function(){
    $('#helpBtnO').popover({ 
      html :  true,
      content: $('.options_help').html(),
     title :$('#options_help_title').html(),
     template: '<div id="popHelpNoLogin" class="popover popHelpNoLogin">'+
      '<div class="popover-inner">'+
      '<h3 class="popover-title"></h3>'+
      '<div class="popover-content"><p></p></div></div></div>'      
    });   }); 

$(document).ready(function(){
    $('#helpBtnW').popover({ 
      html :  true,
      content: $('.will_help').html(),
     title :$('#will_help_title').html(),
     template: '<div id="popHelpNoLogin" class="popover popHelpNoLogin">'+
      '<div class="popover-inner">'+
      '<h3 class="popover-title"></h3>'+
      '<div class="popover-content"><p></p></div></div></div>'      
    });   }); 

</script>



</div>     
<!--  end help butons div  -->   

     
      
      
      
      
      
      <!--  Form with fields inside carousel -->
      
      
<form:form method="POST" action="${path}/growadd" modelAttribute="grow">

   <div id="sT_goal" class="sidesText">
   As You can see there are <span class="badge badge-success">4</span>  fields You will need to fill up to complete
   Your first <span class="badge badge-info">G.R.O.W.</span> chart PRINT.
   <br /><br />
   It will help You establish the goals, motives and ways to fulfill Your desires
   and ideas.
   <br /><br />
   To write down Your way to  <span class="badge badge-warning">thrive</span>  there is help button on the right side.
   <br /><br />
   This is the Part when You are describing Your GOAL.
   <br /><br />
   Use the Help button for info and arows for next step.
   <br /><br />
   Save - saves the chart.
   <br /><br />
   
   </div>
                                 
<div class="item" id="g1">
              <h1>Step first : Your GOAL</h1>
              <p class="lead">
              
              Here You have the space to describe Your GOAL.
                <br /> Be precise, use the S.M.A.R.T. rules under help button.

            <form:textarea path="grow_g" class="growtext" rows="10" cols="150"/>

</div>
<div class="item" id="g2">
               <h1>Step second : Your REALITY</h1>
              <p class="lead">
              What is Your current reality ? Do not dream, be as much objective as possible.
              <br/>  Be honest.
                </p>
            
                     <form:textarea path="grow_r" class="growtext" rows="10" cols="150"/>
            
            
          
</div>
<div class="item" id="g3">
              <h1>Step third : Your Options </h1>
              <p class="lead">
              Think about Options / Opportunities / Obstacles , describe them, use whatever You can or have.
              Write about those that can have the most impact on Your idea.
            </p>
                  <form:textarea path="grow_o" class="growtext" rows="10" cols="150"/>
        
         
</div>
<div class="item" id="g4">
                <h1>Last step : What Will You Do ? </h1>
              <p class="lead">
              Make a promise to Yourself about things You will do, make a list.
              The chart table (on print) will help You measure Your progress.
              </p>
              <form:textarea path="grow_w" class="growtext" rows="10" cols="150"/>
 </div>
        
     
    
              
<input type="submit" id="submit" class="btn btn-large btn-success span5 offset3 saveBtn" value="Generate Chart" />
</form:form>      
                            
      <a class="btn btn-large btn-info" href="/Blog/print"> print  </a><br /><br />
      
      </div>






</div>


