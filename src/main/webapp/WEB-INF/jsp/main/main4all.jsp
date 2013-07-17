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

<p class="lead">
This is the main page when You can describe Your G.R.O.W. steps, print the chart and measure Your progress.</br>
<h4><code class="text-center">Remember ! You can do it !</code></h4>
 
<p class="text-info">* For not logged users the input data is stored locally (on Your computer) in cookies.</p> 
 
 </p>
  
      
<div id="sideBtns" class="sideBtns">      
<!--  check out how to make it happen ? NAV MENU !!  -->
      <!--  HELP BUTTONS -->      
      <a class="btn btn-large btn-info btn-help"   id="helpBtnMainMain" data-placement="left" data-toggle="popover" data-container= "body">  General help  </a><br /><br />
      <a class="btn btn-large btn-info btn-help helpBtnG" id="helpBtnG" data-placement="left" data-toggle="popover" data-container= "body">  G  </a><br /><br />
      <a class="btn btn-large btn-info btn-help helpBtnR" id="helpBtnR" data-placement="left" data-toggle="popover" data-container= "body">  R  </a><br /><br />
      <a class="btn btn-large btn-info btn-help helpBtnO" id="helpBtnO" data-placement="left" data-toggle="popover" data-container= "body">  O  </a><br /><br />
      <a class="btn btn-large btn-info btn-help helpBtnW" id="helpBtnW" data-placement="left" data-toggle="popover" data-container= "body">  W  </a><br /><br />
      <a class="btn btn-large btn-info " href="${path}/print"> Print  </a>

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

     
      
      
      
      
<form:form method="POST" action="${path}/growadd" modelAttribute="grow">

   <div id="sT_goal" class="sidesText">
   As You can see there are <span class="badge badge-success">4</span>  fields You will need to fill up to complete
   Your first <span class="badge badge-info">G.R.O.W.</span> chart and print it !
   <br /><br />
   They will help You establish the goals, motives and ways to fulfill Your desires, dreams
   and ideas.
   <br /><br />
   To write down Your way and  <span class="badge badge-warning">thrive</span>  
   there are help buttons on the right.
   <br /><br />
   <span class="badge badge-success">Print </span> button redirects to a print template.<br />
   Just press ctrl + p .
   <br /><br />
   
   </div>
                                 
<div class="item" id="g1">
              <h1>Step first : Your GOAL
              </h1>
              <p class="lead">
              
              Here You have the space to describe Your GOAL.
                <br /> Be precise, use the S.M.A.R.T. rules under help button.
                
                <!-- 
                <a title="" data-toggle="tooltip" class="pull-right" 
                href="#" data-original-title="Automatic saving is on." 
                id="gTooltipHelp1">
                <i class="gi-circle_question_mark " id="gTooltipHelp"></i>
                </a>
                 <script>
                    $(document).ready( function() {
                        $("#gTooltipHelp1").tooltip({});
                    });
                 </script>
                  -->
 </p>                
    
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
                            
      
      </div>






</div>


