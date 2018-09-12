<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<title><spring:message code="message.title" /></title>
</head>

<body>
	<form:form action="create" modelAttribute="ufo">
		Seed <form:input path="seed"/>
		<br>
		<br>
		<input type="submit" value="Submit"/>
	</form:form>

</body>
</html>