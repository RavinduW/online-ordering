<%-- 
    Document   : updatePizza
    Created on : Sep 29, 2019, 1:01:31 AM
    Author     : Ravindu Weerasnghe
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Online Pizza Ordering</title>
    </head>
    <body>
        <h1>Update Pizza Details</h1>
        <c:forEach items="${FindById}" var="p">
            <form action="/OnlinePizza/UpdatePizzaController" method="post">
                
                <input type="hidden" name="id" value="${p.id}"/>
                
                Name:<br/>
                <input type="text" name="name" value="${p.name}" style="width: 200px" />
                <br/><br/>
                Price:<br/>
                <input type="number" name="price" value="${p.price}"  style="width: 200px" />
                <br/><br/>
                Status:<br/>
                <input type="radio" name="status" value="Available" ${p.status=="Available" ? 'checked' :''}/>Available
                <input type="radio" name="status" value="Unavailable" ${p.status=="Unavailable" ? 'checked' :''}/>Unavailable
                <br/><br/>
                Pizza Image:<br/>
                <img src="data:image/jpg;base64,${p.base64Image}" width="400" height="300"/>
                <br/>
                <button type="submit">Edit</button>
            </form>
        <h3>Change The Image</h3>
        <form method="post" action="/OnlinePizza/UpdatePizzaImageController" enctype = "multipart/form-data">
             <input type="hidden" name="id" value="${p.id}"/> 
             <input type="hidden" name="name" value="${p.name}"/>
             <input type="hidden" name="price" value="${p.price}"/>
             <input type="hidden" name="status" value="${p.status}"/>
             <input type="file" name="image" size="50" />
             <button type="submit">Change Image</button>
        </form>
      </c:forEach>
    </body>
</html>
