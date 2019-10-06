<%-- 
    Document   : viewAvailablePizza
    Created on : Oct 5, 2019, 6:18:46 PM
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
        <link href="css/styles.css" rel="stylesheet">        
        <title>Online Pizza Ordering</title>
        <style>
            
#pizzas {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif !important;
  border-collapse: collapse !important;
  width: 100% !important; 
}

#pizzas td, #pizzas th {
  border: 1px solid #ddd !important;
  padding: 8px !important;
}

#pizzas tr:nth-child(even){background-color: #f2f2f2 !important;}

#pizzas tr:hover {background-color: #ddd !important;}

#pizzas th {
  padding-top: 12px !important;
  padding-bottom: 12px !important;
  text-align: left !important;
  background-color: #4CAF50 !important;
  color: white !important;
}

</style>         
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">Pizza Hut</a>

            <div class="collapse navbar-collapse" id="navbarColor02">
              <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                  <a class="nav-link" href="/OnlinePizza/CustomerPanelController">Customer Home</a>
                </li>
                <li class="nav-item active">
                  <a class="nav-link" href="">View Available Pizza<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/OnlinePizza/CartController">View Your Cart</a>
                </li>
              </ul>
                <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                  <a class="nav-link" href="/OnlinePizza/LoginController">Logout</a>
                </li>
                </ul>
            </div>
        </nav>
        
        <div align="center">

        <div style="margin-left: auto;margin-right: auto;">
            <table id="pizzas" > 
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Pizza Image</th>
                </tr>
                <c:forEach items="${pizza}" var="p">
                    <tr>
                        <td><c:out value="${p.name}" /></td>
                        <td><c:out value="${p.price}" /></td>
                        <td><img src="data:image/jpg;base64,${p.base64Image}" width="250" height="200"/></td>
                        <td>
                            <form action="/OnlinePizza/AddToCartController" method="post">
                                <label>Quantity</label>
                                <input type="number" min="0" name="quantity" id="quantity" />
                                <input type="hidden" name="pizza_id" value="${p.id}" />
                              <button type="submit">Add pizza to cart</button>  
                            </form>
                        </td>  
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>  
       <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>                  
    </body>
</html>
