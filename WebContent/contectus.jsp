<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html lang="en">
<head>
<title></title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/bootstrap.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="css/responsive.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="css/style.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="css/touchTouch.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="css/kwicks-slider.css" type="text/css"
	media="screen">
<link href="css/mobiscroll.custom-2.6.2.min.css" rel="stylesheet"
	type="text/css" />

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/superfish.js"></script>
<script type="text/javascript" src="js/jquery.flexslider-min.js"></script>
<script type="text/javascript" src="js/jquery.kwicks-1.5.1.js"></script>
<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/touchTouch.jquery.js"></script>
<script type="text/javascript" src="js/new_edit.js"></script>
<script src="js/mobiscroll.custom-2.6.2.min.js" type="text/javascript"></script>
<script src="js/forms.js"></script>
<script
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyD-WKH5rvf-9g1To8OHKqPOoVKZddoFCN8&sensor=false">
	</script>
<script src="js/gmap.js"></script>
<script src="js/validation.js"></script>

</head>

<body>
	<!-- header start -->

	<header id="nav">
		<div class="navbar navbar_">
			<div class="container">
				<div style="float: left; margin-top: 20px; margin-left: 50px">
					<b style="color: #FFF; font-size: 40px; font-family: Cooper Black;">College
						of XYZ</b>
				</div>
				<div>
					<div class="nav-collapse nav-collapse_  collapse">
						<ul class="nav sf-menu">
							<li class="active" id="act"><a href="#" id="home"
								style="color: #FFF">Home</a></li>
							<li id="evt"><a href="#evnt" id="evt" style="color: #FFF">&nbsp;Events</a></li>
							<li id="login"><a style="text-align: left;">Login</a>

								<div id="login-form">
									<form class="form-horizontal" action="user.html">
										<div class="control-group">
											<label class="control-label" style="color: #FFF"
												for="inputUname">Username :</label>
											<div class="controls">
												<input type="text" id="inputUname" placeholder="Username">
												<div id="emptyUname" class="bubble">
													<span style="color: #FFF;"> *This field is required.</span>
												</div>
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="inputPassword"
												style="color: #FFF">Password :</label>
											<div class="controls">
												<input type="password" id="inputPassword"
													placeholder="Password">
												<div id="emptyPwd" class="bubble">
													<span style="color: #FFF">*This field is required.</span>
												</div>
												<div id="PwdLen" class="bubble">
													<span style="color: #FFF">*Password Must be > 5
														Character long.</span>
												</div>
											</div>
										</div>
										<div class="control-group" style="margin-left: 40px;">
											<!-- div class="controls">
                                            <label class="checkbox" style="color:#FFF;margin-left:13px;">
													<input type="checkbox" >Keep me logged in
                                           
									    	 </label>
								    		</div -->

											<button type="submit" class="btn"
												class="btn btn-info tm_style_4"
												style="color: #F25C27; margin-left: 60px;" id="signin">Sign
												in</button>

											<!-- span id="fgtpwd" style="color:#FFF;margin-left:20px;"><u>Forgot your password?</u></span -->
										</div>
									</form>
								</div></li>

							<li id="signup"><a style="text-align: left">Sign Up</a>

								<div id="signup-form">
									<form class="form-horizontal">
										<div class="control-group">
											<label class="control-label" style="color: #FFF"
												for="inputFname">First Name :</label>
											<div class="controls">
												<input type="text" id="inputFname" placeholder="First Name">
												<div class="bubble" id="emptyFname">
													<span style="color: #FFF">*This field is required.</span>
												</div>
												<div id="CapsFname" class="bubble">
													<span style="color: #FFF">*First Letter Must be in
														Capital.</span>
												</div>
												<div id="NaNFname" class="bubble">
													<span style="color: #FFF">*Nubers Not Allowed.</span>
												</div>
											</div>
										</div>

										<div class="control-group">
											<label class="control-label" style="color: #FFF"
												for="inputLname">Last Name :</label>
											<div class="controls">
												<input type="text" id="inputLname" placeholder="Last Name">
												<div id="emptyLname" class="bubble">
													<span style="color: #FFF">*This field is required.</span>
												</div>
												<div class="bubble" id="NaNLname">
													<span style="color: #FFF">*Nubers Not Allowed.</span>
												</div>
											</div>
										</div>

										<div class="control-group">
											<label class="control-label" style="color: #FFF"
												for="inputGender">Gender :</label>
											<div class="controls">
												<label class="radio"
													style="display: inline-block; color: #FFF"> <input
													type="radio" name="gender" id="Male" value="Male" checked>
													Male
												</label> <label class="radio"
													style="display: inline-block; color: #FFF"> <input
													type="radio" name="gender" id="Female" value="Female">
													Female
												</label>
											</div>
										</div>

										<div class="control-group">
											<label class="control-label" style="color: #FFF"
												for="inputDob">DOB :</label>
											<div class="controls">
												<select name="demo" id="demo" class="changes">
													<option value="date" selected>Date</option>
												</select> <input type="text" id="inputDob" style="cursor: pointer;"
													placeholder="Date Of Birth">
												<div id="emptyDob" class="bubble">
													<span style="color: #FFF">*This field is required.</span>
												</div>
											</div>
										</div>

										<div class="control-group">
											<label class="control-label" style="color: #FFF"
												for="inputEmail">Email ID :</label>
											<div class="controls">
												<input type="text" id="inputEmail" placeholder="Email Id">
												<div id="emptyEmail" class="bubble">
													<span style="color: #FFF">*This field is required.</span>
												</div>
												<div id="InvalidEmail" class="bubble">
													<span style="color: #FFF">*Email Id Is not Valid.</span>
												</div>
											</div>
										</div>

										<div class="control-group">
											<label class="control-label" style="color: #FFF"
												for="inputPassyr">Passout Year :</label>
											<div class="controls">
												<select style="width: 195px;" id="inputPassyr">
													<option selected>-select-</option>
													<option>June 2010</option>
													<option>June 2011</option>
													<option>July 2012</option>
													<option>June 2013</option>
													<option>July 2014</option>
												</select> <br>
												<div class="bubble" id="emptyPassyr">
													<span style="color: #FFF">*This field is required.</span>
												</div>
											</div>
										</div>

										<div class="control-group">
											<label class="control-label" style="color: #FFF"
												for="inputBranch">Branch :</label>
											<div class="controls">
												<select style="width: 195px;" id="selectBranch">
													<option selected>-select-</option>
													<option>I.T.</option>
													<option>Computer</option>
													<option>E.C.</option>
													<option>Auto.</option>
													<option>Mech.</option>
												</select>
											</div>
											<div class="bubble" style="margin-left: 120px;"
												id="emptyBrach">
												<span style="color: #FFF">*Select Branch.</span>
											</div>
										</div>

										<div class="control-group">
											<label class="control-label" style="color: #FFF"
												for="inputEnrno">Enrollment Id :</label>
											<div class="controls">
												<input type="text" id="inputEnrno"
													placeholder="Enrollment Id">
												<div id="emptyEnrno" class="bubble">
													<span style="color: #FFF">*This field is required.</span>
												</div>
											</div>
										</div>

										<!-- Password box --->
										<!-- <div class="control-group">
											<label class="control-label" for="inputPassword" style="color:#FFF">Password :</label>
								    			<div class="controls">
									    			<input type="password" id="inputPassword" placeholder="Password">
								    			</div>
							    		</div> -->

										<div class="control-group">
											<div class="controls">
												<button type="submit" class="btn" id="signup_btn"
													style="color: #F25C27">Sign Up</button>

											</div>
										</div>
									</form>
								</div></li>
							<li id="cact"><a href="#" id="cnct" style="color: #FFF">&nbsp;Contact</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- header end -->

	<!-- conaint start-->
	<!-- Home Containt Start -->
	<div id="con">
		<div class="bg-content">
			<div class="container">
				<div class="row">
					<div class="span12">
						<!-- slider -->
						<div class="flexslider" id="newcon">
							<ul class="slides">
								<li><img src="img/pic1.png" alt=""></li>
								<li><img src="img/pic2.png" alt=""></li>
								<li><img src="img/pic7.png" alt=""></li>
								<li><img src="img/pic4.png" alt=""></li>
								<li><img src="img/pic5.png" alt=""></li>
							</ul>
						</div>
						<span id="responsiveFlag"></span>
						<div class="block-slogan">
							<h2 style="font-family: Brush Script Std;">College of XYZ</h2>
							<div>
								<p>XYZ Collage is a vibrant community of scholarship and
									learning that stands in the nation's service and in the service
									of all nations.</p>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- content -->

			<div id="content" class="content-extra">
				<div class="ic"></div>
				<div class="row-1" id="evnt">
					<div class="container">
						<div class="row">
							<article class="span12">
								<h4>Events</h4>
							</article>
							<div class="clear"></div>
							<ul class="portfolio clearfix">
								<li class="box"><a href="img/image-blank.png"
									class="magnifier"><img alt="" width="270px" height="290px"
										src="Gallery/img/Album/Annual function/3.jpg"></a></li>
								<li class="box"><a href="img/image-blank.png"
									class="magnifier"><img alt="" width="270px" height="290px"
										src="Gallery/img/work/img1.jpg"></a></li>
								<li class="box"><a href="img/image-blank.png"
									class="magnifier"><img alt="" width="270px" height="290px"
										src="Gallery/img/work/img2.jpg"></a></li>
								<li class="box"><a href="img/image-blank.png"
									class="magnifier"><img alt="" width="270px" height="290px"
										src="Gallery/img/work/img4.jpg"></a></li>
								<li class="box"><a href="img/image-blank.png"
									class="magnifier"><img alt="" width="270px" height="290px"
										src="Gallery/img/work/img5.png"></a></li>
								<li class="box"><a href="img/image-blank.png"
									class="magnifier"><img alt="" width="270px" height="290px"
										src="Gallery/img/work/img6.jpg"></a></li>
								<li class="box"><a href="img/image-blank.png"
									class="magnifier"><img alt="" width="270px" height="290px"
										src="Gallery/img/work/img5.jpg"></a></li>
								<li class="box"><a href="img/image-blank.png"
									class="magnifier"><img alt="" width="270px" height="290px"
										src="../../../../../images/385347_470169549710301_1741801415_n.jpg"></a></li>
							</ul>
						</div>
					</div>
				</div>

				<div class="container">
					<div class="row">
						<article class="span6">
							<h3>Shortly about us</h3>
							<div class="wrapper">
								<figure class="img-indent" style="float: left">
									<img width="400px" height="200px" src="img/alumni.png" alt="" />
								</figure>
						</article>
						<article class="span6">
							<div class="wrapper">
								<h3>&nbsp;</h3>
								<div class="inner-1 overflow extra"
									style="width: 100%; float: left;">
									<div class="txt-1">An alumni association is an
										association of graduates or, more broadly, of former students
										(alumni).</div>
									These associations often organise social events, publish
									newsletters or magazines, and raise funds for the organisation.
								</div>
							</div>
					</div>

					</article>
					<!-- <article class="span6">
              				<h3>Some quick links</h3>
                			<div class="wrapper">
                    			<ul class="list list-pad">
                          			<li><a href="#">Campaigns</a></li>
                         			<li><a href="#">Portraits</a></li>
                          			<li><a href="#">Fashion</a></li>
                          			<li><a href="#">Fine Art</a></li>
                        		</ul>
                    			<ul class="list list-pad">
                          			<li><a href="#">Campaigns</a></li>
                          			<li><a href="#">Portraits</a></li>
                          			<li><a href="#">Fashion</a></li>
                          			<li><a href="#">Fine Art</a></li>
                        		</ul>
                    			<ul class="list list-pad">
                          			<li><a href="#">Campaigns</a></li>
                          			<li><a href="#">Portraits</a></li>
                          			<li><a href="#">Fashion</a></li>
                          			<li><a href="#">Fine Art</a></li>
                        		</ul>
                    			<ul class="list">
                          			<li><a href="#">Advertising</a></li>
                          			<li><a href="#">Lifestyle</a></li>
                          			<li><a href="#">Love story</a></li>
                          			<li><a href="#">Landscapes</a></li>
                    			</ul>
                			</div>
            	</article> -->
				</div>
			</div>

		</div>
	</div>
	</div>
	<!-- Home Containt End -->

	<!-- Contect Us Start -->
	<div id="cntus">
		<div class="bg-content">
			<!-- content -->
			<div id="content">
				<div class="ic"></div>
				<div class="container">
					<div class="row" id="newcon1">
						<article class="span8">
							<h3>Contact us</h3>
							<div class="inner-1">
								<form id="contact-form">
									<div class="success">
										Your message has been sent succesfuly!<strong> We
											will be in touch soon.</strong>
									</div>
									<fieldset>
										<div>
											<label class="name"> <input type="text"
												value="Your name"> <br> <span class="error">*This
													is not a valid name.</span> <span class="empty">*This field
													is required.</span>
											</label>
										</div>
										<div>
											<label class="phone"> <input type="tel"
												value="Telephone"> <br> <span class="error">*This
													is not a valid phone number.</span> <span class="empty">*This
													field is required.</span>
											</label>
										</div>
										<div>
											<label class="email"> <input type="email"
												value="Email"> <br> <span class="error">*This
													is not a valid email address.</span> <span class="empty">*This
													field is required.</span>
											</label>
										</div>
										<div>
											<label class="message"> <textarea>Message</textarea>
												<br> <span class="error">*The message is too
													short.</span> <span class="empty">*This field is required.</span>
											</label>
										</div>
										<div class="buttons-wrapper">
											<a class="btn btn-1" data-type="reset">Clear</a> <a
												class="btn btn-1" data-type="submit">Send</a>
										</div>
									</fieldset>
								</form>
							</div>
						</article>
						<article class="span4">
							<h3>Contact info</h3>

							<div id="googleMap" style="width: 350px; height: 250px;"></div>
							<!-- div style="width:350px;height:250px;">
                <img src="img/gmap.png" style="width:350px;height:250px;" />
                </div -->


							<!-- address class="address-1">
          <strong>Inbetwin Networks,<br>
              Paud Phata, Road,<br>
              Kothrud, Pune-38.</strong>
          <div class="overflow"> <span>Mobile:</span>+91 12345 67890<br>
                <span>Telephone:</span>+91 12345 67890<br>
                <span>FAX:</span>+91 12345 67890 <br>
                <span>E-mail:</span> <a href="#" class="mail-1">you@domain.com</a><br>
                <span>Skype:</span> <a href="#" class="mail-1">@woohooo</a></div>
          </address -->
						</article>
					</div>
				</div>
			</div>
		</div>


	</div>
	<!-- Contect Us End -->

	<!-- footer -->
	<footer>
		<div class="container clearfix">
			<ul class="list-social pull-right">
				<li><a class="icon-1" href="#"></a></li>
				<li><a class="icon-2" href="#"></a></li>
				<li><a class="icon-3" href="#"></a></li>
				<li><a class="icon-4" href="#"></a></li>
			</ul>
			<div class="privacy pull-left">
				&copy; 2013 | <a href="#">Alumni Association</a>
			</div>
	</footer>

</body>
</html>