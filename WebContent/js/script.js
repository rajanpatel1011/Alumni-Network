//Javascript index.jsp

$(document).ready(function(){
	
	$( '#home' ).addClass("active");
	$( '#home' ).click(function(){
		navBack();
		$( '#home' ).addClass("active");
	});
	
	$( '#event' ).click(function(){
		navBack();
		$( '#event' ).addClass("active");
	});
	
	$( '#login' ).click(function(){
		navBack();
		$( '#login' ).addClass("active");
	});
	
	$( '#signup' ).click(function(){
		navBack();
		$( '#signup' ).addClass("active");
	});
	
	$( '#contect' ).click(function(){
		navBack();
		$( '#contect' ).addClass("active");
	});
});
function navBack()
{
	$( '#home').removeClass("active");
	$( '#event').removeClass("active");
	$( '#login').removeClass("active");
	$( '#signup').removeClass("active");
	$( '#contect').removeClass("active");
}


//slide login/signup div 

$(document).ready(function() {
	$('#login-form').hide();
	$('#signup-form').hide();
	$('#lgn').click(function(){
		if($('#signup-form').is(':visible')){
			$('#signup-form').slideUp(300);
		}
		$('#login-form').slideToggle(300);
	});
	$('#sup').click(function(){
		if($('#login-form').is(':visible')){
			$('#login-form').slideUp(300);
		}
		$('#signup-form').slideToggle(300);
	});
});



