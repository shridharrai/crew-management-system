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
				<form action="register" method="post">
					<h3>New Account?</h3>
					<div class="form-holder">
						<span class="lnr lnr-user"></span>
						<input type="text" class="form-control" name="userid" placeholder="Username">
					</div>
					<div class="form-holder">
						<span class="lnr lnr-phone-handset"></span>
						<input type="text" class="form-control" name="contact" placeholder="Phone Number">
					</div>
					<div class="form-holder">
						<span class="lnr lnr-envelope"></span>
						<input type="email" class="form-control" name="email" placeholder="Email">
					</div>
					<div class="form-holder">
						<span class="lnr lnr-lock"></span>
						<input type="password" class="form-control" name="pwd" placeholder="Password">
					</div>
					
					<button type="submit" name="register" value="register"><span>Register</span></button>
					<br>
					<a href="login.jsp" class="mx-5">Already have an account...</a>
				</form>
				<img src="images/image-2.png" alt="" class="image-2">
			</div>
			
		</div>
		
		<script src="js/jquery-3.3.1.min.js"></script>
		<script src="js/main.js"></script>
</body>
</html>