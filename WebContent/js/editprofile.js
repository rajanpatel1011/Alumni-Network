 $(document).ready(function(){
	   $("#emptynpwd").hide();
	   $("#emptycpwd").hide();
	
	   $("#emptyfname").hide();
	   $("#emptymname").hide();
	   $("#emptylname").hide();
	
	   $("#Capfname").hide();
	   $("#Capmname").hide();
	   $("#Caplname").hide();
	   
	   $("#nofname").hide();
	   $("#nomname").hide();
	   $("#nolname").hide();
	   
	   $("#emptymobno").hide();
	   $("#nomobno").hide();
	   $("#digitmobno").hide();
	   
	   $("#emptyemail").hide();
	   $("#properemail").hide();
	   
	   $("#emptyohob").hide();
	   $("#notcheck").hide();
	   
	   $("#emptyadd1").hide();
	   $("#emptyadd2").hide();
	   
	   $("#emptyhighclg").hide();
	   
	   $("#emptycource").hide();
	   $("#emptyoyear").hide();
	   $("#nooyear").hide();
	   $("#emptyoclg").hide();

	   $("#emptyjyear").hide();
	   $("#nojyear").hide();
	   $("#emptyjmonth").hide();
	   $("#nojmonth").hide();
	   $("#emptykeys").hide();
	   
	   $("#emptyjobtype").hide();
	   $("#emptyfarea").hide();
	   $("#emptyindu").hide();
	   
	   $("#npwd").val("_");
	   $("#cpwd").val("_");
	   $(".edit").hide();
	   $("#edit_btn").click(function(){
			
		   $("#npwd").val("");
		   $("#cpwd").val("");  
		   $(".edit").show();
		   $("#temp").hide();
		    $("#edit_btn").hide();
		    
		   $('#npwd').on("keyup",function(){
				if(!$('#npwd').val()){
					$('#emptynpwd').show();			
				}else{
					$('#emptynpwd').hide();					
				}								
			});
			$('#npwd').trigger("keyup");
	  
	   
	   
	   $('#cpwd').on("keyup",function(){
			if(!$('#cpwd').val()){
				$('#emptycpwd').show();
				$("#Notmatchpwd").hide();
			}else{
				$('#emptycpwd').hide();
				if(("#cpwd").val()==("#npwd").val()){
					$("#Notmatchpwd").show();
				}else{
					$("#Notmatchpwd").hide();
				}
			}								
		});
		$('#cpwd').trigger("keyup");
		
		
	   });
	   
	   $('#fname').on("keyup",function(){
			if(!$('#fname').val()){
				$('#emptyfname').show();
				$('#nofname').hide();
			}else{
				$('#emptyfname').hide();					
				if(!isNaN($('#fname').val())){
					$('#nofname').show();
				}else{
					$('#nofname').hide();	
				}
			}								
		});
		$('#fname').trigger("keyup");
		
		 $('#mname').on("keyup",function(){
				if(!$('#mname').val()){
					$('#emptymname').show();
					$('#nomname').hide();
				}else{
					$('#emptymname').hide();					
					if(!isNaN($('#mname').val())){
						$('#nomname').show();
					}else{
						$('#nomname').hide();	
					}
				}								
			});
			$('#mname').trigger("keyup");
			
			 $('#lname').on("keyup",function(){
					if(!$('#lname').val()){
						$('#emptylname').show();
						$('#nolname').hide();
					}else{
						$('#emptylname').hide();					
						if(!isNaN($('#lname').val())){
							$('#nolname').show();
						}else{
							$('#nolname').hide();	
						}
					}								
				});
				$('#lname').trigger("keyup");
				
				$('#mobno').on("keyup",function(){
					if(!$('#mobno').val()){
						$('#emptymobno').show();
						$('#nomobno').hide();
						$('#digitmobno').hide();
					}else{
						$('#emptymobno').hide();
						if(isNaN($('#mobno').val())){
							$('#nomobno').show();
							$('#digitmobno').hide();
							if(!/^[0-9]{1,10}$/.test($('#mobno').val())){
								$('#digitmobno').show();	
							 	}
							else{
								$('#digitmobno').hide();
							}
						}else{
							$('#nomobno').hide();	
						}
					}								
				});
				$('#mobno').trigger("keyup");
				
				$('#email').on("keyup",function(){
					var x = $('#email').val();
				var atpos = x.indexOf("@");
				var dotpos = x.lastIndexOf(".");
					if(!$('#email').val()){
						$('#emptyemail').show();
					}else{
						if(atpos < 1 || dotpos<atpos+2 || dotpos + 2 >= x.length){
							$('#properEmail').show();
						}else{
							$('#properdEmail').hide();
						}
						$('#emptyemail').hide();
					}								
				});
				$('#email').trigger("keyup");
		
				$('#hob').on("keyup",function(){
					$('#ock').prop('checked', true);
					if(!$('#hob').val()){
						$('#emptyohob').show();
					}else{
						$('#emptyohob').hide();					
					}								
				});
				$('#hob').trigger("keyup");
				

				 $('#add1').on("keyup",function(){
						if(!$('#add1').val()){
							$('#emptyadd1').show();
							
						}else{
							$('#emptyadd1').hide();					
							
						}								
					});
					$('#add1').trigger("keyup");

					 $('#add2').on("keyup",function(){
							if(!$('#add2').val()){
								$('#emptyadd2').show();
								
							}else{
								$('#emptyadd2').hide();					
								
							}								
						});
						$('#add1').trigger("keyup");
						
						
						$('#highclg').on("keyup",function(){
							if(!$('#highclg').val()){
								$('#emptyhighclg').show();
								
							}else{
								$('#emptyhighclg').hide();					
								
							}								
						});
						$('#highclg').trigger("keyup");
						
						$('#ocource').on("keyup",function(){
							if(!$('#ocource').val()){
								$('#emptycource').show();
								
							}else{
								$('#emptycource').hide();					
								
							}								
						});
						$('#ocource').trigger("keyup");
						
						
						$('#oyear').on("keyup",function(){
							if(!$('#oyear').val()){
								$('#emptyoyear').show();
								
							}else{
								$('#emptyoyear').hide();
								if(isNaN($('#oyear').val())){
									$('#nooyear').show();
								}else{
									$('#nooyear').hide();	
								}
								
							}								
						});
						$('#oyear').trigger("keyup");
						
					
						$('#oclg').on("keyup",function(){
							if(!$('#oclg').val()){
								$('#emptyoclg').show();
								
							}else{
								$('#emptyoclg').hide();					
								
							}								
						});
						$('#oclg').trigger("keyup");
						
						$('#jyear').on("keyup",function(){
							if(!$('#oyear').val()){
								$('#emptyjyear').show();
								
							}else{
								$('#emptyjyear').hide();
								if(isNaN($('#jyear').val())){
									$('#nojyear').show();
								}else{
									$('#nojyear').hide();	
								}
								
							}								
						});
						$('#jyear').trigger("keyup");
						
						$('#jmonth').on("keyup",function(){
							if(!$('#jmonth').val()){
								$('#emptyjmonth').show();
								
							}else{
								$('#emptyjmonth').hide();
								if(isNaN($('#jmonth').val())){
									$('#nojmonth').show();
								}else{
									$('#nojmonth').hide();	
								}
								
							}								
						});
						$('#jmonth').trigger("keyup");
						
						$('#keys').on("keyup",function(){
							if(!$('#keys').val()){
								$('#emptykeys').show();
								
							}else{
								$('#emptykeys').hide();
							}								
						});
						$('#keys').trigger("keyup");
						
						$('#jobtype').on("keyup",function(){
							if(!$('#jobtype').val()){
								$('#emptyjobtype').show();
								
							}else{
								$('#emptyjobtype').hide();
							}								
						});
						$('#jobtype').trigger("keyup");
						
						$('#indu').on("keyup",function(){
							if(!$('#indu').val()){
								$('#emptyindu').show();
								
							}else{
								$('#emptyindu').hide();
							}								
						});
						$('#indu').trigger("keyup");
						
						$('#farea').on("keyup",function(){
							if(!$('#farea').val()){
								$('#emptyfarea').show();
								
							}else{
								$('#emptyfarea').hide();
							}								
						});
						$('#farea').trigger("keyup");
						
  });
	 
 $(document).ready(function(){
	   $("#emptynpwd").hide();
	   $("#emptycpwd").hide();
	   $("#emptyfname").hide();
	   $("#emptymname").hide();
	   $("#emptylname").hide();
	
	   $("#Capfname").hide();
	   $("#Capmname").hide();
	   $("#Caplname").hide();
	   
	   $("#nofname").hide();
	   $("#nomname").hide();
	   $("#nolname").hide();
	   
	   
	   $("#emptymobno").hide();
	   $("#nomobno").hide();
	   
	   $("#emptyemail").hide();
	   $("#properemail").hide();

	   $("#emptyohob").hide();
	   $("#notcheck").hide();
	   
	   $("#emptyadd1").hide();
	   $("#emptyadd2").hide();
	   
	   $("#emptyhighclg").hide();
	   
	   $("#emptycource").hide();
	   $("#emptyoyear").hide();
	   $("#nooyear").hide();
	   $("#emptyoclg").hide();
	   
	   $("#emptyjyear").hide();
	   $("#nojyear").hide();
	   $("#emptyjmonth").hide();
	   $("#nojmonth").hide();
	   $("#emptykeys").hide();
	   
	   $("#emptyjobtype").hide();
	   $("#emptyfarea").hide();
	   $("#emptyindu").hide();
 });