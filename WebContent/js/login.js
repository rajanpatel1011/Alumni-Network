 $(document).ready(function() {
			$('#emptyUname').hide();
        	$('#emptyPwd').hide();
		//empty username			
        
			
		// username keypress
			$( "#inputUname" ).trigger( "keyup" );
			$('#inputUname').on("keyup",function(){
				$('#emptyUname').hide();
				if(!$('#inputUname').val()){
					$('#emptyUname').show();
				}else{
					$('#emptyUname').hide();
				}
			});
						

		// pwd keypress
			$( "#inputPWD" ).trigger( "keyup" );
			$('#inputPWD').on("keyup",function(){
				$('#emptyUname').hide();
        		$('#emptyPwd').hide();
				if(!$('#inputPWD').val()){
					$('#emptyPwd').show();
				}
				else{
					if(!$('#inputPWD').val())
						$('#emptyUname').show();
					$('#emptyPwd').hide();
				}
			});

			
			
			$('#signin').click(function(){
				if(!$('#inputUname').val()){
					$('#emptyUname').show();
					if(!$('#inputPWD').val()){
						$('#emptyPwd').show();
						$('#inputPWD').focus();						
					}
					$('#inputUname').focus();					
					return false; 
				}
				else{
					if(!$('#inputPWD').val()){
						$('#emptyPwd').show();
						$('#inputPWD').focus();
						return false;
					}
					else{
						$('#PwdLen').hide();
					}
					$('#emptyUname').hide();
					
				}				
			}			
			);
		}); 		
