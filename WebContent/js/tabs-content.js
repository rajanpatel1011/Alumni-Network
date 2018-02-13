$(document).ready(function() {

	
	
	$(".newpost-content").css({"margin-top": "-225px",opacity: 1});
    $(".newpost-content").css({"background-color":"#F4ECDD"});
	
	$("#newpost-btn1").click(function(){
			$("#newpost-btn1").toggleClass('newpost-btn_up');
if(!$("#newpost-btn1").hasClass('newpost-btn_up')){
			$(".newpost-content").css({"background-color":"#F4ECDD"});
	}else{
		$(".newpost-content").css({"background-color":"#EA8C2D"});
	}

	});
	
	
	$("#newpost-btn1").toggle(
		function () { 
			$(".newpost-content").animate({marginTop: "0px",opacity: 1}, 300);

	},function () { 
			$(".newpost-content").animate({marginTop: "-225px",opacity: 1}, 300); 

	});	
	
	
	//new message
	$(".newpost-content").css({"margin-top": "-225px",opacity: 1});
    $(".newpost-content").css({"background-color":"#F4ECDD"});
	
	$("#newpost-btn18").click(function(){
			$("#newpost-btn18").toggleClass('newpost-btn_up');
if(!$("#newpost-btn18").hasClass('newpost-btn_up')){
			$(".newpost-content").css({"background-color":"#F4ECDD"});
	}else{
		$(".newpost-content").css({"background-color":"#EA8C2D"});
	}

	});
	
	
	$("#newpost-btn18").toggle(
		function () { 
			$(".newpost-content8").animate({marginTop: "0px",opacity: 1}, 300);

	},function () { 
			$(".newpost-content8").animate({marginTop: "-225px",opacity: 1}, 300); 

	});
	
	
	

	
	//pin 1
	$('.pin1').show();
	$('.pinned1').hide();
	
	$('.pin1').click(function(){
			$('.pin1').toggle();
			$('.pinned1').toggle();		
		}	
	);
	$('.pinned1').click(function(){
			$('.pin1').toggle();
			$('.pinned1').toggle();		
		}	
	);
	
	//pin2
	$('.pin2').show();
	$('.pinned2').hide();
	
	$('.pin2').click(function(){
			$('.pin2').toggle();
			$('.pinned2').toggle();		
		}	
	);
	$('.pinned2').click(function(){
			$('.pin2').toggle();
			$('.pinned2').toggle();		
		}	
	);
	
	//pin3
	$('.pin3').show();
	$('.pinned3').hide();
	
	$('.pin3').click(function(){
			$('.pin3').toggle();
			$('.pinned3').toggle();		
		}	
	);
	$('.pinned3').click(function(){
			$('.pin3').toggle();
			$('.pinned3').toggle();		
		}	
	);
	
	
	//pin4
	$('.pin4').show();
	$('.pinned4').hide();
	
	$('.pin4').click(function(){
			$('.pin4').toggle();
			$('.pinned4').toggle();		
		}	
	);
	$('.pinned4').click(function(){
			$('.pin4').toggle();
			$('.pinned4').toggle();		
		}	
	);
	
	//pin5
	$('.pin5').show();
	$('.pinned5').hide();
	
	$('.pin5').click(function(){
			$('.pin5').toggle();
			$('.pinned5').toggle();		
		}	
	);
	$('.pinned5').click(function(){
			$('.pin5').toggle();
			$('.pinned5').toggle();		
		}	
	);
	
	
});

//Tab 2 my Profile .....
$(document).ready(function() {

	$('#demo').hide();
	$('.edit').hide();
	$('#update_btn').hide();
	
	$('#edit_btn').click(function(){
		$('label').toggle();
		$('.edit').toggle();
		$('#update_btn').toggle();
		return false;
	});

});


