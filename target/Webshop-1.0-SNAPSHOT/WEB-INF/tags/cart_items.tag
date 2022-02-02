<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="" pageEncoding="UTF-8"%>

<%@ attribute name="cart" required="true" rtexprvalue="true" type="hr.algebra.lmandic.webshop.model.ShoppingCart" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<div class="card card-body cartItemsContainer">
    
    <c:forEach items="${cart.getItems()}" var="entry">
    
        <div class="cartItem" style="display: flex;">
            
            <p>${entry.key.getName()}</p>
            
            <p><span style="font-size: small">Količina: </span>${entry.value}</p>
            
            <p>${entry.key.getPrice()} kn</p>
            
        </div>
    
    </c:forEach>
    
    <p>Total: <b>${cart.getTotalAmount()} kn</b></p>
</div>
