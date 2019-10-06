<%-- 
    Document   : addPizza
    Created on : Sep 29, 2019, 1:00:47 AM
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
            <a class="navbar-brand" href="#">Admin Panel</a>

            <div class="collapse navbar-collapse" id="navbarColor02">
              <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                  <a class="nav-link" href="/OnlinePizza/ViewAdminPanelController">Admin Home</a>
                </li>
                <li class="nav-item active">
                  <a class="nav-link" href="">Add Pizza<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/OnlinePizza/ViewPizzaController">View Pizza</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">View Orders</a>
                </li>
              </ul>
                <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                  <a class="nav-link" href="/OnlinePizza/LoginController">Logout</a>
                </li>
                </ul>
            </div>
        </nav>
        <div class="col-lg-4 col-md-6 col-sm-6 offset-4" style="margin-top: 80px;border-style: solid;border-width: 1px 1px 1px 1px;padding-bottom: 20px">
                    <h1>Add Pizza</h1>
        <form method = "post" enctype = "multipart/form-data" action = "/OnlinePizza/AddPizzaController">
        <fieldset>
          <div class="form-group">
            <label for="name">Name</label>
            <input type="text" name="name" class="form-control" id="name" aria-describedby="name" value="${name}" placeholder="Name">
          </div>
          <div class="form-group">
            <label for="price">Price</label>
            <input type="number" name="price" class="form-control" id="price" placeholder="Price" value="${price}">
          </div>
          <div class="form-group">
              <label for="status">Status</label>
              <input type="radio" name="status" value="Available"/>Available
              <input type="radio" name="status" value="Unavailable" />Unavailable
          </div>
          <div class="form-group">
              <label for="image">Image</label>
               <input type="file" name="image" size="50"/>
          </div>
       
          <button type="submit" class="btn btn-primary">Submit</button>
          <br/>
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
