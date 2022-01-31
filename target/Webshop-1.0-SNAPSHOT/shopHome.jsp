<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/WEB-INF/tld/tagLib.tld" prefix="t" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<jsp:useBean id="products" scope="session" type="java.util.List"/>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="./Resources/css/bootstrap.min.css" type="text/css"/>
    </head>
    <body>
        
        <t:navbar />
        
        <div class="container">
            
            <div class="row">
                
                <t:products products="${products}" />
                
            </div>
            
            
            
            
            
        </div>
        
        
        
    </body>
</html>
