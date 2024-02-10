<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In</title>
<style><%@include file="/WEB-INF/css/StylesLogin.css"%></style>
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
<input style="position: absolute; top: 0; left: 0; padding: 10px; border: 2px solid #3498db;
                    border-radius: 5px; background-color: #0000ff; color: #ffA500; font-size: 16px;"
                              type = "text" id = "Status" value = "<%=request.getAttribute("Status")%>" readonly>
     <div class = "formclass">
    	<form action = "Login" method = "post" >
        	<h1>Login</h1>
        	<div class  = "input-box">
        		<input type = "text" placeholder = "UserName" name = "username" id = "user"required>
        		<i class='bx bxs-user-circle'></i>
        	</div>	

        	<div class = "input-box">
        		<input type = "password" required name = "password" placeholder = "Password"> 
        		<i class='bx bxs-lock'></i>
        	</div>  
        	<div class = "remember-pw">
        		<label><input type = checkbox>Remember me</label>
        		<a href = "#">Forgot password</a>
        	</div>
        	
        	<button type = "submit" class = "log-in">Login</button>
        	
        	<div class = "register-now">
        		<p>Don't have an account<a href = "registration.jsp">Register Now</a></p>
        	</div>	
        	

        </form>
  	</div>
  	

	
</body>
</html>