<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Amazon project">
<meta name="author" content="Zhenghao Gu">
<link rel="stylesheet" href="css/bootstrap.min.css" >
<link rel ="stylesheet" type="text/css" href="css/display.css">
<script src="library/underscore/underscore.js"></script>
<script src="library/jquery/dist/jquery.js"></script>
<script type='text/javascript' src='js/content.js'></script>

<title>Page 2</title>
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

<div class="container-fluid">
     <div class="header clearfix">
        <nav>
          <ul class="nav nav-pills pull-right">
            <li role="presentation" class="active"><a href="#">Home</a></li>
            <li role="presentation"><a href="#">About</a></li>
            <li role="presentation"><a href="#">Contact</a></li>
          </ul>
        </nav>
        <h3 class="text-muted">Project name</h3>
      </div>
</div>




<div class="files">
	   <div class="container-fluid">
		<form method="post" action="ProcessServlet" >
			<div class="row">
		      <div class="col-md-4 file">
		      	<h2>Please specify an input file: </h2>
				<input class="form-group" type="file" id="fileInput1" name="datafile"   size="60"> 
		      </div>
		  	  <div class="col-md-4 file">
		  	  	<h2>Please specify a criteria: </h2>
				<input class="form-group" type="file" id="fileInput2" name="criteria"   size="60"> 
		      </div>
		      <div class="col-md-4 file">
		      	<h2>Languages criteria:</h2>
				<input class="form-control input-sm" type="text" id="language" name="language" placeholder="en">
		      </div>
		    </div>
		    
		    
		    <div class="row" id="display">
		      <div class="col-md-4">
		      	<textarea class="form-control" id="fileDisplayArea1" name="content1" rows="8"><%=content1 %></textarea>
		      </div>
		      <div class="col-md-4">
		      	<textarea class="form-control" id="fileDisplayArea2" name="content2" rows="8"><%=content2 %></textarea>
		      </div>
		      <div class="col-md-4">
		      	<textarea class="form-control" id="fileDisplayArea3" name="content3" rows="8"><%=content3 %></textarea>
		      </div>
		    </div>
	    
		    <div class="row b">
		    	<div class="col-md-2">
		    		<input type="submit" class="btn btn-lg btn-success" id="btn" >
		    	</div>
		    </div>
	    </form>	
	    </div>
</div>

<div class="result">
	  <div class="container-fluid">
			<div class="row" id="result">
	      		<div class="col-md-12">
	          		
		      		<%=request.getAttribute("re") %>
	      		</div>
	    	</div>
	  </div>
</div>

</body>
</html>