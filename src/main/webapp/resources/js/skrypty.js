function checkMe() {
	if (confirm("Are you sure")) 
	{
		
		alert("Clicked Ok");
		return true;
	} 
	else {
		alert("Clicked Cancel");
		return false;
	}
}





// FOR CHANGING THE GROW HELP 

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



//FOR CHANGING THE GROW HELP 

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


// FOR THE HELP BUTTON ON THE MAIN SIDE FOR EVERYBODY

//FOR CHANGING THE GROW HELP 

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




