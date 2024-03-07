<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rgister Student</title>
    
    <!-- All CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/style.css">
    <style type="text/css">
     .validation_message{
        color:red;
      }
    
    </style>
</head>
<body>
    
   <jsp:include page="admin-navbar.jsp"></jsp:include>  
         
  <!-- register starts -->
     <div class="container " style="margin-top:70px;">
       <jsp:include page="message-page.jsp"></jsp:include>     
      <div class="row justify-content-center">
        <div class="col-sm-12 col-md-6 col-lg-6 mt-1">
          <div class="card bg-light">
            <div class="card-header">
              <div class="card-title text-center">
                <h5>Register a new student</h5>
              </div>
            </div>
            <div class="card-body">
              <form:form action="addStudentForm" method="post" modelAttribute="Student" enctype="multipart/form-data">
                <div class="form-group">
                  <label for="name">Name</label>
                  <form:input path="name"  value="${stu.getName()}" cssClass="form-control " />
                  <form:errors path="name" cssClass="validation_message"></form:errors>
                </div>
                <div class="form-group">
                  <label for="name">Roll No</label>
                  <form:input path="rollno" value="${stu.getRollno()}" cssClass="form-control" />
                  <form:errors path="rollno" class="validation_message"></form:errors>
                </div>
                 <div class="form-group">
                  <label for="name">Mobile No</label>
                  <form:input path="phoneno" value="${stu.getPhoneno()}" cssClass="form-control" />
                  <form:errors path="phoneno" cssClass="validation_message"></form:errors>
                </div>
                 <div class="form-group">
                  <label for="name">Email Id</label>
                  <form:input path="email" value="${stu.getEmail()}" cssClass="form-control" />
                  <form:errors path="email" cssClass="validation_message"></form:errors>
                </div>
                <div class="form-group">
                  <label for="name">Programming Language</label>
                  <form:input path="lang" value="${stu.getLang()}" cssClass="form-control " />
                  <form:errors path="lang" cssClass="validation_message"></form:errors>
                </div>
                <div class="form-group">
                  <label for="">Upload Image</label>
                  <input type="file" name="file" class="form-control"/>
                 
                </div>
                <button class="btn btn-success form-control mt-4">Add</button>
              </form:form>
            </div>
          </div>
        </div>
      </div>
     </div>
    
     
   <!-- register end -->
    
    
    <!-- All Js -->
    <script src="js/bootstrap.bundle.min.js"></script>
   
   
</body>
</html>




    