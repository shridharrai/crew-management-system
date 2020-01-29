<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel ="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<!-- LINEARICONS -->
<link rel="stylesheet" href="fonts/linearicons/style.css">
		
<!-- STYLE CSS -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="wrapper">
			<div class="inner">
				<img src="images/image-1.png" alt="" class="image-1">
				<form action="login" method="post">
					<h3>Login Form</h3>
					<div class="form-holder">
						<span class="lnr lnr-user"></span>
						<input type="text" class="form-control" name="userid" placeholder="Username">
					</div>
					<div class="form-holder">
						<span class="lnr lnr-lock"></span>
						<input type="password" class="form-control" name="password" placeholder="Password">
					</div>
					<button type="submit" name="login" value="login"><span>Login</span></button>
					<br>
					<a href="register.jsp" class="mx-4">New User!! Create a new account...</a>
				</form>
				<img src="images/image-2.png" alt="" class="image-2">
			</div>
			
		</div>
		
		<script src="js/jquery-3.3.1.min.js"></script>
		<script src="js/main.js"></script>
<!-- </head>
<body>
<div class="container-fluid">
	<h1 class="alert-info text-center">WebApp</h1>
	<br><br>
	<h1>Login Form</h1>
	<form action="login" method="post">
		<div class='form-group'>
			<label>UserId</label>
			<input class='form-control' type='text' name='userid' placeholder='Enter the User ID'>
		</div>
		<div class='form-group'>
			<label>Password</label>
			<input class='form-control' type='password' name='pwd' placeholder='Enter the Password'>		
		</div>
		<div class='form-group'>
			<button type="submit" name="login" value="login" class='btn btn-primary'>Login</button>
		</div>
	</form>
</div> -->
</body>
</html>