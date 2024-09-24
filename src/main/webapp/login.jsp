<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Page</h1>
	<a href="index.jsp">Return to Home</a>
	
	<form action="login" method="post">
	<input type="email" name="login_email" placeholder="Enter email here : "> 
	<input type="password" name="password" placeholder="Enter password here : ">
	<button>LOGIN</button>
	
	<h1>${login}</h1>
	</form>
	
	
	
	
	
</body>
</html>