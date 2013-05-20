   <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
   
   <c:set var="path" value="${pageContext.request.contextPath}"/>
   
      <!-- Begin page content -->
      <div class="container ">
       
       <div class="page-header">
          <h2>Develope Your GROW and thrive ! </h2>
          </div>

<p class="lead">
The carousel below will help You to obtain and store the answers to all the G.R.O.W. model
questions and steps. Se go, and <code>G.R.O.W</code>
 </p>
  
      
      
      <!--  HELP BUTTONS -->      
      <a class="btn btn-large btn-info btn-help pull-right helpBtn" 
      id="helpBtn" 
      data-placement="left" 
      data-toggle="popover" 
      data-html="true"
      data-container= "body" 
        >         Help ?      </a>

      
      
            <!--  GROW DESC  BUTTONS -->      
      <a class="btn btn-large btn-info pull-right growDescBtn" 
      id="growDescBtn" 
      title="Zapisz" 
      data-placement="left" 
      data-toggle="popover" 
      data-html="true"
      data-original-title="Basic info about the grow popover" 
      data-container= "body" 
        >         GrowDesc      </a>
      
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
   
 
 
 
   <!-- Carousel   ================================================== -->
    <div id="myCarousel" class="carousel slide" data-interval="0" >
      <div class="carousel-inner">


        <div class="item active">
          <img src="resources/img/bg1.jpg" alt="">     
          

          <div class="container" id="G" ">
              <h1>Step first : Your GOAL</h1>
              <p class="lead">
              
              Here You have the space to describe Your GOAL.
<br /> Be precise, use the S.M.A.R.T. rules under help button.

            <form:textarea path="grow_g" class="growtext" rows="10" cols="150"/>

          </div>                                
        </div>
        
        <div class="item">
          <img src="resources/img/bg2.jpg" alt="">
          
          <div class="container" id="R" ">
              <h1>Step second : Your REALITY</h1>
              <p class="lead">
              What is Your current reality ? Do not dream, be as much objective as possible.
              <br/>  Be honest.
</p>
            
                     <form:textarea path="grow_r" class="growtext" rows="10" cols="150"/>
            
            
          </div>
        </div>
        
        <div class="item">
        
          <img src="resources/img/bg3.jpg" alt="">
          <div class="container"  id="O" ">
              <h1>Step third : Your Options </h1>
              <p class="lead">
              Think about Options / Opportunities / Obstacles , describe them, use whatever You can or have.
              Write about those that can have the most impact on Your idea.

</p>
            
        
        
                  <form:textarea path="grow_o" class="growtext" rows="10" cols="150"/>
        
        
          
          </div>
        </div>
        
                
        <div class="item">
        
          <img src="resources/img/bg4.jpg" alt="">
          <div class="container"  id="W" ">
              <h1>Last step : What Will You Do ? </h1>
              <p class="lead">
              Make a promise to Yourself about things You will do, make a list.
              The chart table (on print) will help You measure Your progress.
              </p>
            
            
            
            <form:textarea path="grow_w" class="growtext" rows="10" cols="150"/>
            
          
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
              
<input type="submit" id="submit" class="btn btn-large btn-primary span5 offset3 saveBtn" value="Save / Update Your Grow" />

    
    </form:form>                               
      
      </div>
