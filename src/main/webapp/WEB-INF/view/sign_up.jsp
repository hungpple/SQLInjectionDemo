<%@ include file="fragments/header.jspf"%>
<%@ include file="fragments/navigator.jspf"%>
<h1 id="article" align="center">Create Account</h1>
<br/>
<section id="center">
	<form:form action="signup" method="post" modelAttribute="user">
	 <fieldset>
		<legend>Account Detail:</legend>
		<label for="username">Account Name:</label>
		<form:input type="text" id="username" name="username" path="userName"/><br><br>
		<label for="password">Password:</label>
		<form:input type="password" id="password" name="password" path="password"/><br><br>
<%-- 		<% 
		    //Remove '@' 
		    if(null!=request.getAttribute("errorMessage"))
			{
			    System.out.println(request.getAttribute("errorMessage"));
			}
		%>
		 --%>
	 	<input type="submit" value="Save"/>
		</fieldset>
	</form:form> 
<%-- 			<% 
		    //Remove '@' 
		    String error = (String)request.getAttribute("errorMessage");
		    if ((String)session.getAttribute("errorMessage") != null) 
		    { 
		%>
		<p style="color:red;">User: <%out.println(error);}%></p> --%>
</section>
<%@ include file="fragments/footer.jspf"%>