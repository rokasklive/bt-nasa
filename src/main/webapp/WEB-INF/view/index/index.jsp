<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
	<title><spring:message code="message.title" /></title>
</head>

<body>
	<form action="/gen" method="get">
		<label for="seed">Seed:</label>
			<input type="text" name="seed" id="seed">
			
		<label for="objs">Object count:</label>
			<input type="number" name="objs" id="objs">
			
		<label for="axisx">Size X-Axis</label>
			<input type="number" name="axisx" id="axisx">
			
		<label for="axisy">Size Y-Axis</label>
			<input type="number" name="axisy" id="axist">
			
			<input type="submit" name="Submit" value="Submit">
	</form>
</body>
</html>