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
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
    <h2><c:out value="${pizza.name}" /></h2>
    <h3><c:out value="${pizza.price}" /></h3>
    <img src="data:image/jpg;base64,${pizza.base64Image}" width="800" height="600"/>
</div>
    </body>
</html>
