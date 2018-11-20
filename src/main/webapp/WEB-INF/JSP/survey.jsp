<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Survey</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>

<link rel="stylesheet" type="text/css"
	href="/css/survey.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<jsp:include page="/WEB-INF/JSP/header.jsp" />
<div id = container>
<form:form class="form-horizontal" action="${pageContext.request.contextPath}/surveyPost" modelAttribute="surveyQuestions" method="POST">
<div class="form">
<div class="list-group">

	    <ol>
	        <c:forEach items="${surveyQuestions}" var="questions">
	    	    <div class="form-group">
	    
	    	 <li>${questions.questionTitle}</li>
	    	              		      <input type=hidden name="questionId" value="${questions.questionId}"/>
	    	 
	    	 	<ul class="list-group-item">
             		<c:forEach items="${questions.multipleOptions}" var="ListItem">
            		      
             		
                     		<li><input type="radio" name="${ListItem.questionsDi}" id="answer" value="${ListItem.optionsDi}" />${ListItem.optionTitle}</li>
                     		<input type="hidden" name="${ListItem.questionsDi}" value="${ListItem.optionsDi}">
             	 	
             	 	</c:forEach>
             		
       		 	</ul>
       		 	
       		    </div>
          </c:forEach>
       		 	
	    </ol>   
	    <div class="btnContainer">
			<input id="btnSubmit" class="btn btn-primary" type="submit" name="submit" />
        </div> 
</div>
</div>
</form:form>
</div>
</body>
</html>