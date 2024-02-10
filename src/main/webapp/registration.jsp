<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<head>
<title>SignIn</title>
<style><%@include file="/WEB-INF/css/StylesSignUp.css"%></style>
</head>

<body>

<input style="position: absolute; top: 0; left: 0; padding: 10px; border: 2px solid #3498db;
                    border-radius: 5px; background-color: #0000ff; color: #ffA500; font-size: 16px;"
                               type = "text" id = "Status" value = "<%=request.getAttribute("Status")%>"  readonly>

     <div class = "formclass">
    	<form action = "RegistrationServlet" method = "post" >
        	<h1>Sign Up</h1>
        	<div class  = "input-box">
        		<input type = "text" placeholder = "UserName" required name = "name" id = "user" >
        		<i class='bx bxs-user-circle'></i>
        	</div>	 
        	<div class = "input-box">
        		<input type = "password" required placeholder = "Password" name = "pass" id = "passwords"> 
        	</div>
        	 <div class = "input-box">
        		<input type = "email" required placeholder = "Email" name = "email" id = "email"> 
        	</div> 
        	 <div class = "input-box">
        		<input type = "tel" required placeholder = "PhoneNumber" name = "contact" id = "phone"> 
        	</div>
        	
        	<div class = "remember-state">
			    <span id = "Male">Teacher</span>&nbsp;<input type = "radio" name = "post" id = "PTeacher" value = "Teacher" checked>&nbsp;&nbsp;&nbsp;&nbsp;
			    <span id = "Female">Student</span>&nbsp;<input type = "radio" name = "post" id = "PStudentr"value = "Student">
        	</div>
        	
        	<button type = "submit" class = "sign-in">Register</button>
        	
        	<div class = "Log_now">
        		<p>Already have an account<a href = "index.jsp">Log Now</a></p>
        	</div>	
        	

        </form>
  	</div>
  	

</body>
</html>