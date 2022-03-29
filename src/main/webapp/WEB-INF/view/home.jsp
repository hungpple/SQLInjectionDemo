<%@ include file="fragments/header.jspf"%>
<%@ include file="fragments/navigator.jspf"%>
<h1 id="article" align="center">HOME:</h1>
<section id="center">
	
		<br/>
		<h2>Welcome to my SQLInjection Demo</h2>
		<p>This is a web application to manage student records.</p>
		<img src="/resources/images/sqlinjection.gif" alt="nntpsimpson" id="imgsimpson"/>
		<p>But sadly this web is vulnerable to SQL Injection!!!</p>
		<p>To exploit this web app, try the following example commands into any input text box on the web:</p>
		<div class="command">
		<ul>
		  <li>' or ''='</li>
		  <li>105' OR '1'='1</li>
		  <li>'; DROP TABLE student; -- </li>
		</ul> 
		</div>
		<p><em>Click<a href="/student_list">here</a>to start the Demo</em></p>


</section>
<%@ include file="fragments/footer.jspf"%>