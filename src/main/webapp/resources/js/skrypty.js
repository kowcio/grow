///////////////////////////////
///////////////////////////////
// FOR CHANGING THE GROW HELP 
///////////////////////////////
///////////////////////////////

$(document).ready(function(){
	  $('.helpBtn').popover({ 
	    html : true,
	    content: function() {
	    	var  va = $('.item.active').find('.container').attr('id');
	    	if (va == "G"){	        return $('.goal_help').html();        	}
	    	if (va == "R"){	        return $('.reality_help').html();    	}
	    	if (va == "O"){	        return $('.options_help').html();    	}
	    	if (va == "W"){	    	return $('.will_help').html();	    	}
	    },
	    title : function() {
	    	var  va = $('.item.active').find('.container').attr('id');
	    	if (va == "G"){	        return $('#goal_help_title').html();        	}
	    	if (va == "R"){	        return $('#reality_help_title').html();    	}
	    	if (va == "O"){	        return $('#options_help_title').html();    	}
	    	if (va == "W"){	    	return $('#will_help_title').html();	    	}
	    },
	    	    
template: '<div id="popHelp" class="popover popHelp">'+
'<div class="popover-inner myclass">'+
'<h3 class="popover-title"></h3>'+
'<div class="popover-content"><p></p></div></div></div>'

	  
	  });	});	

///////////////////////////////
///////////////////////////////
//FOR CHANGING THE GROW HELP - for logged in
///////////////////////////////
///////////////////////////////

$(document).ready(function(){
	  $('.growDescBtn').popover({ 
	    html : true,
	    content: function() {
    	return $('.grow_desc').html();	    	
	    },
	    title : "Tytul z js",  
template: '<div id="popHelp" class="popover popHelp">'+
'<div class="popover-inner myclass">'+
'<h3 class="popover-title"></h3>'+
'<div class="popover-content"><p></p></div></div></div>'

	  
	  });	});	

///////////////////////////////
///////////////////////////////
// FOR THE HELP BUTTON ON THE MAIN SIDE FOR EVERYBODY
//FOR CHANGING THE GROW HELP 
///////////////////////////////
///////////////////////////////

$(document).ready(function(){
	  $('.helpBtnMain').popover({ 
	    html : true,
	    content: function() {
	    	var  va = $('.item.active').find('.container').attr('id');
	    	if (va == "G"){	        return $('.goal_help').html();        	}
	    	if (va == "R"){	        return $('.reality_help').html();    	}
	    	if (va == "O"){	        return $('.options_help').html();    	}
	    	if (va == "W"){	    	return $('.will_help').html();	    	}
	    },
	    title : function() {
	    	var  va = $('.item.active').find('.container').attr('id');
	    	if (va == "G"){	        return $('#goal_help_title').html();        	}
	    	if (va == "R"){	        return $('#reality_help_title').html();    	}
	    	if (va == "O"){	        return $('#options_help_title').html();    	}
	    	if (va == "W"){	    	return $('#will_help_title').html();	    	}
	    },
	    	    
template: '<div id="popHelpMain" class="popover popHelpMain">'+
'<div class="popover-inner myclass">'+
'<h3 class="popover-title"></h3>'+
'<div class="popover-content"><p></p></div></div></div>'

	  
	  });	});	



///////////////////////////////
///////////////////////////////
// Making the basic grow for the new user
//Getting cookies or writing the basic one. 
///////////////////////////////
///////////////////////////////
$(document).ready(function(){
	var cookieDomain 	= 	"";
	var cookieName		=	"grow_cookie1";
	var cookiePath 		= 	"/";
	var cookieExpires	=	123456789;
	var cookieVar = {				//define cookei with data for the chart
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
			   expires : cookieExpires,          //expires in 365 days
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
		//console.log("we have a cookie already");
		loadGrowFromCookie( $.cookie(cookieName ) );
		$("#richAlert").html("Welcome back ! ");
		$("#richAlert").fadeIn(2000);
		$("#richAlert").fadeOut(2000);
	}
	
	function loadGrowFromCookie(j ){		//loadGrowFromCookie( $.cookie(cookieName) );
		console.log ( "cookie = "+ JSON.stringify(j) );
		$("#grow_g").val(j.grow_g);
		$("#grow_r").val(j.grow_r);
		$("#grow_o").val(j.grow_o);
		$("#grow_w").val(j.grow_w);	
	}
	
	
//function for dynamic saving the cookie value of the grow (then add ajax push to server) 
	
	$("body").on("keypress", "#grow_g", function(event){
		c.grow_g = $("#grow_g").val();//	console.log("Old cookie = "+JSON.stringify(c));
		$.cookie(cookieName, c  , {});
		//c = $.cookie(cookieName );console.log("New cookie = "+JSON.stringify(c));
	});
	$("body").on("keypress", "#grow_r", function(event){
		c.grow_r = $("#grow_r").val();//	console.log("Old cookie = "+JSON.stringify(c));
		$.cookie(cookieName, c  , {});
		//c = $.cookie(cookieName );console.log("New cookie = "+JSON.stringify(c));
	});
	$("body").on("keypress", "#grow_o", function(event){
		c.grow_o = $("#grow_o").val();//	console.log("Old cookie = "+JSON.stringify(c));
		$.cookie(cookieName, c  , {});
		//c = $.cookie(cookieName );console.log("New cookie = "+JSON.stringify(c));
	});
	$("body").on("keypress", "#grow_w", function(event){
		c.grow_w = $("#grow_w").val();//	console.log("Old cookie = "+JSON.stringify(c));
		$.cookie(cookieName, c  , {});
		//c = $.cookie(cookieName );console.log("New cookie = "+JSON.stringify(c));
	});
	
	
});

///////////////////////////////
///////////////////////////////
//		Load example grow for interval running. 
///////////////////////////////
///////////////////////////////






///////////////////////////////
///////////////////////////////
//	Dynamic	SCROLL for the help buttons 
///////////////////////////////
///////////////////////////////
/*$(function() {
    var $left = $('#sT_goal');
    var $test = $('#checkVals');
    $(window).bind('scroll', function() {
        //below line is just demo code
$('#log').text($(document).height() - (window.pageYOffset + window.innerHeight));
var q =$(document).height() - (window.pageYOffset + window.innerHeight);
var x = 200+q-1000;

$('#checkVals').text(
"Document.height  " +$(document).height() + 
"  Win.pageYOffset" + window.pageYOffset +
"  Win.innerHeight" + window.innerHeight +
"  Q= " + q +
"  X= " + x
);
        if (q < 1400) 
        {       
            if (x < 575) {$('#left').css('marginTop', 0);}
            else         {$('#left').css('marginTop', x);}
            
        } else {
            $left.css('marginTop', 0);
        }
    });
});*/














