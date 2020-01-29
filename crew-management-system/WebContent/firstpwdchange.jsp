<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel ="stylesheet">
</head>
<body>

	<div class="container-fluid">
	<h1 class="alert-info text-center">WEB APP</h1>
	<br><br>
	<h1>Change Password</h1>
	<form action="firstpwdchnge" method="post">
		<div class='form-group'>
			<label>UserId</label>
			<input class='form-control' type='text' name='userid' placeholder='Enter the User ID'>
		</div>
		<div class='form-group'>
			<label>Phone No.</label>
			<input class='form-control' type='text' name='contact' placeholder='Enter the Phone no.'>
		</div>
		<div class='form-group'>
			<label>Email</label>
			<input class='form-control' type='email' name='email' placeholder='Enter the Email'>
		</div>
		<div class='form-group'>
			<label>Password</label>
			<input class='form-control' type='password' name='pwd' placeholder='Enter the Password'>		
		</div>
		<div class='form-group'>
			<button type="submit" name="login" value="login" class='btn btn-primary'>Login</button>
		</div>
	</form>
  </div>
</body>
</html>