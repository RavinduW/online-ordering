<%-- 
    Document   : register
    Created on : Sep 22, 2019, 10:57:57 PM
    Author     : Ravindu Weerasnghe
--%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">  
        <link href="css/styles.css" rel="stylesheet">
        
        <title>Online Pizza Ordering</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">Pizza Hut</a>

            <div class="collapse navbar-collapse" id="navbarColor02">
              <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                  <a class="nav-link" href="/OnlinePizza">Home</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/OnlinePizza/Home/login.jsp">Login</a>
                </li>
                <li class="nav-item active">
                  <a class="nav-link" href="">Sign Up<span class="sr-only">(current)</span></a>
                </li>
              </ul>
            </div>
        </nav>
  
        <div class="col-lg-4 col-md-6 col-sm-6 offset-4" style="border-style: solid;border-width: 1px 1px 1px 1px;padding-bottom: 20px">
            <h1>Sign Up</h1>
        <c:if test="${not empty success}">
            <br/>
            <h4 style="color:green">${success}</h4>
            <c:remove var="success"/>
        </c:if>
        <c:if test="${not empty error}">
            <br/>
            <h4 style="color:red">${error}</h4>
            <c:remove var="error"/>
        </c:if> 
        <form action="/OnlinePizza/SignUpController" method="post">
        <fieldset>
          <div class="form-group">
            <label for="firstName">First Name</label>
            <input type="text" name="firstName" class="form-control" id="firstName" placeholder="First Name" value="${firstName}">
          </div>
          <div class="form-group">
            <label for="lastName">Last Name</label>
            <input type="text" class="form-control" name="lastName" id="lastName" value="${lastName}" placeholder="Last Name">
          </div>
          <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" value="${email}" placeholder="Email">
          </div>
          <div class="form-group">
            <label for="username">Username</label>
            <input type="text" class="form-control" id="username" name="username" value="${username}" placeholder="Username">
          </div>  
          <div class="form-group">
            <label for="address">Address</label>
            <input type="text" class="form-control" id="address" name="address" value="${address}" placeholder="Address">
          </div>
          <div class="form-group">
            <label for="contact_number">Contact Number</label>
            <input type="text" name="contact_number" class="form-control" id="contact_number" value="${contact_number}" placeholder="Contact Number">
          </div>
          <div class="form-group">
            <label for="password1">Password</label>
            <input type="password" name="password1" class="form-control" id="password1" placeholder="Password">
          </div>      
          <div class="form-group">
             <label for="password2">Confirm Password</label>
             <input type="password" name="password2" class="form-control" id="password2" placeholder="Confirm Password">
          </div>  
          <input type="submit" name="signup" value="Submit" class="btn btn-primary" />
        </fieldset>
        </form> 
        </div>
            

                
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
    </body>
</html>
