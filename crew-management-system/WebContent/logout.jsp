<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel ="stylesheet">
<link href="css/logout.css" rel ="stylesheet">
<script src="logout.js"></script>
</head>
<body class="bg-purple">
        
        <div class="stars">
           
            <div class="central-body">
            	<h1 class="text-white display-3">LOGOUT SUCCESSFULLY</h1><br><br>
            	<h3 class="text-white">Redirecting You in <span id="sec"></span> Seconds.....</h3>
               <!--  <img class="image-404" src="http://salehriaz.com/404Page/img/404.svg" width="300px"> -->
               <!--  <a href="http://salehriaz.com/404Page/404.html" class="btn-go-home" target="_blank">GO BACK TO LOGIN PAGE</a> -->
            </div>
            <div class="objects">
                <img class="object_rocket" src="http://salehriaz.com/404Page/img/rocket.svg" width="40px">
                <div class="earth-moon">
                    <img class="object_earth" src="http://salehriaz.com/404Page/img/earth.svg" width="100px">
                    <img class="object_moon" src="http://salehriaz.com/404Page/img/moon.svg" width="80px">
                </div>
                <div class="box_astronaut">
                    <img class="object_astronaut" src="http://salehriaz.com/404Page/img/astronaut.svg" width="140px">
                </div>
            </div>
            <div class="glowing_stars">
                <div class="star"></div>
                <div class="star"></div>
                <div class="star"></div>
                <div class="star"></div>
                <div class="star"></div>

            </div>

        </div>
			<script>
var countDown = 10;
var d = setInterval(()=>{
	document.querySelector("#sec").innerText = countDown;
	countDown--;
	if(countDown==0){
		clearInterval(d);
		location.href="login.jsp";
	}
},1000);
</script>
</body>
</html>