// JavaScript Document

$(document).ready(function(e) {
    //$('.create-news').hide();
	$('.logo').hide();
	$('.published').hide();
	$('.create').hide();
	$('.publish-no').hide();
	$('.publish-yes').hide();
	$('.batch').hide();
	
	tabs();
	$('#news').show();
	$('#news-btn').addClass('click-btn-css');
	
	$('.create-event').hide();
	
	if($('.logo').is(':hidden')){
			$('.title').css('margin-left','50px');
		}
	$('#crnews').click(function(){
		$('.create-news').toggle();
		$('.prvnews').toggle();	
		if($('.create-news').is(':visible')){
			$('#crnews').text('Archive');
		}else{
			$('#crnews').text('Create News	');
		}
	}
	);
	
	$('.pass-yr-btn').click(function(){
		$('.batch').hide();
		$('.pass-yr').show();		
	}
	);
	
	$('.batch-btn').click(function(){
		$('.batch').show();
		$('.pass-yr').hide();
		
	}
	);
	
	$('#crevnt').click(function(){
		$('.create-event').toggle();
		$('.prv-events').toggle();	
		if($('.create-event').is(':visible')){
			$('#crevnt').text('Archive');
		}else{
			$('#crevnt').text('Create Event');
		}
	}
	);
	
	$('#news-btn').click(function(){
		tabs();	
		$('#news').show();
		$('#news-btn').addClass('click-btn-css');
	}	
	);
	
	$('#event-btn').click(function(){
		tabs();	
		$('#event').show();
		$('#event-btn').addClass('click-btn-css');
	}	
	);
	
	$('#ini-mod-btn').click(function(){
		tabs();	
		$('#ini-mod').show();
		$('#ini-mod-btn').addClass('click-btn-css');
	}	
	);
	
	$('#branch-btn').click(function(){
		tabs();	
		$('#branch').show();
		$('#branch-btn').addClass('click-btn-css');
	}	
	);
	
	$('#pyear-btn').click(function(){
		tabs();	
		$('#pyear').show();
		$('#pyear-btn').addClass('click-btn-css');
	}	
	);
	$('#ini-usr-btn').click(function(){
		tabs();	
		$('#ini-usr').show();
		$('#ini-usr-btn').addClass('click-btn-css');
	}	
	);
	
	$('#usr-app-btn').click(function(){
		tabs();	
		$('#usr-app').show();
		$('#usr-app-btn').addClass('click-btn-css');
	}	
	);
	
	$('#batch-btn').click(function(){
		tabs();	
		$('#batches').show();
		$('#batch-btn').addClass('click-btn-css');
	}	
	);
	
	$('#help-spt-btn').click(function(){
		tabs();	
		$('#help-spt').show();
		$('#help-spt-btn').addClass('click-btn-css');
	}	
	);
	function tabs(){
		//$('#news').hide();
		$('#event').hide();
		$('#ini-mod').hide();		
		$('#ini-usr').hide();		
		$('#usr-app').hide();		
		$('#batches').hide();		
		$('#help-spt').hide();
		$('#branch').hide();
		$('#pyear').hide();
		$('#news-btn').removeClass('click-btn-css');
		$('#event-btn').removeClass('click-btn-css');
		$('#ini-mod-btn').removeClass('click-btn-css');
		$('#ini-usr-btn').removeClass('click-btn-css');		
		$('#usr-app-btn').removeClass('click-btn-css');
		$('#batch-btn').removeClass('click-btn-css');		
		$('#help-spt-btn').removeClass('click-btn-css');
		$('#branch-btn').removeClass('click-btn-css');	
		$('#pyear-btn').removeClass('click-btn-css');	
		
	}
	
	
	$('#pubnewsbtn').click(function(){
		return false;
	});
	$('#crtnewsbtn').click(function(){
		return false;
	});
	
});

