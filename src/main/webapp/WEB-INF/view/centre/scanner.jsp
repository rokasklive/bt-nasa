<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>

	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
	
	<script src="<c:url value="/resources/js/jquery-3.3.1.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/planetGen.js"/>" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/scanner.js"/>" type="text/javascript"></script>
		
	<title><spring:message code="message.title" /></title>

</head>
<body>
	<p>Selected seed is: ${gridSeed}</p>
	<p>Scanner coordinates:</p>
	<p class="clicked">Click on a sector.</p>
	<div id="scanInfo" class="scanInfo">
		Naujo Objekto nerado
	</div>
	<div class="wrapper">
		<div class="scanner view">
			<div class="grid-container">
				<c:forEach var="i" begin="0" end="${gridAxisy - 1}">
					<div class="rows">
						<c:forEach var="j" begin="0" end="${gridAxisx - 1}">
							<div class="boxes" id="${j}_${i}" onclick="clicked(this, this.id)"></div>
						</c:forEach>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="dashboard-container">
			<div class="info" id="placeholder"></div>
			<form:form action="#" method="POST" id="note_form" name="note_form">
				<textarea class="notes" name="notes" form="note_form" id="notes"></textarea>		
				<input type="hidden" name="uid" id="uid"/>
				
			</form:form>
			<div onclick="sendNote()" class="submit_note">Submit</div>
		</div>
	</div>
</body>
</html>