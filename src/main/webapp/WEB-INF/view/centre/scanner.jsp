<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	
    <title><spring:message code="message.title" /></title>
    <style>
    .grid-container{
    	margin: 0 auto;
    	padding: 0;
    	text-align: center;
    }
    
    .rows{
    	display: flex;
    	flex-direction: row;
  		flex-wrap: no-wrap;
  		padding: 0;
  		margin: 0;
    }
    
    .boxes{
    	width: 15px;
    	height: 15px;
    	border: 1px solid grey;
    	padding: 0;
    	margin: 0;
    }
    
    </style>
</head>
<body>
<p>Selected seed is: ${gridSeed}</p>
	<p>kinda works</p>
	<div class="grid-container">
	 <c:forEach var = "i" begin = "1" end = "${gridAxisy}">
         <div class="rows">
         <c:forEach var = "j" begin = "1" end = "${gridAxisx}">
			<div class="boxes"></div>

        </c:forEach></div>
      </c:forEach>
      </div>
</body>
</html>