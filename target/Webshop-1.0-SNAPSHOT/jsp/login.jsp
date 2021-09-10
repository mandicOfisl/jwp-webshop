<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="../Resources/css/bootstrap.min.css" type="text/css"/>
    </head>
    
    
    <body>
        <nav class="navbar navbar-expand-md navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Web Duchan</a>
            <button class="navbar-toggler" 
                    type="button" 
                    data-bs-toggle="collapse" 
                    data-bs-target="#navbarSupportedContent" 
                    aria-controls="navbarSupportedContent" 
                    aria-expanded="false" 
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>              
                    <li class="nav-item">
                        <a class="nav-link disabled">Disabled</a>
                    </li>
                </ul>
                <form class="d-flex">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
        </nav>
        
        
        <div class="container">
            <div class="row justify-content-center" style="margin-top: 30vh;">
                <div class="col text-center" style="display: flex; flex-direction: column; align-items: center;">
                    <h3>Login</h3>
                    <form method="POST" action="login">

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

                        <a href="login" type="submit" class="btn btn-primary" style="margin-top: 10vh;">Login!</a>                    
                    </form>
                </div>     
            </div>
        </div>
        
        
    </body>
</html>
