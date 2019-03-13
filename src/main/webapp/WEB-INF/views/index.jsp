<%@ include file="/WEB-INF/views/includes/include.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		
		<title>Demo Application</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	</head>
	<body>
	<input type="button" name="getData" id="getData" value="GET DATA" onclick="getDataFromAPI();"/>
	<input type="button" name="postData" id="postData" value="POST DATA" onclick="postDataFromAPI();"/>
	<input type="text" name="demo_id" id="demo_id"/>
	<input type="text" name="demo_name" id="demo_name"/>
	
	<script>
	
	function getDataFromAPI() {
	    $.ajax({
	        url: "/mvc/getdata",
	        type: "GET",
	        success: function (data) {
	        	console.log("GET DATA API RESPONSE - ID::"+data.id);
	        	console.log("GET DATA API RESPONSE - NAME::"+data.nom);
	        	$("#demo_id").val(data.id);
	        	$("#demo_name").val(data.nom);
	        }, error: function (jqXHR, textStatus, errorThrown) {
	        }
		});
	}
	
	function postDataFromAPI() {
		
		var modelObj = {
				id: $("#demo_id").val(),
				nom: $("#demo_name").val()
		};
		
		console.log("post data:"+modelObj);		
		
		 $.ajax({
	            type: "POST",
	            url: "/mvc/postdata",
	            headers: {
	                "Content-Type": "application/json"
	            },
	            data: JSON.stringify(modelObj),
	            success: function (data) {
	            	console.log("POST API RESPONSE::"+data);
	            },
	            error: function (jqXHR, textStatus, errorThrown) {
	            }
	        });
	}
	</script>
	</body>
</html>