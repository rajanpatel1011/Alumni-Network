$(document).ready(function() {
	$('#newpost-content1').hide();
	
	//if($('#signup-form').is(':visible')){
	if($('#newpost-content1').is(':visible')){
	}else{
		$("#btn-new-post").css({"background-color":"#EA8C2D"});
		$(".forum").css({"padding-top":"0px"});
		$(".form-search").css({"padding-top":"30px"});
	}
	$("#newpost-btn1").hide();
	$("#newpost-btn2").click(function(){
		
		//$('#newpost-content1').show();
		$("#newpost-btn2").hide();
		
		$('#newpost-content1').slideDown(function(){
			$("#newpost-btn1").show();
		});
		
	});
	
	$("#newpost-btn1").click(function(){
		$("#newpost-btn1").hide();
		$('#newpost-content1').slideUp(
				function(){
					$("#newpost-btn2").show();
				}
				);		
		//$("#newpost-btn2").show();
	});
	
	
});