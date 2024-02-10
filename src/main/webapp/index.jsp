<%
     if(session.getAttribute("name") == null){
    	 response.sendRedirect("login.jsp");    //implicit objects
     }

%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
</head>
<body>

Welcome
<input style=" border: 2px solid #3498db;
                    border-radius: 5px;  font-size: 16px;"
                               type = "text" id = "Status" value = "<%=session.getAttribute("name")%>"  readonly>
<a href = "logout"><button href = "logout">Logout</button></a>

<a href = "teacherform.jsp"><button href = "logout">Enter announcement</button></a>



</body>
</html>


