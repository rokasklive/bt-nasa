	function clicked(divObj, clicked_id) {
		$(".clicked").text(clicked_id);
		if($(divObj).hasClass("bounce-top")){
			nameGen(1);
			$("#uid").val(clicked_id);
		}else{
			divObj.style.background = "red";
			$('#' + clicked_id).addClass('puff-out-center');
			setTimeout(function(){
				divObj.style.background = "none";
			}, 1500)
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

	function sendNote(){
		var text = $('.notes').val();
		var coord = $("#uid").val();
		$.ajax({
			type : "POST",
			url : "http://localhost:8080/nasa/note",
			data: { text: JSON.stringify(text), coord: JSON.stringify(coord) },
			success : function(data) {
				
				console.log("yay");
				
			}
		});
	}
	
	function findObj(coordinates) {
		setTimeout(function() {
			if($(coordinates).hasClass("bounce-top")){
				$("#scanInfo").css("visibility", "visible")
				setTimeout(function() {
					$("#scanInfo").css("visibility", "hidden")
				}, 2000)
				console.log("????");
			}else{
				$(coordinates).css("background-color", "green");
				$(coordinates).css("border-radius", "50%");
				$(coordinates).addClass("bounce-top");
			}
		}, 500)

	}