<%@page import="java.util.ArrayList,com.shubham.webapp.dto.userDTO,com.shubham.webapp.dto.rightsDTO,com.shubham.webapp.dto.roleDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WEBAPP</title>
<link href="css/bootstrap.min.css" rel ="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
 <link href="css/dashboard.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
        
        /* .hide{
        	display: none;
        } */
      }
    </style>
</head>
<body>
<% if(session.getAttribute("sessionuserid")==null){
	response.sendRedirect("login.jsp");	
}%>

  <%@include file="header.jsp" %>

<div class="container-fluid">
  <div class="row">
    <nav class="col-md-2 d-none d-md-block bg-light sidebar">
      <div class="sidebar-fixed">
        <ul class="nav flex-column">
        <%ArrayList<rightsDTO> userlinklist = (ArrayList<rightsDTO>)request.getAttribute("userdata");
	if(userlinklist!=null){
		for(rightsDTO obj : userlinklist){
			%>
          <li class="nav-item">
            <a class="nav-link active" href="<%=obj.getScreenname() %>" onclick="<%=obj.getScreenname() %>()">
         	<%=obj.getRightname() %></a>
          </li>
          <%}
			}%>
        </ul>
      </div>
    </nav>

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4 overflow-auto mb-5">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">Add Seller</h1>
      </div>
<div class='w-100 float-right pr-2'>
	<h1 class='text-center btn btn-outline-success w-100 display-1'>Add Seller</h1>
	<form action="addseller" method="post">
		<div class='form-group'>
			<label>UserId</label>
			<input class='form-control' type='text' name='userid' placeholder='Enter the User ID/Name'>
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
		<div>
		<h1 class='text-center btn btn-outline-info w-100 float-none display-1'>Add Role</h1>
		<div class="form-group">
    <label>Role</label>
   <select name="selectrole">
		<c:forEach items="${roles}" var="obj">
			<option >${obj.rolename}</option>
		</c:forEach>
	</select>
<%-- 	<% ArrayList<roleDTO> rolelist = (ArrayList<roleDTO>)request.getAttribute("roles");
		if(rolelist!=null){
			for(roleDTO obj : rolelist){
				%>
				<h1><%=obj.getRolename() %></h1>
				<%
			}
		}
		
	%> --%>
    </div>
  </div>
		<div class='form-group'>
			<button type="submit" name="addsellerbtn" value="addsellerbtn" class='btn btn-primary'>ADD Seller</button>
		 </div>
	</form>
</div>
  </main>
  </div>
</div>
	<%@include file="footer.jsp" %>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
      <script>window.jQuery || document.write('<script src="/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')</script><script src="/docs/4.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
        <script src="dashboard.js"></script>
</body>
</html>