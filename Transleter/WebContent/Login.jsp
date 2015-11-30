<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Library</title>
</head>
<body>

<form method="post" action="LibraryServlet">
	<h2>Select a library from below: </h2><br>
	<select name="library"  >
		<option value="lib1">lib1</option>
		<option value="lib2">lib2</option>
		<option value="lib3">lib3</option>
		<option value="lib4">lib4</option>
		<option value="others">otherLib</option>
	</select>
	<input type="submit">
</form>


</body>
</html>