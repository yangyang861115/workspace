<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>first JSP</title>
</head>
<body>
	<h3>Test JSP</h3>
	<%!
	//method
	public int add(int a, int b){
		return a+b;
	}
	
	%>
	
	<%
	int i = 1;
	int j = 2;
	int k = add(i, j);
	//out.println(k);
	
	%>
	The value of k is: <%=k %>
	<% for(i = 0; i < 5; i++){%>
		<br>i = <%=i %>
	<% } %>
</body>
</html>