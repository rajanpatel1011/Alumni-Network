$(document).ready(function() {
			$('#emptyFname').hide();
			$('#CapsFname').hide();
			$('#NaNFname').hide();
			$('#emptyLname').hide();
			$('#NaNLname').hide();
			$('#emptyPassyr').hide();
			$('#emptyEmail').hide();
			$('#InvalidEmail').hide();
			
			$('#inputFname').on("keyup",function(){
				if(!$('#inputFname').val()){
					$('#emptyFname').show();
					$('#NaNFname').hide();
				}else{
					$('#emptyFname').hide();					
					if(!isNaN($('#inputFname').val())){
						$('#NaNFname').show();
					}else{
						$('#NaNFname').hide();	
					}
				}								
			});
			$('#inputFname').trigger("keyup");
			
			$('#inputLname').on("keyup",function(){
				
				if(!$('#inputLname').val()){
					$('#emptyLname').show();
					$('#NaNLname').hide();
				}else{
					$('#emptyLname').hide();					
					if(!isNaN($('#inputLname').val())){
						$('#NaNLname').show();
					}else{
						$('#NaNLname').hide();	
					}
				}								
			});
			$('#inputLname').trigger("keyup");	
			
			
			$('#inputPassyr').on("focusout",function(){
				if($('#inputPassyr').val() == "-select-"){
					$('#emptyPassyr').show();
				}else{
					$('#emptyPassyr').hide();
				}								
			});
			$('#inputPassyr').trigger("focusout");
					
			
			$('#selectBranch').on("focusout",function(){
				if($('#selectBranch').val()  == "-select-"){
					$('#emptyBrach').show();
				}else{
					$('#emptyBrach').hide();
				}								
			});
			$('#selectBranch').trigger("focusout");
			
			
			$('#inputEmail').on("keyup",function(){
				var x = $('#inputEmail').val();
			var atpos = x.indexOf("@");
			var dotpos = x.lastIndexOf(".");
				if(!$('#inputEmail').val()){
					$('#emptyEmail').show();
				}else{
					if(atpos < 1 || dotpos<atpos+2 || dotpos + 2 >= x.length){
						$('#InvalidEmail').show();
					}else{
						$('#InvalidEmail').hide();
					}
					$('#emptyEmail').hide();
				}								
			});
			$('#inputEmail').trigger("keyup");
			
			$('#inputEnrno').on("keyup",function(){
				if(!$('#inputEnrno').val()){
					$('#emptyEnrno').show();
				}else{
					$('#emptyEnrno').hide();
				}						
			});
			$('#inputEnrno').trigger("keyup");
			
			$('#inputDob').on("focusout",function(){
				if(!$('#inputDob').val()){
					$('#emptyDob').show();
				}else{
					$('#emptyDob').hide();
				}						
			});
			$('#inputEnrno').trigger("focusout");
			
			$('#signup_btn').click(
				function(){
					var i = 1;
					if(!$('#inputFname').val()){
						$('#emptyFname').show();
						i = 2;
					}
					if(!$('#inputLname').val()){
						$('#emptyLname').show();
						i = 2;
					}
					if(!$('#inputDob').val()){
						$('#emptyDob').show();
						i = 2;
					}
					if(!$('#inputEmail').val()){
						$('#emptyEmail').show();
						i = 2;
					}
					if($('#inputPassyr').val() == "-select-"){
						$('#emptyPassyr').show();
						i = 2;
					}
					if($('#selectBranch').val() == '-select-'){
						$('#emptyBrach').show();
						i = 2;
					}
					if(!$('#inputEnrno').val()){
						$('#emptyEnrno').show();
						i = 2;
					}
					if(i==1){
						$('#signupForm').hide(300);
						$('#msg').show(300);
						return true;
					}else{
						return false;
					}				
				}				
			);
			
			
			$('#sub_code').click(
					function(){
						var i = 1;
						if(i==1){
							$('#signupForm').hide(300);
							$('#msg').show(300);
							return true;
						}else{
							return false;
						}				
					}				
				);
	});
	
	
	$(document).ready(function() {
		$('#emptyPassyr').hide();
		$('#emptyFname').hide();
		$('#CapsFname').hide();
		$('#NaNFname').hide();
		$('#emptyLname').hide();
		$('#NaNLname').hide();
		$('#emptyEmail').hide();
		$('#InvalidEmail').hide();
		$('#emptyDob').hide();
		$('#emptyBrach').hide();
		$('#emptyEnrno').hide();
		$('#msg').hide();
	});

