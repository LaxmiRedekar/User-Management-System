<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login page</title>
<style type="text/css">
	body{
		background-color: #005580;
		font-family: cursive;
		color: white;
	}
		.container{
		background-color:#006699;
		width: 500px;
		height: auto;
		margin-left: 500px;
		margin-top: 100px;
	}
	.container:hover {
		transform: scale(1.2);
		z-index: 2;
	}
	.input{
		background-color: transparent;
		height: 30px;
		width: 250px;
	}
	.input:hover {
		background-color:#005580;
	}
	.sub{
		background-color: transparent;
		height: 30px;
		width: 70px;
		font-size: large;
		color: white;
	}
	.sub:hover {
		background-color:#005580;
	}
	
</style>
</head>
<body>
	<form action="validate" method="post">
		<div class="container" align="center">
       <h1>Welcome To Admin Page</h1>
         <h3>Email :</h3> <input type="email" name="email" class="input" placeholder="ENTER YOUR EMAIL"/><br>
         <h3>Password :</h3> <input type="password" name="pwd" class="input" placeholder="ENTER YOUR PASSWORD"/><br><br>
    
         <input type="submit" value="login" class="sub"/><br><br>
         </div>
    </form>
</body>
</html>