<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./Resources/css/bootstrap.min.css" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center" style="margin-top: 30vh;">
                <div class="col text-center">
                    <h1>Welcome to Web Duchan!</h1>
                    <a href="${contextPath}/login" class="btn btn-primary" style="margin-top: 10vh;">Login</a>
                    <a href="${contextPath}/home?logout=1" class="btn btn-primary" style="margin-top: 10vh;">Continue without login</a>                    
                </div>     
            </div>
        </div>
    </body>
</html>
