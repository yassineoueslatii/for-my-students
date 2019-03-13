<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div id="app">
<h1>{{message}}</h1>
</div>
<script src="https://unpkg.com/vue@2.0.3/dist/vue.js"></script>
	<script src="https://unpkg.com/vue@2.0.3/dist/vue.js"></script>
	<script>
const app = new Vue({
    el: '#app',
    data: {
    	message:'Bonjour Yassine'
    	}
    	
    });
</script>
</body>
</html>