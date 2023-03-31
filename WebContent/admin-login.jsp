<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<header style="color:white">
	 <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Customer Management</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
    </div>
  </div> 
</nav>
</header>
<form action="list" method="post">
<div class="container" style="width:50%">
	<div class="mb-3">
	<h2 align="center">Admin Login</h2>
	<div class="container"  style="width:50%">
	<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Username</label>
  <input type="text" class="form-control" id="exampleFormControlInput1"  required="required" name="tbUser">
</div>
<br>
<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Password</label>
  <input type="text" class="form-control" id="exampleFormControlInput1"  required="required" name="tbPass">
</div>


 <div class="input-group mb-3">
  
  <input  type="submit"  class="btn btn-success" value="Login"  >	
  </div>
  
	</div>
</div>	
	</div>
</form>	
</body>
</html>