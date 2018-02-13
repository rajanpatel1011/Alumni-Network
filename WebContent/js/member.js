$(document).ready(function(){
	hide();
	$( '#tab1').show();
	
	$( '#forum' ).click(function(){
		hide();
		$( '#tab1').show();		
	});
	/*if($('#tab1').is(':visible')){
		$('#forum').addClass("active");
	}*/
	
	$( '#myprofile' ).click(function(){
		hide();
		$( '#tab2').show();
		
	});
	$( '#searchmem' ).click(function(){
		hide();
		$( '#tab3').show();	
	});
	$( '#gallery' ).click(function(){
		hide();
		$( '#tab4').show();
	});
	$( '#privmsg' ).click(function(){
		hide();
		$( '#tab5').show();	
	});
	$( '#makeapp' ).click(function(){
		hide();
		$( '#tab6').show();	
	});
	$( '#reportuser' ).click(function(){
		hide();
		$( '#tab7').show();	
	});
	$( '#mod_req' ).click(function(){
		hide();
		$( '#tab8').show();	
	});
	$( '#user_req' ).click(function(){
		hide();
		$( '#tab9').show();	
	});
});
function hide()
{
	$( '#tab1').hide();
	$( '#tab2').hide();
	$( '#tab3').hide();
	$( '#tab4').hide();
	$( '#tab5').hide();
	$( '#tab6').hide();
	$( '#tab7').hide();
	$( '#tab8').hide();
	$( '#tab9').hide();
}