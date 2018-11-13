<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<link rel="stylesheet" type="text/css" href="/css/login.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<div id="wholeContainer">
		<div id="container">
		<div id="header" class="blockElement">
			<h2 id="headerTitle">Login
				<a id="registerURL" href="${pageContext.request.contextPath}/register">Register?</a>
			
			</h2>
			
		 </div>
		 <div>
		  <c:if test="${param.error != null}" >
		   Invalid Password 
		  </c:if>
		  
		 </div>
	 	<!--<form action="profile/profilePage" method="GET"> -->
			<form:form class="blockElement" action="login" modelAttribute="loginDetails" method="POST">		
				<div id="entireForm">
					<div id="formElements">
						<label class="textLabel" for="email">
						Email: <form:errors path="email" cssClass="error"/>
						</label>
						<form:input class="textfield" id="email" path="email"/><br/>
						<label class="textLabel" for="password">
						Password: <form:errors path="password" cssClass="error"/>
						</label>
						<form:password class="textfield" id="password" path="password"/><br/>
					
					</div>
				</div>
					<div class="btn-container">
					<input class="btn-submit" type="submit" name="submit" />
					</div>
			</form:form> 
		</div> 
 	</div>
 </body>
 </html>