<%
if(session.getAttribute("login") != null){
	response.sendRedirect("home.jsp");
}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
  <div class="container  mt-5">
   <div class="row">
  <div class="col-lg-6 m-auto shadow-lg p-5 mb-5 bg-body rounded">
	<form method="POST" action="login">
	<h1 class="mb-3 mt-2">Form Login</h1>
	<% if(request.getAttribute("errorMessage") != null){ %>
	<div class="alert alert-danger" role="alert">
	 <%= request.getAttribute("errorMessage") %>
	</div>
	<% } %>
	  <div class="mb-3">
	    <label for="exampleInputEmail1" class="form-label">Login(username) </label>
	    <input type="text" name="login" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
	  </div>
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">Password</label>
	    <input type="password" name="password" class="form-control" id="exampleInputPassword1">
	  </div>
	  <button type="submit" class="btn btn-primary">login</button>
	  <a href="register.jsp">register</a>
    </form>
	
	</div>
	 </div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>