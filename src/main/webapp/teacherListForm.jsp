<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    <!--Import JSTL tags-->
<html>
<head>
<title>Announcements Management</title>
<style><%@include file="/WEB-INF/css/teachlist.css"%></style>

</head>
<body>

	<br>
	
	  Welcome
			<input style=" border: 2px solid #3498db; border-radius: 5px;  font-size: 16px;" type = "text" id = "Status" value = "<%=session.getAttribute("name")%>"  readonly>
			<a href = "logout"><button href = "logout">Logout</button></a>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div>
			<h3>Announcement List</h3>
		
			<div>

				
				<a href="<%=request.getContextPath()%>/new" ><input type ="submit" id = "add" value= "Add New Announcement"></a>
			</div>
			<br>
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>Teacher's Name</th>
						<th>Grade</th>
						<th>Date</th>
						<th>Subject</th>
						<th>Announcement</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach var="ann" items="${listAnnouncement}">

						<tr>
							<td><c:out value="${ann.id}" /></td>
							<td><c:out value="${ann.name}" /></td>
							<td><c:out value="${ann.grade}" /></td>
							<td><c:out value="${ann.date}" /></td>
							<td><c:out value="${ann.subject}" /></td>
							<td><c:out value="${ann.announce}" /></td>
							<td><a href="edit?id=<c:out value='${ann.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${ann.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>