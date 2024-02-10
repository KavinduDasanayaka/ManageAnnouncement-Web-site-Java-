<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Announce Application</title>

<style><%@include file="/WEB-INF/css/teachform.css"%></style>
	<script>

		function enableButton(){
			if(document.getElementById("checkbox").checked){
	
    			document.getElementById("submit").disabled=false;
			}
			else{
    			document.getElementById("submit").disabled=true;
			}
		}
	</script>
	
</head>
<body >
	

        <header>
		<nav>
			
			
			<ul>
				<li><a href="<%=request.getContextPath()%>/list"><input type = "Submit" id = "snl" value= "Announcements"></a></li>
			</ul>
		</nav>
	</header>
	

	
	<br>
				<c:if test="${Announce != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${Announce == null}">
					<form action="insert" method="post">
				</c:if>
				
				<div class = "Main">	
	            <div class = "PForm">
				
				
					<h3>
						<c:if test="${Announce != null}">
            			Edit User
            		</c:if>
						<c:if test="${Announce == null}">
            			Add New Announcement
            		</c:if>
					</h3>
				
				
				
               <form id = "announce">
				<c:if test="${Announce != null}">
					<input type="hidden" name="id" value="<c:out value='${Announce.id}'/>" id = "id">
				</c:if>

				    <br>
					<label>Teacher Name :</label><br><br><input type="text"
						value="<c:out value='${Announce.name}' />"
						name="name" required="required" id = "name"><br><br>
				
				
					<label>Enter Grade and Class (1A - 13C) :</label> <br><br><input type="text"
						value="<c:out value='${Announce.grade}' />"
						name="grade" pattern="([1-9]|1[0-3])[ABC]" id = "grade"><br><br>
				
				
					<label>Enter a Date (YYYY-MM-DD) :</label><br><br> <input type="date"
						value="<c:out value='${Announce.date}'/>" 
						name="date" pattern="\d{4}-\d{2}-\d{2}" required id = "date"><br><br>
				
				
					<label>Subject :</label><br><br> <input type="text"
						value="<c:out value='${Announce.subject}' />"
						name="subject" id = "subject"><br><br>
				
					<label>Announcement :</label> <br><br><input type="text"
						value="<c:out value='${Announce.announce}' />" 
						name="announce" id = "ann"><br><br>
				
				
				
				<label>confirm this announcement:</label>
		       <input type="checkbox" id="checkbox" onclick = "enableButton()" ><br><br>  
		        

				<input type="submit" id = "submit" value= "Save">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				    
				<input type = "reset" id = "reset">
				</form>
				</div>
				</div>
			
</body>


</html>