<%-- 
    Document   : navbar
    Created on : Jan 31, 2022, 6:01:14 PM
    Author     : C
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>

<%-- any content can be specified here e.g.: --%>
<nav class="navbar navbar-expand-md navbar-dark bg-dark" style="margin-bottom: 16px;">
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
        </div>
    </div>
</nav>