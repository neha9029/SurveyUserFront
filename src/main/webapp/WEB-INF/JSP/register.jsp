<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Register</title>
<link rel="stylesheet" type="text/css"
	href="/css/register.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<div id="wholeContainer" class="mainContent">
	<div id="container">
		<div id="header" class="blockElement">
			<h2 id="headerTitle">
				Registration <a id="loginURL"
					href="${pageContext.request.contextPath}/login">Login?</a>
			</h2>

		</div>
		<!--<form action="profile/profilePage" method="GET"> -->
		<form:form class="blockElement" action="register"
			modelAttribute="registerDetails" method="POST">
			<div id="entireForm">
				<div id="formElements">

					<label class="textLabel" for="firstname">
					First name: <form:errors path="firstName" cssClass="error" /></label>
					<!-- path -> MVC calls registerDetails.setFirstName -->
					<form:input class="textfield" id="firstname" path="firstName" />
					<br /> 
					<label class="textLabel" for="lastname">
					Last name:<form:errors path="lastName" cssClass="error" />
					</label>
					<form:input class="textfield" id="lastname" path="lastName" />
					<br /> 
					<label class="textLabel" for="email">
					Email: <form:errors path="email" cssClass="error" /></label>
					<form:input class="textfield" id="email" path="email" />
					
					<br />
					<label class="textLabel" for="password">
					Password: <form:errors path="password" cssClass="error" />
					</label>
					<form:password class="textfield" id="password" path="password" />
					<br />
					<label class="textLabel" for="comfirmPassword">
					Confirm Password: <form:errors path="confirmPassword" cssClass="error" />
					</label>
					<form:password class="textfield" id="confirmpassword" path="confirmPassword" />
					<br />

					<div id="accountTypeDropdown">
						<label class="textLabel" for="accountType">Select account type:</label>
						<form:select id="accountType" path="accountType">
							<form:option value="HandyMan" label="HandyMan" />
							<form:option value="Cleaner" label="Cleaner" />
						</form:select>
					</div>
				
					<div id="terms">
						<label>
							<ul id="termsCheckbox">
								<li><form:checkbox path="terms" value="checked" /></li>
								
								<li>
									<p>I agree to the terms and condition</p>
								</li>
								
								<li>
								   <p><form:errors path="terms" cssClass="error" /></p>
								
								</li>								
							</ul>
						</label>
					</div>
					<div class="btn-container">
						<input class="btn-submit" type="submit" name="Register"
							value="Register" />
					</div>
				</div>


			</div>
		</form:form>
		
	</div>
</div>
<div class="mainContent">

<%-- <jsp:include page="/WEB-INF/JSP/footer.jsp" /> --%>
</div>

</body>
</html>