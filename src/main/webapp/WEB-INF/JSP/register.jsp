<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Register</title>
 <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/static/register.css"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<div id="wholeContainer">
		<div id="container">
			<div id="header">
				<h2 id="headerTitle">
					Registration 
					<!-- <a id="loginURL"
						href="${pageContext.request.contextPath}/loginForm">Login?</a> 	-->		
						
				</h2>

			</div>

			<form:form action="processRegisterForm"
				modelAttribute="registerDetails" method="POST">
				<div id="entireForm">
					<div id="formElements">

						<label class="textLabel" for="firstname">First name:</label>
						<!-- path -> MVC calls registerDetails.setFirstName -->
						<form:input class="textfield" id="firstname" path="firstName" />
						<br /> <label class="textLabel" for="lastname">Last name:</label>
						<form:input class="textfield" id="lastname" path="lastName" />
						<br /> <label class="textLabel" for="email">Email:</label>
						<form:input class="textfield" id="email" path="email" />
						<br />
						<form:errors path="email" cssClass="error" />
						<label class="textLabel" for="password">Password:</label>
						<form:errors path="password" cssClass="error" />
						<form:password class="textfield" id="password" path="password" />
						<br />


						<div id="typeAccountRadio">
							<label class="textLabel" id="accountType" for="typeOfAccount">Type
								of Account:</label>
							<ul id="account">
								<li><label>
										<ul class="para-radio">
											<li><form:radiobutton id="typeOfAccount" path="HandyMan"
													value="jobSeeker" /></li>
											<li class="para"><p>Handy Man</p></li>
										</ul>
								</label></li>
								<li><label>
										<ul class="para-radio">
											<li><form:radiobutton path="userType" value="Cleaner" />
											</li>
											<li class="para"><p>Cleaner</p></li>
										</ul>
								</label></li>
							</ul>
						</div>
					
					</div>
					<div class="btn-container">
						<input class="btn-submit" type="submit" name="submit" />
					</div>
				</div>
			</form:form>
				
		</div>
	</div>
</body>
</html>