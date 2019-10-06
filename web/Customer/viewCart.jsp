<%-- 
    Document   : viewCart
    Created on : Oct 6, 2019, 8:25:45 AM
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
        <h3> Your Cart </h3>
        <div align="center">

        <div style="margin-left: auto;margin-right: auto;">
            <table cellpadding="10" > 
                <tr>
                    <th>Pizza Type</th>
                    <th>Quantity</th>
                    <th>Total Price</th>
                </tr>
                <c:forEach items="${cart}" var="p">
                    <c:set var="total_price" value="${p.pizza.price*p.quantity}" />
                    <tr>
                        <td><c:out value="${p.pizza.name}" /></td>
                        <td><c:out value="${p.quantity}" /></td>
                        <td><c:out value="${total_price}"></c:out></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    </body>
</html>
