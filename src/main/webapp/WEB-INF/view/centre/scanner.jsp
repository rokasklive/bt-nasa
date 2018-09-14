<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>

<link href="<c:url value="/resources/css/scanner.css" />"
	rel="stylesheet">

<script src="<c:url value="/resources/js/jquery-3.3.1.js"/>"
	type="text/javascript"></script>

<title><spring:message code="message.title" /></title>
<style>

</style>
<script type="text/javascript">
	function clicked(divObj, clicked_id) {
		$(".clicked").text(clicked_id);
		if($(divObj).hasClass("bounce-top")){
			console.log("Note darymas");
			
		}else{
			divObj.style.background = "red";
		
			var req = "http://localhost:8080/nasa/findObj?coord=" + clicked_id;
	
			$.ajax({
				type : "GET",
				url : req,
				dataType : "text",
				success : function(data) {
	
					console.log(data);
					findObj(data);
				}
			});
		}
	}

	function findObj(coordinates) {
		setTimeout(function() {
			$(coordinates).css("background-color", "green");
			$(coordinates).css("border-radius", "50%");
			$(coordinates).addClass("bounce-top");
		}, 500)

	}
</script>
</head>
<body>
	<p>Selected seed is: ${gridSeed}</p>
	<p>Clicked ID:</p>
	<p class="clicked">Click on a sector.</p>
	<div class="wrapper">
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
		<div class="dashboard">
		</div>
	</div>

</body>
</html>