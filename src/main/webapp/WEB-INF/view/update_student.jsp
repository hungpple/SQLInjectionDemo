<%@ include file="fragments/header.jspf"%>
<%@ include file="fragments/navigator.jspf"%>
<h1 id="article" align="center">Edit Student</h1>
<br/>
<section id="center">
	<form:form action="save" method="post" modelAttribute="student">
	 <fieldset>
	  <legend>Student Details:</legend>
	  <form:input type="hidden" id="id" name="id" path="id"/>
	  <label for="name">Full name:</label>
	  <form:input type="text" id="name" name="name" path="name"/><br><br>
	  <label for="email">Email:</label>
	  <form:input type="email" id="email" name="email" path="email"/><br><br>
	  <label for="address">Address:</label>
	  <form:input type="text" id="address" name="address" path="address"/><br><br>
  	  <label for="enrolledclass">Enrolled class:</label>
	  <form:input type="text" id="enrolledclass" name="enrolledclass" path="enrolledclass"/><br><br>
	  <input type="submit" value="Save"/>
	 </fieldset>
	</form:form> 
</section>
<%@ include file="fragments/footer.jspf"%>