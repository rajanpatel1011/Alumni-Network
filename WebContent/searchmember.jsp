<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="com.alumni.beans.SearchMembersBEAN" %>
<%@page import="java.util.List" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
#searchmem{
background-color: #F25C27;
color: #FFF;
};
#myprofile,#forum,#gallery,#privmsg,#makeapp,#reportuser,#mod_req,#user_req{
background-color: #F5F1E5;
color: #000;
}
</style>

 <link href="css/searchmem.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="header.jsp" />
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	$('#btnShowAll').click(function() {
		optionHide();
		$(this).removeClass("btnoption");
	    $(this).addClass('activeoption');
	    $('#optionseleced').val("1");
	});
	$('#btnBatch').click(function() {
		optionHide();
		$(this).removeClass("btnoption");
	    $(this).addClass('activeoption');
	    $('#optionseleced').val("2");
	    
	});
	$('#btnYear').click(function() {
		optionHide();
		$(this).removeClass("btnoption");
	    $(this).addClass('activeoption');
	    $('#optionseleced').val("3");
	});
	$('#btnBranch').click(function() {
		optionHide();
		$(this).removeClass("btnoption");
	    $(this).addClass('activeoption');
	    $('#optionseleced').val("4");
	});
	
	
});
function optionHide(){
	$('#btnShowAll').removeClass("activeoption");
	$('#btnShowAll').addClass("btnoption");
	$('#btnBatch').removeClass("activeoption");
	$('#btnBatch').addClass("btnoption");
	$('#btnYear').removeClass("activeoption");
	$('#btnYear').addClass("btnoption");
	$('#btnBranch').removeClass("activeoption");
	$('#btnBranch').addClass("btnoption");
};

$(document).ready(function() {
	
	$('#searchTxtBox').on("keyup",function(){
		var txt = $('#searchTxtBox').val();
		var o = $('#optionseleced').val();
		$.post('SearchMembersSERVLET',{st:txt,optionseleced:o},function(responseText) {
			$('#Searchmems').html(responseText);
			//searchbean  
			$(".main").height("0px");
			var setHeight = $(".content").height();
			$(".main").height(setHeight);
			//alert(txt);
		});
		
	});
	$('#searchTxtBox').trigger("keyup");
	

	
	
});
</script>
	<div class="content">
		<div class="main" >
			<div class="option">
				<input type="button" id="btnShowAll" class="activeoption"  value="Show All"/>
				<input type="button" id="btnBatch" class="btnoption" value="Batch"/>
				<input type="button" id="btnYear" class="btnoption" value="Year"/>
				<input type="button" id="btnBranch" class="btnoption" value="Branch"/>
				<input type="hidden" name="optionseleced" id="optionseleced" value="1"/>
			</div>
			<div class="searchtext">
				<input type="text" class="searchtextbox" id="searchTxtBox" />
				<input type="button" class="searchbtn" id="searchbtn"  value="Search"/>
			</div>
			<div class="Searchmems" id="Searchmems">
				
			</div>
		</div>
	<jsp:include page="footer.jsp" />
</body>
</html>