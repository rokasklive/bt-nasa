<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
	<title><spring:message code="message.title" /></title>
	<style>

		form{
		
			margin: auto;
			width: 200px;
			text-align: center;
		}
		
		input{
			margin: 0 auto;
			margin-bottom: 10px;
			text-align: center;
		}
	</style>
</head>

<body>
	<form action="gen" method="get">

			<input type="text" name="seed" id="seed" placeholder="Seed">

			<input type="number" name="objs" id="objs" placeholder="Object amount">

			<input type="number" name="axisx" id="axisx" placeholder="Scanner width">
	
			<input type="number" name="axisy" id="axisy" placeholder="Scanner height">

			<input type="submit" name="submit" value="Submit">

	</form>
</body>
</html>