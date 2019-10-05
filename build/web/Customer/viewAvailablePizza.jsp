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
                </tr>
                <c:forEach items="${pizza}" var="p">
                    <tr>
                        <td><c:out value="${p.name}" /></td>
                        <td><c:out value="${p.price}" /></td>
                        <td><img src="data:image/jpg;base64,${p.base64Image}" width="400" height="300"/></td>
                        <td>
                            <form action="/OnlinePizza/AddToCartController" method="post">
                                <input type="number" min="0" name="quantity" id="quantity" />
                                <input type="hidden" name="delivery_status" value="false" />
                              <button type="submit">Add pizza to cart</button>  
                            </form>
                        </td>  
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>        
    </body>
</html>
