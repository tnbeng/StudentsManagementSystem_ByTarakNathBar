<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student List</title>
    
    <!-- All CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/style.css">
    
</head>
<body>
    
   <jsp:include page="admin-navbar.jsp"></jsp:include>
    
    <!-- table start -->
      <div class="container" style="margin-top:100px"> 
            
            <table class="table table-light table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Image</th>
                        <th>Full Name</th>
                        <th>Roll No</th>
                        <th>Phone No</th>
                        <th>Email</th>
                        <th>Technology</th>
                        <th style="text-align: center;">Update</th>
                        <th style="text-align: center;">Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="stu" items="${model_student_list}" >
                    	<tr>
                    	    <td><img alt="Not found" src="upload/${stu.getImage_name()}" height="30px"></td>
                    		<td> ${stu.getName()} </td>
                    		<td> ${stu.getRollno()}</td>
                    		<td> ${stu.getPhoneno()}</td>
                    		<td> ${stu.getEmail()}</td>
                    		<td> ${stu.getLang()} </td>
                    		<td style="text-align: center;"> 
                    			<button class="btn btn-primary" onclick="confirmUpdate('${stu.getEmail()}')">Update</button>
                    		</td>
                    		<td style="text-align: center;"> 
                    			<button class="btn btn-danger" onclick="confirmDelete('${stu.getEmail()}','${current_page}')">Delete</button>
                    		</td>
                    	</tr>
                    </c:forEach>
                </tbody>
            </table>
         </div>
    <!-- table end -->
    
  <!-- Pagination start-->
  <nav aria-label="..." class="mt-5">
  <ul class="pagination justify-content-center">
    <c:choose>
      <c:when test="${current_page>1}">
        <li class="page-item">
           <a class="page-link" href="showStudent?page=${current_page-1}">Previous</a>
        </li>
      </c:when>
      <c:when test="${current_page==1}">
        <li class="page-item disabled">
           <a class="page-link" href="#">Previous</a>
        </li>
      </c:when>
    </c:choose>
     
     <c:forEach begin="1" end="${required_pages }" var="page_number">
     <c:choose>
      <c:when test="${page_number==current_page}">
        <li class="page-item active">
           <a class="page-link " href="showStudent?page=${page_number}">${page_number}</a>
        </li>
      </c:when>
      <c:when test="${page_number!=current_page}">
        <li class="page-item ">
           <a class="page-link" href="showStudent?page=${page_number}">${page_number}</a>
        </li>
      </c:when>
     </c:choose>
    </c:forEach>
    
    <c:choose>
      <c:when test="${current_page<required_pages}">
        <li class="page-item">
           <a class="page-link " href="showStudent?page=${current_page+1}">Next</a>
        </li>
      </c:when>
      <c:when test="${current_page==required_pages}">
        <li class="page-item disabled">
           <a class="page-link " href="#">Next</a>
        </li>
      </c:when>
    </c:choose>
  </ul>
</nav>
<!-- Pagination end -->
    
            
      
   
    
    <!-- All Js -->
    <script src="js/bootstrap.bundle.min.js"></script>
    
    <script type="text/javascript">
        function confirmUpdate(email)
         {
        	var is_confirm= confirm("Are you sure you want to update this student");
            if(is_confirm)
            	{
            	  window.location.href="/updateStudent?email="+email;
            	}
         }
        function confirmDelete(email,page)
        {
       	var is_confirm= confirm("Are you sure you want to Delete this student");
           if(is_confirm)
           	{
           	  window.location.href="/deleteStudent?email="+email+"&page="+page;
           	}
        }
    </script>
   
 
</body>
</html>




    