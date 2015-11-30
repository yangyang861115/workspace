<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel ="stylesheet" type="text/css" href="css/display.css">
<script src="library/underscore/underscore.js"></script>
<script src="library/jquery/dist/jquery.js"></script>
<script type='text/javascript' src='js/content.js'></script>
<script type='text/javascript' src='js/display.js'></script>
<title>Insert title here</title>
</head>
<body>
<%
	
	
	String content1 ="";
	  
	if(request.getParameter("content1")!=null)
	{
	  
		content1 = request.getParameter("content1");
	  
	};
	String content2 ="";
	  
	if(request.getParameter("content2")!=null)
	{
	  
		content2 = request.getParameter("content2");
	  
	};
	String content3 ="";
	  
	if(request.getParameter("content3")!=null)
	{
	  
		content3 = request.getParameter("content3");
	  
	};
	
	
	
	
	
	
	%>

<form method="post" action="ProcessServlet" >
	<div id="container">
		<div class="file">
			<h2>Please specify an input file: </h2>
			<input type="file" id="fileInput1" name="datafile"   size="60">
		</div>
		<div class="file">
			<h2>Please specify a criteria: </h2>
			<input type="file" id="fileInput2" name="criteria"   size="60">
		</div>
		<div class="file">
			<h2>Languages criteria:</h2>
			<input type="text"  id="language" name="language" >
		</div>		
	</div>	
		
	<br>
	<div id="display">
		<textarea id="fileDisplayArea1" name="content1" ><%=content1 %></textarea>
		<textarea id="fileDisplayArea2" name="content2" ><%=content2 %></textarea>
		<textarea id="fileDisplayArea3" name="content3" ><%=content3 %></textarea>
	</div>
	<br>
	
	<div><input type="submit" id="btn" ></div>
</form>	
	
	<div id="result">
	<%="result" %> 
	<%=request.getAttribute("re") %>
	
	
	

	
</body>
</html>