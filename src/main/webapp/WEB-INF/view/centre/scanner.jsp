<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	<script src="<c:url value="/resources/js/jquery-3.3.1.js"/>" type="text/javascript"></script> 
	
    <title><spring:message code="message.title" /></title>
    <style>
    
    .wrapper{
    	text-align: center;
    }
    .grid-container{
    	margin: 0 auto;
    	padding: 0;
    	display: inline-block;
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
    <script type="text/javascript">
   		 function clicked(divObj, clicked_id) {
       		 divObj.style.background="red";
       			$(".clicked").text(clicked_id);
  				var req = "http://localhost:8080/nasa/findObj?coord="+clicked_id;
  				
       			$.ajax({
       			    type: "GET",
       			    url: req,
       			    dataType: "text",
       			    success: function(data) {

       			        console.log(data);
						findObj(data);
       			    }
       			}); 
       			
    		}
   		 function findObj(coordinates){
   			 setTimeout(function(){
   			 $(coordinates).css("background-color", "green");
   			 $(coordinates).css("border-radius", "50%");
   			}, 4000)
   		 }
   		 
    </script>
</head>
<body>
<p>Selected seed is: ${gridSeed}</p>
	<p>Clicked ID:</p>
	<p class="clicked">kinda works</p>
	<div class="wrapper">
	<div class="grid-container">
	 <c:forEach var = "i" begin = "1" end = "${gridAxisy}">
         <div class="rows">
         <c:forEach var = "j" begin = "1" end = "${gridAxisx}">
			<div class="boxes" id="${j}_${i}" onclick="clicked(this, this.id)"></div>
        </c:forEach></div>
      </c:forEach>
      </div>
      </div>
</body>
</html>