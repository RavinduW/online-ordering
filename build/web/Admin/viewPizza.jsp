<%-- 
    Document   : viewPizza
    Created on : Sep 29, 2019, 1:01:18 AM
    Author     : Ravindu Weerasnghe
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Pizza Ordering</title>
    </head>
    <body>
        <div align="center">

        <div style="margin-left: auto;margin-right: auto;">
            <table cellpadding="10" > 
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Pizza Image</th>
                    <th>Availability</th>
                </tr>
                <c:forEach items="${pizza}" var="p">
                    <tr>
                        <td><c:out value="${p.name}" /></td>
                        <td><c:out value="${p.price}" /></td>
                        <td><img src="data:image/jpg;base64,${p.base64Image}" width="400" height="300"/></td>
                        <td><c:out value="${p.status}" /></td>
                        <td>
                            <a href="UpdatePizzaController?id=${p.id}">Update</a>
                            <form action="/OnlinePizza/DeletePizzaController?id=${p.id}" method="post">
                              <button type="submit">Delete</button>  
                            </form>
                            
                        </td>  
                    </tr>

                </c:forEach>
            </table>
        </div>
    </div>
    </body>
</html>
