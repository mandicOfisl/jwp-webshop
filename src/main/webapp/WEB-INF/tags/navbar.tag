<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@attribute name="message"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="adminRole" value="admin" />

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
                    <a class="nav-link" href="${contextPath}/home">Shop home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/cart">Cart</a>
                </li>
                <c:if test="${cookie['role'].getValue().length() > 0}">
                    <li class="nav-item">
                        <a class="nav-link" href="${contextPath}/">Past purchases</a>
                    </li>
                </c:if>
                <c:if test="${cookie['role'].getValue().equals(adminRole)}">
                    <li class="nav-item">
                        <a class="nav-link" href="${contextPath}/productManagment">Manage products</a>
                    </li>
                    
                    <li class="nav-item">
                        <a class="nav-link" href="${contextPath}/userLogin">User logins</a>
                    </li>
                </c:if>
            </ul>            
        </div>
        <c:if test="${cookie['role'].getValue().length() > 0}">            
            <a class="btn btn-danger" href="${contextPath}/logout">Logout</a>            
        </c:if>
        <c:if test="${cookie['role'].getValue().length() == 0}">            
            <a class="btn btn-success" href="${contextPath}/login">Login</a>            
        </c:if>    
    </div>
</nav>