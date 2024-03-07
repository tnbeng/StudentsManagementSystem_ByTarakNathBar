<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
    
    <!-- All CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    
    <nav class="navbar navbar-expand-lg navbar-light bg-info fixed-top">
        <div class="container">
          <a class="navbar-brand" href="#"><span class="text-warning">Student</span> Management System</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
            
              <li class="nav-item ">
               <a href="admin" class="nav-link">Home</a>
              </li>
              
              <li class="nav-item ">
               <a href="register" class="nav-link">Add Student</a>
              </li>
              
              <li class="nav-item">
               <a href="showStudent" class="nav-link">Show Student</a>
              </li>
              
               <li class="nav-item ">
               <a href="logout" class="btn btn-danger nav-link">Logout</a>
              </li>
                      
            </ul>
          </div>
        </div>
     </nav>
         
    <!-- All Js -->
    <script src="js/bootstrap.bundle.min.js"></script>
   
   
</body>
</html>




    