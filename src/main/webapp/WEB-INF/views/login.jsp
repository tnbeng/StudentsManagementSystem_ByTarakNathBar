<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    
    <!-- All CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    
   <jsp:include page="home-navbar.jsp"></jsp:include>
         
  <!-- login starts -->
     <div class="container" style="margin-top:70px">
               <c:if test="${not empty error}">
					<div class="row">
						<div class="alert alert-danger alert-dismissible fade show"
							role="alert">
							Login failed
							<button type="button" class="btn-close" data-bs-dismiss="alert"
								aria-label="Close"></button>
						</div>
					</div>
				</c:if>
      <div class="row justify-content-center">
        <div class="col-sm-12 col-md-6 col-lg-6 mt-1">
          <div class="card">
            <div class="card-header">
              <div class="card-title text-center">
                <h5>Login</h5>
              </div>
            </div>
            <div class="card-body">
              <form action="loginForm" method="post">
                <div class="form-group">
                  <label for="name">Email</label>
                  <input type="name" name="email" class="form-control " id="email">
                </div>
                <div class="form-group">
                  <label for="name">Password</label>
                  <input type="name" name="password" class="form-control " id="password">
                </div>
                <button class="btn btn-success form-control mt-4">Login</button>
              </form>
            </div>
          </div>
        </div>
      </div>
     </div>
  
     
   <!-- login ends -->
    
    
    <!-- All Js -->
    <script src="js/bootstrap.bundle.min.js"></script>
   
   
</body>
</html>




    