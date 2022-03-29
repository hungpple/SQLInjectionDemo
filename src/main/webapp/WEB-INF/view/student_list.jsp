<%@ include file="fragments/header.jspf"%>
<%@ include file="fragments/navigator.jspf"%>
<h1 id="article" align="center">Student List</h1>
<br/>
<section id="center">
	
		<form:form method="get" action="search" style ='display:inline-block;'>
			<p>Search student
		 		<input type="text" id="id" name="id" placeholder="Student ID">
				<button type="submit" id="submit" style="color:'black'">Search</button>
			</p>
		</form:form> 
	
		 <table  border="1" cellpadding="10">
		     <tr>
		         <th>ID</th><th>Name</th><th>Email</th><th>Address</th><th>Class</th><th>Action</th>
		     </tr>
		     <c:forEach var="student" items="${studentList}">
		     <tr>
				<td>${student.id}</td>
				<td>${student.name}</td>
				<td>${student.email}</td>
				<td>${student.address}</td>
				<td>${student.enrolledclass}</td> 
				<td><a type="button" class="btn" href="/update_student?id=${student.id}">Update</a>
					<a type="button" class="btn"href="/delete?id=${student.id}">Delete</a>
				</td>
		     </tr>    
		     </c:forEach>
		 </table>
	
 </section>
<%@ include file="fragments/footer.jspf"%>
 