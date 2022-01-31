<%@page contentType="text/html;charset=UTF-8" %>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/WEB-INF/tld/tagLib.tld" prefix="t" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="./Resources/css/bootstrap.min.css" type="text/css"/>
    </head>    
    
    <body>
        
        <t:navbar />
        <t:time />
        
        
        <div class="container">
            <div class="row justify-content-center" style="margin-top: 30vh;">
                <div class="col text-center" style="display: flex; flex-direction: column; align-items: center;">
                    <h3>Login</h3>
                    <form method="POST" action="http://localhost:8084/Webshop/login">

                        <input type="text" 
                               class="form-control my-3" 
                               name="username" 
                               id="txtUsername" 
                               placeholder="Username" 
                               style="width: 360px;"/>
                        
                        <input type="password" 
                               class="form-control my-3" 
                               name="password" 
                               id="txtPassword" 
                               placeholder="Password" 
                               style="width: 360px;"/>

                        <button type="submit" class="btn btn-primary" style="margin-top: 10vh;">Login!</a>                    
                    </form>
                </div>     
            </div>
        </div>        
        
    </body>
</html>
