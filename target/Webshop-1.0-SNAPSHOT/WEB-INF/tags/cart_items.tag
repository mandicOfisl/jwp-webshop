<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="" pageEncoding="UTF-8"%>

<%@ attribute name="cart" required="true" rtexprvalue="true" type="hr.algebra.lmandic.webshop.model.ShoppingCart" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<div 
    class="card card-body cartItemsContainer" 
    style="
        width: 700px;
        display: flex;"
        >
    
    <c:forEach items="${cart.getItems()}" var="entry">
        <form action="${contextPath}/cart?u=1" method="POST">
            <div 
                class="cartItem" 
                style="
                    display: flex; 
                    justify-content: space-between;
                    border-bottom: 1px solid black;
                    align-items: center;
                    ">
                
                <input hidden="true" value="${entry.key.getId()}" name="productId">

                <h5 style="width: 220px;">${entry.key.getName()}</h5>

                <div style="text-align: center;">
                    <span style="font-size: small">
                        Količina: 
                    </span>
                    <input 
                        class="form-control"
                        type="number"
                        min="1"
                        value="${entry.value}"
                        name="quantity"
                        style="width: 80px;">                    
                </div>

                <p>
                    Cijena: <span>${entry.key.getPrice()} kn</span>
                </p>
                
                <button
                    type="submit"
                    class="btn btn-warning">
                        Update
                </button>
                    
                <a class="btn btn-danger"
                   href="${contextPath}/cart?d=11&productId=${entry.key.getId()}">
                    Delete
                </a>

            </div>
        </form>
    </c:forEach>
    
    <div class="row">
        <div class="col">
            <p>Total: <b>${cart.getTotalAmount()} kn</b></p>
        </div>
        <c:if test="${cart.getItems().size() > 0}">
            <div class="col">
                <a class="btn btn-success" 
                   href="${contextPath}/checkout"
                   style="width: 75%;">
                    Proceed to checkout
                </a>
            </div>
        </c:if>
    </div>
    
</div>
