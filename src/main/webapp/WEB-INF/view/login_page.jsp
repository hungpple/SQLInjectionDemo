<%@ include file="fragments/header.jspf"%>
<%@ include file="fragments/navigator.jspf"%>
<h1 id="article" align="center">Sign In</h1>
<br/>
<section id="center">
		<form:form method="get" action="login" style ='display:inline-block;' modelAttribute="user">
			<p>User name:
		 		<form:input type="text" id="username" name="username" placeholder="User name" path="userName"/>
			</p>
			<p>Password:&nbsp;
		 		<form:input type="password" id="password" name="password" placeholder="Password" path="password"/>
			</p>
			<button type="submit" id="submit" style="color:'black'">Log in</button>
		</form:form>
</section>
<%@ include file="fragments/footer.jspf"%>