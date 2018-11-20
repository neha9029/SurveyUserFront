<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Profile</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	</head>
	<body>
	<c:set var="userProfile" value="${userDetails}">
	</c:set>
	<c:set var = "userName" value="${userProfile.firstName}"/>
		     <c:url var = "surveyLink" value="${pageContext.request.contextPath}/survey">
					 	<c:param name="userId" value="${userProfile.userId}"/>
			</c:url>
			<c:url var = "profileLink" value="${pageContext.request.contextPath}/profile">
					 	<c:param name="userId" value="${userProfile.userId}"/>
			</c:url>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
           <h3 class="navbar-brand">Hi ${userName}</h3>
            
            <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link" href="${surveyLink}">Survey</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="${profileLink}">Profile</a>
                </li>
                 <li class="nav-item">
                  <a class="nav-link" href="${pageContext.request.contextPath}/login">Log Out</a>
                </li>
             
          
              </ul>	
    </nav>	    
		<div id="container">
		</div>
	</body>
</html>