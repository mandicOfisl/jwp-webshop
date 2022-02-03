<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/WEB-INF/tld/tagLib.tld" prefix="t" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<jsp:useBean id="cart" scope="session" type="hr.algebra.lmandic.webshop.model.ShoppingCart"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout</title>
        <link rel="stylesheet" href="./Resources/css/bootstrap.min.css" type="text/css"/>
        
        <script src="Resources/js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="Resources/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    </head>
    <body>
        
        
        <t:navbar />
        
        <div class="container">
            <div class="row">
                <div class="col">
                    <t:cartItems cart="${cart}" />
                </div>         
                <div class="col">
                
                    <t:purchaseForm />
                
                </div>
            </div>
            
            
            
            
        </div>
        
        
        
        
        
        
        
        
        
        
        
        
    </body>
</html>
